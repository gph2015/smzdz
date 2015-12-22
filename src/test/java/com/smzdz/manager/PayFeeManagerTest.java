package com.smzdz.manager;

import java.util.List;

import com.smzdz.BaseTest;
import com.smzdz.util.result.ResultListBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.model.PayFeeModel;
import com.smzdz.util.result.ResultListBean;

public class PayFeeManagerTest extends BaseTest {

	@Autowired
	private PayFeeManager ma;
	
	@Test
	public void testQueryList(){
		ResultListBean<PayFeeModel> result = ma.selectPayFeeList(null, null);
		List list = result.getValue();
		System.out.println(list.toString());
	}
	
}
