package com.smzdz.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author	huangguoqing 
 * @ClassName	FinancialReportInfo 
 * @Date	2015年3月17日 
 * @Description:业务财务报表信息
 */
public class FinancialReportInfo {
    //支付单流水号
    private String payReqId;
    
    //业务订单号
    private String orderId;
    
    //订单金额
    private BigDecimal orderAmount;
    
    //付款方式
    private Integer payType;
    
    //支付渠道编码
    private String channelCode;
    
    //支付渠道名称
    private String channelName;
    
    //支付金额
    private BigDecimal payMoney;
    
    //手续费
    private BigDecimal fee;
    
    //交易完成时间
    private Date paySuccessTime;

}
