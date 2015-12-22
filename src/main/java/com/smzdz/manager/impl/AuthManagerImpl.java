package com.smzdz.manager.impl;

import com.smzdz.entity.Auth;
import com.smzdz.service.MenuService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.entity.Auth;
import com.smzdz.entity.MenuItem;
import com.smzdz.entity.User;
import com.smzdz.manager.AuthManager;
import com.smzdz.model.AuthMenuModel;
import com.smzdz.service.AuthService;
import com.smzdz.service.MenuService;
import com.smzdz.service.UserService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * User: hujunfei Date: 2015-03-19 10:16
 */
@Component
public class AuthManagerImpl implements AuthManager {

    private static final Logger logger = LoggerFactory.getLogger(AuthManagerImpl.class);

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;


    @Override
    public Result insertAuths(String mail, String ids) {
        ResultBean result = ResultBean.build();
        User queryUser = new User();
        queryUser.setMail(mail);
        try {
            queryUser = userService.queryUserByParams(queryUser).get(0);
        } catch (Exception e) {
            logger.warn("Menu Id Illegal: " + ids);
            return result.withError(ResultStatus.PARAM_ERROR);
        }
        String[] idArr = ids.split("\\|");
        List<Integer> menuIdList = new ArrayList<>();
        List<Auth> authList = new ArrayList<>();
        for (String idStr : idArr) {
            try {
                Integer id = Integer.parseInt(idStr);
                menuIdList.add(id);
            } catch (Exception e) {
                logger.warn("Menu Id Illegal: " + ids);
                return result.withError(ResultStatus.PARAM_ERROR);
            }
        }

        for (Integer menuId : menuIdList) {
            Auth auth = new Auth();
            auth.setUserId(queryUser.getId());
            auth.setMenuId(menuId);
            authList.add(auth);
        }
        int insertNum = authService.insertList(authList);
        if (insertNum != authList.size()) {
            return result.withError(ResultStatus.SYSTEM_ERROR);
        }
        return result;
    }

    /**
     * 获取一个用户的菜单权限
     */
    @Override
    public ResultListBean<AuthMenuModel> queryAuthMenu(Integer userId) {
        ResultBean result = ResultBean.build();
        ResultListBean<AuthMenuModel> AuthMenuModelList = ResultListBean.build();
        List<AuthMenuModel> menuModelList = new ArrayList<AuthMenuModel>();

        try {
            //获取全部菜单
            List<MenuItem> allMenuItemList = menuService.selectAll();
            //获取用户权限列表
            List<Auth> auths = authService.select(userId);
            //获取用户所有权限的菜单id
            List<Integer> menuIds = new ArrayList<>();
            if (auths == null || auths.isEmpty()) {
                AuthMenuModelList = queryAllMenu();
                return AuthMenuModelList;
            }
            for (Auth info : auths) {
                menuIds.add(info.getMenuId());
            }
            for (MenuItem menu : allMenuItemList) {
                if (menuIds.contains(menu.getId())) {
                    menu.setStatus(2);//有此权限
                } else {
                    menu.setStatus(1);
                }
            }
            menuModelList = convertAuthsMenu(menuIds,allMenuItemList);
            AuthMenuModelList.setValue(menuModelList);
        } catch (Exception e) {
            AuthMenuModelList.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }

        return AuthMenuModelList;
    }

    /**
     * 登陆获取权限下面的菜单列表
     */
    public ResultListBean<AuthMenuModel> queryAllMenu() {
        ResultListBean result = ResultListBean.build();
        List<AuthMenuModel> menuModelList = new ArrayList<AuthMenuModel>();
        List<MenuItem> menuItemList = new ArrayList<>();
        try {
            menuItemList = menuService.selectAll(); //显示禁用
            menuModelList = convertMenu(1, menuItemList);
            result.setValue(menuModelList);
        } catch (Exception e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    private List<AuthMenuModel> convertAuthsMenu(List<Integer> menuIds,List<MenuItem> menu) {
        if (menu == null || menu.isEmpty()) {
            return null;
        }
        List<AuthMenuModel> menuModelList = new ArrayList<AuthMenuModel>();
        try {

            for (MenuItem menuItem : menu) {
                if (menuItem.getParent() == null) {
                    AuthMenuModel menuModel = new AuthMenuModel();
                    menuModel.setId(1);
                    menuModel.setOneName(menuItem.getName());
                    menuModel.setStatus(menuItem.getStatus());
                    menuModelList.add(menuModel);
                } else if (menuItem.getParent().toString().equals("1")) {
                    AuthMenuModel menuModel2 = new AuthMenuModel();
                    menuModel2.setId(menuItem.getId());
                    menuModel2.setOneName("|_");
                    menuModel2.setTwoName(menuItem.getName());
                    menuModel2.setStatus(menuItem.getStatus());
                    menuModelList.add(menuModel2);
                    //根据菜单Id查询子菜单，并组装子菜单信息
                    List<MenuItem> twoMenu = menuService.selectMenuList(menuItem.getId());
                    for (MenuItem menus : twoMenu) {
                        if (menuIds.contains(menus.getId())) {
                            menus.setStatus(2);//有此权限
                        } else {
                            menus.setStatus(1);
                        }
                    }
                    for (MenuItem twoMenuItem : twoMenu) {
                        AuthMenuModel menuModel3 = new AuthMenuModel();
                        menuModel3.setId(twoMenuItem.getId());
                        menuModel3.setTwoName("|_");
                        menuModel3.setThreeName(twoMenuItem.getName());
                        menuModel3.setUrl(twoMenuItem.getUrl());
                        menuModel3.setStatus(twoMenuItem.getStatus());
                        menuModelList.add(menuModel3);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuModelList;
    }

    private List<AuthMenuModel> convertMenu(int blog, List<MenuItem> menu) {
        if (menu == null || menu.isEmpty()) {
            return null;
        }
        List<AuthMenuModel> menuModelList = new ArrayList<AuthMenuModel>();
        MenuItem item = new MenuItem();
        try {
            for (MenuItem menuItem : menu) {
                if (menuItem.getParent() == null) {
                    AuthMenuModel menuModel = new AuthMenuModel();
                    menuModel.setId(1);
                    menuModel.setOneName(menuItem.getName());
                    menuModel.setStatus(blog);
                    menuModelList.add(menuModel);
                } else if (menuItem.getParent().toString().equals("1")) {
                    AuthMenuModel menuModel2 = new AuthMenuModel();
                    item = menuService.select(menuItem.getParent());
                    menuModel2.setId(menuItem.getId());
                    menuModel2.setOneName("|_");
                    menuModel2.setTwoName(menuItem.getName());
                    menuModel2.setStatus(blog);
                    menuModelList.add(menuModel2);
                    //根据菜单Id查询子菜单，并组装子菜单信息
                    List<MenuItem> twoMenu = menuService.selectMenuList(menuItem.getId());
                    for (MenuItem twoMenuItem : twoMenu) {
                        AuthMenuModel menuModel3 = new AuthMenuModel();
                        menuModel3.setId(twoMenuItem.getId());
                        menuModel3.setTwoName("|_");
                        menuModel3.setThreeName(twoMenuItem.getName());
                        menuModel3.setUrl(twoMenuItem.getUrl());
                        menuModel3.setStatus(blog);
                        menuModelList.add(menuModel3);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuModelList;
    }

    @Override
    public ResultBean updateAuthList(Map map, String userId) {
        ResultBean result = ResultBean.build();
        Iterator<String> it = map.keySet().iterator();
        try {
            while (it.hasNext()) {

                String key = it.next();
                if (key.equals("userId")) {
                    continue;
                }
                String menuId = key.substring(0, key.indexOf('_'));
                String status = (String) map.get(key);
                //1.组装权限表参数
                Auth auth = new Auth();
                auth.setUserId(Integer.parseInt(userId));
                auth.setMenuId(Integer.parseInt(menuId));
                //2.根据用户id和菜单id判断是否具有此条记录
                int count = authService.getCount(userId,
                        menuId);
                auth.setStatus(status);
                //3.如果有则修改
                if (count > 0) {
                    authService.updateUseAuth(auth);
                } else {    //4.如果没有则插入
                    List<Auth> auths = new ArrayList<>();
                    auths.add(auth);
                    authService.insertList(auths);
                }
            }
        } catch (Exception e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }
}
