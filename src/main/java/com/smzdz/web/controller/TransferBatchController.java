package com.smzdz.web.controller;

import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.TransferBatchManager;
import com.smzdz.manager.TransferManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.sogou.pay.common.http.utils.HttpUtil;
import com.smzdz.entity.Transfer;
import com.smzdz.entity.TransferBatch;
import com.smzdz.entity.User;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.TransferBatchManager;
import com.smzdz.manager.TransferManager;
import com.smzdz.manager.UserManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 16:31
 */
@Controller
@RequestMapping("/transferBatch")
public class TransferBatchController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TransferBatchController.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private TransferBatchManager batchManager;

    @Autowired
    private AppInfoManager appInfoManager;

    @Autowired
    private TransferManager transferManager;

    private static final String BACK_URL = "transferBatchList.j";

    /**
     * @param pager
     * @return
     */
    @RequestMapping("/transferBatchList")
    public ModelAndView transferBatchList(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/transfer/transferBatchList");
        User user = getCurrentUser();
        if (user != null && user.getAppId() != 1000) {
            pager.getF().put("appId", "" + user.getAppId());
        }
        modelAndView.addObject("user", user);
        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("tradeState"))) {
            pager.getF().put("tradeState", "0");
        }
        //产品查询
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());
        ResultBean<Map> userMapBean = userManager.selectUserInfoForMap(1);
        modelAndView.addObject("userMap", userMapBean.getValue());
        //代付状态
        modelAndView.addObject("tradeMap", Constant.TRADE_STATUS_MAP);
        ResultListBean<TransferBatch> resultListBean = batchManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }

    @RequestMapping("/transferBatchDetail")
    public ModelAndView transferBatchDetail(String batchNo, String appId, Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/transfer/transferBatchDetail");
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        if (StringUtils.isEmpty(pager.getF().get("payStatus"))) {
            pager.getF().put("payStatus", "0");
        }
        if (!StringUtils.isEmpty(batchNo)) {
            pager.getF().put("batchNo", batchNo);
        }
        if (! StringUtils.isEmpty(appId)) {
            pager.getF().put("appId",appId);
        }
        ResultListBean<Transfer> resultListBean = transferManager.selectByPaging(pager);
        modelAndView.addObject("appMap", appMapBean.getValue());
        //支付状态
        modelAndView.addObject("payMap", Constant.PAY_STATUS_MAP);
        modelAndView.addObject("batchNo", batchNo);
        modelAndView.addObject("appId", appId);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }

    @RequestMapping("/transferBatchReview")
    public ModelAndView transferBatchReview(String batchNo, Integer appId) {
        ModelAndView modelAndView = new ModelAndView("/transfer/transferBatchReview");
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());
        //支付状态
        modelAndView.addObject("payMap", Constant.PAY_STATUS_MAP);
        ResultBean<TransferBatch> resultListBean = batchManager.selectTransferBatchDetail(batchNo, appId);
        modelAndView.addObject("transferBatch", resultListBean.getValue());
        return modelAndView;
    }

    @RequestMapping("/doReview")
    public ModelAndView doReview(String appId,String batchNo, Integer tradeState, String auditDesc) {
        //更新代付批次状态
        PMap params = new PMap();
        params.put("userId", getCurrentUser().getId());
        params.put("batchNo", batchNo);
        params.put("tradeState", tradeState);
        params.put("auditDesc", auditDesc);
        params.put("appId", appId);
        ResultBean result = batchManager.updateBatchAudit(params);
        if (!Result.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(), result.getStatus().getCode());
        //调用代付接口
        if (Constant.AUDIT_STATUS_2 == tradeState) {
            logger.info("【代付单审核】调用HTTP请求开始，参数为batchNo=" + batchNo);
            HttpUtil.sendPost(ResourceBundle.getBundle("config").getString("payTransferUrl"), "batchNo=" + batchNo+"&appId="+appId);
            logger.info("【代付单审核】调用HTTP请求结束。");
        }
        return toSuccess(BACK_URL);
    }

}
