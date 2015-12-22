package com.smzdz.manager;

import com.smzdz.model.TransReportModel;
import com.smzdz.BaseTest;
import com.smzdz.model.TransReportModel;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ReportManagerTest extends BaseTest {

    @Autowired
    ReportManager reportManager;

    /**
     * @Author huangguoqing
     * @MethodName selectList
     * @Date 2015年3月17日
     * @Description:
     */
    @Test
    public void selectList() {
        Pager pager = new Pager();
        String agencyCode = "TENPAY";
        String startDate = "2015-03-11";
        String endDate = "2015-03-12";

        ResultListBean<TransReportModel> result = reportManager.selectByPaging(pager);
        System.out.println(result.getValue().size());
        System.out.println(result);
    }

    @Test
    public void selectPayReportSum() {
        Pager pager = new Pager();
        String agencyCode = "TENPAY";
        String startDate = "2015-03-11";
        String endDate = "2015-03-12";

        BigDecimal payAmt = reportManager.selectPayAmtSum(pager);
        System.out.println(payAmt);
    }

    @Test
    public void selectRefundReportSum() {
        Pager pager = new Pager();
        String agencyCode = "TENPAY";
        String startDate = "2015-03-11";
        String endDate = "2015-03-12";

        BigDecimal refundAmt = reportManager.selectRefundAmtSum(pager);
        System.out.println(refundAmt);
    }


}
