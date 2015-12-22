package com.smzdz.service.impl;

import com.smzdz.dao.AppReportDao;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.dao.AppReportDao;
import com.smzdz.model.AppReportModel;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.service.AppReportService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qibaichao on 2015/3/30.
 */
@Service
public class AppReportServiceImpl implements AppReportService {

    @Autowired
    private AppReportDao appReportDao;

    @Override
    public AppReportSumModel selectSum(Pager pager) throws ServiceException {
        return appReportDao.selectSum(pager);
    }

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return appReportDao.selectCount(pager);
    }

    @Override
    public List<AppReportModel> selectByPaging(Pager pager) throws ServiceException {
        return appReportDao.selectByPaging(pager);
    }

    @Override
    public BigDecimal selectRefundFeeSum(Pager pager) throws ServiceException {
        return appReportDao.selectRefundFeeSum(pager);
    }
}
