package com.smzdz.service.impl;

import com.smzdz.dao.ChannelInfoDao;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.utils.Pager;
import com.smzdz.dao.ChannelInfoDao;
import com.smzdz.entity.ChannelInfo;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:43
 */
@Service
public class ChannelInfoServiceImpl implements ChannelInfoService {

    @Autowired
    ChannelInfoDao channelInfoDao;

    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return channelInfoDao.selectCount(pager);
    }

    public List<ChannelInfo> queryChannelInfoList(Pager pager) throws ServiceException {
        return channelInfoDao.queryChannelInfoList(pager);
    }

    public List<ChannelInfo> queryChannelInfoList() throws ServiceException {
        return channelInfoDao.queryAllChannelInfoList();
    }

    @Override
    public ChannelInfo queryChannelInfoDetailById(Integer id) throws ServiceException {
        return channelInfoDao.queryChannelInfoDetail(id);
    }

    @Override
    public int insertChannelInfo(ChannelInfo channelInfo) throws ServiceException {
        return channelInfoDao.insertChannelInfo(channelInfo);
    }

    @Override
    public int updateChannelInfo(ChannelInfo channelInfo) throws ServiceException {
        return channelInfoDao.updateChannelInfo(channelInfo);
    }

    @Override
    public int deleteChannelInfo(Integer id) throws ServiceException {
        return channelInfoDao.deleteChannelInfo(id);
    }

    @Override
    public int queryChannelByCode(String channelCode) throws ServiceException {
        return channelInfoDao.queryChannelByCode(channelCode);
    }
    @Override
    public Map<String, String> queryChannelInfoForMap() throws ServiceException {
        Map<String, String> channelMap = new HashMap<String, String>();
        List<ChannelInfo> channelList = channelInfoDao.queryAllChannelInfoList();
        for (ChannelInfo info : channelList) {
            channelMap.put(info.getChannelCode(), info.getChannelName());
        }
        return channelMap;
    }
}
