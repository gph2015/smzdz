package com.smzdz.service.impl;

import com.smzdz.service.ImgService;
import com.smzdz.util.img.RequestModel;
import com.smzdz.util.img.RequestModelFileToYt;
import com.smzdz.util.img.SGHttpClient;
import com.smzdz.util.utils.StringUtil;
import com.smzdz.service.ImgService;
import com.smzdz.util.img.RequestModel;
import com.smzdz.util.img.RequestModelFileToYt;
import com.smzdz.util.img.SGHttpClient;
import com.smzdz.util.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.File;

/**
 * 图片上传到云图
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/4/14 15:44
 */
@Service
public class ImgServiceImpl implements ImgService {
    @Override
    public boolean uploadImg(String picNameInURL, File file, String appid) {
        RequestModel requestModel = new RequestModelFileToYt(file, appid, picNameInURL);
        String json = SGHttpClient.executeStr(requestModel);
        if (!StringUtil.isBlankOrNull(json)) {
            JSONArray arr = JSONArray.fromObject(json);
            if (arr.size() != appid.split(",").length) {
                return false;
            }
            for (int i = 0; i < arr.size(); i++) {
                JSONObject single = arr.getJSONObject(i);
                String status = single.getString("status");
                if (!"0".equals(status)) {
                    return false;
                }
            }
        }
        return true;
    }
}

