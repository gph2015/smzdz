package com.smzdz.service.impl;

import com.smzdz.dao.UserDao;
import com.smzdz.entity.User;
import com.smzdz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/23 15:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询用户列表
     */
    @Override
    public List<User> queryAllUser(String name, String mail) {
        return userDao.queryAllUser(name, mail);
    }

    /**
     * 根据用户姓名和邮箱查询用户信息
     */
    @Override
    public List<User> queryUserByParams(User user) {
        return userDao.queryUserByParams(user);
    }

    /**
     * 新增一个用户
     */
    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUserInfo(String mail) {
        return userDao.deleteUserInfo(mail);
    }
    /**
     * 查询用户
     */
    @Override
    public User queryUserInfoByMail(String mail) {
        return userDao.queryUserInfoByMail(mail);
    }

    /**
     * 查询用户
     */
    @Override
    public User queryUserInfoById(String id) {
        return userDao.queryUserInfoById(id);
    }

    @Override
    public Map<Integer, String> selectUserInfoForMap(int status){
        User user  = new User();
        user.setStatus(status);
        List<User> userList = userDao.queryUserByStatus(user);
        Map<Integer,String> map = new HashMap<Integer,String>();
        for(User info : userList){
            map.put(info.getId(), info.getName());
        }
        return map;
    }

}
