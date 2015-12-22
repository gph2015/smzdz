package com.smzdz.manager;

import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.TransReportModel;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * @Author qibaichao
 * @ClassName TransReportManager
 * @Date 2015年3月27日
 * @Description:交易报表Manager
 */
public interface ReportManager {


    public ResultListBean<TransReportModel> selectByPaging(Pager pager);

    public BigDecimal selectPayAmtSum(Pager pager);

    public BigDecimal selectRefundAmtSum(Pager pager);

    public BigDecimal selectPayFeeAmtSum(Pager pager);

    public BigDecimal selectRefundFeeAmtSum(Pager pager);

    public void reportExport(Pager pager,HttpServletResponse response);


}
