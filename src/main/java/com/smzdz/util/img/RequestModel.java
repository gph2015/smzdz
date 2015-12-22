package com.smzdz.util.img;

import com.google.common.base.Strings;
import com.smzdz.util.utils.CommonConstant;
import com.smzdz.util.utils.StringUtil;
import com.smzdz.util.utils.CommonConstant;
import com.smzdz.util.utils.HttpMethodEnum;
import com.smzdz.util.utils.StringUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/4/14 11:52
 */
public class RequestModel {

    protected static final String DEFAULT_ENCODE = CommonConstant.DEFAULT_CHARSET;

    private static final String HEADER_CONTENT_TYPE = "Content-Type";

    private String HEADER_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded;charset=utf-8";

    private static final Logger logger = LoggerFactory.getLogger(RequestModel.class);

    //要请求的地址
    private String url;

    //请求的方法，默认采用post请求
    private HttpMethodEnum httpMethodEnum;

    //提交的参数
    protected Map<String, Object> params;

    //提交的头信息
    private Map<String, String> headers;

    // 字符集
    private String charset;

    /**
     * 请求参数Model
     *
     * @param url 请求地址
     */
    public RequestModel(String url) {
        if (Strings.isNullOrEmpty(url)) {
            throw new IllegalArgumentException("url不能为空！");
        }
        this.url = url.trim();
        this.httpMethodEnum = HttpMethodEnum.GET;
        this.params = new HashMap<>();
        this.headers = new HashMap<>(1);
        this.headers.put(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public HttpMethodEnum getHttpMethodEnum() {
        return httpMethodEnum;
    }

    public void setHttpMethodEnum(HttpMethodEnum httpMethodEnum) {
        this.httpMethodEnum = httpMethodEnum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 增加参数，如果原key已经存在一个value，则覆盖老参数
     *
     * @param key   参数名
     * @param value 参数值
     */
    public void addParam(String key, Object value) {
        if (StringUtil.isBlank(key)) {
            throw new IllegalArgumentException("key 不能为空");
        }
        this.params.put(key, value);
    }

    public Header[] getHeaders() {
        if (headers.isEmpty()) {
            return new Header[0];
        }
        Header[] header = new Header[this.headers.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            header[i] = new BasicHeader(entry.getKey(), entry.getValue());
            i++;
        }
        return header;
    }

    public HttpEntity getRequestEntity() {
        List<NameValuePair> nameValuePairs = new ArrayList<>(this.params.size());
        for (Map.Entry<String, Object> entry : this.params.entrySet()) {
            NameValuePair param = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
            nameValuePairs.add(param);
        }
        try {
            return new UrlEncodedFormEntity(nameValuePairs, StringUtil.isBlank(charset) ? DEFAULT_ENCODE : charset);
        } catch (UnsupportedEncodingException e) {
            logger.error("http param url encode error ", e);
            throw new RuntimeException("http param url encode error", e);
        }
    }
}
