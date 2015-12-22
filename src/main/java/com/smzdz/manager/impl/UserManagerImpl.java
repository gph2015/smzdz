package com.smzdz.manager.impl;

import com.smzdz.entity.Auth;
import com.smzdz.service.MenuService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.entity.Auth;
import com.smzdz.entity.MenuItem;
import com.smzdz.entity.User;
import com.smzdz.manager.UserManager;
import com.smzdz.model.AgencyMerchantModel;
import com.smzdz.model.UserModel;
import com.smzdz.service.AppInfoService;
import com.smzdz.service.AuthService;
import com.smzdz.service.MenuService;
import com.smzdz.service.UserService;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/23 15:19
 */
@Component
public class UserManagerImpl implements UserManager {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private AppInfoService appInfoService;

    /**
     * 查询用户列表
     */
    @Override
    public ResultListBean<UserModel> queryAllUser(String name, String mail) {
        ResultListBean<UserModel> resultListBean = ResultListBean.build();
        try {
            List<User> resultList = userService.queryAllUser(name, mail);
            resultListBean.success(covertData(resultList));
        } catch (ServiceException e) {
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return resultListBean;
    }

    private List<UserModel> covertData(List<User> resultList) throws ServiceException {
        if (null == resultList || resultList.size() == 0) {
            return null;
        }
        Map<Integer, String> appMap = null;
        appMap = appInfoService.selectAppInfoForMap();
        List<UserModel> list = new ArrayList<UserModel>();
        UserModel model = null;
        for (User info : resultList) {
            model = new UserModel(info, appMap);
            list.add(model);
        }
        return list;
    }

    /**
     * 根据条件查询用户列表
     */
    @Override
    public ResultListBean<UserModel> queryUserByParams(String name, String mail) {
        ResultListBean<UserModel> result = ResultListBean.build();
        User queryUser = new User();
        queryUser.setName(name);
        queryUser.setMail(mail);
        try {
            List<User> info = userService.queryUserByParams(queryUser);
            result.success(covertData(info));
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 新增用户
     */
    @Override
    public ResultBasicBean<Boolean> addUser(User user) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();

        //1.查询是否存在
        User queryUser = new User();
        queryUser.setMail(user.getMail());
        try {
            List<User> userList = userService.queryUserByParams(queryUser);
            if (userList.size() != 0) {
                result.withError(ResultStatus.ADD_EXISTSUSER_ERROR);
                return result;
            }
            //2.插入数据库
            userService.addUser(user);
            user = userService.queryUserInfoByMail(user.getMail());
            List<Integer> menuItemList = menuService.selectAllMenuId();
            if (menuItemList == null || menuItemList.isEmpty()) {
                return result;
            }
            List<Auth> authList = new ArrayList<>();
            for (Integer info : menuItemList) {
                Auth auth = new Auth();
                auth.setMenuId(info);
                auth.setUserId(user.getId());
                auth.setStatus("1");
                auth.setType("1");
                authList.add(auth);
            }
            authService.insertList(authList);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            return result;
        }
        return result;
    }

    /**
     * 删除用户所有权限
     */
    @Override
    public ResultBasicBean<Boolean> deleteUserAuth(String mail) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        User queryUser = new User();
        queryUser.setMail(mail);
        try {
            queryUser = userService.queryUserByParams(queryUser).get(0);
            authService.deteleUserAuth(queryUser.getId());
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    public ResultBasicBean<Boolean> updateUserInfo(User user) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        //1.查询是否存在
        User queryUser = new User();
        queryUser.setMail(user.getMail());
        try {
            List<User> userList = userService.queryUserByParams(queryUser);
            if (userList.size() > 1) {
                result.withError(ResultStatus.ADD_EXISTSUSER_ERROR);
                return result;
            }
            //2.插入数据库
            userService.updateUser(user);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            return result;
        }
        return result;

    }

    /**
     * 删除用户所有信息
     */
    @Override
    public ResultBasicBean<Boolean> deleteUserInfo(String mail) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        try {
            userService.deleteUserInfo(mail);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询用户
     */
    @Override
    public ResultBasicBean<User> queryUserInfoByMail(String mail) {
        ResultBasicBean<User> resultBean = ResultBasicBean.build();
        try {
            User resultList = userService.queryUserInfoByMail(mail);
            resultBean.success(resultList);
        } catch (ServiceException e) {
            resultBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return resultBean;
    }

    @Override
    public User queryUserInfoByRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        User user = new User();
        try {
            user = userService.queryUserInfoById(userId.toString());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public ResultBean<Map> selectUserInfoForMap(int status) {
        ResultBean result = ResultBean.build();
        try {
            Map<Integer, String> map = userService.selectUserInfoForMap(status);
            result.success(map);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }
}
