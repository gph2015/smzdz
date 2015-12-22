package com.smzdz.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.smzdz.entity.AgencyInfo;
import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.model.AgencyInfoModel;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.util.result.*;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smzdz.entity.AgencyInfo;
import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.model.AgencyInfoModel;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.ServiceException;

@Component
public class AgencyInfoManagerImpl implements AgencyInfoManager {
	
	@Autowired
	private AgencyInfoService service;
	
	@Override
	public ResultListBean<AgencyInfoModel> getAgencyList(String code) {
		ResultListBean<AgencyInfoModel> resultListBean = ResultListBean.build();
		try {
			List<AgencyInfo> resultList = service.getAllAgencyInfo(code);
			resultListBean.success(covertData(resultList));
		} catch (ServiceException e) {
			resultListBean.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return resultListBean;
	}

	private List<AgencyInfoModel> covertData(List<AgencyInfo> resultList) {
		if (null == resultList || resultList.size() == 0)
			return null;
		List<AgencyInfoModel> list = new ArrayList<AgencyInfoModel>();
		AgencyInfoModel model = null;
		for (AgencyInfo info : resultList) {
			model = new AgencyInfoModel(info);
			list.add(model);
		}
		return list;
	}

	@Override
	public ResultBean<AgencyInfoModel> getById(Integer id) {
		ResultBean<AgencyInfoModel> result = ResultBean.build();
		try {
			AgencyInfo info = service.getById(id);
			result.success(new AgencyInfoModel(info));
		} catch (ServiceException e) {
			result.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultBasicBean<Boolean> insertAgencyInfo(AgencyInfo info) {
		ResultBasicBean<Boolean> result = ResultBasicBean.build();
		try {
			int count = service.getCountByConn(info.getAgencyCode(),
					String.valueOf(info.getAgencyType()), String.valueOf(info.getAccessPlatform()));
			if (count > 0) {
				result.withError(ResultStatus.ADD_AGENCY_ERROR);
				return result;
			}
			service.insertAgencyInfo(info);
		} catch (ServiceException e) {
			result.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result<Boolean> updateAgencyInfo(AgencyInfo info) {
		ResultBasicBean<Boolean> result = ResultBasicBean.build();
		try {
//			int count = service.getCountByConn(info.getAgencyCode(),
//					String.valueOf(info.getAgencyType()), String.valueOf(info.getAccessPlatform()));
//			if (count > 0) {
//				result.withError(ResultStatus.ADD_AGENCY_ERROR);
//				return result;
//			}
			service.updateAgencyInfo(info);
		} catch (ServiceException e) {
			result.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<String, String> getAllAgencyInfoForMap() {
		return service.getAllAgencyInfoForMap();
	}
	

}
