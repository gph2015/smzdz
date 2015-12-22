package com.smzdz.service.impl;

import com.smzdz.service.StatisReportService;
import com.smzdz.dao.StatisReportDao;
import com.smzdz.service.StatisReportService;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/4/24.
 */
@Service
public class StatisReportServiceImpl implements StatisReportService {

    @Autowired
    private StatisReportDao statisReportDao;

    @Override
    public List<Map> selectPayTypeReport(String startDate, String endDate, Integer appId) throws ServiceException {
        return statisReportDao.selectPayTypeReport(startDate, endDate, appId);
    }

    @Override
    public List<Map> selectReportByAgency(String startDate, String endDate, Integer appId) throws ServiceException {
        return statisReportDao.selectReportByAgency(startDate, endDate, appId);
    }

    @Override
    public int selectSuccessResCount(String startDate, String endDate) throws ServiceException {
        return statisReportDao.selectSuccessResCount(startDate, endDate);
    }

    @Override
    public int selectResCount(String startDate, String endDate) throws ServiceException {
        return statisReportDao.selectResCount(startDate, endDate);
    }

    @Override
    public int selectNotifySuccessCount(String startDate, String endDate) throws ServiceException {
        return statisReportDao.selectNotifySuccessCount(startDate, endDate);
    }

    @Override
    public int selectPayOrderSuccessCount(String startDate, String endDate) throws ServiceException {
        return statisReportDao.selectPayOrderSuccessCount(startDate, endDate);
    }

    @Override
    public int selectPayOrderCount(String startDate, String endDate) throws ServiceException {
        return statisReportDao.selectPayOrderCount(startDate, endDate);
    }

    @Override
    public int selectPaySuccessCount(String startDate, String endDate, Integer appId) throws ServiceException {
        return statisReportDao.selectPaySuccessCount(startDate, endDate, appId);
    }

    @Override
    public BigDecimal selectPaySuccessAmt(String startDate, String endDate, Integer appId) throws ServiceException {
        return statisReportDao.selectPaySuccessAmt(startDate, endDate, appId);
    }

}
