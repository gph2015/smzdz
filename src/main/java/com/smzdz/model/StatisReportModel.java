package com.smzdz.model;

import java.io.Serializable;

/**
 * Created by qibaichao on 2015/4/24.
 */
public class StatisReportModel implements Serializable {

    private String label;

    private String value;

    private String color;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //随机颜色
    public String getColor() {

        String str = "0123456789abcdef";
        String color = "#";
        for (int j = 0; j < 6; j++) {
            color += str.charAt((int) (Math.random() * str.length()));
        }
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
