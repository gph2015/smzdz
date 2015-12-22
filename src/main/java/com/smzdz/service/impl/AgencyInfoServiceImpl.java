package com.smzdz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smzdz.dao.AgencyInfoDao;
import com.smzdz.entity.AgencyInfo;
import com.smzdz.service.AgencyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smzdz.dao.AgencyInfoDao;
import com.smzdz.entity.AgencyInfo;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.util.utils.ServiceException;


/**
 * Created by wujingpan on 2015/3/2.
 */
@Service
public class AgencyInfoServiceImpl implements AgencyInfoService {

    @Autowired
    AgencyInfoDao dao;

    public List<AgencyInfo> getAllAgencyInfo(String code) throws ServiceException {
        return dao.getAgencyInfoList(code);
    }

    @Override
    public AgencyInfo getById(Integer id) throws ServiceException {
        return dao.getById(id);
    }


	@Override
	public int insertAgencyInfo(AgencyInfo info) throws ServiceException {
		return dao.insertAgencyInfo(info);
	}


	@Override
	public int updateAgencyInfo(AgencyInfo info) throws ServiceException {
		return dao.updateAgencyInfo(info);
	}


	@Override
	public int getCountByConn(String code, String type, String accessPlat)
			throws ServiceException {
		return dao.getAgencyInfoByConn(code, accessPlat, type);
	}
	
	@Override
	public Map<String,String> getAllAgencyInfoForMap(){
	    Map<String,String> agnecyMap = new HashMap<String,String>();
	    List<AgencyInfo> agencyList = dao.getAgencyInfoList(null);
	    for(AgencyInfo info : agencyList){
	        agnecyMap.put(info.getAgencyCode(), info.getAgencyName());
	    }
	    return agnecyMap;
	}
}
