package com.smzdz.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author	huangguoqing 
 * @ClassName	BankRouter 
 * @Date	2015年3月16日 
 * @Description:银行路由实体
 */
public class BankRouter {

    //自增ID
    private Integer id;
    
    //银行编码
    private String bankCode;
    
    //银行编码
    private String bankName;
    
    //银行卡类型
    private Integer bankCardType;
    
    //业务平台ID
    private Integer appId;
    
    //业务平台名称
    private String appName;
    
    //机构编码
    private String agencyCode;
    
    //机构名称
    private String agencyName;
    
    //比例
    private BigDecimal scale;
    
    //状态
    private Integer status;
    
    //状态str
    private String statusStr;
    
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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(Integer bankCardType) {
        this.bankCardType = bankCardType;
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

    public BigDecimal getScale() {
        return scale;
    }

    public void setScale(BigDecimal scale) {
        this.scale = scale;
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

    
    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    @Override
    public String toString() {
        return "BankRouter [id=" + id + ", bankCode=" + bankCode + ", bankName=" + bankName
                + ", bankCardType=" + bankCardType + ", appId=" + appId
                + ", appName=" + appName + ", agencyCode=" + agencyCode
                + ", agencyName=" + agencyName + ", scale=" + scale
                + ", status=" + status + ", statusStr=" + statusStr + ", createTime=" + createTime
                + ", modifyTime=" + modifyTime + "]";
    }
    
}
