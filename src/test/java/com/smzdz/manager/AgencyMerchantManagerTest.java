package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.BaseTest;
import com.smzdz.entity.AgencyMerchant;
import com.smzdz.model.AgencyMerchantModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class AgencyMerchantManagerTest extends BaseTest {

    @Autowired
    private AgencyMerchantManager agencyMerchantManager;

    @Test
    public void testQueryAll() {
//        ResultListBean<AgencyMerchantModel>
//            result =
//            agencyMerchantManager.queryAgencyMerchantList();
//        List<AgencyMerchantModel> list = result.getValue();
//        System.out.println(list.size());
    }

    @Test
    public void testQueryById() {
        System.out.println(agencyMerchantManager.queryAgencyMerchantDetailById(1));
    }

    @Test
    public void testInsert() {
//        AgencyMerchant info = new AgencyMerchant();
//        info.setAgencyCode("11");
//        info.setCompanyCode(1);
//        info.setMerchantNo("11");
//        info.setSellerEmail("!111");
//        info.setEncryptionType(1);
//        info.setEncryptKey("!11");
//        info.setPubKeypath("11111");
//        info.setPrivateKeypath("1111");
//        info.setPageBackUrl("11111");
//        info.setNotifyBackUrl("11111");
//        info.setIsUsed(1);
//        info.setCreateTime(new Date());
//        info.setModifyTime(new Date());
//        Result<Boolean> result = agencyMerchantManager.insertAgencyMerchant(info);
//        assertEquals(0, result.getStatus().getCode());
    }

    @Test
    public void testUpdate() {
//        AgencyMerchant info = new AgencyMerchant();
//        info.setId(5);
//        info.setAgencyCode("11");
//        info.setCompanyCode(2);
//        info.setMerchantNo("11");
//        info.setIsUsed(2);
//        info.setModifyTime(new Date());
//        Result<Boolean> result = agencyMerchantManager.updateAgencyMerchant(info);
//        assertEquals(0, result.getStatus().getCode());
    }

}
