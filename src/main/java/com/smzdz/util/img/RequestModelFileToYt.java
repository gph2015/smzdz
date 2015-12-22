package com.smzdz.util.img;

import com.smzdz.util.utils.CommonConstant;
import com.smzdz.util.utils.HttpMethodEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/4/14 11:52
 */
public class RequestModelFileToYt extends RequestModel {

    private File file;


    public RequestModelFileToYt(File file, String appIds, String name) {
        super(CommonConstant.YT_UPLOAD_URL);
        this.file = file;
        this.addParam("appid", appIds);
        this.addParam("sign_f1", name);
        this.setHttpMethodEnum(HttpMethodEnum.POST);
    }

    public File getFile() {
        return file;
    }

    private void setFile(File file) {
        this.file = file;
    }


    @Override
    public String getUrl() {
        if (params == null || params.isEmpty()) {
            return super.getUrl();
        }
        StringBuilder url = new StringBuilder(super.getUrl());
        url.append("?");
        try {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (!StringUtils.isBlank(entry.getKey()) && entry.getValue() != null) {
                    url.append("&");
                    url.append(URLEncoder.encode(entry.getKey(), CommonConstant.DEFAULT_CHARSET));
                    url.append("=");
                    url.append(URLEncoder.encode(entry.getValue().toString(), CommonConstant.DEFAULT_CHARSET));
                }

            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("getUrlWithParam UnsupportedEncodingException ");
        }
        return url.toString();
    }

    public Header[] getHeaders() {
        return null;
    }

    /**
     * 返回json格式的参数
     *
     * @return
     */
    @Override
    public MultipartEntity getRequestEntity() {
        MultipartEntity reqEntity = new MultipartEntity();
        FileBody fileBody = new FileBody(file);
        reqEntity.addPart("f1", fileBody);
        return reqEntity;
    }
}
