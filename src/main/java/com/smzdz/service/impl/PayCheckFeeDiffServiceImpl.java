package com.smzdz.service.impl;

import com.smzdz.dao.PayCheckFeeDiffDao;
import com.smzdz.service.PayCheckFeeDiffService;
import com.smzdz.util.utils.Pager;
import com.smzdz.dao.PayCheckFeeDiffDao;
import com.smzdz.entity.PayCheckFeeDiff;
import com.smzdz.model.PayCheckFeeDiffModel;
import com.smzdz.service.PayCheckFeeDiffService;
import com.smzdz.util.result.ResultBean;
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
public class PayCheckFeeDiffServiceImpl implements PayCheckFeeDiffService {

    @Autowired
    private PayCheckFeeDiffDao payCheckFeeDiffDao;

    @Override
    public Map<String, String> sumCountAndAmt(Pager pager) throws ServiceException {
        return payCheckFeeDiffDao.sumCountAndAmt(pager);
    }

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return payCheckFeeDiffDao.selectCount(pager);
    }

    @Override
    public List<PayCheckFeeDiff> selectByPaging(Pager pager) throws ServiceException {
        return payCheckFeeDiffDao.selectByPaging(pager);
    }

    @Override
    public PayCheckFeeDiff selectDiffById(Long id) throws ServiceException {
        return payCheckFeeDiffDao.selectDiffById(id);
    }

    @Override
    public void processDiff(Long id, String remark) throws ServiceException {
        payCheckFeeDiffDao.processDiff(id, remark);
    }
}
