package com.smzdz.service;

import com.smzdz.entity.AgencyMerchant;
import com.smzdz.entity.AgencyMerchant;
import com.smzdz.util.utils.ServiceException;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:21
 */
public interface AgencyMerchantService {

    public List<AgencyMerchant> queryAgencyMerchantList(String agencyCode) throws ServiceException;

    public AgencyMerchant queryAgencyMerchantDetailById(Integer id) throws ServiceException;

    public int insertAgencyMerchant(AgencyMerchant agencyMerchant) throws ServiceException;

    public int updateAgencyMerchant(AgencyMerchant agencyMerchant) throws ServiceException;

    public int deleteMerchant(Integer id) throws ServiceException;

}
