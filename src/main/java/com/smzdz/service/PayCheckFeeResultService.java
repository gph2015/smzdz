package com.smzdz.service;

import com.smzdz.entity.PayCheckFeeResult;
import com.smzdz.util.utils.ServiceException;

import java.util.List;

/**
 * Created by qibaichao on 2015/3/23.
 */
public interface PayCheckFeeResultService {

    public List<PayCheckFeeResult> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode,Integer status )
            throws ServiceException;
}
