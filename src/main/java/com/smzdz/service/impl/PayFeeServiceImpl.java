package com.smzdz.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.smzdz.dao.PayFeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smzdz.dao.PayFeeDao;
import com.smzdz.entity.PayFee;
import com.smzdz.service.PayFeeService;
import com.smzdz.util.utils.ServiceException;

@Service
public class PayFeeServiceImpl implements PayFeeService {

	@Autowired
	private PayFeeDao dao;
	
	@Override
	public PayFee getById(String id) throws ServiceException{
		return dao.getById(id);
	}

	@Override
	public List<PayFee> selectPayFeeList(String payFeeType, String agencyCode) throws ServiceException{
		return dao.selectPayFeeList(payFeeType, agencyCode);
	}

	@Override
	public int insertPayFee(PayFee payFee) throws ServiceException{
		return dao.insertPayFee(payFee);
	}

	@Override
	public int updatePayFee(PayFee payFee) throws ServiceException{
		return dao.updatePayFee(payFee);
	}

	@Override
	public int getCount(String payFeeType, String merchantNo,Integer accessPlatform) throws ServiceException{
		return dao.getCount(payFeeType, merchantNo,accessPlatform);
	}
	
	@Override
    public BigDecimal getPayFee(BigDecimal payAmount,String merchantNo, Integer payFeeType) throws ServiceException {

        BigDecimal fee = new BigDecimal(-1);
        PayFee feeInfo = dao.getPayFee(merchantNo,payFeeType);

        if(feeInfo == null){
            return fee;
        }
        /* 按定额方式获取手续费 */
        if(feeInfo.getFeeType() == 2)
            fee = feeInfo.getFee();
        //按 比例
        if(feeInfo.getFeeType() == 1){
            BigDecimal feeRate = feeInfo.getFeeRate();
            fee = payAmount.multiply(feeRate).setScale(5, BigDecimal.ROUND_HALF_UP);
            if(!feeInfo.getLowerLimit().equals(BigDecimal.valueOf(-1).setScale(2))){
                //有保底值,小于保底值则取保底值
                BigDecimal lower = feeInfo.getLowerLimit().setScale(2, BigDecimal.ROUND_HALF_UP);
                fee = fee.compareTo(lower) < 0 ? lower :fee;
            }
            if(!feeInfo.getUpperLimit().equals(BigDecimal.valueOf(-1).setScale(2))){
                //有封顶值，大于封顶值则取封顶值
                BigDecimal upper = feeInfo.getUpperLimit().setScale(2, BigDecimal.ROUND_HALF_UP);
                fee = fee.compareTo(upper) < 0 ? fee : upper;
            }
        }
        return fee;
    }

}
