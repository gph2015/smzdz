package com.smzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smzdz.entity.PayFee;

/**
 * User: Liwei
 * Date: 15/3/19
 * Time: 上午11:34
 * Description:
 */
@Repository
public interface PayFeeDao {

	/**
	 * 查一条
	 * @param id
	 * @return
	 */
	public PayFee getById(String id);
	
	/**
	 * 查列表
	 * @param payFeeType
	 * @param agencyCode
	 * @return
	 */
    public List<PayFee> selectPayFeeList(@Param("payFeeType")String payFeeType,@Param("agencyCode")String agencyCode);
    
    /**
     * 新增
     * @param payFee
     * @return
     */
    public int insertPayFee(PayFee payFee);
    
    /**
     * 修改
     * @param payFee
     * @return
     */
    public int updatePayFee(PayFee payFee);
    
    /**
     * 去重校验
     * @param payFeeType
     * @param merchantNo
     * @param accessPlatform
     * @return
     */
    public int getCount(@Param("payFeeType")String payFeeType,@Param("merchantNo")String merchantNo,
                        @Param("accessPlatform")Integer accessPlatform);

    /**
     * 根据商户和付款类型获取支付手续费
     * @param merchantNo 商户号
     * @param payFeeType 1，网银 2，第三方  3，扫码支付，4.SDK
     * @return 手续费entity
     */
    public PayFee getPayFee(@Param("merchantNo")String merchantNo,@Param("payFeeType")Integer payFeeType);
}
