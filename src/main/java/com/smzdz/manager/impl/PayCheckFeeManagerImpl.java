package com.smzdz.manager.impl;

import com.smzdz.model.PayCheckFeeDiffModel;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.PayCheckDiff;
import com.smzdz.entity.PayCheckFeeDiff;
import com.smzdz.entity.PayCheckFeeResult;
import com.smzdz.manager.PayCheckFeeManager;
import com.smzdz.model.PayCheckFeeDiffModel;
import com.smzdz.model.PayCheckFeeResultModel;
import com.smzdz.service.PayCheckFeeDiffService;
import com.smzdz.service.PayCheckFeeResultService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/23.
 * 手续费对账结果查询
 */
@Component
public class PayCheckFeeManagerImpl implements PayCheckFeeManager {

    private static final Logger logger = LoggerFactory.getLogger(PayCheckFeeManagerImpl.class);

    @Autowired
    private PayCheckFeeResultService payCheckFeeResultService;

    @Autowired
    private PayCheckFeeDiffService payCheckFeeDiffService;

    @Override
    public ResultListBean<PayCheckFeeResultModel> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode, Integer status) {
        ResultListBean<PayCheckFeeResultModel> resultListBean = ResultListBean.build();
        try {
            checkDate = checkDate.replace("-", "");
            List<PayCheckFeeResult> resultList = payCheckFeeResultService.selectByDateAndAgency(checkDate, agencyCode, bizCode, status);
            //负数 取正
            for (PayCheckFeeResult payCheckFeeResult : resultList) {
                payCheckFeeResult.setTotalFee(payCheckFeeResult.getTotalFee().abs());
                payCheckFeeResult.setOutTotalFee(payCheckFeeResult.getOutTotalFee().abs());
            }
            resultListBean.success(covertPayCheckFeeResult(resultList));
        } catch (Exception e) {
            logger.error("PayCheckFeeResultManager selectByDataAndAgency  Error: ", e);
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }


    @Override
    public ResultBean<Map> sumDiffCountAndAmt(Pager pager) {
        ResultBean<Map> resultBean = ResultBean.build();
        try {
            Map<String, String> map = payCheckFeeDiffService.sumCountAndAmt(pager);
            resultBean.success(map);
        } catch (Exception e) {
            logger.error("PayCheckFeeDiffManager sumCountAndAmt  Error: ", e);
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultBean;
    }

    @Override
    public ResultListBean<PayCheckFeeDiffModel> selectDiffByPaging(Pager pager) {
        ResultListBean<PayCheckFeeDiffModel> resultListBean = ResultListBean.build();
        List<PayCheckFeeDiff> resultList = null;
        try {
            int totalCount = payCheckFeeDiffService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = payCheckFeeDiffService.selectByPaging(pager);
            }
            resultListBean.success(covertPayCheckFeeDiff(resultList), totalCount);
        } catch (Exception e) {
            logger.error("PayCheckFeeDiffManager selectByPaging  Error: ", e);
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }

    @Override
    public ResultBean<PayCheckFeeDiffModel> selectDiffById(Long id) {

        ResultBean<PayCheckFeeDiffModel> resultBean = ResultBean.build();
        try {
            PayCheckFeeDiff payCheckFeeDiff = payCheckFeeDiffService.selectDiffById(id);
            PayCheckFeeDiffModel model = new PayCheckFeeDiffModel();
            model.build(payCheckFeeDiff);
            resultBean.success(model);
        } catch (Exception e) {
            logger.error("PayCheckFeeDiffManager selectDiffById  Error: ", e);
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultBean;
    }

    @Override
    public ResultBean processDiff(Long id, String remark) {
        ResultBean resultBean = ResultBean.build();
        PayCheckDiff payCheckDiff = null;
        try {
            payCheckFeeDiffService.processDiff(id, remark);
        } catch (Exception e) {
            logger.error("PayCheckFeeDiffManager processDiff  Error: ", e);
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultBean;
    }

    private List<PayCheckFeeDiffModel> covertPayCheckFeeDiff(List<PayCheckFeeDiff> list) {
        if (null == list || list.size() == 0)
            return null;
        List<PayCheckFeeDiffModel> returnList = new ArrayList<PayCheckFeeDiffModel>();
        PayCheckFeeDiffModel model = null;
        for (PayCheckFeeDiff info : list) {
            model = new PayCheckFeeDiffModel();
            model.build(info);
            returnList.add(model);
        }
        return returnList;
    }

    private List<PayCheckFeeResultModel> covertPayCheckFeeResult(List<PayCheckFeeResult> list) {
        if (null == list || list.size() == 0)
            return null;
        List<PayCheckFeeResultModel> returnList = new ArrayList<PayCheckFeeResultModel>();
        PayCheckFeeResultModel model = null;
        for (PayCheckFeeResult info : list) {
            model = new PayCheckFeeResultModel();
            model.build(info);
            returnList.add(model);
        }
        return returnList;
    }
}
