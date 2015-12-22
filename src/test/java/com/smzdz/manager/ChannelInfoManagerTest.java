package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.BaseTest;
import com.smzdz.entity.ChannelInfo;
import com.smzdz.model.ChannelInfoModel;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.ServiceException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ChannelInfoManagerTest extends BaseTest {

    @Autowired
    private ChannelInfoManager channelInfoManager;

    @Autowired
    private ChannelInfoService service;
    
    @Test
    public void testQueryAll() {
//        ResultListBean<ChannelInfoModel> result = channelInfoManager.queryChannelInfoList();
//        System.out.println(result.getStatus().getCode());
//        System.out.println(result.getValue().toString());
//        List<ChannelInfoModel> list = result.getValue();
//        System.out.println(list.size());
    }

    @Test
    public void testQueryById() {
        System.out.println(channelInfoManager.queryChannelInfoDetailById(1));
    }

    @Test
    public void testInsert() {
//        ChannelInfo info = new ChannelInfo();
//        info.setChannelCode("1111");            //渠道编码
//        info.setChannelNature(1);             //渠道性质
//        info.setChannelName("wwww");            //渠道名称
//        info.setLogo("111");                   //logo图片地址
//        info.setLowLimit(new BigDecimal(11));           //最低限额
//        info.setHighLimit(new BigDecimal(112));          //最高限额
//        info.setLimitInfo("111");              //页面显示信息
//        info.setChannelType(1);               //支付渠道类型
//        info.setCreateTime(new Date());         //创建时间
//        info.setModifyTime(new Date());   //修改时间
//        Result<Boolean> result = channelInfoManager.insertChannelInfo(info);
//        assertEquals(0, result.getStatus().getCode());
    }

    @Test
    public void testUpdate() {
//        ChannelInfo info = new ChannelInfo();
//        info.setId(30);
//        info.setChannelCode("111111111");            //渠道编码
//        info.setChannelNature(1);             //渠道性质
//        info.setChannelName("wwww");            //渠道名称
//        info.setLogo("111");                   //logo图片地址
//        info.setLowLimit(new BigDecimal(11));           //最低限额
//        info.setHighLimit(new BigDecimal(112));          //最高限额
//        info.setLimitInfo("111");              //页面显示信息
//        info.setChannelType(1);               //支付渠道类型
//        info.setModifyTime(new Date());
//        Result<Boolean> result = channelInfoManager.updateChannelInfo(info);
//        assertEquals(0, result.getStatus().getCode());
    }

    @Test
    public void testSelectMap() throws ServiceException{
        System.out.println(service.queryChannelInfoForMap());
    }
}
