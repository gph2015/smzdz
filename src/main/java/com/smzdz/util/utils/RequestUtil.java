package com.smzdz.util.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hujunfei Date: 14-5-28 Time: 下午7:09
 */
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    private static final String
        REGULAR_STR =
        ".*jpassport-sp=\\{.*username:([a-z0-9A-Z.\\-_]+@sogou-inc\\.com).*";
    private static final String[] SERVER_HEADERS = {"X-Forwarded-Server", "X-Forwarded-Host"};

    private static String IP_LOCAL = null;

    public static String fetchUserId(HttpServletRequest request) {
        String cookieStr = request.getHeader("Cookie");
        if (StringUtil.isBlankOrNull(cookieStr)) {
            return null;
        }
        try {
            Pattern pattern = Pattern.compile(REGULAR_STR);
            Matcher matcher = pattern.matcher(cookieStr);
            if (matcher.matches()) {
                return matcher.group(1);
            }
        } catch (Exception e) {
            logger.error("Fetch User Error!", e);
        }
        return null;
    }
}
