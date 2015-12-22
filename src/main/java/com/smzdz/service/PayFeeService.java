package com.smzdz.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smzdz.entity.PayFee;
import com.smzdz.util.utils.ServiceException;

public interface PayFeeService {

	/**
	 * 查一条
	 * @param id
	 * @return
	 */
	public PayFee getById(String id) throws ServiceException;
	
	/**
	 * 查列表
	 * @param payFeeType
	 * @param agencyCode
	 * @return
	 */
	public List<PayFee> selectPayFeeList(
			String payFeeType,String agencyCode) throws ServiceException;
    
    /**
     * 新增
     * @param payFee
     * @return
     */
    public int insertPayFee(PayFee payFee) throws ServiceException;
    
    /**
     * 修改
     * @param payFee
     * @return
     */
    public int updatePayFee(PayFee payFee) throws ServiceException;
    
    /**
     * 去重校验
     * @param payFeeType
     * @param merchantNo
     * @param accessPlatform
     * @return
     */
    public int getCount(String payFeeType,String merchantNo,Integer accessPlatform) throws ServiceException;
    
    /**
     * 计算支付手续费
     * @param payAmount
     * @param merchantNo
     * @param payFeeType
     * @return
     * @throws ServiceException
     */
    public BigDecimal getPayFee(BigDecimal payAmount,String merchantNo, Integer payFeeType) throws ServiceException;
}
