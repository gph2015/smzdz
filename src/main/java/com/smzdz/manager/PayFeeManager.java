package com.smzdz.manager;

import com.smzdz.entity.PayFee;
import com.smzdz.model.PayFeeModel;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;

public interface PayFeeManager {

	/**
	 * 查一条
	 * @param id
	 * @return
	 */
	public ResultBean<PayFeeModel>  getById(String id);
	
	/**
	 * 查列表
	 * @param payFeeType
	 * @param agencyCode
	 * @return
	 */
    public ResultListBean<PayFeeModel>  selectPayFeeList(String payFeeType,String agencyCode);
    
    /**
     * 新增
     * @param payFee
     * @return
     */
    public ResultBasicBean<Boolean> insertPayFee(PayFee payFee);
    
    /**
     * 修改
     * @param payFee
     * @return
     */
    public ResultBasicBean<Boolean> updatePayFee(PayFee payFee);

}
