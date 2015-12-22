package com.smzdz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付机构银行别名 t_pay_bank_alias 对应entity
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/11 15:28
 */
public class BankAlias implements Serializable {


    public int aliasId;             //自增ID
    public String agencyCode;       //第三方支付机构编码
    public int bankCardType;     //银行卡类别
    public String bankCode;         //银行简称
    public String aliasName;        //银行别名
    public String reserved;         //预留字段
    public Date createTime;         //创建时间
    public Date modifyTime;         //修改时间

    public int getAliasId() {
        return aliasId;
    }

    public void setAliasId(int aliasId) {
        this.aliasId = aliasId;
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

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
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

    public int getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(int bankCardType) {
        this.bankCardType = bankCardType;
    }
}
