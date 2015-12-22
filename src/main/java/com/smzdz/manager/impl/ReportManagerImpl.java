package com.smzdz.manager.impl;

import com.smzdz.model.TransReportModel;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.manager.ReportManager;
import com.smzdz.model.TransReportModel;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.service.ReportService;
import com.smzdz.util.Constant;
import com.smzdz.util.NumberUtil;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.DateUtil;
import com.smzdz.util.utils.ExcelUtils;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.apache.commons.collections.CollectionUtils;
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
 * @Author qibaichao
 * @ClassName ReportManagerImpl
 * @Date 2015年3月17日
 * @Description:交易报表Manager
 */
@Component
public class ReportManagerImpl implements ReportManager {

    private static final Logger logger = LoggerFactory.getLogger(ReportManagerImpl.class);

    @Autowired
    private ReportService reportService;

    @Autowired
    private ChannelInfoService channelInfoService;

    @Autowired
    private AgencyInfoService agencyInfoService;

    @Override
    public ResultListBean<TransReportModel> selectByPaging(Pager pager) {
        ResultListBean<TransReportModel> resultListBean = ResultListBean.build();
        List<TransReportModel> resultList = null;
        try {
            int totalCount = reportService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = reportService.selectTransReportList(pager);
                if (CollectionUtils.isNotEmpty(resultList)) {
                    for (TransReportModel transReportModel : resultList) {
                        if (transReportModel != null) {
                            if (transReportModel.getCommissionFeeAmt() != null) {
                                transReportModel.setCommissionFeeAmt(transReportModel.getCommissionFeeAmt().abs());
                            } else {
                                transReportModel.setCommissionFeeAmt(BigDecimal.ZERO);
                            }
                        }
                    }
                }
            }
            resultListBean.success(resultList);
        } catch (ServiceException e) {
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return resultListBean;
    }

    @Override
    public BigDecimal selectPayAmtSum(Pager pager) {
        BigDecimal payAmtSum = BigDecimal.ZERO;
        try {
            payAmtSum = reportService.selectPayAmtSum(pager);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
        return payAmtSum;
    }

    @Override
    public BigDecimal selectRefundAmtSum(Pager pager) {
        BigDecimal refundAmtSum = BigDecimal.ZERO;
        try {
            refundAmtSum = reportService.selectRefundAmtSum(pager);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
        return refundAmtSum;
    }

    @Override
    public BigDecimal selectPayFeeAmtSum(Pager pager) {
        BigDecimal totalFeeAmt = BigDecimal.ZERO;
        try {
            totalFeeAmt = reportService.selectPayFeeAmtSum(pager);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
        return totalFeeAmt;
    }

    @Override
    public BigDecimal selectRefundFeeAmtSum(Pager pager) {
        BigDecimal totalFeeAmt = BigDecimal.ZERO;
        try {
            totalFeeAmt = reportService.selectRefundFeeAmtSum(pager);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
        return totalFeeAmt;
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
            sumHeaderList.add("手续费退还");
            sumHeaderList.add("入账金额合计");
            //汇总数据
            Integer totalCount = reportService.selectCount(pager);
            BigDecimal payAmtSum = reportService.selectPayAmtSum(pager);
            BigDecimal refundAmtSum = reportService.selectRefundAmtSum(pager);
            BigDecimal totalPayFee = reportService.selectPayFeeAmtSum(pager);
            BigDecimal totalRefundFee = reportService.selectRefundFeeAmtSum(pager);

            List<String> sumDataList = new ArrayList<String>();
            sumDataList.add(String.valueOf(totalCount));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(payAmtSum)));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(refundAmtSum)));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(totalPayFee)));
            sumDataList.add(NumberUtil.getDecimalFormat(String.valueOf(totalRefundFee.abs())));
            //计算总收入
            BigDecimal totalFee = totalPayFee.add(totalRefundFee);
            sumDataList.add(String.valueOf(payAmtSum.subtract(refundAmtSum).subtract(totalFee)));
            // excel 头部
            List<String> headerList = new ArrayList<String>();
            headerList.add("序号");
            headerList.add("类型");
            headerList.add("流水号");
            headerList.add("支付机构");
            headerList.add("付款方式");
            headerList.add("支付渠道");
            headerList.add("交易金额");
            headerList.add("费率");
            headerList.add("手续费");
            headerList.add("交易完成时间");
            // excel 列表数据
            pager.setPageFlag("false");
            List<TransReportModel> reportList = reportService.selectTransReportList(pager);
            Map<String, String> agencyMap = agencyInfoService.getAllAgencyInfoForMap();
            Map<String, String> channelMap = channelInfoService.queryChannelInfoForMap();

            List<List<String>> dataList = new ArrayList<List<String>>();
            List<String> data = null;
            int index = 0;
            for (TransReportModel report : reportList) {
                index++;
                data = new ArrayList<String>();
                data.add(String.valueOf(index));
                data.add(Constant.BIZ_TYPE_MAP.get(report.getBizCode()));
                data.add(report.getInstructId());
                data.add(agencyMap.get(report.getAgencyCode()));
                data.add(Constant.PAY_FEETYPE_MAP.get(report.getPayType()));
                data.add(channelMap.get(report.getBankCode()));
                data.add(NumberUtil.getDecimalFormat(String.valueOf(report.getBizAmt())));
                //费率
                data.add(NumberUtil.getPercent(String.valueOf(report.getFeeRate())));
                data.add(NumberUtil.getDecimalFormat(String.valueOf(report.getCommissionFeeAmt().abs())));
                data.add(DateUtil.formatTime(report.getOutTransTime()));
                dataList.add(data);
            }
            StringBuffer fileNameBuffer = new StringBuffer("report");
            fileNameBuffer.append("_");
            fileNameBuffer.append(System.currentTimeMillis());
            ExcelUtils.exportExcel(sumHeaderList, sumDataList, headerList, dataList, fileNameBuffer.toString(), response);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
    }


}
