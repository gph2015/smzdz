package com.smzdz.controller;

import java.util.HashMap;
import java.util.Map;

import com.smzdz.BaseTest;
import com.smzdz.web.controller.AgencyInfoController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.web.controller.AgencyInfoController;

public class AgencyControllerTest extends BaseTest {

	@Autowired
	private AgencyInfoController controller;
	
	@Test
	public void test(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "");
		//testGet("/agency/query", map);
	}
}
