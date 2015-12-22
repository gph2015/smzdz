package com.smzdz.service.impl;

import com.smzdz.dao.PayCheckFeeResultDao;
import com.smzdz.entity.PayCheckFeeResult;
import com.smzdz.entity.PayCheckResult;
import com.smzdz.service.PayCheckFeeResultService;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qibaichao on 2015/3/23.
 */
@Service
public class PayCheckFeeResultServiceImpl implements PayCheckFeeResultService {

    @Autowired
    private PayCheckFeeResultDao payCheckFeeResultDao;

    @Override
    public List<PayCheckFeeResult> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode, Integer status) throws ServiceException {
        return payCheckFeeResultDao.selectByDateAndAgency(checkDate,agencyCode,bizCode,status);
    }
}
