package com.smzdz.manager.impl;

import com.smzdz.entity.PayCheckDiff;
import com.smzdz.entity.PayCheckResult;
import com.smzdz.manager.PayCheckManager;
import com.smzdz.model.PayCheckDiffModel;
import com.smzdz.service.PayCheckDiffService;
import com.smzdz.service.PayCheckResultService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.PayCheckDiff;
import com.smzdz.entity.PayCheckResult;
import com.smzdz.manager.PayCheckManager;
import com.smzdz.model.PayCheckDiffModel;
import com.smzdz.model.PayCheckResultModel;
import com.smzdz.service.PayCheckDiffService;
import com.smzdz.service.PayCheckResultService;
import com.smzdz.service.PayCheckService;
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
 * Created by qibaichao on 2015/3/12.
 */
@Component
public class PayCheckManagerImpl implements PayCheckManager {

    private static final Logger logger = LoggerFactory.getLogger(PayCheckManagerImpl.class);

    @Autowired
    private PayCheckService payCheckService;

    @Autowired
    private PayCheckResultService payCheckResultService;

    @Autowired
    private PayCheckDiffService payCheckDiffService;


//    @Override
//    public ResultBean<Map> sumCountAndAmt(Pager pager) {
//
//        ResultBean<Map> resultBean = ResultBean.build();
//        try {
//            Map<String, String> map=payCheckService.sumCountAndAmt(pager);
//            resultBean.success(map);
//        }catch (Exception e){
//            logger.error("PayCheckManager sumCountAndAmt  Error: ", e);
//            resultBean.withError(ResultStatus.SYSTEM_ERROR);
//
//        }
//        return resultBean;
//    }
//
//    @Override
//    public ResultListBean<PayCheckModel> selectByPaging(Pager pager) {
//
//        ResultListBean<PayCheckModel> resultListBean = ResultListBean.build();
//        List<PayCheckModel>  resultList =null;
//        try {
//
//           int  totalCount= payCheckService.selectCount(pager);
//            if (totalCount > 0) {
//                pager.resetTotalCount(totalCount);
//                resultList=payCheckService.selectByPaging(pager);
//            }
//            resultListBean.success(resultList,totalCount);
//        }catch (Exception e){
//            logger.error("PayCheckManager selectByPaging  Error: ", e);
//            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
//        }
//        return resultListBean;
//    }


    @Override
    public ResultListBean<PayCheckResultModel> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode, Integer status) {

        ResultListBean<PayCheckResultModel> resultListBean = ResultListBean.build();
        try {
            checkDate = checkDate.replace("-", "");
            List<PayCheckResult> resultList = payCheckResultService.selectByDateAndAgency(checkDate, agencyCode, bizCode, status);
            resultListBean.success(covertPayCheckResult(resultList));
        } catch (Exception e) {
            logger.error("PayCheckResultManager selectByDataAndAgency  Error: ", e);
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }


    @Override
    public ResultBean<Map> sumDiffCountAndAmt(Pager pager) {
        ResultBean<Map> resultBean = ResultBean.build();
        try {
            Map<String, String> map = payCheckDiffService.sumCountAndAmt(pager);
            resultBean.success(map);
        } catch (Exception e) {
            logger.error("PayCheckDiffManager sumCountAndAmt  Error: ", e);
            resultBean.withError(ResultStatus.SYSTEM_ERROR);

        }
        return resultBean;
    }

    @Override
    public ResultListBean<PayCheckDiffModel> selectDiffByPaging(Pager pager) {
        ResultListBean<PayCheckDiffModel> resultListBean = ResultListBean.build();
        List<PayCheckDiff> resultList = null;
        try {

            int totalCount = payCheckDiffService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = payCheckDiffService.selectByPaging(pager);
            }

            resultListBean.success(covertPayCheckDiff(resultList), totalCount);
        } catch (Exception e) {
            logger.error("PayCheckManager selectByPaging  Error: ", e);
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }

    @Override
    public ResultBean<PayCheckDiffModel> selectDiffById(Long id) {
        ResultBean<PayCheckDiffModel> resultBean = ResultBean.build();
        PayCheckDiff payCheckDiff = null;
        try {
            payCheckDiff = payCheckDiffService.selectDiffById(id);
            PayCheckDiffModel model = new PayCheckDiffModel();
            model.build(payCheckDiff);
            resultBean.success(model);
        } catch (Exception e) {
            logger.error("PayCheckDiffManager selectDiffById  Error: ", e);
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultBean;
    }

    @Override
    public ResultBean processDiff(Long id, String remark) {
        ResultBean resultBean = ResultBean.build();
        PayCheckDiff payCheckDiff = null;
        try {
            payCheckDiffService.processDiff(id, remark);
        } catch (Exception e) {
            logger.error("PayCheckDiffManager processDiff  Error: ", e);
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultBean;
    }

    @Override
    public void processResultStatus(String checkDate, String agencyCode, Integer bizCode) {
        try {
            int count = payCheckDiffService.selectNoProcessCount(checkDate, agencyCode, bizCode);
            //修改对账结果为已经人工处理
            if (count == 0) {
                payCheckResultService.updateResultStatus(checkDate, agencyCode, bizCode);
            }
        } catch (Exception e) {
            logger.error("PayCheckDiffManager processDiff  Error: ", e);
        }
    }


    private List<PayCheckDiffModel> covertPayCheckDiff(List<PayCheckDiff> list) {
        if (null == list || list.size() == 0)
            return null;
        List<PayCheckDiffModel> returnList = new ArrayList<PayCheckDiffModel>();
        PayCheckDiffModel model = null;
        for (PayCheckDiff info : list) {
            model = new PayCheckDiffModel();
            model.build(info);
            returnList.add(model);
        }
        return returnList;
    }

    private List<PayCheckResultModel> covertPayCheckResult(List<PayCheckResult> list) {
        if (null == list || list.size() == 0)
            return null;
        List<PayCheckResultModel> returnList = new ArrayList<PayCheckResultModel>();
        PayCheckResultModel model = null;
        for (PayCheckResult info : list) {
            model = new PayCheckResultModel();
            model.build(info);
            returnList.add(model);
        }
        return returnList;
    }
}
