package com.smzdz.web.controller;

import com.smzdz.entity.MenuItem;
import com.smzdz.model.MenuTree;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.entity.User;
import com.smzdz.manager.MenuManager;
import com.smzdz.model.MenuModel;
import com.smzdz.util.result.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/25 14:34
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuManager menuManager;
    private static final String BACK_URL = "queryAllMenu.j";

    @RequestMapping("/menuList")
    @ResponseBody
    public Map getMenuList() {
        Map<String, Object> result = new HashMap<String, Object>();
        User user = getCurrentUser();
        ResultBean<MenuTree> menuTreeResultBean = menuManager.queryMenu(user.getMail());
        MenuTree menuTree = menuTreeResultBean.getValue();
        menuTree.setName("运营中心");
        menuTree.setOpen("true");
        result.put("success", "Y");
        result.put("data", menuTree);
        return result;
    }

    /**
     * 获取菜单列表
     */
    @RequestMapping("/queryAllMenu")
    public ModelAndView queryAllMenu(String code) {
        ModelAndView modelAndView = new ModelAndView(
                "/basicParam/menu/menuList");
        ResultListBean<MenuModel> menuTreeResultBean = menuManager.queryAllMenu();
        if (!Result.isSuccess(menuTreeResultBean))
            return setErrorPage(menuTreeResultBean.getStatus().getMessage(), menuTreeResultBean
                    .getStatus().getCode(),BACK_URL);
        modelAndView.addObject("menuList", menuTreeResultBean.getValue());
        return modelAndView;
    }


    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView("/basicParam/menu/addMenu");
        ResultBean<Map> appMapBean = menuManager.selectTwoMenu();
        modelAndView.addObject("twoMenuMap", appMapBean.getValue());
        return modelAndView;
    }

    @RequestMapping("/addMenu")
    public ModelAndView addMenu(HttpServletRequest request, HttpServletResponse response) {
        PMap map = new PMap();
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        String parent = request.getParameter("parent");

        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setParent(Integer.parseInt(parent));
        if (Integer.parseInt(parent) == 1) {
            menuItem.setLevel(2);
        } else {
            menuItem.setLevel(3);
        }
        menuItem.setSort(999);
        menuItem.setUrl(url);
        Result<Boolean> result = menuManager.insertMenuItem(menuItem);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode(),BACK_URL);
        }
        return toSuccess(BACK_URL);
    }
    @RequestMapping("/showMenu")
    public ModelAndView showMenu(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        String flag = request.getParameter("flag");
        if ("detail".equals(flag)) {
            view.setViewName("/basicParam/menu/menuDetail");
        } else if ("update".equals(flag)) {
            view.setViewName("/basicParam/menu/updateMenu");
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResultBean<MenuItem> result = menuManager.selectById(id);
        if (!ResultListBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(),
                    result.getStatus().getCode(), BACK_URL);
        MenuItem menu = result.getValue();
        //产品列表
        view.addObject("menu", menu);
        return view;
    }
    @RequestMapping("/deleteMenu")
    public ModelAndView deleteUserInfo(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResultListBean<MenuItem> menuItemResult = menuManager.selectByParent(id);
        if (!Result.isSuccess(menuItemResult)) {
            return setErrorPage(menuItemResult.getStatus().getMessage(), menuItemResult
                    .getStatus().getCode());
        }
        List<MenuItem> menuItem = menuItemResult.getValue();
        if (menuItem.size() != 0) {
            return setErrorPage("该菜单存在子菜单不能删除！", 999,BACK_URL);
        }
        Result<Boolean> result = menuManager.deleteMenu(id);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        return toSuccess(BACK_URL);
    }

}
