package com.smzdz.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 批次表 t_pay_transfer_batch 对应entity
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 15:19
 */
public class TransferBatch implements Serializable {

    private Integer id;                //自增id
    private Date createTime;           //创建时间
    private Date modifyTime;           //修改时间
    private Integer appId;             //app的id
    private String batchNo;            //批次Id
    private Integer userId;            //审核人
    private Date auditTime;            //审核时间
    private Integer tradeState;        //交易状态
    private String auditDesc;        //交易状态
    private String resultDesc;         //结果说明
    private String reqNbr;             //流程实例号
    private String companyName;         //公司名称
    private String dbtAcc;             //转出账户
    private String bbkNbr;             //分行代码
    private String busCod;             //业务类型
    private String busMod;             //业务模式编号
    private String trsTyp;             //交易代码
    private Integer planTotal;         //计划笔数
    private Integer sucTotal;          //成功笔数
    private BigDecimal planAmt;        //计划金额
    private BigDecimal sucAmt;         //成功金额
    private String memo;               //用途

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

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDbtAcc() {
        return dbtAcc;
    }

    public void setDbtAcc(String dbtAcc) {
        this.dbtAcc = dbtAcc;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getReqNbr() {
        return reqNbr;
    }

    public void setReqNbr(String reqNbr) {
        this.reqNbr = reqNbr;
    }

    public String getBbkNbr() {
        return bbkNbr;
    }

    public void setBbkNbr(String bbkNbr) {
        this.bbkNbr = bbkNbr;
    }

    public String getBusCod() {
        return busCod;
    }

    public void setBusCod(String busCod) {
        this.busCod = busCod;
    }

    public String getBusMod() {
        return busMod;
    }

    public void setBusMod(String busMod) {
        this.busMod = busMod;
    }

    public String getTrsTyp() {
        return trsTyp;
    }

    public void setTrsTyp(String trsTyp) {
        this.trsTyp = trsTyp;
    }

    public Integer getPlanTotal() {
        return planTotal;
    }

    public void setPlanTotal(Integer planTotal) {
        this.planTotal = planTotal;
    }

    public Integer getSucTotal() {
        return sucTotal;
    }

    public void setSucTotal(Integer sucTotal) {
        this.sucTotal = sucTotal;
    }

    public BigDecimal getPlanAmt() {
        return planAmt;
    }

    public void setPlanAmt(BigDecimal planAmt) {
        this.planAmt = planAmt;
    }

    public BigDecimal getSucAmt() {
        return sucAmt;
    }

    public void setSucAmt(BigDecimal sucAmt) {
        this.sucAmt = sucAmt;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
