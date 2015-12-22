package com.smzdz.manager;

import com.alibaba.fastjson.JSON;
import com.smzdz.BaseTest;
import com.smzdz.BaseTest;
import com.smzdz.model.PayCheckResultModel;
import com.smzdz.util.result.ResultListBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2015/3/12.
 */
public class PayCheckResultManagerTest extends BaseTest {

    @Autowired
    private PayCheckManager payCheckManager;

    @Test
    public void selectByDataAndAgency() {
        String checkDate = "20150303";
        String agencyCode = "ALIPAY";
        int bizCode = 1;
        int status = 2;
        ResultListBean<PayCheckResultModel> listBean = payCheckManager.selectByDateAndAgency(checkDate, agencyCode, bizCode, status);
        System.out.println(JSON.toJSON(listBean));
    }

}
