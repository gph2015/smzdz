package com.smzdz.util.utils;

/**
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/20 17:11
 */

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringUtil {

    static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static boolean isBlankOrNull(String str) {
        return StringUtils.isBlank(str) || str.equalsIgnoreCase("null");
    }

    /**
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isMoney(String str) {
        if (str.contains("-")) {
            return false;
        }
        Boolean isNumber = str.matches("^[0-9]+(.[0-9]*)?$");
        Boolean isInteger = str.matches("^[1-9]\\d*|0$");
        if (isNumber && isInteger) {
            return true;
        } else if (str.split("\\.")[1].length() == 2) {
            return true;

        } else {
            return false;
        }
    }
}
