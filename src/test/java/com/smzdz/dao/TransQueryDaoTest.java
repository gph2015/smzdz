package com.smzdz.dao;

import com.smzdz.BaseTest;
import com.smzdz.util.utils.Pager;
import com.smzdz.BaseTest;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransStatisModel;
import com.smzdz.util.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class TransQueryDaoTest extends BaseTest {

    @Autowired
    TransQueryDao transQueryDao;

    @Test
    public void testQuery() {
//		TransQueryParamModel m = new TransQueryParamModel();
//		m.setAccessPlatform(1);
//		m.setAppId(2012);
//		m.setPayId(null);
//		m.setStatus(1);
//		m.setStartTime("2015-03-9 00:00:00");
//		m.setEndTime("2015-03-9 23:59:59");
//		List<PayOrderInfo> list = dao.selectPayOrderList(m);
//		System.out.println(list.size());

        Pager pager = new Pager();
        pager.getF().put("status", "0");
        List<TransStatisModel> results = transQueryDao.selectCount(pager);

        for (TransStatisModel re: results) {
            System.out.println(re);
        }
    }

    @Test
    public void selectByPayId() {
        String payId = "111111";
        TransQueryModel transQueryModel = transQueryDao.selectSuccessByPayId(payId);

        System.out.println(transQueryModel);
    }

}
