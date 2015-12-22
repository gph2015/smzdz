package com.smzdz.service;

import com.smzdz.entity.Auth;
import com.smzdz.entity.Auth;
import com.smzdz.util.utils.ServiceException;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: hujunfei Date: 2015-03-19 09:32
 */
public interface AuthService {

    public List<Auth> select(@Param("userId") Integer userId);

    /**
     * 获取用户权限对应的菜单id
     */
    public List<Integer> selectMenuIds(@Param("userId") Integer userId) throws ServiceException ;

    /**
     * 批量插入用户权限
     */
    public int insertList(List<Auth> auths);

    /**
     * 删除用户权限
     */
    public int deteleUserAuth(@Param("userId") Integer userId) throws ServiceException;
    /**
     * 修改用户权限状态
     */
    public int updateUseAuth(Auth auth) throws ServiceException;

    public int getCount(@Param("userId") String userId,@Param("menuId") String menuId) throws ServiceException;
}
