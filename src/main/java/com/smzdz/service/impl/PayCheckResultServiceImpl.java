package com.smzdz.service.impl;

import com.smzdz.dao.PayCheckResultDao;
import com.smzdz.entity.PayCheckResult;
import com.smzdz.service.PayCheckResultService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qibaichao on 2015/3/12.
 */
@Service
public class PayCheckResultServiceImpl implements PayCheckResultService {

    @Autowired
    private PayCheckResultDao payCheckResultDao;

    @Override
    public List<PayCheckResult> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode, Integer status)
            throws ServiceException {

        List<PayCheckResult>   list = payCheckResultDao.selectByDateAndAgency(checkDate, agencyCode, bizCode, status);
        return list;
    }

    @Override
    public void updateResultStatus(String checkDate, String agencyCode, Integer bizCode) {
        payCheckResultDao.updateResultStatus(checkDate,agencyCode,bizCode);
    }
}
