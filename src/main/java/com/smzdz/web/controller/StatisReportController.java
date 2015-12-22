package com.smzdz.web.controller;

import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.util.Constant;
import com.smzdz.util.utils.JsonUtil;
import com.smzdz.entity.User;
import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.StatisReportManager;
import com.smzdz.model.StatisReportModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.utils.DateUtil;
import com.smzdz.util.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by qibaichao on 2015/4/23.
 */
@Controller
@RequestMapping("/statis")
public class StatisReportController extends BaseController {

    @Autowired
    private StatisReportManager statisReportManager;

    @Autowired
    private AgencyInfoManager agencyInfoManager;

    @Autowired
    private AppInfoManager appInfoManager;

    /**
     * 支付类型report
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/report")
    public ModelAndView payTypeReport(String startDate, String endDate, Integer dimension, Integer index, Integer appId) {


        ModelAndView modelAndView = new ModelAndView("/statis/statisReport");
        User user = getCurrentUser();
//        User user = new User();
//        user.setAppId(1000);
        if (user != null && user.getAppId() != 1000) {
            appId = user.getAppId();
        }
        modelAndView.addObject("user", user);

        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap();
        modelAndView.addObject("appMap", appMapBean.getValue());

        if (StringUtils.isEmpty(startDate)) {
            startDate =DateUtil.formatDate(DateUtil.get7DayAgoDate());
        }
        if (StringUtils.isEmpty(endDate)) {
            endDate = DateUtil.formatDate(new Date());
        }
        if (appId == null) {
            appId = 0;
        }
        //查询支付总数count
        int successCount = statisReportManager.selectPaySuccessCount(startDate, endDate, appId);
        modelAndView.addObject("successCount", successCount);
        //总金额
        BigDecimal successAmt = statisReportManager.selectPaySuccessAmt(startDate, endDate, appId);
        modelAndView.addObject("successAmt", successAmt);

        //计算成功率
        double successRate = statisReportManager.computeSuccessRate(startDate, endDate);
        modelAndView.addObject("successRate", successRate);
        //计算调单率
        double leakageRate = statisReportManager.computeLeakageRate(startDate, endDate);
        modelAndView.addObject("leakageRate", leakageRate);

        //计算转换率
        double convertRate = statisReportManager.computeConvertRate(startDate, endDate);
        modelAndView.addObject("convertRate", convertRate);

        HashMap<Integer, String> statisDimensionMap = (HashMap<Integer, String>) Constant.STATIS_DIMENSION_MAP.clone();
        modelAndView.addObject("statisDimensionMap", statisDimensionMap);

        HashMap<Integer, String> statisIndexMap = (HashMap<Integer, String>) Constant.STATIS_INDEX_MAP.clone();
        modelAndView.addObject("statisIndexMap", statisIndexMap);
        modelAndView.addObject("startDate", startDate);
        modelAndView.addObject("endDate", endDate);
        modelAndView.addObject("dimension", dimension);
        modelAndView.addObject("index", index);
        modelAndView.addObject("appId", appId);

        List<Map> payTypeMapList = statisReportManager.selectPayTypeReport(startDate, endDate, appId);
        List<StatisReportModel> payFeeReportCount = convertPayFeeCount(payTypeMapList);
        List<StatisReportModel> payFeeReportAmt = convertPayFeeAmt(payTypeMapList);
        modelAndView.addObject("payFeeCountJsonData", JsonUtil.beanToJson(payFeeReportCount));
        modelAndView.addObject("payFeeAmtJsonData", JsonUtil.beanToJson(payFeeReportAmt));

        List<Map> agencyMapList = statisReportManager.selectReportByAgency(startDate, endDate, appId);
            List<StatisReportModel> agencyReportCount = convertAgencyCount(agencyMapList);
        List<StatisReportModel> agencyReportAmt = convertAgencyAmt(agencyMapList);
        modelAndView.addObject("aegncyCountJsonData", JsonUtil.beanToJson(agencyReportCount));
        modelAndView.addObject("aegncyAmtJsonData", JsonUtil.beanToJson(agencyReportAmt));

        return modelAndView;
    }

    private List<StatisReportModel> convertPayFeeCount(List<Map> list) {
        List<StatisReportModel> reportList = new ArrayList<>();
        StatisReportModel statisReportModel = null;
        if (list != null && list.size() != 0) {
            for (Map map : list) {
                statisReportModel = new StatisReportModel();
                statisReportModel.setLabel(Constant.PAY_FEETYPE_MAP.get(map.get("pay_type")));
                statisReportModel.setValue(String.valueOf(map.get("count")));
                reportList.add(statisReportModel);
            }
        }
        return reportList;
    }

    private List<StatisReportModel> convertPayFeeAmt(List<Map> list) {
        List<StatisReportModel> reportList = new ArrayList<>();
        StatisReportModel statisReportModel = null;
        if (list != null && list.size() != 0) {
            for (Map map : list) {
                statisReportModel = new StatisReportModel();
                statisReportModel.setLabel(Constant.PAY_FEETYPE_MAP.get(map.get("pay_type")));
                statisReportModel.setValue(String.valueOf(map.get("biz_amt")));
                reportList.add(statisReportModel);
            }
        }
        return reportList;
    }

    private List<StatisReportModel> convertAgencyCount(List<Map> list) {
        List<StatisReportModel> reportList = new ArrayList<>();
        StatisReportModel statisReportModel = null;
        Map<String,String> agencyMap = agencyInfoManager.getAllAgencyInfoForMap();
        if (list != null && list.size() != 0) {
            for (Map map : list) {
                statisReportModel = new StatisReportModel();
                statisReportModel.setLabel(String.valueOf(agencyMap.get((map.get("agency_code")))));
                statisReportModel.setValue(String.valueOf(map.get("count")));
                reportList.add(statisReportModel);
            }
        }
        return reportList;
    }

    private List<StatisReportModel> convertAgencyAmt(List<Map> list) {
        List<StatisReportModel> reportList = new ArrayList<>();
        StatisReportModel statisReportModel = null;
        Map<String,String> agencyMap = agencyInfoManager.getAllAgencyInfoForMap();
        if (list != null && list.size() != 0) {
            for (Map map : list) {
                statisReportModel = new StatisReportModel();
                statisReportModel.setLabel(String.valueOf(agencyMap.get((map.get("agency_code")))));
                statisReportModel.setValue(String.valueOf(map.get("biz_amt")));
                reportList.add(statisReportModel);
            }
        }
        return reportList;
    }

    @RequestMapping("/test")
    public String reportList(HttpServletRequest request) {
        //4.设置系统通用session和超时时间
        HttpSession session = request.getSession();
        User user = new User();
        user.setName("qibaichao");
        session.setAttribute(CURRENT_USER, user);
        return "/statis/test";

    }
}
