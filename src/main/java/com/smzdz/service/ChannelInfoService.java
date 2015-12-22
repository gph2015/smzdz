package com.smzdz.service;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.ChannelInfo;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:28
 */
public interface ChannelInfoService {

    /**
     * 0.获得支付渠道信息总条数
     *
     * @return COUNT
     */
    public int selectCount(Pager pager) throws ServiceException;

    /**
     * 1.获得支付渠道信息列表
     *
     * @return List<ChannelInfo>
     */
    public List<ChannelInfo> queryChannelInfoList(Pager pager) throws ServiceException;

    /**
     * 2.获得支付渠道信息列表
     *
     * @return List<ChannelInfo>
     */
    public List<ChannelInfo> queryChannelInfoList() throws ServiceException;


    /**
     * 3.新增支付渠道信息
     */
    public int insertChannelInfo(ChannelInfo channelInfo) throws ServiceException;

    /**
     * 5.根据自增主键id查询支付渠道记录详情
     */
    public ChannelInfo queryChannelInfoDetailById(Integer id) throws ServiceException;

    /**
     * 6.修改支付渠道信息
     */
    public int updateChannelInfo(ChannelInfo channelInfo) throws ServiceException;

    /**
     * 7.删除支付渠道信息
     */
    public int deleteChannelInfo(Integer id) throws ServiceException;

    /**
     * 8.根据支付渠道编码查询支付渠道信息
     */
    public int queryChannelByCode(String channelCode) throws ServiceException;
    public Map<String,String> queryChannelInfoForMap() throws ServiceException;
}
