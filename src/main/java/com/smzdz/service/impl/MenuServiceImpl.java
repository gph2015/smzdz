package com.smzdz.service.impl;

import com.smzdz.dao.MenuDao;
import com.smzdz.entity.MenuItem;
import com.smzdz.service.MenuService;
import com.smzdz.dao.MenuDao;
import com.smzdz.entity.AppInfo;
import com.smzdz.entity.MenuItem;
import com.smzdz.service.MenuService;
import com.smzdz.util.utils.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/24 14:57
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public MenuItem select(Integer id) {
        return menuDao.select(id);
    }

    @Override
    public List<MenuItem> selectList(List<Integer> ids) {
        return menuDao.selectList(ids);
    }

    @Override
    public List<MenuItem> selectAll() {
        return menuDao.selectAll();
    }

    @Override
    public int insertMenuItem(MenuItem menuItem) throws ServiceException {
        return menuDao.insert(menuItem);
    }

    @Override
    public List<MenuItem> selectMenuList(Integer parent) {
        return menuDao.selectByParent(parent);
    }

    @Override
    public List<Integer> selectAllMenuId() {
        List<Integer> menus = new ArrayList<>();
        List<MenuItem> menuItems = menuDao.selectAll();
        for (MenuItem info : menuItems) {
            menus.add(info.getId());
        }
        return menus;
    }

    @Override
    public Map<Integer, String> selectTwoMenu() throws ServiceException {
        List<MenuItem> menuItems = menuDao.selectTwoMenu();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (MenuItem info : menuItems) {
            map.put(info.getId(), info.getName());
        }
        return map;
    }

    @Override
    public int deleteMenu(Integer id) throws ServiceException{
        return menuDao.deleteMenu(id);

    }


}
