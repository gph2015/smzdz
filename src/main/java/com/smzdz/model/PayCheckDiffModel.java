package com.smzdz.model;

import com.smzdz.entity.PayCheckDiff;
import com.smzdz.entity.PayCheckDiff;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qibaichao on 2015/3/26.
 */
public class PayCheckDiffModel implements Serializable {

    /**
     * id
     */
    private long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date modifyTime;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 我方流水号
     */
    private String instructId;
    /**
     * 我方金额
     */
    private BigDecimal bizAmt;
    /**
     * 对方流水号
     */
    private String outOrderId;
    /**
     * 对方金额
     */
    private BigDecimal outBizAmt;
    /**
     * 业务代码
     */
    private Integer bizCode;
    /**
     * 交易时间
     */
    private Date outTransTime;
    /**
     * 差异类型
     */
    private Integer diffType;
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
    /**
     * 处理状态
     */
    private Integer handleStatus;
    /**
     * 备注
     */
    private String remark;

    public void build(PayCheckDiff payCheckDiff) {
        if (payCheckDiff != null) {
            this.id = payCheckDiff.getId();
            this.createTime = payCheckDiff.getCreateTime();
            this.modifyTime = payCheckDiff.getModifyTime();
            this.version = payCheckDiff.getVersion();
            this.instructId = payCheckDiff.getInstructId();
            this.bizAmt = payCheckDiff.getBizAmt();
            this.outOrderId = payCheckDiff.getOutOrderId();
            this.outBizAmt = payCheckDiff.getOutBizAmt();
            this.bizCode = payCheckDiff.getBizCode();
            this.outTransTime = payCheckDiff.getOutTransTime();
            this.diffType = payCheckDiff.getDiffType();
            this.checkDate = payCheckDiff.getCheckDate();
            this.agencyCode = payCheckDiff.getAgencyCode();
            this.merchantNo = payCheckDiff.getMerchantNo();
            this.handleStatus = payCheckDiff.getHandleStatus();
            this.remark = payCheckDiff.getRemark();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getInstructId() {
        return instructId;
    }

    public void setInstructId(String instructId) {
        this.instructId = instructId;
    }

    public BigDecimal getBizAmt() {
        return bizAmt;
    }

    public void setBizAmt(BigDecimal bizAmt) {
        this.bizAmt = bizAmt;
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId;
    }

    public BigDecimal getOutBizAmt() {
        return outBizAmt;
    }

    public void setOutBizAmt(BigDecimal outBizAmt) {
        this.outBizAmt = outBizAmt;
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

    public int getDiffType() {
        return diffType;
    }

    public void setDiffType(int diffType) {
        this.diffType = diffType;
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

    public int getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(int handleStatus) {
        this.handleStatus = handleStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
