package com.smzdz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * User: hujunfei Date: 2015-03-19 14:41
 */
public class User implements Serializable {

    private Integer id;
    private String name;
    private String mail;
    private Integer type;
    private Integer status;
    private Integer appId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
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
        return "User [id=" + id + ", name=" + name + ", mail=" + mail
               + ", type=" + type + ", status=" + status
               + ", appId=" + appId + ", createTime=" + createTime
               + ", modifyTime=" + modifyTime + "]";
    }
}
