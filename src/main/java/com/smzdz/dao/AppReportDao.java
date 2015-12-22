package com.smzdz.dao;

import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.AppReportModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qibaichao on 2015/3/30.
 */
public interface AppReportDao {

    public int selectCount(Pager pager);

    public List<AppReportModel> selectByPaging(Pager pager);

    public AppReportSumModel selectSum(Pager pager);

    public BigDecimal selectRefundFeeSum(Pager pager);
}
