package com.smzdz.service.impl;

import com.smzdz.util.utils.Pager;
import com.smzdz.dao.PayCheckDiffDao;
import com.smzdz.entity.PayCheckDiff;
import com.smzdz.service.PayCheckDiffService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/26.
 */
@Service
public class PayCheckDiffServiceImpl implements PayCheckDiffService {

    @Autowired
    private PayCheckDiffDao payCheckDiffDao;

    @Override
    public Map<String, String> sumCountAndAmt(Pager pager) throws ServiceException {
        return payCheckDiffDao.sumCountAndAmt(pager);
    }

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return payCheckDiffDao.selectCount(pager);
    }

    @Override
    public List<PayCheckDiff> selectByPaging(Pager pager) throws ServiceException {
        return payCheckDiffDao.selectByPaging(pager);
    }

    @Override
    public PayCheckDiff selectDiffById(Long id) throws ServiceException {
        return payCheckDiffDao.selectDiffById(id);
    }

    @Override
    public void processDiff(Long id, String remark) throws ServiceException {
        payCheckDiffDao.processDiff(id, remark);
    }

    @Override
    public int selectNoProcessCount(String checkDate, String agencyCode, Integer bizCode) {
        return payCheckDiffDao.selectNoProcessCount(checkDate, agencyCode, bizCode);
    }
}
