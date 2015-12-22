package com.smzdz.service.impl;


import java.util.List;
import java.util.Map;

import com.smzdz.util.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smzdz.dao.TransferBatchDao;
import com.smzdz.entity.TransferBatch;
import com.smzdz.service.TransferBatchService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 15:53
 */
@Service
public class TransferBatchServiceImpl implements TransferBatchService {

    @Autowired
    private TransferBatchDao transferBatchDao;

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return transferBatchDao.selectCount(pager);
    }

    @Override
    public List<TransferBatch> selectBatchInfo(Pager pager) throws ServiceException {
        return transferBatchDao.selectBatchInfo(pager);
    }

    @Override
    public TransferBatch selectTransferBatchDetail(String batchNo, Integer appId) throws ServiceException {
        return transferBatchDao.selectTransferBatchDetail(batchNo, appId);
    }
    
    @Override
    public int updateBatchAudit(Map map) {
        return transferBatchDao.updateBatchAudit(map);
    }
}
