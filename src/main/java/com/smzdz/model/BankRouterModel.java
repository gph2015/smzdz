package com.smzdz.model;

import java.util.List;

import com.smzdz.util.Constant;
import com.smzdz.entity.BankRouter;
import com.smzdz.util.Constant;

/**
 * @Author	huangguoqing 
 * @ClassName	BankRouterModel 
 * @Date	2015年3月16日 
 * @Description:银行路由Model
 */
public class BankRouterModel {

    //页面展示用ID bankCode_appId_bankCardType
    private String id;
    
    //银行编码
    private String bankCode;
    
    //银行名称
    private String bankName;
    
    //业务平台ID
    private Integer appId;
    
    //业务平台名称
    private String appName;
    
    //银行卡类型
    private Integer bankCardType;
    
    //银行卡类型String
    private String bankCardTypeStr;
    
    //支付机构信息
    private List<BankRouter> routerList;

    public BankRouterModel(BankRouter bankRouter){
        this.setAppId(bankRouter.getAppId());
        this.setAppName(bankRouter.getAppName());
        this.setBankCode(bankRouter.getBankCode());
        this.setBankName(bankRouter.getBankName());
        this.setBankCardType(bankRouter.getBankCardType());
        this.setBankCardTypeStr(Constant.BANKCARDMAP.get(bankRouter.getBankCardType()));
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<BankRouter> getRouterList() {
        return routerList;
    }

    public void setRouterList(List<BankRouter> routerList) {
        this.routerList = routerList;
    }

    @Override
    public String toString() {
        return "BankRouterModel [id=" + id + ", bankCode=" + bankCode
                + ", bankName=" + bankName + ", appId=" + appId + ", appName="
                + appName + ", bankCardType=" + bankCardType + ", bankCardTypeStr="
                + bankCardTypeStr + ", routerList=" + routerList + "]";
    }
    
}
