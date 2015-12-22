package com.smzdz.dao;

import com.smzdz.BaseTest;
import com.smzdz.BaseTest;

/**
 *  *渠道表DAO测试
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 14:44
 */

import com.smzdz.entity.ChannelInfo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ChannelInfoDaoTest extends BaseTest {

    @Autowired
    private ChannelInfoDao channelInfoDao;

    @Test
    public void testInsertChannelInfo() {
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setChannelCode("1");
        channelInfo.setChannelName("1");
        channelInfo.setChannelNature(1);
        channelInfo.setLogo("222");
        channelInfo.setLimitInfo("2323");
        channelInfo.setLowLimit(new BigDecimal(12));
        channelInfo.setHighLimit(new BigDecimal(23));
        channelInfo.setCreateTime(new Date());
        channelInfo.setModifyTime(new Date());
        System.out.println(channelInfoDao.insertChannelInfo(channelInfo));
    }

    @Test
    public void testQueryChannelInfos() {
        List<ChannelInfo> ss = channelInfoDao.queryChannelInfo("1",12);
        System.out.println(ss);
    }

    @Test
    public void testQueryChannelInfoDetail() {
        ChannelInfo channelInfo = channelInfoDao.queryChannelInfoDetail(1);
        System.out.println(channelInfo);
    }

    @Test
    public void testUpdateChannelInfo() {
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setId(1);
        channelInfo.setChannelCode("asd");
        channelInfo.setChannelName("1");
        channelInfo.setChannelNature(1);
        channelInfo.setLogo("222");
        channelInfo.setLimitInfo("2323");
        channelInfo.setLowLimit(new BigDecimal(12));
        channelInfo.setHighLimit(new BigDecimal(23));
        channelInfo.setCreateTime(new Date());
        channelInfo.setModifyTime(new Date());
        System.out.println(channelInfoDao.updateChannelInfo(channelInfo));
    }


}
