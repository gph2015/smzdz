package com.smzdz.entity;

import java.io.Serializable;

/**
 * User: hujunfei Date: 2015-03-19 09:27
 */
public class MenuItem implements Serializable {

    private Integer id;
    private String name;
    private String url;
    private Integer level;
    private Integer type;
    private Integer status;
    private Integer parent;
    private Integer sort;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Menu{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", url='" + url + '\'' +
               ", level='" + level + '\'' +
               ", type='" + type + '\'' +
               ", status='" + status + '\'' +
               ", parent='" + parent + '\'' +
               ", sort=" + sort +
               '}';
    }

}
