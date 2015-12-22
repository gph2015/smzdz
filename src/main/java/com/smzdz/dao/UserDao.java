package com.smzdz.dao;

import com.smzdz.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/23 15:23
 */
@Repository
public interface UserDao {

    /**
     * 查询用户列表
     */
    public List<User> queryAllUser(@Param("name") String name, @Param("mail") String mail);

    /**
     * 根据用户姓名和邮箱查询用户信息
     */
    public List<User> queryUserByParams(User user);

    /**
     * 新增一个用户
     */
    public int insertUser(User user);

    /**
     * 修改一个用户
     */
    public int updateUser(User user);

    /**
     * 删除一个用户
     */
    public int deleteUserInfo(@Param("mail") String mail);

    /**
     * 根据邮箱查询用户信息
     */
    public User queryUserInfoByMail(@Param("mail") String mail);

    /**
     * 根据邮箱查询用户信息
     */
    public User queryUserInfoById(@Param("id") String id);

    /**
     * 根据用户姓名和邮箱查询用户信息
     */
    public List<User> queryUserByStatus(User user);
}
