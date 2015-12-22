package com.smzdz.service.impl;


import com.smzdz.dao.TransferDao;
import com.smzdz.service.TransferService;
import com.smzdz.util.utils.Pager;
import com.smzdz.dao.TransferDao;
import com.smzdz.entity.Transfer;
import com.smzdz.service.TransferService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 15:53
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferDao transferDao;

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return transferDao.selectCount(pager);
    }

    @Override
    public List<Transfer> selectTransferInfo(Pager pager) throws ServiceException {
        return transferDao.selectTransferInfo(pager);
    }


    @Override
    public List<Transfer> selectTransferDetailInfo(String batchNo,Integer appId) throws ServiceException {
        return transferDao.selectTransferDetailInfo(batchNo,appId);
    }
}
