package com.smzdz.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qibaichao on 2015/3/12.
 */
public class PayCheckModel implements Serializable {

    /**
     * id
     */
    private long id;
    /**
     * 支付流水号
     */
    private String instructId;
    /**
     * 支付平台流水号
     */
    private String outOrderId;
    /**
     * 业务代码
     */
    private int bizCode;
    /**
     * 交易日期
     */
    private Date outTransTime;
    /**
     * 机构金额
     */
    private BigDecimal outBizAmt;
    /**
     * 机构手续费
     */
    private BigDecimal outCommissionFeeAmt;
    /**
     *我方金额
     */
    private BigDecimal bizAmt;
    /**
     * 我方手续费
     */
    private BigDecimal commissionFeeAmt;
    /**
     * 对账状态
     */
    private int status;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getBizCode() {
        return bizCode;
    }

    public void setBizCode(int bizCode) {
        this.bizCode = bizCode;
    }

    public Date getOutTransTime() {
        return outTransTime;
    }

    public void setOutTransTime(Date outTransTime) {
        this.outTransTime = outTransTime;
    }

    public BigDecimal getOutBizAmt() {
        return outBizAmt;
    }

    public void setOutBizAmt(BigDecimal outBizAmt) {
        this.outBizAmt = outBizAmt;
    }

    public BigDecimal getOutCommissionFeeAmt() {
        return outCommissionFeeAmt;
    }

    public void setOutCommissionFeeAmt(BigDecimal outCommissionFeeAmt) {
        this.outCommissionFeeAmt = outCommissionFeeAmt;
    }

    public BigDecimal getBizAmt() {
        return bizAmt;
    }

    public void setBizAmt(BigDecimal bizAmt) {
        this.bizAmt = bizAmt;
    }

    public BigDecimal getCommissionFeeAmt() {
        return commissionFeeAmt;
    }

    public void setCommissionFeeAmt(BigDecimal commissionFeeAmt) {
        this.commissionFeeAmt = commissionFeeAmt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}
