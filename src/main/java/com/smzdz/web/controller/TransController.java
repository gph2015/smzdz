package com.smzdz.web.controller;

import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.manager.TransManager;
import com.smzdz.model.TransQueryModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.User;
import com.smzdz.model.TransStatisModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 交易查询
 * Created by qibaichao on 2015/3/23.
 */
@Controller
@RequestMapping("/trans")
public class TransController extends BaseController {

    @Autowired
    private TransManager transManager;

    @Autowired
    private AppInfoManager appInfoManager;

    @Autowired
    private AgencyInfoManager agencyInfoManager;

    @Autowired
    private ChannelInfoManager channelInfoManager;

    /*
     * 交易信息统计
     * @param pager
     * @return
     */
    @RequestMapping("/statis")
    public @ResponseBody
    ResultListBean<TransStatisModel> statis(Pager pager) {
        User user = getCurrentUser();

//        if(user==null || user.getAppId()!=1000)
//            return null;

        pager.getF().put("statis", "true");

        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("status"))) {
            pager.getF().put("status", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("accessPlatform"))) {
            pager.getF().put("accessPlatform", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("payId"))) {
            pager.getF().put("payId", null);
        }
        if (StringUtils.isEmpty(pager.getF().get("buyHomeAccount"))) {
            pager.getF().put("buyHomeAccount", null);
        }
        if (StringUtils.isEmpty(pager.getF().get("orderId"))) {
            pager.getF().put("orderId", null);
        }
        if (StringUtils.isEmpty(pager.getF().get("channelCode"))) {
            pager.getF().put("channelCode", null);
        }
        if (StringUtils.isEmpty(pager.getF().get("startDate"))) {
            pager.getF().put("startDate", null);
        }
        if (StringUtils.isEmpty(pager.getF().get("endDate"))) {
            pager.getF().put("endDate", null);
        }

        //产品map
        Map<Integer,String> appMap = appInfoManager.selectAppInfoForMap(1).getValue();

        //支付状态map
        HashMap<Integer, String> statusMap = Constant.PAYORDER_STATUS_MAP;

        //支付渠道map
        Map<Integer,String> channelMap = channelInfoManager.queryChannelInfoForMap();

        ResultListBean<TransStatisModel> resultListBean = transManager.statis(pager);

        for(TransStatisModel t: resultListBean.getValue()){
            t.setAppName(appMap.get(t.getAppId()));
            t.setStatusName(statusMap.get(t.getPayOrderStatus()));
            t.setChannelName(channelMap.get(t.getChannelCode()));
        }

        return resultListBean;
    }


    /**
     * 交易列表查询
     *
     * @param pager
     * @return
     */
    @RequestMapping("/transList")
    public ModelAndView transList(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/trans/transList");


        User user = getCurrentUser();
//        User user = new User();
//        user.setAppId(3000);

        if (user != null && user.getAppId() != 1000) {
            pager.getF().put("appId", "" + user.getAppId());
        }
        modelAndView.addObject("user", user);

        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("status"))) {
            pager.getF().put("status", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("accessPlatform"))) {
            pager.getF().put("accessPlatform", "0");
        }
        String startDate = pager.getF().get("startDate");
        if (StringUtils.isEmpty(startDate)) {
            pager.getF().put("startDate", DateUtil.formatDate(DateUtil.get7DayAgoDate()));
        }
        String endDate = pager.getF().get("endDate");
        if (StringUtils.isEmpty(endDate)) {
            pager.getF().put("endDate", DateUtil.formatDate(new Date()));
        }


        //产品查询
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());
        //支付状态map
        modelAndView.addObject("statusMap", Constant.PAYORDER_STATUS_MAP);
        //接入平台map
        HashMap<Integer, String> accessplatMap = (HashMap<Integer, String>) Constant.ACCESSPLAT_MAP.clone();
        accessplatMap.remove(99);
        modelAndView.addObject("accessplatMap", accessplatMap);
        //支付渠道map
        Map channelMap = channelInfoManager.queryChannelInfoForMap();
        modelAndView.addObject("channelMap", channelMap);
        ResultListBean<TransQueryModel> resultListBean = transManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }


    @RequestMapping("/transDetail")
    public ModelAndView transDetail(String payId) {
        ModelAndView modelAndView = new ModelAndView("/trans/transDetail");
        if (StringUtils.isEmpty(payId)) {
            return modelAndView;
        }
        //接入产品map
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());
        //支付状态map
        modelAndView.addObject("statusMap", Constant.PAYORDER_STATUS_MAP);
        //接入平台map
        HashMap<Integer, String> accessplatMap = (HashMap<Integer, String>) Constant.ACCESSPLAT_MAP.clone();
        accessplatMap.remove(99);
        modelAndView.addObject("accessplatMap", accessplatMap);
        //支付机构map
        Map<String, String> agencyMap = agencyInfoManager.getAllAgencyInfoForMap();
        modelAndView.addObject("agencyMap", agencyMap);
        //支付渠道map
        Map channelMap = channelInfoManager.queryChannelInfoForMap();
        modelAndView.addObject("channelMap", channelMap);
        //
        Map payFeeTypeMap = Constant.PAY_FEETYPE_MAP;
        modelAndView.addObject("payFeeTypeMap", payFeeTypeMap);

        ResultBean<TransQueryModel> resultBean = transManager.selectByPayId(payId);
        //验证resultListBean
        if (!Result.isSuccess(resultBean)) {
            return setErrorPage(resultBean.getStatus().getMessage(), resultBean.getStatus().getCode());
        }
        modelAndView.addObject("transQueryModel", resultBean.getValue());
        return modelAndView;
    }

}
