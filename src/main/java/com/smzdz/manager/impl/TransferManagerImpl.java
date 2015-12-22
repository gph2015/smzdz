package com.smzdz.manager.impl;

import com.smzdz.manager.TransferManager;
import com.smzdz.service.TransferService;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.Transfer;
import com.smzdz.manager.TransferBatchManager;
import com.smzdz.manager.TransferManager;
import com.smzdz.service.TransferBatchService;
import com.smzdz.service.TransferService;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/15 11:22
 */
@Component
public class TransferManagerImpl implements TransferManager {

    @Autowired
    private TransferService transferService;

    @Override
    public ResultListBean<Transfer> selectByPaging(Pager pager) {
        ResultListBean<Transfer> resultListBean = ResultListBean.build();
        List<Transfer> resultList = null;
        try {
            int totalCount = transferService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = transferService.selectTransferInfo(pager);
            }
            resultListBean.success(resultList, totalCount);
        } catch (Exception e) {
            e.printStackTrace();
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }

    @Override
    public ResultListBean<Transfer> selectBatchDetail(String batchNo, Integer appId) {
        ResultListBean<Transfer> resultListBean = ResultListBean.build();
        List<Transfer> resultList = null;
        try {
            resultList = transferService.selectTransferDetailInfo(batchNo, appId);
            resultListBean.success(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }
}
