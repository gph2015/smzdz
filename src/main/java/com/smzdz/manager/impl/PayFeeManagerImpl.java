package com.smzdz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.smzdz.manager.PayFeeManager;
import com.smzdz.util.result.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smzdz.entity.PayFee;
import com.smzdz.manager.PayFeeManager;
import com.smzdz.model.PayFeeModel;
import com.smzdz.service.PayFeeService;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.ServiceException;

@Component
public class PayFeeManagerImpl implements PayFeeManager {

	@Autowired
	private PayFeeService service;
	
	@Override
	public ResultBean<PayFeeModel> getById(String id) {
		ResultBean<PayFeeModel> result = ResultBean.build();
		try {
			PayFee fee = service.getById(id);
			result.success(new PayFeeModel(fee));
		} catch (ServiceException e) {
			result.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultListBean<PayFeeModel> selectPayFeeList(String payFeeType,
			String agencyCode) {
		ResultListBean<PayFeeModel> resultListBean = ResultListBean.build();
		try {
			List<PayFee> resultList = service.selectPayFeeList(payFeeType,
					agencyCode);
			resultListBean.success(covertData(resultList));
		} catch (ServiceException e) {
			resultListBean.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return resultListBean;
	}

	private List<PayFeeModel> covertData(List<PayFee> resultList) {
		if (null == resultList || resultList.size() == 0)
			return null;
		List<PayFeeModel> list = new ArrayList<PayFeeModel>();
		PayFeeModel model = null;
		for (PayFee info : resultList) {
			model = new PayFeeModel(info);
			list.add(model);
		}
		return list;
	}
	
	@Override
	public ResultBasicBean<Boolean> insertPayFee(PayFee payFee) {
		ResultBasicBean<Boolean> result = ResultBasicBean.build();
		try {
			int count = service.getCount(String.valueOf(payFee.getPayFeeType()), payFee.getMerchantNo(),payFee.getAccessPlatform());
			if (count > 0) {
				result.withError(ResultStatus.ADD_AGENCY_ERROR);
				return result;
			}
			service.insertPayFee(payFee);
		} catch (ServiceException e) {
			result.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultBasicBean<Boolean> updatePayFee(PayFee payFee) {
		ResultBasicBean<Boolean> result = ResultBasicBean.build();
		try {
			service.updatePayFee(payFee);
		} catch (ServiceException e) {
			result.withError(ResultStatus.SYSTEM_ERROR);
			e.printStackTrace();
		}
		return result;
	}
	
	

}
