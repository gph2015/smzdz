package com.smzdz.manager;

import com.smzdz.entity.MenuItem;
import com.smzdz.model.MenuTree;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.entity.MenuItem;
import com.smzdz.model.MenuModel;
import com.smzdz.model.MenuTree;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;

import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:28
 */
public interface MenuManager {

    /**
     * 登陆获取权限下面的菜单列表
     */
    public ResultBean<MenuTree> queryMenu(String mail);

    public ResultListBean<MenuModel> queryAllMenu();

    /**
     * 新增菜单信息
     *
     * @return ResultBean<MenuItem>
     */
    public Result<Boolean> insertMenuItem(MenuItem info);

    public ResultBean<Map> selectTwoMenu();

    public ResultBean<MenuItem> selectById(Integer id);

    public ResultListBean<MenuItem>  selectByParent(Integer id);

    /**
     * 删除
     */
    public ResultBasicBean<Boolean> deleteMenu(Integer id);

}
