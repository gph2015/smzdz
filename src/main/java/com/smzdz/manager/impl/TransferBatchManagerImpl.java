package com.smzdz.manager.impl;

import java.util.Date;
import java.util.List;

import com.smzdz.manager.TransferBatchManager;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smzdz.entity.TransferBatch;
import com.smzdz.manager.TransferBatchManager;
import com.smzdz.service.TransferBatchService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 11:22
 */
@Component
public class TransferBatchManagerImpl implements TransferBatchManager {

    @Autowired
    private TransferBatchService transferBatchService;

    @Override
    public ResultListBean<TransferBatch> selectByPaging(Pager pager) {
        ResultListBean<TransferBatch> resultListBean = ResultListBean.build();
        List<TransferBatch> resultList = null;
        try {
            int totalCount = transferBatchService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = transferBatchService.selectBatchInfo(pager);
            }
            resultListBean.success(resultList, totalCount);
        } catch (Exception e) {
            e.printStackTrace();
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }

    @Override
    public ResultBean<TransferBatch> selectTransferBatchDetail(String batchNo, Integer appId) {

        ResultBean<TransferBatch> result = ResultBean.build();
        try {
            TransferBatch bankAlias = transferBatchService.selectTransferBatchDetail(batchNo, appId);
            result.setValue(bankAlias);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBean updateBatchAudit(PMap params) {
        ResultBean result = ResultBean.build();
        try {
            params.put("auditTime", new Date());
            transferBatchService.updateBatchAudit(params);
        } catch (Exception e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }
}
