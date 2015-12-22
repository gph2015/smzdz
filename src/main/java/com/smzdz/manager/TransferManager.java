package com.smzdz.manager;

import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.Transfer;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/15 11:22
 */
public interface TransferManager {

    public ResultListBean<Transfer> selectByPaging(Pager pager);
    public ResultListBean<Transfer> selectBatchDetail(String batchNo,Integer appId);




}
