package com.smzdz.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qibaichao on 2015/3/30.
 */
public class AppReportModel {
    //支付单ID
    private String payId;

    //订单类型 1：普通支付订单；2：余额充值订单；3：退款订单；4：其他订单
    private Integer orderType;

    //商户订单号
    private String orderId;

    //商品信息
    private String productInfo;

    //订单金额
    private BigDecimal orderMoney;

    //用户ID
    private String buyHomeAccount;
    //用户IP
    private String buyHomeIp;

    //卖家账号
    private Integer sellHomeAccount;

    //支付方式：1，PC在线支付 2，移动支付
    private Integer accessPlatForm;

    //支付渠道
    private String channelCode;

    //支付单状态：1，未支付；2，部份支付；3，支付完成；4，无效；
    private Integer payOrderStatus;

    //退款金额
    private BigDecimal refundMoney;

    //退款标识 1:未退款 2:部分退款 3:退款完成
    private Integer refundFlag;

    //订单生成时间
    private Date orderCreateTime;

    //创建时间
    private Date createTime;

    //支付完成时间
    private Date paySuccessTime;

    //业务平台ID
    private Integer appId;
    /**
     * 费率
     */
    private BigDecimal feeRate;
    //支付手续费
    private BigDecimal payFee;
    //付款方式：1，网银支付；2.第三方支付 3,扫码支付 4，SDK
    private Integer payType;
    //商户号
    private String merchantNo;
    //支付机构
    private String agencyCode;
    //支付渠道
    private String bankCode;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public BigDecimal getOrderMoney() {

//        if (orderMoney.compareTo(BigDecimal.ZERO) == 0) {
//            orderMoney = null;
//        }
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getBuyHomeAccount() {
        return buyHomeAccount;
    }

    public void setBuyHomeAccount(String buyHomeAccount) {
        this.buyHomeAccount = buyHomeAccount;
    }

    public String getBuyHomeIp() {
        return buyHomeIp;
    }

    public void setBuyHomeIp(String buyHomeIp) {
        this.buyHomeIp = buyHomeIp;
    }

    public Integer getSellHomeAccount() {
        return sellHomeAccount;
    }

    public void setSellHomeAccount(Integer sellHomeAccount) {
        this.sellHomeAccount = sellHomeAccount;
    }

    public Integer getAccessPlatForm() {
        return accessPlatForm;
    }

    public void setAccessPlatForm(Integer accessPlatForm) {
        this.accessPlatForm = accessPlatForm;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Integer getPayOrderStatus() {
        return payOrderStatus;
    }

    public void setPayOrderStatus(Integer payOrderStatus) {
        this.payOrderStatus = payOrderStatus;
    }

    public BigDecimal getRefundMoney() {


//        if (refundMoney.compareTo(BigDecimal.ZERO) == 0) {
//            refundMoney = null;
//        }
        return refundMoney;
    }

    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Integer getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(Integer refundFlag) {
        this.refundFlag = refundFlag;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public BigDecimal getPayFee() {

//        if (payFee.compareTo(BigDecimal.ZERO) == 0) {
//            payFee = null;
//        }
        return payFee;
    }

    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
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
