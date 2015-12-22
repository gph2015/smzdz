package com.smzdz.model;

import java.io.InterruptedIOException;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by xiepeidong on 2015/11/24.
 */
public class TransStatisModel  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer appId;
    private String appName;
    private String channelCode;
    private String channelName;
    private Integer payOrderStatus;
    private String statusName;
    private Integer transCount;
    private BigDecimal moneyAmount;

    public Integer getAppId(){return appId;}
    public void setAppId(Integer appId){this.appId=appId;}
    public String getChannelCode(){return channelCode;}
    public void setChannelCode(String channelCode){this.channelCode=channelCode;}
    public Integer getPayOrderStatus(){return payOrderStatus;}
    public void setPayOrderStatus(Integer payOrderStatus){this.payOrderStatus=payOrderStatus;}
    public Integer getTransCount(){return transCount;}
    public void setTransCount(Integer transCount){this.transCount=transCount;}
    public BigDecimal getMoneyAmount(){return moneyAmount;}
    public void setMoneyAmount(BigDecimal moneyAmount){this.moneyAmount=moneyAmount;}
    public String getAppName(){return appName;}
    public void setAppName(String appName){this.appName=appName;}
    public String getChannelName(){return channelName;}
    public void setChannelName(String channelName){this.channelName=channelName;}
    public String getStatusName(){return statusName;}
    public void setStatusName(String statusName){this.statusName=statusName;}

    @Override
    public String toString(){
        return "TransStatisModel [appId=" +  appId
                + ", channelCode=" + channelCode
                + ", payOrderStatus=" + payOrderStatus
                + ", transCount=" + transCount
                +", moneyAmount=" + moneyAmount
                + "]";
    }
}
