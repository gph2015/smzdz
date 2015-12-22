package com.smzdz.dao;

import java.util.List;
import java.util.Map;

import com.smzdz.util.utils.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smzdz.entity.TransferBatch;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 16:53
 */
@Repository
public interface TransferBatchDao {

    public int selectCount(Pager pager);

    public List<TransferBatch> selectBatchInfo(Pager pager);

    public TransferBatch selectTransferBatchDetail(@Param("batchNo")String batchNo, @Param("appId")Integer appId);
    
    public int updateBatchAudit(Map params);
}
