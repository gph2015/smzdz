package com.smzdz.model;

import java.math.BigDecimal;

/**
 * Created by qibaichao on 2015/3/30.
 */
public class AppReportSumModel {
    //总数
    private Long totalNum;
    //总金额
    private BigDecimal totalOrderAmt = BigDecimal.ZERO;
    //总退款金额
    private BigDecimal totalRefundAmt = BigDecimal.ZERO;
    //总支付手续费
    private BigDecimal totalPayFee = BigDecimal.ZERO;
    //总收入
    private BigDecimal totalIncome = BigDecimal.ZERO;

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getTotalOrderAmt() {
        return totalOrderAmt;
    }

    public void setTotalOrderAmt(BigDecimal totalOrderAmt) {
        this.totalOrderAmt = totalOrderAmt;
    }

    public BigDecimal getTotalRefundAmt() {
        return totalRefundAmt;
    }

    public void setTotalRefundAmt(BigDecimal totalRefundAmt) {
        this.totalRefundAmt = totalRefundAmt;
    }

    public BigDecimal getTotalPayFee() {
        return totalPayFee;
    }

    public void setTotalPayFee(BigDecimal totalPayFee) {
        this.totalPayFee = totalPayFee;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }
}
