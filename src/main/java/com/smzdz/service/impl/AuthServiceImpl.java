package com.smzdz.service.impl;

import com.smzdz.dao.AuthDao;
import com.smzdz.entity.Auth;
import com.smzdz.service.AuthService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.dao.AuthDao;
import com.smzdz.entity.Auth;
import com.smzdz.entity.BankAlias;
import com.smzdz.service.AuthService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: hujunfei Date: 2015-03-19 15:04
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDao authDao;

    @Override
    public List<Auth> select(Integer userId) {
        return authDao.selectList(userId);
    }

    @Override
    public List<Integer> selectMenuIds(Integer userId) throws ServiceException {
        return authDao.selectMenuIds(userId);
    }

    /**
     * 批量插入权限
     */
    @Override
    public int insertList(List<Auth> auths) {
        return authDao.insertList(auths);
    }

    /**
     * 删除用户权限
     */
    @Override
    public int deteleUserAuth(Integer userid) throws ServiceException {
        try {
            return authDao.deleteUserAuth(userid);
        } catch (Exception e) {
            throw new ServiceException(ResultStatus.SYSTEM_DB_ERROR);
        }
    }
    @Override
    public int updateUseAuth(Auth auth) throws ServiceException {
        return authDao.updateUseAuth(auth);

    }

    @Override
    public int getCount(String userId,String menuId) throws ServiceException {
        return authDao.getCount( userId, menuId);
    }
}
