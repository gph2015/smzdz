package com.smzdz.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;

public class AgencyDaoTest extends BaseTest{
	
	@Autowired
	private AgencyInfoDao dao;
	
	@Test
	public void testquery(){
		System.out.println(dao.getById(1));
	}

}
