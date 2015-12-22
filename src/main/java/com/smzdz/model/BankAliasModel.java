package com.smzdz.model;

import com.smzdz.entity.BankAlias;
import com.smzdz.util.Constant;
import com.smzdz.entity.BankAlias;
import com.smzdz.util.Constant;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 16:36
 */

public class BankAliasModel implements Serializable {

    private static final long serialVersionUID = 1L;
    public int aliasId;             //自增ID
    public String agencyCode;       //第三方支付机构编码
    public int bankCardType;        //银行卡类型 1：储蓄卡  2：信用卡  3：不区分
    public String bankCode;         //银行简称
    public String aliasName;        //银行别名
    public String reserved;         //预留字段
    public Date createTime;         //创建时间
    public Date modifyTime;         //修改时间
    //新加如下字段
    private String bankCardTypeStr;          //银行卡类别名称
    private String createTimeStr;               //创建时间
    private String modifyTimeStr;          //创建时间


    public BankAliasModel(BankAlias bankAlias) {
        this.setAliasId(bankAlias.getAliasId());
        this.setAgencyCode(bankAlias.getAgencyCode());
        this.setBankCardType(bankAlias.getBankCardType());
        this.setBankCardTypeStr(Constant.BANKCARDMAP.get(bankAlias.getBankCardType()));
        this.setBankCode(bankAlias.getBankCode());
        this.setAliasName(bankAlias.getAliasName());
        this.setReserved(bankAlias.getReserved());
        this.setCreateTime(bankAlias.getCreateTime());
        this.setModifyTime(bankAlias.getModifyTime());
        this.setCreateTimeStr(
            (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(bankAlias.getCreateTime()));
        this.setModifyTimeStr(
            (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(bankAlias.getModifyTime()));
    }

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

    public int getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(int bankCardType) {
        this.bankCardType = bankCardType;
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

    public String getBankCardTypeStr() {
        return bankCardTypeStr;
    }

    public void setBankCardTypeStr(String bankCardTypeStr) {
        this.bankCardTypeStr = bankCardTypeStr;
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
