package com.smzdz.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.smzdz.util.Constant;
import com.smzdz.entity.PayFee;
import com.smzdz.util.Constant;

/**
 * Created by liwei on 2015/3/18.
 */
public class PayFeeModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6939889330768694353L;

	public PayFeeModel(PayFee fee){
    	this.setPayFeeType(fee.getPayFeeType());
    	this.setCreateTime(fee.getCreateTime());
    	this.setFee(fee.getFee());
    	this.setFeeRate(fee.getFeeRate());
    	this.setFeeType(fee.getFeeType());
    	this.setId(fee.getId());
    	this.setAgencyCode(fee.getAgencyCode());
    	this.setLowerLimit(fee.getLowerLimit());
    	this.setMerchantNo(fee.getMerchantNo());
    	this.setModifyTime(fee.getModifyTime());
    	this.setName(fee.getName());
    	this.setStatus(fee.getStatus());
    	this.setUpperLimit(fee.getUpperLimit());
    	this.setPayFeeTypeStr(Constant.PAY_FEETYPE_MAP.get(fee.getPayFeeType()));
    	this.setFeeTypeStr(Constant.FEE_TYPE_MAP.get(fee.getFeeType()));
    	this.setStatusStr(Constant.FEE_STAUTS_MAP.get(fee.getStatus()));
    	this.setAccessPlatform(fee.getAccessPlatform());
    	this.setAccessPlatformStr(Constant.ACCESSPLAT_MAP.get(fee.getAccessPlatform()));
    }
	
    private String id;
	private String payFeeTypeStr;
    private String feeTypeStr;
    private String statusStr;
    
    /**
     * 付款方式：1，网银 2，第三方  3，扫码支付，4.SDK    5：不区分
     */
    private Integer payFeeType;

    private String name;

    /**
     * 费率类型1：按比率；2按定额
     */
    private Integer feeType;

    /**
     * 固定手续费，单位：分；
     */
    private BigDecimal fee;

    /**
     * 手续费率，费率类型为按比率
     */
    private BigDecimal feeRate;

    /**
     * 手续费保底，单位：分，-1表示下不保底；定额费率此项无效
     */
    private BigDecimal lowerLimit;

    /**
     * 手续费封顶，单位：分，-1表示上不封顶；定额费率此项无效
     */
    private BigDecimal upperLimit;
    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 启用状态0：未启用；1：已启用
     */
    private Integer status;

    /**
     * 机构编码
     */
    private String agencyCode;
    //创建时间
    private Date createTime;
    //修改时间
    private Date modifyTime;
    //接入平台
    private Integer accessPlatform;
    //接入平台str
    private String accessPlatformStr;
    
    public PayFeeModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPayFeeType() {
        return payFeeType;
    }

    public void setPayFeeType(Integer payFeeType) {
        this.payFeeType = payFeeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(BigDecimal upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
    
    public String getPayFeeTypeStr() {
		return payFeeTypeStr;
	}

	public void setPayFeeTypeStr(String payFeeTypeStr) {
		this.payFeeTypeStr = payFeeTypeStr;
	}

	public String getFeeTypeStr() {
		return feeTypeStr;
	}

	public void setFeeTypeStr(String feeTypeStr) {
		this.feeTypeStr = feeTypeStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

    public Integer getAccessPlatform() {
        return accessPlatform;
    }

    public void setAccessPlatform(Integer accessPlatform) {
        this.accessPlatform = accessPlatform;
    }

    public String getAccessPlatformStr() {
        return accessPlatformStr;
    }

    public void setAccessPlatformStr(String accessPlatformStr) {
        this.accessPlatformStr = accessPlatformStr;
    }

}
