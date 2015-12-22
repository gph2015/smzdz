package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.util.utils.JsonUtil;
import com.smzdz.BaseTest;
import com.smzdz.model.StatisReportModel;
import com.smzdz.util.utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/4/24.
 */
public class StatisReportManagerTest extends BaseTest {


    @Autowired
    private StatisReportManager statisReportManager;


    @Test
    public void selectPayTypeReport() {
        String startDate = "";
        String endDate = "";
        Integer appId = 1999;
        List<Map> list = statisReportManager.selectPayTypeReport(startDate, endDate, appId);
        System.out.println(JsonUtil.beanToJson(list));
    }

    @Test
    public void selectAppReport() {
        String startDate = "";
        String endDate = "";
        Integer appId = 1999;
        List<Map> list = statisReportManager.selectReportByAgency(startDate, endDate, appId);
        System.out.println(JsonUtil.beanToJson(list));
    }

    @Test
    public void computeSuccessRate() {
        String startDate = "";
        String endDate = "";
        Integer appId = 1999;
        double rate = statisReportManager.computeSuccessRate(startDate, endDate);
        System.out.println(rate);
    }

    @Test
    public void computeLeakageRate() {
        String startDate = "2015-05-15";
        String endDate = "2015-06-04";
        Integer appId = 3000;
        double rate = statisReportManager.computeLeakageRate(startDate, endDate);
        System.out.println(rate);
    }


    @Test
    public void selectPayOrderSuccessCount() {
        String startDate = "2015-04-01";
        String endDate = "2015-04-28";
        Integer appId = 0;
        int count = statisReportManager.selectPaySuccessCount(startDate, endDate, appId);
        System.out.println(count);
    }

    public static void main(String args[]) {
        int successResCount = 144;
        int resCount = 227;
        MathContext mc = new MathContext(4, RoundingMode.HALF_DOWN);
        double rate = BigDecimal.valueOf(successResCount).divide(BigDecimal.valueOf(resCount), mc).doubleValue();
        System.out.println(rate);

    }
}
