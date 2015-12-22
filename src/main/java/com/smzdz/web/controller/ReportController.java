package com.smzdz.web.controller;

import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.model.TransReportModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.manager.ReportManager;
import com.smzdz.util.utils.DateUtil;
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
 * 报表查询
 */
@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {


    @Autowired
    private AgencyInfoManager agencyInfoManager;

    @Autowired
    private ReportManager reportManager;

    @Autowired
    private ChannelInfoManager channelInfoManager;


    @RequestMapping("/reportList")
    public ModelAndView reportList(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/report/report");
        //业务类型
        modelAndView.addObject("bizTypeMap", Constant.BIZ_TYPE_MAP);
        //付款方式
        modelAndView.addObject("payTypeMap", Constant.PAY_FEETYPE_MAP);

        String startDate = pager.getF().get("startDate");
        if (StringUtils.isEmpty(startDate)) {
            pager.getF().put("startDate", DateUtil.formatDate(DateUtil.get7DayAgoDate()));
        }
        String endDate = pager.getF().get("endDate");
        if (StringUtils.isEmpty(endDate)) {
            pager.getF().put("endDate", DateUtil.formatDate(new Date()));
        }
        String bizCode = pager.getF().get("bizCode");
        if (StringUtils.isEmpty(bizCode)) {
            pager.getF().put("bizCode", "0");
        }

//        ResultListBean<AgencyInfoModel> agencyListBean = agencyInfoManager.getAgencyList(null);
//        modelAndView.addObject("agencyInfoList", agencyListBean.getValue());
        Map<String, String> agencyMap = agencyInfoManager.getAllAgencyInfoForMap();
        modelAndView.addObject("agencyMap", agencyMap);
        Map channelMap = channelInfoManager.queryChannelInfoForMap();
        modelAndView.addObject("channelMap", channelMap);

        //业务类型map
        HashMap<Integer, String> bizTypeMap = (HashMap<Integer, String>) Constant.BIZ_TYPE_MAP.clone();
        bizTypeMap.remove(2);
        modelAndView.addObject("bizTypeMap", bizTypeMap);

        //总支付金额
        BigDecimal totalPayAmt = reportManager.selectPayAmtSum(pager);
        modelAndView.addObject("totalPayAmt", totalPayAmt);
        //总退款金额
        BigDecimal totalRefundAmt = reportManager.selectRefundAmtSum(pager);
        modelAndView.addObject("totalRefundAmt", totalRefundAmt);
        //支付手续费
        BigDecimal totalPayFee = reportManager.selectPayFeeAmtSum(pager);
        modelAndView.addObject("totalPayFee", totalPayFee);
        //退款手续费
        BigDecimal totalRefundFee = reportManager.selectRefundFeeAmtSum(pager);
        BigDecimal totalRefundFeeShow = totalRefundFee.abs();
        modelAndView.addObject("totalRefundFee", totalRefundFeeShow);
        //总的手续费
        BigDecimal totalFee = totalPayFee.add(totalRefundFee);
        modelAndView.addObject("totalFee", totalFee);

        modelAndView.addObject("totalIncome", totalPayAmt.subtract(totalRefundAmt).subtract(totalFee));
        //分页查询
        ResultListBean<TransReportModel> resultListBean = reportManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        //查询支付渠道map

//        toLog(OperationLogType.DELETE, "删除", pager);
        return modelAndView;
    }


    @RequestMapping("/exportExcel")
    public void exportExcel(Pager pager, HttpServletResponse response) {
        reportManager.reportExport(pager, response);
    }


}
