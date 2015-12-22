package com.smzdz.web.controller;

import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.TransferManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.Transfer;
import com.smzdz.entity.User;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.TransferManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 16:31
 */
@Controller
@RequestMapping("/transfer")
public class TransferController extends BaseController {

    @Autowired
    private TransferManager transferManager;

    @Autowired
    private AppInfoManager appInfoManager;

    /**
     *
     * @param pager
     * @return
     */
    @RequestMapping("/transferList")
    public ModelAndView transList(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/transfer/transferList");
        User user = getCurrentUser();
        if (user != null && user.getAppId() != 1000) {
            pager.getF().put("appId", "" + user.getAppId());
        }
        modelAndView.addObject("user", user);
        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }

        if (StringUtils.isEmpty(pager.getF().get("payStatus"))) {
            pager.getF().put("payStatus", "0");
        }
        //产品查询
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());
        //支付状态
        modelAndView.addObject("payMap", Constant.PAY_STATUS_MAP);
        ResultListBean<Transfer> resultListBean = transferManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }


}
