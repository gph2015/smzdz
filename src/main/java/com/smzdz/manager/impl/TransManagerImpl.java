package com.smzdz.manager.impl;

import com.smzdz.manager.TransManager;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransStatisModel;
import com.smzdz.service.PayFeeService;
import com.smzdz.service.TransQueryService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.enums.PayOrderStatus;
import com.smzdz.manager.TransManager;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransStatisModel;
import com.smzdz.service.PayFeeService;
import com.smzdz.service.TransQueryService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import org.apache.kahadb.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 交易manager
 * Created by qibaichao on 2015/3/12.
 */
@Component
public class TransManagerImpl implements TransManager {

    private static final Logger logger = LoggerFactory.getLogger(TransManagerImpl.class);

    @Autowired
    private TransQueryService transQueryService;
    //    @Autowired
//    private PayOrderRelationService payOrderRelationService;
//    @Autowired
//    private PayResDetailService payResDetailService;
    @Autowired
    private PayFeeService payFeeService;


    @Override
    public ResultListBean<TransQueryModel> selectByPaging(Pager pager) {
        ResultListBean<TransQueryModel> resultListBean = ResultListBean.build();
        List<TransQueryModel> resultList = null;
        try {
            int totalCount = transQueryService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = transQueryService.selectByPaging(pager);
            }
            resultListBean.success(resultList, totalCount);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("PayCheckManager selectByPaging  Error: ", e);
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }

    @Override
    public ResultListBean<TransStatisModel> statis(Pager pager) {
        ResultListBean<TransStatisModel> resultListBean = ResultListBean.build();
        List<TransStatisModel> resultList = null;
        try {
            int totalCount = 0;
            resultList = transQueryService.statis(pager);
            if(resultList != null)
                totalCount = resultList.size();
            resultListBean.success(resultList, totalCount);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("PayCheckManager statis  Error: ", e);
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultListBean;
    }

//    @Override
//    public ResultBean<TransQueryModel> selectByPayId(String payId) {
//        ResultBean<TransQueryModel> resultBean = ResultBean.build();
//        PayOrderInfo payOrderInfo = null;
//        try {
//            payOrderInfo = payOrderService.selectByPayId(payId);
//            TransQueryModel transQueryModel = new TransQueryModel();
//            if (payOrderInfo != null) {
//                transQueryModel.build(payOrderInfo);
//                PayOrderRelation payOrderRelation = payOrderRelationService.selectByPayId(payId);
//                if (payOrderRelation != null) {
//                    PayResDetail payResDetail = payResDetailService.selectByPayDetailId(payOrderRelation.getPayDetailId());
//                    if (payResDetail != null) {
//                        transQueryModel.build(payResDetail);
//                        //计算渠道手续费
//                        BigDecimal payAmount = payOrderInfo.getOrderMoney().subtract(payOrderInfo.getRefundMoney());
//                        BigDecimal payFee = payFeeService.getPayFee(payAmount, payResDetail.getMerchantNo(), payResDetail.getPayFeeType());
//                        if (payFee.compareTo(BigDecimal.valueOf(-1)) != 0) {
//                            transQueryModel.setPayFee(payFee);
//                            //计算收入
//                            BigDecimal income = payOrderInfo.getOrderMoney().subtract(payOrderInfo.getRefundMoney()).subtract(payFee);
//                            transQueryModel.setIncome(income);
//                        }
//                    }
//                }
//            }
//            resultBean.success(transQueryModel);
//        } catch (Exception e) {
//            logger.error("TransManagerImpl selectByPayId  Error: ", e);
//            resultBean.withError(ResultStatus.SYSTEM_ERROR);
//        }
//        return resultBean;
//    }


    @Override
    public ResultBean<TransQueryModel> selectByPayId(String payId) {
        ResultBean<TransQueryModel> resultBean = ResultBean.build();
        TransQueryModel transQueryModel = null;
        try {
            transQueryModel = transQueryService.selectPayOrderByPayId(payId);
            //支付未完成
            if (transQueryModel == null || transQueryModel.getPayOrderStatus() != PayOrderStatus.SUCCESS.getValue()) {
                resultBean.success(transQueryModel);
                return resultBean;
            }
            //支付完成Success
            if (transQueryModel.getPayOrderStatus() == PayOrderStatus.SUCCESS.getValue()) {
                transQueryModel = transQueryService.selectSuccessByPayId(payId);
                //支付手续费
                BigDecimal payFee = transQueryModel.getPayFee();
                //退款手续费
                BigDecimal refundFee = BigDecimal.ZERO;
                if (transQueryModel.getRefundFlag() != 1) {
                    refundFee = transQueryService.selectRefundFee(transQueryModel.getPayId());
                }
                //计算手续费
                BigDecimal fee = payFee.add(refundFee);
                BigDecimal income = transQueryModel.getOrderMoney().subtract(transQueryModel.getRefundMoney()).subtract(fee);
                transQueryModel.setIncome(income);
            }
            resultBean.success(transQueryModel);
        } catch (Exception e) {
            logger.error("TransManagerImpl selectByPayId  Error: ", e);
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
        }
        return resultBean;
    }


//    private List<TransQueryModel> covertData(List<PayOrderInfo> list) {
//        if (null == list || list.size() == 0)
//            return null;
//        List<TransQueryModel> returnList = new ArrayList<TransQueryModel>();
//        TransQueryModel model = null;
//        for (PayOrderInfo info : list) {
//            model = new TransQueryModel();
//            model.build(info);
//            returnList.add(model);
//        }
//        return returnList;
//    }
}
