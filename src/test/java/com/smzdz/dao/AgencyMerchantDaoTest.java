package com.smzdz.dao;
/**
 *支付机构商户DAO测试
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 9:43
 */

import com.smzdz.BaseTest;
import com.smzdz.entity.AgencyMerchant;
import com.smzdz.BaseTest;
import com.smzdz.entity.AgencyMerchant;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AgencyMerchantDaoTest extends BaseTest {

    @Autowired
    private AgencyMerchantDao agencyMerchantDao;

    @Test
    public void testInsertAgencyMerchant() {
        AgencyMerchant agencyMerchant = new AgencyMerchant();
        agencyMerchant.setAgencyCode("111");
//        agencyMerchant.setAppId(111);
        agencyMerchant.setCompanyCode(11234);
        agencyMerchant.setCreateTime(new Date());
        agencyMerchant.setModifyTime(new Date());
        agencyMerchant.setEncryptionType(1);
        agencyMerchant.setIsUsed(1);
        agencyMerchant.setEncryptKey("11");
        agencyMerchant.setMerchantNo("1212");
        agencyMerchant.setPageBackUrl("1212");
        agencyMerchant.setNotifyBackUrl("121212");
        agencyMerchant.setSellerEmail("111");
        agencyMerchant.setPrivateKeypath("111");
        agencyMerchant.setPubKeypath("ssss");
        System.out.println(agencyMerchantDao.insertAgencyMerchant(agencyMerchant));
    }

    @Test
    public void testQueryAgencyMerchants() {
        List<AgencyMerchant> ss = agencyMerchantDao.queryAgencyMerchants("WENCAT");
        System.out.println(ss.get(0).getAgencyCode());
    }

    @Test
    public void testQueryAgencyMerchantDetail() {
        AgencyMerchant agencyMerchant = agencyMerchantDao.queryAgencyMerchantDetail(1);
        System.out.println(agencyMerchant.getEncryptionType());
    }

    @Test
    public void testUpdateAgencyMerchant() {
        AgencyMerchant agencyMerchant = new AgencyMerchant();
        agencyMerchant.setId(4);
        agencyMerchant.setCompanyCode(2);
        agencyMerchant.setModifyTime(new Date());
        System.out.println(agencyMerchantDao.updateAgencyMerchant(agencyMerchant));
    }

    @Test
    public void testUpdateAgencyMerchantS() {
        AgencyMerchant agencyMerchant = new AgencyMerchant();
        agencyMerchant.setId(4);
        agencyMerchant.setAgencyCode("12");
//        agencyMerchant.setAppId(111);
        agencyMerchant.setCompanyCode(2);
        agencyMerchant.setCreateTime(new Date());
        agencyMerchant.setModifyTime(new Date());
        agencyMerchant.setEncryptionType(1);
        agencyMerchant.setEncryptKey("11");
        agencyMerchant.setMerchantNo("1212");
        agencyMerchant.setPageBackUrl("1212");
        agencyMerchant.setNotifyBackUrl("121212");
        agencyMerchant.setSellerEmail("111");
        agencyMerchant.setPrivateKeypath("111");
        agencyMerchant.setPubKeypath("ssss");
        int isok = agencyMerchant.getIsUsed();
        System.out.println(agencyMerchantDao.updateAgencyMerchant(agencyMerchant));
    }

}
