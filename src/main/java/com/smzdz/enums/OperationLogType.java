package com.smzdz.enums;

import java.util.HashSet;

/**
 * Created by qibaichao on 2015/4/14.
 */
public enum OperationLogType {
    /**
     * 登陆
     */
    LOGIN(0),
    /**
     * 插入
     */
    INSERT(1),
    /**
     * 删除
     */
    DELETE(2),
    /**
     * 修改
     */
    UPDATE(3),
    /**
     * 查询
     */
    SELECT(4);


    private final int value;

    private OperationLogType(int value)

    {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
