package com.smzdz;

import java.math.BigDecimal;

import com.smzdz.service.PayFeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.service.PayFeeService;
import com.smzdz.util.utils.ServiceException;

/**
 * Created by wujingpan on 2015/3/5.
 */
public class PayFeeServiceTest extends BaseTest {

    @Autowired
    private PayFeeService service;

    @Test
    public void getFee(){
        try {
            BigDecimal fee = service.getPayFee(BigDecimal.valueOf(0.01),"1234274801",1);
            System.out.println(fee.toString());
            //assertEquals(fee, BigDecimal.valueOf(0.30));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
