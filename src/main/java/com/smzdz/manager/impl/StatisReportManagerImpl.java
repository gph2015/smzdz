package com.smzdz.manager.impl;

import com.smzdz.manager.StatisReportManager;
import com.smzdz.service.AppInfoService;
import com.smzdz.service.StatisReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/4/24.
 */
@Component
public class StatisReportManagerImpl implements StatisReportManager {


    private static final Logger logger = LoggerFactory.getLogger(StatisReportManagerImpl.class);

    @Autowired
    private StatisReportService statisReportService;

    @Autowired
    private AppInfoService appInfoService;

    @Override
    public List<Map> selectPayTypeReport(String startDate, String endDate, Integer appId) {
        List<Map> list = null;
        try {
            list = statisReportService.selectPayTypeReport(startDate, endDate, appId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Map> selectReportByAgency(String startDate, String endDate, Integer appId) {
        List<Map> list = null;
        try {
            list = statisReportService.selectReportByAgency(startDate, endDate, appId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return list;
    }

    @Override
    public int selectPaySuccessCount(String startDate, String endDate, Integer appId) {
        int count = 0;
        try {
            count = statisReportService.selectPaySuccessCount(startDate, endDate, appId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return count;
    }

    @Override
    public BigDecimal selectPaySuccessAmt(String startDate, String endDate, Integer appId) {
        BigDecimal amt = BigDecimal.ZERO;
        try {
            amt = statisReportService.selectPaySuccessAmt(startDate, endDate, appId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return amt;
    }

    /**
     * 计算成功率
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public double computeSuccessRate(String startDate, String endDate) {
        double rate = 0d;
        try {
            MathContext mc = new MathContext(4, RoundingMode.HALF_DOWN);
            int successResCount = statisReportService.selectSuccessResCount(startDate, endDate);
            int resCount = statisReportService.selectResCount(startDate, endDate);
            rate = BigDecimal.valueOf(successResCount).divide(BigDecimal.valueOf(resCount),mc).doubleValue();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rate;
    }

    /**
     * 计算调单率
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public double computeLeakageRate(String startDate, String endDate) {
        double rate = 0d;
        try {
            MathContext mc = new MathContext(4, RoundingMode.HALF_DOWN);
            int notifySuccessCount = statisReportService.selectNotifySuccessCount(startDate, endDate);
            int payOrderSuccessCount = statisReportService.selectPayOrderSuccessCount(startDate, endDate);
            rate = BigDecimal.valueOf(payOrderSuccessCount - notifySuccessCount).divide(BigDecimal.valueOf(payOrderSuccessCount),mc).doubleValue();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rate;
    }

    @Override
    public double computeConvertRate(String startDate, String endDate) {

        double rate = 0d;
        try {
            MathContext mc = new MathContext(4, RoundingMode.HALF_DOWN);
            int notifySuccessCount = statisReportService.selectNotifySuccessCount(startDate, endDate);
            int payOrderCount = statisReportService.selectPayOrderCount(startDate, endDate);
            rate = BigDecimal.valueOf( notifySuccessCount).divide(BigDecimal.valueOf(payOrderCount),mc).doubleValue();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rate;
    }


}
