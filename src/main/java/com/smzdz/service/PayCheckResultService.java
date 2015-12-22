package com.smzdz.service;

import com.smzdz.entity.PayCheckResult;
import com.smzdz.util.utils.ServiceException;

import java.util.List;

/**
 * Created by qibaichao on 2015/3/12.
 */
public interface PayCheckResultService {

    public List<PayCheckResult> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode, Integer status)
            throws ServiceException;

    public void updateResultStatus(String checkDate, String agencyCode, Integer bizCode) throws ServiceException;

}

