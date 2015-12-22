package com.smzdz.service;


import com.smzdz.entity.Transfer;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 16:31
 */
public interface TransferService {
    public int selectCount(Pager pager) throws ServiceException;

    public List<Transfer> selectTransferInfo(Pager pager) throws ServiceException;


    public List<Transfer> selectTransferDetailInfo(String batchNo,Integer appId) throws ServiceException;


}
