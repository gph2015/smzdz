package com.smzdz.service.impl;

import com.smzdz.model.TransReportModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.dao.ReportDao;
import com.smzdz.model.TransReportModel;
import com.smzdz.service.ReportService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return reportDao.selectCount(pager);
    }

    @Override
    public List<TransReportModel> selectTransReportList(Pager pager) {
        return reportDao.selectTransReportList(pager);
    }

    @Override
    public BigDecimal selectPayAmtSum(Pager pager) throws ServiceException {
        return reportDao.selectPayAmtSum(pager);
    }

    @Override
    public BigDecimal selectRefundAmtSum(Pager pager) throws ServiceException {
        return reportDao.selectRefundAmtSum(pager);
    }

    @Override
    public BigDecimal selectPayFeeAmtSum(Pager pager) throws ServiceException {
        return reportDao.selectPayFeeAmtSum(pager);
    }

    @Override
    public BigDecimal selectRefundFeeAmtSum(Pager pager) throws ServiceException {
        return reportDao.selectRefundFeeAmtSum(pager);
    }


}
