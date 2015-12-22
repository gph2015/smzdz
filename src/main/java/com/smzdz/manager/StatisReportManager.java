package com.smzdz.manager;

import com.smzdz.model.StatisReportModel;
import com.smzdz.util.utils.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/4/24.
 */
public interface StatisReportManager {

    public List<Map> selectPayTypeReport(String startDate, String endDate, Integer appId);

    public List<Map> selectReportByAgency(String startDate, String endDate, Integer appId);

    public int selectPaySuccessCount(String startDate, String endDate, Integer appId);

    public BigDecimal selectPaySuccessAmt(String startDate, String endDate, Integer appId);

    //成功率 =成功回调数/回调总数
    public double computeSuccessRate(String startDate, String endDate);

    //调单率 =成功通知数/回调总数
    public double computeLeakageRate(String startDate, String endDate);

    public double computeConvertRate(String startDate, String endDate);


}
