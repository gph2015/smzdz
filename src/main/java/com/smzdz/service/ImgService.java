package com.smzdz.service;

import com.smzdz.entity.User;
import com.smzdz.util.utils.ServiceException;

import java.io.File;
import java.util.List;

/**
 * 
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/23 15:43
 */
public interface ImgService {

    /**
     * 上传图片
     */
    public boolean uploadImg(String picNameInURL,File file,String appid);


}
