package com.smzdz.dao;

import java.util.Date;

import com.smzdz.BaseTest;
import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.util.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.util.utils.Pager;

public class PayChannelAdaptDaoTest extends BaseTest {
    
    @Autowired
    private ChannelAdaptDao dao;
    
    @Test
    public void selectList(){
        PayChannelAdapt channelAdapt = new PayChannelAdapt();
        channelAdapt.setAppId(1999);
        channelAdapt.setChannelType(2);;
        Pager pager = new Pager();
//        pager.setTotalCount(11);
//        pager.setPageRows(10);
//        pager.setPageNo(2);
        System.out.println(dao.selectChannelAdaptList(pager));
    }
    
    @Test
    public void selectById(){
        System.out.println(dao.selectChannelAdaptById(2));
    }
    
    @Test
    public void selectListByCon(){
        System.out.println(dao.selectAdaptListByCon(null));
    }
    @Test
    public void insert(){
        PayChannelAdapt adapt = new PayChannelAdapt();
        adapt.setAppId(111);
        adapt.setAccessPlatform(1);
        adapt.setChannelCode("MMMM");
        adapt.setChannelType(1);
        adapt.setBankCardType(1);
        adapt.setStatus(1);
        adapt.setSort(2);
        adapt.setCreateTime(new Date());
        adapt.setModifyTime(new Date());
        int i = dao.insertChannelAdapt(adapt);
        assertEquals(1, i);
    }
    
    @Test
    public void update(){
        PayChannelAdapt adapt = new PayChannelAdapt();
        adapt.setId(4);
        adapt.setAppId(111);
        adapt.setAccessPlatform(1);
        adapt.setChannelCode("ABC");
        adapt.setChannelType(1);
        adapt.setBankCardType(1);
        adapt.setStatus(1);
        adapt.setSort(22);
        adapt.setModifyTime(new Date());
        int i = dao.updateChannelAdapt(adapt);
        assertEquals(1, i);
    }
    
    @Test
    public void delete(){
        dao.deleteChannelAdapt(4);
    }
}
