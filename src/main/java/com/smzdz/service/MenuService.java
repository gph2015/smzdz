package com.smzdz.service;

import com.smzdz.entity.MenuItem;
import com.smzdz.util.utils.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * User: hujunfei Date: 2015-03-19 09:32
 */
public interface MenuService {

    public MenuItem select(Integer id) throws ServiceException;

    public List<MenuItem> selectList(List<Integer> ids)throws ServiceException;

    public List<MenuItem> selectAll() throws ServiceException;

    public int insertMenuItem(MenuItem menuItem) throws ServiceException;

    public List<MenuItem> selectMenuList(Integer parent) throws ServiceException;
    public List<Integer> selectAllMenuId() throws ServiceException;
    public Map<Integer,String> selectTwoMenu() throws ServiceException;

    /**
     * 删除
     */
    public int deleteMenu(Integer id) throws ServiceException;


}
