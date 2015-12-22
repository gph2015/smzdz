package com.smzdz.dao;
/**
 *支付机构银行别名DAO测试
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 9:43
 */

import com.smzdz.BaseTest;
import com.smzdz.entity.BankAlias;
import com.smzdz.BaseTest;
import com.smzdz.entity.BankAlias;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BankAliasDaoTest extends BaseTest {

    @Autowired
    private BankAliasDao bankAliasDao;

    @Test
    public void testInsertBankAlias() {
        BankAlias bankAlias = new BankAlias();
        bankAlias.setAgencyCode("111");
        bankAlias.setBankCode("11");
        bankAlias.setAliasName("1212");
        bankAlias.setReserved("111");
        bankAlias.setCreateTime(new Date());
        bankAlias.setModifyTime(new Date());
        System.out.println(bankAliasDao.insertBankAlias(bankAlias));
    }

    @Test
    public void testQueryBankAliass() {
        List<BankAlias> ss = bankAliasDao.queryBankAlias("WENCAT","");
        System.out.println(ss);
    }

    @Test
    public void testQueryBankAliasDetail() {
        BankAlias bankAlias = bankAliasDao.queryBankAliasDetail(1);
        System.out.println(bankAlias.getAgencyCode());
    }

    @Test
    public void testUpdateBankAlias() {
        BankAlias bankAlias = new BankAlias();
        bankAlias.setAliasId(29);
        bankAlias.setAliasName("1");
        bankAlias.setModifyTime(new Date());
        System.out.println(bankAliasDao.updateBankAlias(bankAlias));
    }

    @Test
    public void testUpdateBankAliasS() {
        BankAlias bankAlias = new BankAlias();
        bankAlias.setAgencyCode("12");
        bankAlias.setCreateTime(new Date());
        bankAlias.setModifyTime(new Date());
        System.out.println(bankAliasDao.updateBankAlias(bankAlias));
    }

}
