package com.smzdz.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.smzdz.entity.AppInfo;
import com.smzdz.util.Constant;
import com.smzdz.entity.AppInfo;
import com.smzdz.util.Constant;

public class AppInfoModel {

    private Integer id;              //自增ID

    private String appName;     //app名称

    private Integer appId;       //app的id

    private Integer belongCompany;   //所属公司 1：搜狗网络 2：搜过科技

    private String companyName; //所属公司名称
    
    private String signKey;   //签名key

    private Integer status;        //状态 0：失效 1：使用中

    private String statusStr;  //状态名称
    
    private Date createTime;   //创建时间

    private String createTimeStr; //创建时间str
    
    private Date modifyTime;     //修改时间

    private String modifyTimeStr; //修改时间str
    
    private String wxServiceNo;   //微信公众服务号

    public AppInfoModel(AppInfo appInfo){
        this.setId(appInfo.getId());
        this.setAppId(appInfo.getAppId());
        this.setAppName(appInfo.getAppName());
        this.setBelongCompany(appInfo.getBelongCompany());
        this.setCompanyName(Constant.COMPANYMAP.get(appInfo.getBelongCompany()));
        this.setSignKey(appInfo.getSignKey());
        this.setStatus(appInfo.getStatus());
        this.setStatusStr(Constant.APPISUSEDMAP.get(appInfo.getStatus()));
        this.setCreateTime(appInfo.getCreateTime());
        this.setCreateTimeStr((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(appInfo.getCreateTime()));
        this.setModifyTime(appInfo.getModifyTime());
        this.setModifyTimeStr((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(appInfo.getModifyTime()));
        this.setWxServiceNo(appInfo.getWxServiceNo());
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer Id) {
        this.appId = Id;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
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

    public Integer getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(Integer belongCompany) {
        this.belongCompany = belongCompany;
    }

    public String getWxServiceNo() {
        return wxServiceNo;
    }

    public void setWxServiceNo(String wxServiceNo) {
        this.wxServiceNo = wxServiceNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

}
