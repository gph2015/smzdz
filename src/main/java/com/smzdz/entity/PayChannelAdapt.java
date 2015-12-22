package com.smzdz.entity;


import java.util.Date;

/**
 * @Author	huangguoqing 
 * @ClassName	PayChannelAdapt 
 * @Date	2015年3月13日 
 * @Description:银行适配实体
 */
public class PayChannelAdapt {
    
    //ID
    private Integer id;
    
    //业务平台ID
    private Integer appId;
    
    //业务平台名称
    private String appName;

    //接入平台 1:PC 2:手机端
    private Integer accessPlatform;
    
    //渠道方式ID
    private Integer channelType;
    
    //银行卡类型ID
    private Integer bankCardType;
    
    //渠道编码
    private String channelCode;
    
    //渠道名称
    private String channelName;
    
    //排序
    private Integer sort;
    
    //状态
    private Integer status;
    
    //创建时间
    private Date createTime;
    
    //修改时间
    private Date modifyTime;
    
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

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(Integer bankCardType) {
        this.bankCardType = bankCardType;
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

    @Override
    public String toString() {
        return "PayChannelAdapt [id=" + id + ",appId=" + appId + ", appName=" + appName
                + ", accessPlatform=" + accessPlatform + ", channelType="
                + channelType + ", bankCardType=" + bankCardType
                + ", channelCode=" + channelCode + ", channelName="
                + channelName + ", sort=" + sort + ", status=" + status
                + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }

}
