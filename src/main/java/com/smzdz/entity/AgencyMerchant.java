package com.smzdz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付机构商户信息表 t_pay_agency_merchant 对应entity
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/11 15:31
 */
public class AgencyMerchant implements Serializable {

    private int id;                   //ID
    private String agencyCode;        //支付机构编码
    private int companyCode;          //所属公司编码 (1:搜狗网络 2:搜狗科技)
    private String merchantNo;        //商户号
    private String sellerEmail;       //第三方开设的收款账号对应（邮箱）或者为微信公众号
    private Integer appId;
    //业务平台名称
    private String appName;
    private int encryptionType;       //加密方式 (1：签名；2：非对称加密 3：对账加密)
    private String encryptKey;        //加密密钥
    private String pubKeypath;        //第三方公钥证书路径
    private String privateKeypath;    //本地私钥证书路径
    private String pageBackUrl;       //支付之后页面回调地址
    private String notifyBackUrl;     //支付之后服务后端回调地址
    private int isUsed;               //是否启用 (0:未启用  1:已启用)
    private Date createTime;          //创建时间
    private Date modifyTime;          //修改时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
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

    public int getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(int encryptionType) {
        this.encryptionType = encryptionType;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getPubKeypath() {
        return pubKeypath;
    }

    public void setPubKeypath(String pubKeypath) {
        this.pubKeypath = pubKeypath;
    }

    public String getPrivateKeypath() {
        return privateKeypath;
    }

    public void setPrivateKeypath(String privateKeypath) {
        this.privateKeypath = privateKeypath;
    }

    public String getPageBackUrl() {
        return pageBackUrl;
    }

    public void setPageBackUrl(String pageBackUrl) {
        this.pageBackUrl = pageBackUrl;
    }

    public String getNotifyBackUrl() {
        return notifyBackUrl;
    }

    public void setNotifyBackUrl(String notifyBackUrl) {
        this.notifyBackUrl = notifyBackUrl;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
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

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
