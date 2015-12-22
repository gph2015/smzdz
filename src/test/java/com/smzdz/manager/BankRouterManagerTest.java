package com.smzdz.manager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.entity.BankRouter;

public class BankRouterManagerTest extends BaseTest{
    @Autowired
    private BankRouterManager bankRouterManager;
    
    @Test
    public void selectList(){
        BankRouter bankRouter = new BankRouter();
//        bankRouter.setAppId(1999);
//        bankRouter.setBankCode("ABC");
//        bankRouter.setBankCardType(1);
        System.out.println(bankRouterManager.getBankRouterList(null));
    }
}
