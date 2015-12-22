package com.smzdz.model;

import java.lang.reflect.Field;

public class TestModel {    
    public static void main(String[] args) {
        System.out.println(getName(PayChannelAdaptModel.class));
    }
    
    public static String getName(Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        String str = "";
        for(Field field : fields){
            str += field.getName() + ",";
        }
        str = str.substring(0,str.length() - 1);
        return str;
    }
}
