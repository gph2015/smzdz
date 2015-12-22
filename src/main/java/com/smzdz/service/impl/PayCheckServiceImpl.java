package com.smzdz.service.impl;

import com.smzdz.dao.PayCheckDao;
import com.smzdz.util.utils.Pager;
import com.smzdz.dao.PayCheckDao;
import com.smzdz.model.PayCheckModel;
import com.smzdz.service.PayCheckService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/12.
 */
@Service
public class PayCheckServiceImpl implements PayCheckService {

    @Autowired
    private PayCheckDao payCheckDao;

    @Override
    public Map<String, String> sumCountAndAmt(Pager pager) throws ServiceException {
        return payCheckDao.sumCountAndAmt(pager);
    }

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return payCheckDao.selectCount(pager);
    }

    @Override
    public List<PayCheckModel> selectByPaging(Pager pager) throws ServiceException {
        return payCheckDao.selectByPaging(pager);
    }
}
