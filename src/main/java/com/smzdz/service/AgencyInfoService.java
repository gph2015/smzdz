package com.smzdz.service;

import java.util.List;
import java.util.Map;

import com.smzdz.entity.AgencyInfo;
import com.smzdz.entity.AgencyInfo;
import com.smzdz.util.utils.ServiceException;



/**
 * Created by wujingpan on 2015/3/2.
 */
public interface AgencyInfoService {

    public List<AgencyInfo> getAllAgencyInfo(String code) throws ServiceException;

    public AgencyInfo getById(Integer id) throws ServiceException;
    
    public int insertAgencyInfo(AgencyInfo info) throws ServiceException;
    
    public int updateAgencyInfo(AgencyInfo info)throws ServiceException;
    
    public int getCountByConn(String code,String type,String accessPlat)throws ServiceException;
    
    public Map<String,String> getAllAgencyInfoForMap();
}
