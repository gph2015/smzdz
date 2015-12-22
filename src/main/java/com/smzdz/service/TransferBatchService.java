package com.smzdz.service;

import java.util.List;
import java.util.Map;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.TransferBatch;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;


/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 16:22
 */
public interface TransferBatchService {
    public int selectCount(Pager pager) throws ServiceException;

    public List<TransferBatch> selectBatchInfo(Pager pager) throws ServiceException;

    public TransferBatch selectTransferBatchDetail(String batchNo, Integer appId) throws ServiceException;

    public int updateBatchAudit(Map map);
}
