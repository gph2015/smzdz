package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.entity.BankAlias;
import com.smzdz.BaseTest;
import com.smzdz.entity.BankAlias;
import com.smzdz.model.BankAliasModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BankAliasManagerTest extends BaseTest {

    @Autowired
    private BankAliasManager bankAliasManager;

    @Test
    public void testQueryAll() {
//        ResultListBean<BankAliasModel> result = bankAliasManager.queryBankAliasList();
//        System.out.println(result.getStatus().getCode());
//        System.out.println(result.getValue().toString());
//        List<BankAliasModel> list = result.getValue();
//        System.out.println(list.size());
    }

    @Test
    public void testQueryById() {
        System.out.println(bankAliasManager.queryBankAliasDetailById(1));
    }

    @Test
    public void testInsert() {
        BankAlias info = new BankAlias();
        info.setAgencyCode("11"); //第三方支付机构编码
        info.setBankCardType(1);     //银行卡类别
        info.setBankCode("111");         //银行简称
        info.setAliasName("111");        //银行别名
        info.setReserved("11111");         //预留字段
        info.setCreateTime(new Date());         //创建时间
        info.setModifyTime(new Date());   //修改时间
//        Result<Boolean> result = bankAliasManager.insertBankAlias(info);
//        assertEquals(0, result.getStatus().getCode());
    }

    @Test
    public void testUpdate() {
        BankAlias info = new BankAlias();
        info.setAliasId(29);
        info.setAgencyCode("11"); //第三方支付机构编码
        info.setBankCardType(1);     //银行卡类别
        info.setBankCode("111");         //银行简称
        info.setAliasName("111");        //银行别名
        info.setReserved("111223423421");         //预留字段
        info.setModifyTime(new Date());
//        Result<Boolean> result = bankAliasManager.updateBankAlias(info);
//        assertEquals(0, result.getStatus().getCode());
    }

}
