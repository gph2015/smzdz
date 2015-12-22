package com.smzdz.dao;

import com.smzdz.model.TransReportModel;
import com.smzdz.util.utils.Pager;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author qibaichao
 * @ClassName ReportDao
 * @Date 2015年03月27日
 * @Description:
 */
@Repository
public interface ReportDao {

    public int selectCount(Pager pager);

    public List<TransReportModel> selectTransReportList(Pager pager);

    public BigDecimal selectPayAmtSum(Pager pager);

    public BigDecimal selectRefundAmtSum(Pager pager);

    public BigDecimal selectPayFeeAmtSum(Pager pager);

    public BigDecimal selectRefundFeeAmtSum(Pager pager);


}
