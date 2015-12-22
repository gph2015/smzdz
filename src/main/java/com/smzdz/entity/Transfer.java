package com.smzdz.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 代付单 t_pay_transfer 对应entity
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 15:41
 */
public class Transfer implements Serializable {

    private Integer id;                //自增id
    private Date createTime;           //创建时间
    private Date modifyTime;           //修改时间
    private Integer appId;             //app的id
    private String batchNo;            //流程实例号
    private String outRef;             //外部关联号
    private Integer payStatus;         //付款状态
    private String recBankacc;         //收款方银行账号
    private String recName;            //收款方真实姓名
    private BigDecimal payAmt;         //付款金额
    private BigDecimal fee;            //手续费
    private String payDesc;            //付款说明
    private String bankFlag;           //系统内部标志
    private String otherBank;          //他行开户行
    private String otherCity;          //他行开户地
    private String resultDesc;         //结果描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getOutRef() {
        return outRef;
    }

    public void setOutRef(String outRef) {
        this.outRef = outRef;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getRecBankacc() {
        return recBankacc;
    }

    public void setRecBankacc(String recBankacc) {
        this.recBankacc = recBankacc;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public BigDecimal getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getPayDesc() {
        return payDesc;
    }

    public void setPayDesc(String payDesc) {
        this.payDesc = payDesc;
    }

    public String getBankFlag() {
        return bankFlag;
    }

    public void setBankFlag(String bankFlag) {
        this.bankFlag = bankFlag;
    }

    public String getOtherBank() {
        return otherBank;
    }

    public void setOtherBank(String otherBank) {
        this.otherBank = otherBank;
    }

    public String getOtherCity() {
        return otherCity;
    }

    public void setOtherCity(String otherCity) {
        this.otherCity = otherCity;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
