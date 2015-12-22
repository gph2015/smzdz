package com.smzdz.dao;

import java.util.Date;

import com.smzdz.BaseTest;
import com.smzdz.entity.AppInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.entity.AppInfo;
import com.smzdz.util.utils.PMap;

public class AppDaoTest extends BaseTest {
    
    @Autowired
    private AppInfoDao dao;
    
    @Test
    public void selectListTest(){
        PMap map = new PMap();
        map.put("appName", "搜狗");
        System.out.println(dao.selectAppInfoList(map));
    }
    
    @Test
    public void selectByIdTest(){
        System.out.println(dao.selectAppInfoById(1));
    }
    
    @Test
    public void insertTest(){
        AppInfo app = new AppInfo();
        app.setAppId(2);
        app.setAppName("测试App");
        app.setBelongCompany(1);
        app.setSignKey("signKey");
        app.setStatus(1);
        app.setCreateTime(new Date());
        app.setModifyTime(new Date());
        int i = dao.insertAppInfo(app);
        assertEquals(1, i);
    }
    
    @Test
    public void updateTest(){
        AppInfo app = new AppInfo();
        app.setAppId(2);
        app.setAppName("修改测试App");
        app.setBelongCompany(2);
        app.setSignKey("signKey2");
        app.setStatus(2);
        app.setModifyTime(new Date());
        int i = dao.updateAppInfo(app);
        assertEquals(1, i);
    }
    
    @Test
    public void selectTest2(){
        System.out.println(dao.selectAppInfo("搜狗游戏", 1999));
    }
}
