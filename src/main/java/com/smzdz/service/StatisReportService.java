package com.smzdz.service;

import com.smzdz.util.utils.ServiceException;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/4/24.
 */
public interface StatisReportService {

    public List<Map> selectPayTypeReport(String startDate, String endDate, Integer appId) throws ServiceException;

    public List<Map> selectReportByAgency(String startDate, String endDate, Integer appId) throws ServiceException;

    //成功回调数
    public int selectSuccessResCount(String startDate, String endDate) throws ServiceException;

    //回调数
    public int selectResCount(String startDate, String endDate) throws ServiceException;

    //通知成功count
    public int selectNotifySuccessCount(String startDate, String endDate) throws ServiceException;

    //支付单总数
    public int selectPayOrderSuccessCount(String startDate, String endDate) throws ServiceException;

    //查询支付单总数
    public int  selectPayOrderCount(String startDate, String endDate)throws ServiceException;

    //查询支付成功总笔数
    public int selectPaySuccessCount(String startDate, String endDate,Integer appId) throws ServiceException;

    //查询支付成功总金额
    public BigDecimal selectPaySuccessAmt(String startDate, String endDate,Integer appId) throws ServiceException;


}
