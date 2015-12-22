package com.smzdz.service.impl;

import com.smzdz.dao.TransQueryDao;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransStatisModel;
import com.smzdz.service.TransQueryService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import com.smzdz.dao.TransQueryDao;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransStatisModel;
import com.smzdz.service.TransQueryService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 交易查询服务
 * Created by qibaichao on 2015/3/23.
 */
@Service
public class TransQueryServiceImpl implements TransQueryService {

    @Autowired
    private TransQueryDao transQueryDao;

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        List<TransStatisModel> results = transQueryDao.selectCount(pager);
        if (results.size() <= 0)
            return 0;
        return results.get(0).getTransCount();
    }

    @Override
    public List<TransStatisModel> statis(Pager pager) throws ServiceException {
        return transQueryDao.selectCount(pager);
    }

    @Override
    public List<TransQueryModel> selectByPaging(Pager pager) throws ServiceException {
        return transQueryDao.selectByPaging(pager);
    }

    @Override
    public TransQueryModel selectPayOrderByPayId(String payId) throws ServiceException {
        return transQueryDao.selectPayOrderByPayId(payId);
    }

    @Override
    public TransQueryModel selectNoSuccessByPayId(String payId) throws ServiceException {
        return transQueryDao.selectNoSuccessByPayId(payId);
    }


    @Override
    public TransQueryModel selectSuccessByPayId(String payId) throws ServiceException {
        return transQueryDao.selectSuccessByPayId(payId);
    }

    @Override
    public BigDecimal selectRefundFee(String payId) {
        return transQueryDao.selectRefundFee(payId);
    }
}
