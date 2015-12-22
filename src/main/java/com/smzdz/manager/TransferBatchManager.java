package com.smzdz.manager;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.TransferBatch;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 16:44
 */
public interface TransferBatchManager {

    public ResultListBean<TransferBatch> selectByPaging(Pager pager);

    public ResultBean<TransferBatch> selectTransferBatchDetail(String batchNo,Integer appId);

    public ResultBean updateBatchAudit(PMap params);


}
