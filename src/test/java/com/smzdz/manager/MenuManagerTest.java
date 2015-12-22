package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.entity.MenuItem;
import com.smzdz.model.MenuTree;
import com.smzdz.service.MenuService;
import com.smzdz.util.result.Result;
import com.smzdz.util.utils.JsonUtil;
import com.smzdz.BaseTest;
import com.smzdz.entity.MenuItem;
import com.smzdz.model.MenuModel;
import com.smzdz.model.MenuTree;
import com.smzdz.service.MenuService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.JsonUtil;
import com.smzdz.util.utils.PMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/24 14:36
 */
public class MenuManagerTest extends BaseTest {

    @Autowired
    private MenuManager menuManager;

    private static final String EMAIL = "huangguoqing@sogou-inc.com";
    @Autowired
    private MenuService menuService;

    @Test
    public void testQueryMenu() {
        ResultBean<MenuTree> result = menuManager.queryMenu(EMAIL);
        MenuTree menuTree = result.getValue();
        List ss = new ArrayList();
        ss.add(menuTree);
        String str = JsonUtil.beanToJson(menuTree);
        String sssss = str.substring(1);
        String s1 = "{\"id\": 13,name: \"运营系统\",open: \"true\"," + sssss;
    }

    @Test
    public void testInsert() {
        MenuItem item = new MenuItem();
        item.setName("修改");
        item.setUrl("sdsdsd");
        item.setParent(1);
        Result<Boolean> result = menuManager.insertMenuItem(item);
        assertEquals(0, result.getStatus().getCode());
    }

    @Test
    public void testQueryssMenu() {
        try {
            Map ss = menuService.selectTwoMenu();
            System.out.println(ss);
        }catch (Exception e){

        }


    }
}
