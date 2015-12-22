package com.smzdz.service.impl;

import com.smzdz.entity.AgencyMerchant;
import com.smzdz.service.AgencyMerchantService;
import com.smzdz.dao.AgencyMerchantDao;
import com.smzdz.entity.AgencyMerchant;
import com.smzdz.service.AgencyMerchantService;
import com.smzdz.util.utils.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:35
 */
@Service
public class AgencyMerchantServiceImpl implements AgencyMerchantService {

    @Autowired
    AgencyMerchantDao agencyMerchantDao;

    @Override
    public List<AgencyMerchant> queryAgencyMerchantList(String agencyCode) throws ServiceException {
        return agencyMerchantDao.queryAgencyMerchantList(agencyCode);
    }

    @Override
    public AgencyMerchant queryAgencyMerchantDetailById(Integer id) throws ServiceException {
        return agencyMerchantDao.queryAgencyMerchantDetail(id);
    }

    @Override
    public int insertAgencyMerchant(AgencyMerchant agencyMerchant) throws ServiceException {
        return agencyMerchantDao.insertAgencyMerchant(agencyMerchant);
    }

    @Override
    public int updateAgencyMerchant(AgencyMerchant agencyMerchant) throws ServiceException {
        return agencyMerchantDao.updateAgencyMerchant(agencyMerchant);
    }

    @Override
    public int deleteMerchant(Integer id) throws ServiceException {
        return agencyMerchantDao.deleteMerchant(id);
    }

}
