package com.smzdz.model;

import com.smzdz.util.utils.JsonUtil;
import com.smzdz.entity.MenuItem;
import com.smzdz.util.utils.JsonUtil;

import java.util.*;

/**
 * User: hujunfei Date: 2015-03-19 10:19
 */
public class MenuTree {

    private Integer id;
    private String name;
    private String url;
    private Integer sort;
    private String target;
    private String open;
    private MenuTreeNode children;
    private Map<Object, Object> mappings = new HashMap<>();

    public MenuTree() {
        MenuItem childrenItem = new MenuItem();
        children = new MenuTreeNode(childrenItem);
        children.setName("是否");
//        setName("ssss");
        mappings.put(1, children);
        mappings.put(2,"sdf");


    }

    public Collection<MenuTreeNode> getChildren() {
        return children.getChildren();
    }

    @Override
    public String toString() {
        return JsonUtil.beanToJson(this);
    }

    public boolean addChild(Object parent, MenuTreeNode child) {
        MenuTreeNode parentNode = (MenuTreeNode) mappings.get(parent);
        if (parentNode != null) {
            parentNode.addChild(child);
            mappings.put(child.getId(), child);
            return true;
        }
        return true;
    }


    public static class MenuTreeNode {

        private Integer id;
        private String name;
        private String url;
        private Integer sort;
        private String target;
        private String open;
        private Map<Integer, MenuTreeNode> children = new LinkedHashMap<>();

        public MenuTreeNode(MenuItem menuItem) {
            this.id = menuItem.getId();
            this.name = menuItem.getName();
            this.url = menuItem.getUrl();
            this.target = "_self";
            this.open = "true";
            this.sort = menuItem.getSort();
        }

        public Integer getSort() {
            return sort;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public String getTarget() {
            return target;
        }

        public String getOpen() {
            return open;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public void setChildren(Map<Integer, MenuTreeNode> children) {
            this.children = children;
        }

        public Collection<MenuTreeNode> getChildren() {
            return children.isEmpty() ? null : children.values();
        }

        public void addChild(MenuTreeNode child) {
            this.children.put(child.getId(), child);
        }


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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public void setMappings(Map<Object, Object> mappings) {
        this.mappings = mappings;
    }

    public void setChildren(MenuTreeNode children) {
        this.children = children;
    }
}
