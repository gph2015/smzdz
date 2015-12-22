package com.smzdz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/4/24.
 * 统计报表
 */
@Repository
public interface StatisReportDao {

    public List<Map> selectPayTypeReport(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("appId") Integer appId);

    public List<Map> selectReportByAgency(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("appId") Integer appId);

    //成功回调
    public int selectSuccessResCount(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //回调数
    public int selectResCount(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //通知成功count
    public int selectNotifySuccessCount(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //支付单成功总数
    public int selectPayOrderSuccessCount(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //查询支付单总数
    public int selectPayOrderCount(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //查询支付成功总笔数
    public int selectPaySuccessCount(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("appId") Integer appId);

    //查询支付成功总金额
    public BigDecimal selectPaySuccessAmt(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("appId") Integer appId);
}
