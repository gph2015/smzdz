package com.smzdz.dao;

import java.util.List;

import com.smzdz.util.utils.Pager;
import org.springframework.stereotype.Repository;

import com.smzdz.entity.PayChannelAdapt;

/**
 * Created by wujingpan on 2015/3/5.
 */
@Repository
public interface ChannelAdaptDao {

    /**
     * @Author	huangguoqing 
     * @MethodName	getChannelAdaptList 
     * @return 银行适配列表
     * @Date	2015年3月13日
     * @Description:
     */
    public List<PayChannelAdapt> selectChannelAdaptList(Pager pager);
    
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectChannelAdaptById 
     * @param id
     * @return 银行适配信息
     * @Date	2015年3月16日
     * @Description:根据ID查询银行适配信息
     */
    public PayChannelAdapt selectChannelAdaptById(Integer id);
    /**
     * @Author	huangguoqing 
     * @MethodName	insertChannelAdapt 
     * @param channelAdapt
     * @return 插入结果
     * @Date	2015年3月16日
     * @Description:插入银行适配信息
     */
    public int insertChannelAdapt(PayChannelAdapt channelAdapt);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	updateChannelAdapt 
     * @param channelAdapt
     * @return 更新结果
     * @Date	2015年3月16日
     * @Description:更新银行适配信息
     */
    public int updateChannelAdapt(PayChannelAdapt channelAdapt);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	deleteChannelAdapt 
     * @param id
     * @return 删除结果
     * @Date	2015年3月16日
     * @Description:根据ID删除银行适配信息
     */
    public int deleteChannelAdapt(Integer id);
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectCount 
     * @param pager
     * @return 渠道适配数量
     * @Date    2015年3月26日
     * @Description:根据条件查询渠道数量
     */
    public int selectCount(Pager pager);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectAdaptListByCon 
     * @param adapt
     * @return 适配信息
     * @Date	2015年3月26日
     * @Description:根据条件查询适配信息
     */
    public List<PayChannelAdapt> selectAdaptListByCon(PayChannelAdapt adapt);
}
