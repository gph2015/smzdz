package com.smzdz.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易报表Model
 * Created by qibaichao on 2015/3/27
 */
public class TransReportModel {

    /**
     * id
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date modifyTime;
    /**
     * 版本
     */
    private Short version;
    /**
     * 我方流水号
     */
    private String instructId;
    /**
     * 对方流水号
     */
    private String outOrderId;
    /**
     * 业务代码
     */
    private Integer bizCode;
    /**
     * 交易时间
     */
    private Date outTransTime;
    /**
     * 金额
     */
    private BigDecimal bizAmt;
    /**
     * 费率
     */
    private BigDecimal feeRate;
    /**
     * 手续费
     */
    private BigDecimal commissionFeeAmt;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 接入平台
     */
    private Integer accessPlatform;
    /**
     * 业务平台ID
     */
    private Integer appId;
    /**
     * 付款方式
     */
    private Integer payType;

    /**
     * 支付渠道 编码
     */
    private String bankCode;

    /**
     * 对账日期
     */
    private String checkDate;
    /**
     * 机构编码
     */
    private String agencyCode;

    /**
     * 商户号
     */
    private String merchantNo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public String getInstructId() {
        return instructId;
    }

    public void setInstructId(String instructId) {
        this.instructId = instructId;
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId;
    }

    public Integer getBizCode() {
        return bizCode;
    }

    public void setBizCode(Integer bizCode) {
        this.bizCode = bizCode;
    }

    public Date getOutTransTime() {
        return outTransTime;
    }

    public void setOutTransTime(Date outTransTime) {
        this.outTransTime = outTransTime;
    }

    public BigDecimal getBizAmt() {

//        if (bizAmt.compareTo(BigDecimal.ZERO) == 0) {
//            bizAmt = null;
//        }
        return bizAmt;
    }

    public void setBizAmt(BigDecimal bizAmt) {
        this.bizAmt = bizAmt;
    }

    public BigDecimal getCommissionFeeAmt() {

//        if (commissionFeeAmt.compareTo(BigDecimal.ZERO) == 0) {
//            commissionFeeAmt = null;
//        }
        return commissionFeeAmt;
    }

    public void setCommissionFeeAmt(BigDecimal commissionFeeAmt) {
        this.commissionFeeAmt = commissionFeeAmt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAccessPlatform() {
        return accessPlatform;
    }

    public void setAccessPlatform(Integer accessPlatform) {
        this.accessPlatform = accessPlatform;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }
}
