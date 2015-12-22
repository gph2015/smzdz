package com.smzdz.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 渠道表 t_pay_channel_info 对应entity
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/11 15:09
 */
public class ChannelInfo implements Serializable {

    private int id;                        //自增ID
    private String channelCode;            //渠道编码
    private int channelNature;             //渠道性质
    private String channelName;            //渠道名称
    private String logo;                   //logo图片地址
    private BigDecimal lowLimit;           //最低限额
    private BigDecimal highLimit;          //最高限额
    private String limitInfo;              //页面显示信息
    private int channelType;               //支付渠道类型
    private Date createTime;               //创建时间
    private Date modifyTime;               //修改时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public int getChannelNature() {
        return channelNature;
    }

    public void setChannelNature(int channelNature) {
        this.channelNature = channelNature;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public BigDecimal getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(BigDecimal lowLimit) {
        this.lowLimit = lowLimit;
    }

    public BigDecimal getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(BigDecimal highLimit) {
        this.highLimit = highLimit;
    }

    public String getLimitInfo() {
        return limitInfo;
    }

    public void setLimitInfo(String limitInfo) {
        this.limitInfo = limitInfo;
    }

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
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

}
