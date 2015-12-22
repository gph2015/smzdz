package com.smzdz.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.util.Constant;

/**
 * @Author	huangguoqing 
 * @ClassName	PayChannelAdaptModel 
 * @Date	2015年3月13日 
 * @Description:银行适配Model
 */
public class PayChannelAdaptModel {
    
    //银行适配ID
    private Integer id;
    
    //业务平台ID
    private Integer appId;
    
    //业务平台名称
    private String appName;

    //接入平台 1:PC 2:手机端
    private Integer accessPlatform;
    
    //接入平台名称
    private String accessPlatformStr;
    
    //渠道方式ID
    private Integer channelType;
    
    //渠道方式名称
    private String channelTypeStr;
    
    //银行卡类型ID
    private Integer bankCardType;
    
    //银行卡类型名称
    private String bankCardTypeStr;
    
    //渠道编码
    private String channelCode;
    
    //渠道名称
    private String channelName;
    
    //排序
    private Integer sort;
    
    //状态
    private Integer status;
    
    //状态str
    private String statusStr;
    
    //创建时间
    private Date createTime;
    
    //创建时间str
    private String createTimeStr;

    public PayChannelAdaptModel(){}
    
    public PayChannelAdaptModel(PayChannelAdapt channelAdapt){
        this.id = channelAdapt.getId();
        this.appId = channelAdapt.getAppId();
        this.appName = channelAdapt.getAppName();
        this.accessPlatform = channelAdapt.getAccessPlatform();
        this.accessPlatformStr = Constant.ACCESSPLAT_MAP.get(accessPlatform);
        this.channelType = channelAdapt.getChannelType();
        this.channelTypeStr = Constant.PAY_FEETYPE_MAP.get(channelType);
        this.bankCardType = channelAdapt.getBankCardType();
        this.bankCardTypeStr = Constant.BANKCARDMAP.get(bankCardType);
        this.channelCode = channelAdapt.getChannelCode();
        this.channelName = channelAdapt.getChannelName();
        this.sort = channelAdapt.getSort();
        this.status = channelAdapt.getStatus();
        this.statusStr = Constant.APPISUSEDMAP.get(status);
        this.createTime = channelAdapt.getCreateTime();
        this.createTimeStr = (new SimpleDateFormat("yyyy-MM-dd HH:MM:ss")).format(channelAdapt.getCreateTime());
    }
    
    
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getAccessPlatform() {
        return accessPlatform;
    }

    public void setAccessPlatform(Integer accessPlatform) {
        this.accessPlatform = accessPlatform;
    }

    public String getAccessPlatformStr() {
        return accessPlatformStr;
    }

    public void setAccessPlatformStr(String accessPlatformStr) {
        this.accessPlatformStr = accessPlatformStr;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getChannelTypeStr() {
        return channelTypeStr;
    }

    public void setChannelTypeStr(String channelTypeStr) {
        this.channelTypeStr = channelTypeStr;
    }

    public Integer getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(Integer bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getBankCardTypeStr() {
        return bankCardTypeStr;
    }

    public void setBankCardTypeStr(String bankCardTypeStr) {
        this.bankCardTypeStr = bankCardTypeStr;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    @Override
    public String toString() {
        return "PayChannelAdaptModel [appId=" + appId + ", appName=" + appName
                + ", accessPlatform=" + accessPlatform + ", accessPlatformStr="
                + accessPlatformStr + ", channelType=" + channelType
                + ", channelTypeStr=" + channelTypeStr + ", bankCardType="
                + bankCardType + ", bankCardTypeStr=" + bankCardTypeStr
                + ", channelCode=" + channelCode + ", channelName="
                + channelName + ", sort=" + sort + ", status=" + status
                + ", statusStr=" + statusStr + ", createTime=" + createTime
                + ", createTimeStr=" + createTimeStr + "]";
    }
    
}
