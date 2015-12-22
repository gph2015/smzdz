package com.smzdz.manager;

import java.util.List;

import com.smzdz.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransQueryParamModel;
import com.smzdz.util.result.ResultListBean;

public class TransQueryManagerTest extends BaseTest {
	
	@Autowired
	private TransManager m1;
	
	@Test
	public void testQueryList(){ 
//		TransQueryParamModel m = new TransQueryParamModel();
//		m.setAccessPlatform(1);
//		m.setAppId(2012);
//		m.setPayId(null);
//		m.setStatus(1);
//		m.setStartTime("2015-03-9 00:00:00");
//		m.setEndTime("2015-03-9 23:59:59");
//		ResultListBean<TransQueryModel>  resultbean = m1.getTransList(m);
//		List<TransQueryModel> ll = resultbean.getValue();
//		assertEquals(resultbean.getStatus().getCode(), 0);
	}

}
