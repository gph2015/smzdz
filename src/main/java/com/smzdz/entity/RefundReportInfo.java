package com.smzdz.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author	huangguoqing 
 * @ClassName	RefundReportInfo 
 * @Date	2015年3月17日 
 * @Description:退款报表信息
 */
public class RefundReportInfo {
    
    //退款流水号
    private String refundId;
    
    //支付单流水号
    private String payReqId;
    
    //支付机构编码
    private String agencyCode;
    
    //支付机构名称
    private String agencyName;
    
    //订单金额
    private BigDecimal orderMoney;
    
    //退款金额
    private BigDecimal refundMoney;
    
    //退款状态
    private Integer refundStatus;
    
    //交易完成时间
    private Date refundSucTime;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getPayReqId() {
        return payReqId;
    }

    public void setPayReqId(String payReqId) {
        this.payReqId = payReqId;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getRefundSucTime() {
        return refundSucTime;
    }

    public void setRefundSucTime(Date refundSucTime) {
        this.refundSucTime = refundSucTime;
    }

    @Override
    public String toString() {
        return "RefundReportInfo [refundId=" + refundId + ", payReqId="
                + payReqId + ", agencyCode=" + agencyCode + ", agencyName="
                + agencyName + ", orderMoney=" + orderMoney + ", refundMoney="
                + refundMoney + ", refundStatus=" + refundStatus
                + ", refundSucTime=" + refundSucTime + "]";
    }

}
