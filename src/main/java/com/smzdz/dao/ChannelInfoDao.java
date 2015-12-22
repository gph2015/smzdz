package com.smzdz.dao;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.ChannelInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 支付渠道表对应DAO
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/11 15:52
 */
@Repository
public interface ChannelInfoDao {

    /**
     * 0.获得支付渠道信息总条数
     *
     * @return COUNT
     */
    public int selectCount(Pager pager);

    /**
     * 1.获得支付渠道信息列表
     *
     * @return List<ChannelInfo>
     */
    public List<ChannelInfo> queryChannelInfoList(Pager pager);

    /**
     * 2.获得支付渠道信息列表
     *
     * @return List<ChannelInfo>
     */
    public List<ChannelInfo> queryAllChannelInfoList();

    /**
     * 3.新增支付渠道信息
     */
    public int insertChannelInfo(ChannelInfo channelInfo);

    /**
     * 4.根据渠道编码、渠道类型查询支付渠道信息列表
     */
    public List<ChannelInfo> queryChannelInfo(@Param("channelName") String channelName,
                                              @Param("channelType") int channelType);

    /**
     * 5.根据自增主键id查询支付渠道记录详情
     */
    public ChannelInfo queryChannelInfoDetail(Integer id);

    /**
     * 6.修改支付渠道信息
     */
    public int updateChannelInfo(ChannelInfo channelInfo);

    /**
     * 7.删除支付渠道信息
     */
    public int deleteChannelInfo(@Param("id") Integer id);

    /**
     * 8.根据支付渠道编码查询支付渠道信息
     */
    public int queryChannelByCode(@Param("channelCode") String channelCode);

}