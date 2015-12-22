package com.smzdz.manager;

import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.model.AuthMenuModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;

import java.util.Map;

/**
 * User: hujunfei Date: 2015-03-19 10:16
 */
public interface AuthManager {

    public Result insertAuths(String mail, String ids);
    public ResultListBean<AuthMenuModel> queryAuthMenu(Integer userId);
    public ResultBean updateAuthList(Map map,String userId);
}
