package com.smzdz.web.controller;

import com.smzdz.manager.AppReportManager;
import com.smzdz.model.AppReportModel;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.Constant;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.User;
import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.AppReportManager;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.DateUtil;
import com.smzdz.util.utils.Pager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/30.
 */
@Controller
@RequestMapping("/appReport")
public class AppReportController extends BaseController {

    @Autowired
    private AppInfoManager appInfoManager;
    @Autowired
    private AppReportManager appReportManager;
    @Autowired
    private AgencyInfoManager agencyInfoManager;
    @Autowired
    private ChannelInfoManager channelInfoManager;


    @RequestMapping("/reportList")
    public ModelAndView reportList(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/appReport/appReport");

        User user = getCurrentUser();
//        User user = new User();
//        user.setAppId(1000);
        if (user != null && user.getAppId() != 1000) {
            pager.getF().put("appId", String.valueOf(user.getAppId()));
        }
        modelAndView.addObject("user", user);

        String startDate = pager.getF().get("startDate");
        String endDate = pager.getF().get("endDate");

        if (StringUtils.isEmpty(startDate)) {
            pager.getF().put("startDate", DateUtil.formatDate(DateUtil.get7DayAgoDate()));
        }
        if (StringUtils.isEmpty(endDate)) {
            pager.getF().put("endDate", DateUtil.formatDate(new Date()));
        }
        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("accessPlatform"))) {
            pager.getF().put("accessPlatform", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("payType"))) {
            pager.getF().put("payType", "0");
        }

        Map<String,String> agencyMap = agencyInfoManager.getAllAgencyInfoForMap();
        modelAndView.addObject("agencyMap", agencyMap);
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());

        HashMap<Integer, String> accessplatMap = (HashMap<Integer, String>) Constant.ACCESSPLAT_MAP.clone();
        accessplatMap.remove(99);
        modelAndView.addObject("accessplatMap", accessplatMap);
        HashMap<Integer, String> payTypeMap = (HashMap<Integer, String>) Constant.PAY_FEETYPE_MAP.clone();
        payTypeMap.remove(99);
        modelAndView.addObject("payTypeMap", payTypeMap);

        HashMap<Integer, String> refundStatusMap = (HashMap<Integer, String>) Constant.PAYORDER_REFUND_STATUS_MAP;
        modelAndView.addObject("refundStatusMap", refundStatusMap);

        Map channelMap = channelInfoManager.queryChannelInfoForMap();
        modelAndView.addObject("channelMap", channelMap);
        //汇总查询
        ResultBean<AppReportSumModel> sumBean = appReportManager.selectSum(pager);
        modelAndView.addObject("appSum", sumBean.getValue());

        //分页查询
        ResultListBean<AppReportModel> resultListBean = appReportManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }


    @RequestMapping("/exportExcel")
    public void exportExcel(Pager pager, HttpServletResponse response) {

        appReportManager.reportExport(pager, response);
    }


}
