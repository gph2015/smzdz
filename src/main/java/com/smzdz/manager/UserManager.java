package com.smzdz.manager;

import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.entity.User;
import com.smzdz.model.UserModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserManager {

    /**
     * 查询用户列表
     *
     * @return ResultListBean<UserModel>
     */
    public ResultListBean<UserModel> queryAllUser(String name, String mail);


    /**
     * 根据查询条件查询用户列表
     *
     * @return ResultListBean<UserModel>
     */
    public ResultListBean<UserModel> queryUserByParams(String name, String mail);

    /**
     * 新增用户信息
     */
    public Result<Boolean> addUser(User user);

    /**
     * 删除用户权限
     */
    public ResultBasicBean<Boolean> deleteUserAuth(String mail);

    /**
     * 修改用户状态信息
     */
    public ResultBasicBean<Boolean> updateUserInfo(User user);

    /**
     * 删除用户信息
     */
    public ResultBasicBean<Boolean> deleteUserInfo(String mail);

    public ResultBasicBean<User> queryUserInfoByMail(String mail);
    public User queryUserInfoByRequest(HttpServletRequest request);
    public ResultBean<Map> selectUserInfoForMap(int status) ;
}
