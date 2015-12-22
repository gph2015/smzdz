package com.smzdz.manager.impl;

import com.smzdz.manager.AppReportManager;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.manager.AppReportManager;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.model.AppReportModel;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.service.AppInfoService;
import com.smzdz.service.AppReportService;
import com.smzdz.service.PayFeeService;
import com.smzdz.util.Constant;
import com.smzdz.util.NumberUtil;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.DateUtil;
import com.smzdz.util.utils.ExcelUtils;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/30.
 * 业务报表
 */
@Component
public class AppReportManagerImpl implements AppReportManager {

    private static final Logger logger = LoggerFactory.getLogger(AppReportManagerImpl.class);

    @Autowired
    private AppReportService appReportService;

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private PayFeeService payFeeService;

    @Autowired
    private AgencyInfoService agencyInfoService;

    @Autowired
    private ChannelInfoManager channelInfoManager;

    @Override
    public ResultBean<AppReportSumModel> selectSum(Pager pager) {
        ResultBean<AppReportSumModel> resultBean = ResultBean.build();
        AppReportSumModel appReportSumModel = null;
        try {
            appReportSumModel = appReportService.selectSum(pager);
            BigDecimal totalOrderAmt = appReportSumModel.getTotalOrderAmt();
            BigDecimal totalRefundAmt = appReportSumModel.getTotalRefundAmt();
            BigDecimal totalPayFeeAmt = appReportSumModel.getTotalPayFee();
            BigDecimal totalFeeAmt = BigDecimal.ZERO;
            //手续费处理，判断是否有退款，有退款 重新计算手续费
            if (totalRefundAmt.compareTo(BigDecimal.ZERO) != 0) {
                //从t_pay_check_waiting 表中汇总退款手续费
                BigDecimal refundFeeAmt = appReportService.selectRefundFeeSum(pager);
                totalFeeAmt = totalPayFeeAmt.add(refundFeeAmt);
                appReportSumModel.setTotalPayFee(totalFeeAmt);
                appReportSumModel.setTotalIncome(totalOrderAmt.subtract(totalRefundAmt).subtract(totalFeeAmt));
            }
            resultBean.success(appReportSumModel);
        } catch (ServiceException e) {
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
            logger.error(e.getMessage());
        }
        return resultBean;
    }

    @Override
    public ResultListBean<AppReportModel> selectByPaging(Pager pager) {
        ResultListBean<AppReportModel> resultListBean = ResultListBean.build();
        List<AppReportModel> resultList = null;
        try {
            int totalCount = appReportService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = appReportService.selectByPaging(pager);
                //手续费处理，判断是否有退款，有退款 重新计算手续费
//                for (AppReportModel appReportModel : resultList) {
                //退款标示 不为1说明有退款
//                    if (appReportModel.getRefundFlag() != 1) {
//                        BigDecimal payAmount = appReportModel.getOrderMoney().subtract(appReportModel.getRefundMoney());
//                        BigDecimal payFee = payFeeService.getPayFee(payAmount, appReportModel.getMerchantNo(), appReportModel.getPayType());
//                        if (payFee.compareTo(BigDecimal.valueOf(-1)) != 0) {
//                            appReportModel.setPayFee(payFee);
//                        }
//                    }
//                    if (appReportModel.getRefundFlag() != 1) {
//                        appReportModel.setPayFee(payFee);
//                    }
//                }
            }
            resultListBean.success(resultList);
        } catch (ServiceException e) {
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
            logger.error(e.getMessage());
        }
        return resultListBean;
    }

    @Override
    public void reportExport(Pager pager, HttpServletResponse response) {
        try {

            //汇总头部
            List<String> sumHeaderList = new ArrayList<String>();
            sumHeaderList.add("交易总笔数");
            sumHeaderList.add("支付总金额");
            sumHeaderList.add("退款总金额");
            sumHeaderList.add("手续费支出");
            sumHeaderList.add("入账金额合计");
            //汇总数据
            Integer totalCount = appReportService.selectCount(pager);
            AppReportSumModel appReportSumModel = appReportService.selectSum(pager);
            List<String> sumDataList = new ArrayList<String>();
            BigDecimal totalOrderAmt = appReportSumModel.getTotalOrderAmt();
            BigDecimal totalRefundAmt = appReportSumModel.getTotalRefundAmt();
            BigDecimal totalPayFeeAmt = appReportSumModel.getTotalPayFee();
            BigDecimal totalIncome = appReportSumModel.getTotalIncome();
//            BigDecimal totalFeeAmt = BigDecimal.ZERO;
            //手续费处理，判断是否有退款，有退款 重新计算手续费
            BigDecimal totalFeeAmt = BigDecimal.ZERO;
            if (totalRefundAmt.compareTo(BigDecimal.ZERO) != 0) {
                //从t_pay_check_waiting 表中汇总退款手续费
                BigDecimal refundFeeAmt = appReportService.selectRefundFeeSum(pager);
                totalFeeAmt = totalPayFeeAmt.add(refundFeeAmt);
                //重新计算总收入
                totalIncome = totalOrderAmt.subtract(totalRefundAmt).subtract(totalFeeAmt);
            }
            sumDataList.add(String.valueOf(totalCount));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(totalOrderAmt)));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(totalRefundAmt)));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(totalFeeAmt)));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(totalIncome)));
            // excel 头部
            List<String> headerList = new ArrayList<String>();
            headerList.add("序号");
            headerList.add("支付单号");
            headerList.add("业务订单号");
            headerList.add("订单金额");
            headerList.add("已退款金额");
            headerList.add("费率");
            headerList.add("手续费");
            headerList.add("接入产品");
            headerList.add("付款方式");
            headerList.add("接入平台");
            headerList.add("支付机构");
            headerList.add("支付渠道");
            headerList.add("交易完成时间");
            // excel 列表数据
            pager.setPageFlag("false");
            List<AppReportModel> reportList = appReportService.selectByPaging(pager);
            //手续费处理，判断是否有退款，有退款 重新计算手续费
            for (AppReportModel appReportModel : reportList) {
                //退款标示 不为1说明有退款
                if (appReportModel.getRefundFlag() != 1) {
                    BigDecimal payAmount = appReportModel.getOrderMoney().subtract(appReportModel.getRefundMoney());
                    BigDecimal payFee = payFeeService.getPayFee(payAmount, appReportModel.getMerchantNo(), appReportModel.getPayType());
                    if (payFee.compareTo(BigDecimal.valueOf(-1)) != 0) {
                        appReportModel.setPayFee(payFee);
                    }
                }
            }
            Map<Integer, String> appMap = appInfoService.selectAppInfoForMap();
            List<List<String>> dataList = new ArrayList<List<String>>();
            List<String> data = null;
            int index = 0;
            Map<String, String> agencyMap = agencyInfoService.getAllAgencyInfoForMap();
            Map<String, String> channelMap = channelInfoManager.queryChannelInfoForMap();
            for (AppReportModel report : reportList) {
                index++;
                data = new ArrayList<String>();
                data.add(String.valueOf(index));
                data.add(report.getPayId());
                data.add(report.getOrderId());
                data.add(NumberUtil.getDecimalFormat(String.valueOf(report.getOrderMoney())));
                data.add(NumberUtil.getDecimalFormat(String.valueOf(report.getRefundMoney())));
                //费率
                data.add(NumberUtil.getPercent(String.valueOf(report.getFeeRate())));
                data.add(NumberUtil.getDecimalFormat(String.valueOf(report.getPayFee())));
                data.add(appMap.get(report.getAppId()));
                data.add(Constant.PAY_FEETYPE_MAP.get(report.getPayType()));
                data.add(Constant.ACCESSPLAT_MAP.get(report.getAccessPlatForm()));
                data.add(agencyMap.get(report.getAgencyCode()));
                data.add(channelMap.get(report.getBankCode()));
                data.add(DateUtil.formatTime(report.getPaySuccessTime()));
                dataList.add(data);
            }
            StringBuffer fileNameBuffer = new StringBuffer("appReport");
            fileNameBuffer.append("_");
            fileNameBuffer.append(System.currentTimeMillis());
            ExcelUtils.exportExcel(sumHeaderList, sumDataList, headerList, dataList, fileNameBuffer.toString(), response);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
    }


}
