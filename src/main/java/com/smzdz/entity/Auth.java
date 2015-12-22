package com.smzdz.entity;

import java.io.Serializable;

/**
 * User: hujunfei
 * Date: 2015-03-19 14:45
 */
public class Auth implements Serializable {
    private Integer userId;
    private Integer menuId;
    private String type;
    private String status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
