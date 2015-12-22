package com.smzdz.manager;

import java.util.Date;
import java.util.List;

import com.smzdz.BaseTest;
import com.smzdz.entity.AgencyInfo;
import com.smzdz.model.AgencyInfoModel;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.entity.AgencyInfo;
import com.smzdz.model.AgencyInfoModel;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.ServiceException;

public class AgencyInfoManagerTest extends BaseTest {
	
	@Autowired
	private AgencyInfoManager ma;
	
	@Autowired 
	private AgencyInfoService service;
	@Test
	public void testQueryAll(){
		ResultListBean<AgencyInfoModel> result = ma.getAgencyList("易宝");
		System.out.println(result.getValue().toString());
		List<AgencyInfoModel> list = result.getValue();
		System.out.println(list.size());
	}
	@Test
	public void testInsert(){
		AgencyInfo info = new AgencyInfo();
		info.setAccessPlatform(1);
		info.setAgencyCode("EPAY");
		info.setAgencyName("易宝支付111");
		info.setAgencyType(4);
		info.setAliasFlag(1);
		info.setCreateTime(new Date());
		info.setModifyTime(new Date());
		info.setPayUrl("111");
		info.setPrepayUrl("adb");
		info.setQueryUrl("444");
		info.setRefundUrl("55555");
		info.setSendPhoneUrl("444fff");
		Result<Boolean> result = ma.insertAgencyInfo(info);
		assertEquals(0, result.getStatus().getCode());
	}
	
	@Test
	public void testUpdate(){
		AgencyInfo info = new AgencyInfo();
		info.setId(6);
		info.setAccessPlatform(1);
		info.setAgencyCode("EPAY");
		info.setAgencyName("易宝支2222付123");
		info.setAgencyType(4);
		info.setAliasFlag(1);
		info.setModifyTime(new Date());
		info.setPayUrl("111");
		info.setPrepayUrl("adb");
		info.setQueryUrl("444");
		info.setRefundUrl("55555");
		info.setSendPhoneUrl("444fff");
		Result<Boolean> result = ma.updateAgencyInfo(info);
		assertEquals(0, result.getStatus().getCode());
	}

	@Test
	public void testSelectListForMap() throws ServiceException{
	    System.out.println(service.getAllAgencyInfoForMap());
	}
}
