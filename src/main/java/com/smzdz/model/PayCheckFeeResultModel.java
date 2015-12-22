package com.smzdz.model;

import com.smzdz.entity.PayCheckFeeResult;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qibaichao on 2015/3/26.
 */
public class PayCheckFeeResultModel {

    /**
     * 主键
     */
    private Long id;
    /**
     * 入库时间
     */
    private Date createTime;
    /**
     * 我方总笔数
     */
    private Integer totalNum;
    /**
     * 我方总数续费金额
     */
    private BigDecimal totalFee;
    /**
     * 对方总笔数
     */
    private Integer outTotalNum;
    /**
     * 对方总手续费金额
     */
    private BigDecimal outTotalFee;
    /**
     * 1：支付 3：退款
     */
    private Integer bizCode;
    /**
     * 1：对账成功
     * 2：金额不等
     */
    private Integer status;
    /**
     * 对账日期
     */
    private String checkDate;
    /**
     * 机构编码
     */
    private String agencyCode;

    public void build(PayCheckFeeResult payCheckFeeResult) {
        if (payCheckFeeResult != null) {
            this.id = payCheckFeeResult.getId();
            this.createTime = payCheckFeeResult.getCreateTime();
            this.totalNum = payCheckFeeResult.getTotalNum();
            this.totalFee=payCheckFeeResult.getTotalFee();
            this.outTotalNum = payCheckFeeResult.getOutTotalNum();
            this.outTotalFee = payCheckFeeResult.getOutTotalFee();
            this.bizCode = payCheckFeeResult.getBizCode();
            this.status = payCheckFeeResult.getStatus();
            this.checkDate = payCheckFeeResult.getCheckDate();
            this.agencyCode = payCheckFeeResult.getAgencyCode();
        }
    }


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

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public int getOutTotalNum() {
        return outTotalNum;
    }

    public void setOutTotalNum(int outTotalNum) {
        this.outTotalNum = outTotalNum;
    }

    public BigDecimal getOutTotalFee() {
        return outTotalFee;
    }

    public void setOutTotalFee(BigDecimal outTotalFee) {
        this.outTotalFee = outTotalFee;
    }

    public int getBizCode() {
        return bizCode;
    }

    public void setBizCode(int bizCode) {
        this.bizCode = bizCode;
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
}
