package com.smzdz.service;

import com.smzdz.model.TransReportModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.TransReportModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author qibaichao
 * @ClassName TransReportService
 * @Date 2015年3月27日
 * @Description:交易报表Service
 */
public interface ReportService {

    public int selectCount(Pager pager) throws ServiceException;

    public List<TransReportModel> selectTransReportList(Pager pager) throws ServiceException;

    public BigDecimal selectPayAmtSum(Pager pager) throws ServiceException;

    public BigDecimal selectRefundAmtSum(Pager pager) throws ServiceException;

    public BigDecimal selectPayFeeAmtSum(Pager pager) throws ServiceException;

    public BigDecimal selectRefundFeeAmtSum(Pager pager) throws ServiceException;

}
