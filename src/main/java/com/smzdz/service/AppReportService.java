package com.smzdz.service;

import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.AppReportModel;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qibaichao on 2015/3/30.
 */
public interface AppReportService {

    public AppReportSumModel selectSum(Pager pager) throws ServiceException;

    public int selectCount(Pager pager) throws ServiceException;

    public List<AppReportModel> selectByPaging(Pager pager) throws ServiceException;

    public BigDecimal selectRefundFeeSum(Pager pager)throws ServiceException;
}
