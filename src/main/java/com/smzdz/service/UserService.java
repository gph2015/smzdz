package com.smzdz.service;

import com.smzdz.entity.User;
import com.smzdz.util.utils.ServiceException;
import com.smzdz.entity.User;
import com.smzdz.util.utils.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/23 15:43
 */
public interface UserService {

    /**
     * 查询用户列表
     */
    public List<User> queryAllUser(String name, String mail) throws ServiceException;

    /**
     * 根据用户姓名和邮箱查询用户信息
     */
    public List<User> queryUserByParams(User user) throws ServiceException;

    /**
     * 新增一个用户
     */
    public int addUser(User user) throws ServiceException;

    /**
     * 修改用户状态
     */
    public int updateUser(User user) throws ServiceException;

    /**
     * 删除用户信息
     */
    public int deleteUserInfo(String mail) throws ServiceException;

    public User queryUserInfoByMail(String mail) throws ServiceException;

    public User queryUserInfoById(String id) throws ServiceException;

    public Map<Integer, String> selectUserInfoForMap(int status) throws ServiceException;
}
