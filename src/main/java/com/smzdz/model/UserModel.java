package com.smzdz.model;

import com.smzdz.entity.User;
import com.smzdz.util.Constant;
import com.smzdz.entity.User;
import com.smzdz.util.Constant;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/23 15:14
 */
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String mail;
    private Integer status;
    private String statusStr;
    private Integer appId;
    private String appIdStr;
    private Integer type;
    private String typeStr;
    //创建时间
    private Date createTime;
    //创建时间
    private String createTimeStr;
    //修改时间
    private Date modifyTime;

    public UserModel(User info, Map appMap) {
        this.setId(info.getId());
        this.setName(info.getName());
        this.setMail(info.getMail());
        this.setStatus(info.getStatus());
        this.setStatusStr(Constant.USERISUSEDMAP.get(info.getStatus()));
        if (null != info.getAppId()) {
            this.setAppId(info.getAppId());
            this.setAppIdStr(appMap.get(info.getAppId()).toString());
        }
        this.setType(info.getType());
        this.setTypeStr(Constant.USER_TYPE_MAP.get(info.getType()));
        this.setCreateTime(info.getCreateTime());
        this.setCreateTimeStr(
                (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(info.getCreateTime()));
        this.setModifyTime(info.getModifyTime());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppIdStr() {
        return appIdStr;
    }

    public void setAppIdStr(String appIdStr) {
        this.appIdStr = appIdStr;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id
                + ", name=" + name + ", id=" + id + ", mail=" + mail
                + ", statusStr=" + statusStr + ", appIdStr="
                + appIdStr + "]";
    }


}
