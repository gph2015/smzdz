package com.smzdz.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.entity.BankRouter;
import com.smzdz.util.utils.Pager;

public class BankRouterDaoTest extends BaseTest{
    @Autowired
    private BankRouterDao dao;
    
    @Test
    public void selectList(){
        BankRouter router = new BankRouter();
//        router.setAppId(1999);
//        router.setBankCode("ABC");
//        router.setBankCardType(1);
        List list = dao.selectBankRouterList(null);
        System.out.println(list);
    }
    
    @Test
    public void selectById(){
        System.out.println(dao.selectBankRouterById(1));
    }
    
    @Test
    public void insert(){
        BankRouter router = new BankRouter();
        router.setAppId(111);
        router.setBankCode("CMB");
        router.setBankCardType(1);
        router.setAgencyCode("TENPAY");
        router.setScale(new BigDecimal(0.7));
        router.setStatus(1);
        router.setCreateTime(new Date());
        router.setModifyTime(new Date());
        int i = dao.insertBankRouter(router);
        assertEquals(i, 1);
    }
    
    @Test
    public void selectCount(){
        Pager pager =new Pager();
        int i = dao.selectCount(pager);
        System.out.println(i);
    }
    
    @Test
    public void selectBankRouterByPager(){
        Pager pager = new  Pager();
//        pager.setPageRows(4);
//        pager.setPageNo(1);
        System.out.println(dao.selectBankRouterByPager(pager));
    }
    
    @Test
    public void insertTest(){
        List<BankRouter> list = new ArrayList<BankRouter>();
        BankRouter r1 = new BankRouter();
        r1.setAppId(1);
        r1.setBankCode("test");
        r1.setBankCardType(1);
        r1.setAgencyCode("ALIPAY");
        r1.setScale(new BigDecimal(0.7));
        r1.setStatus(1);
        r1.setCreateTime(new Date());
        r1.setModifyTime(new Date());
        BankRouter r2 = new BankRouter();
        r2.setAppId(1);
        r2.setBankCode("test");
        r2.setBankCardType(1);
        r2.setAgencyCode("ALIPAY");
        r2.setScale(new BigDecimal(0.3));
        r2.setStatus(1);
        r2.setCreateTime(new Date());
        r2.setModifyTime(new Date());
        list.add(r1);
        list.add(r2);
        dao.insertBankRouterList(list);
    }
    
    @Test
    public void selectCountTest(){
        Map map = new HashMap();
        map.put("bankCode", "ABC");
        map.put("bankCardType", "1");
        map.put("appId", "1999");
        System.out.println(dao.selectCountByconn(map));
        
        
    }
    
    @Test
    public void updateTest(){
        BankRouter router = new BankRouter();
        router.setAppId(1999);
        router.setBankCardType(3);
        router.setBankCode("ABC");
        router.setAgencyCode("TENPAY");
        router.setStatus(4);
        router.setScale(new BigDecimal(0.14));
        router.setModifyTime(new Date());
        System.out.println(dao.updateBankRouter(router));
    }
}
