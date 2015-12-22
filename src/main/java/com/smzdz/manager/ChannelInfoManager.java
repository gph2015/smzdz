package com.smzdz.manager;

import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.ChannelInfo;
import com.smzdz.model.ChannelInfoModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;

import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:28
 */
public interface ChannelInfoManager {

    /**
     * 查询支付渠道列表
     */
    public ResultListBean<ChannelInfoModel> queryChannelInfoList(Pager pager);

    /**
     * 查询支付渠道列表
     */
    public ResultListBean<ChannelInfoModel> queryChannelInfoList();

    /**
     * 根据ID获得单条支付渠道信息
     *
     * @return ResultBean<ChannelInfo>
     */
    public ResultBean<ChannelInfoModel> queryChannelInfoDetailById(Integer id);

    /**
     * 新增支付渠道信息
     *
     * @return ResultBean<ChannelInfo>
     */
    public Result<Boolean> insertChannelInfo(PMap map);

    /**
     * 修改支付渠道信息
     *
     * @return ResultBean<ChannelInfo>
     */
    public Result<Boolean> updateChannelInfo(PMap map);

    public Result<Boolean> deleteChannelInfo(PMap map);

    public Map queryChannelInfoForMap();



}
