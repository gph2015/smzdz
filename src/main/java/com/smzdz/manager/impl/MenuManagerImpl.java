package com.smzdz.manager.impl;
/**
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:42
 */

import com.smzdz.entity.MenuItem;
import com.smzdz.model.MenuModel;
import com.smzdz.model.MenuTree;
import com.smzdz.service.MenuService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.entity.MenuItem;
import com.smzdz.entity.User;
import com.smzdz.manager.MenuManager;
import com.smzdz.model.MenuModel;
import com.smzdz.model.MenuTree;
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
import java.util.List;
import java.util.Map;

@Component
public class MenuManagerImpl implements MenuManager {

    private static final Logger logger = LoggerFactory.getLogger(MenuManagerImpl.class);
    @Autowired
    private MenuService menuService;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    /**
     * 登陆获取权限下面的菜单列表
     */
    @Override
    public ResultBean<MenuTree> queryMenu(String mail) {
        User queryUser = new User();
        queryUser.setMail(mail);
        ResultBean result = ResultBean.build();
        List<Integer> menuIds = new ArrayList<>();
        try {
            queryUser = userService.queryUserByParams(queryUser).get(0);
            //管理员
            if (queryUser.getType() == 1) {
                menuIds = menuService.selectAllMenuId();
            } else if (queryUser.getType() == 2) { //业务查询交易员1
                menuIds.add(1);
                menuIds.add(8);
                menuIds.add(23);
                menuIds.add(24);
            } else if (queryUser.getType() == 3) {//业务代付审批员
                menuIds.add(26);
                menuIds.add(27);
                menuIds.add(28);
            } else if (queryUser.getType() == 4) {//业务查询交易员兼代付审批员
                menuIds.add(1);
                menuIds.add(8);
                menuIds.add(23);
                menuIds.add(24);
                menuIds.add(26);
                menuIds.add(27);
                menuIds.add(28);
            }
//            List<Integer> menuIds = authService.selectMenuIds(queryUser.getId());
            List<MenuItem> menuItemList = menuService.selectList(menuIds);
            MenuTree menuTree = new MenuTree();
            menuTree = convert(menuItemList);
            result.setValue(menuTree);
        } catch (
                Exception e
                )

        {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }

        return result;
    }


    private MenuTree convert(List<MenuItem> menu) {
        if (menu == null || menu.isEmpty()) {
            return null;
        }
        MenuTree menuTree = new MenuTree();
        for (MenuItem menuItem : menu) {
//            if (menuItem.getLevel() == 3) {
//                continue;
//            }
            MenuTree.MenuTreeNode node = new MenuTree.MenuTreeNode(menuItem);
            menuTree.addChild(menuItem.getParent(), node);
        }

        return menuTree;
    }

    @Override
    public ResultBasicBean<Boolean> insertMenuItem(MenuItem menuItem) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        try {
            int level = 1;
            MenuItem parent = menuService.select(menuItem.getParent());
            if (parent != null) {
                level = parent.getLevel() + 1;
            }
            menuItem.setLevel(level);
            menuService.insertMenuItem(menuItem);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登陆获取权限下面的菜单列表
     */
    @Override
    public ResultListBean<MenuModel> queryAllMenu() {
        ResultListBean result = ResultListBean.build();
        List<MenuModel> menuModelList = new ArrayList<MenuModel>();
        try {
            List<MenuItem> menuItemList = menuService.selectAll();
            menuModelList = convertMenu(menuItemList);
            result.setValue(menuModelList);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public ResultListBean<MenuItem> selectByParent(Integer id) {
        ResultListBean result = ResultListBean.build();
        try {
            List<MenuItem> menuItemList = menuService.selectMenuList(id);
            result.setValue(menuItemList);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }


    private List<MenuModel> convertMenu(List<MenuItem> menu) {

        if (menu == null || menu.isEmpty()) {
            return null;
        }
        List<MenuModel> menuModelList = new ArrayList<MenuModel>();
        MenuItem item = new MenuItem();
        try {
            for (MenuItem menuItem : menu) {
                if (menuItem.getParent() == null) {
                    MenuModel menuModel = new MenuModel();
                    menuModel.setId(1);
                    menuModel.setOneName(menuItem.getName());
                    menuModelList.add(menuModel);
                } else if (menuItem.getParent().toString().equals("1")) {
                    MenuModel menuModel2 = new MenuModel();
                    item = menuService.select(menuItem.getParent());
                    menuModel2.setId(menuItem.getId());
//                menuModel2.setOneName(item.getName());
                    menuModel2.setOneName("|_");
                    menuModel2.setTwoName(menuItem.getName());
                    menuModelList.add(menuModel2);
                    //根据菜单Id查询子菜单，并组装子菜单信息
                    List<MenuItem> twoMenu = menuService.selectMenuList(menuItem.getId());
                    for (MenuItem twoMenuItem : twoMenu) {
                        MenuModel menuModel3 = new MenuModel();
                        menuModel3.setId(twoMenuItem.getId());
//                    menuModel3.setOneName(item.getName());
//                    menuModel3.setTwoName(menuItem.getName());
                        menuModel3.setTwoName("|_");
                        menuModel3.setThreeName(twoMenuItem.getName());
                        menuModel3.setUrl(twoMenuItem.getUrl());
                        menuModelList.add(menuModel3);
                    }
                }
            }
        } catch (Exception e) {
        }
        return menuModelList;
    }

    @Override
    public ResultBean<Map> selectTwoMenu() {
        ResultBean result = ResultBean.build();
        try {
            Map<Integer, String> map = menuService.selectTwoMenu();
            result.success(map);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBean<MenuItem> selectById(Integer id) {
        ResultBean result = ResultBean.build();
        try {
            MenuItem item = menuService.select(id);
            result.setValue(item);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBasicBean<Boolean> deleteMenu(Integer id) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        try {
            menuService.deleteMenu(id);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;


    }
}
