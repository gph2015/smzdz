package com.smzdz.model;

import com.smzdz.entity.ChannelInfo;
import com.smzdz.util.Constant;
import com.smzdz.entity.ChannelInfo;
import com.smzdz.util.Constant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 16:36
 */

public class ChannelInfoModel implements Serializable {

    private static final long serialVersionUID = 1L;
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
    //新加如下字段
    private String channelNatureStr;          //渠道性质名称
    private String channelTypeStr;            //支付渠道类型名称
    private String createTimeStr;               //创建时间
    private String modifyTimeStr;          //创建时间

    public ChannelInfoModel(ChannelInfo channelInfo) {
        this.setId(channelInfo.getId());
        this.setChannelCode(channelInfo.getChannelCode());
        this.setChannelNature(channelInfo.getChannelNature());
        this.setChannelNatureStr(Constant.CHANNELNATUREMAP.get(channelInfo.getChannelNature()));
        this.setChannelName(channelInfo.getChannelName());
        this.setLogo(channelInfo.getLogo());
        this.setLowLimit(channelInfo.getLowLimit());
        this.setHighLimit(channelInfo.getHighLimit());
        this.setLimitInfo(channelInfo.getLimitInfo());
        this.setChannelType(channelInfo.getChannelType());
        this.setChannelTypeStr(Constant.CHANNELTYPEMAP.get(channelInfo.getChannelType()));
        this.setCreateTime(channelInfo.getCreateTime());
        this.setModifyTime(channelInfo.getModifyTime());
        this.setCreateTimeStr(
                (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(channelInfo.getCreateTime()));
        this.setModifyTimeStr(
                (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(channelInfo.getModifyTime()));
    }

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

    public String getChannelNatureStr() {
        return channelNatureStr;
    }

    public void setChannelNatureStr(String channelNatureStr) {
        this.channelNatureStr = channelNatureStr;
    }

    public String getChannelTypeStr() {
        return channelTypeStr;
    }

    public void setChannelTypeStr(String channelTypeStr) {
        this.channelTypeStr = channelTypeStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getModifyTimeStr() {
        return modifyTimeStr;
    }

    public void setModifyTimeStr(String modifyTimeStr) {
        this.modifyTimeStr = modifyTimeStr;
    }
}
