package com.smzdz.service;

import java.util.List;

import com.smzdz.util.utils.Pager;
import org.springframework.stereotype.Service;

import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.model.PayChannelAdaptModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

/**
 * @Author	huangguoqing 
 * @ClassName	ChannelAdaptService 
 * @Date	2015年3月13日 
 * @Description:渠道适配服务
 */
@Service
public interface ChannelAdaptService {
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectChannelAdaptLsit 
     * @param pager
     * @return 渠道适配列表
     * @Date	2015年3月13日
     * @Description:根据条件查询渠道适配列表
     */
    public List<PayChannelAdapt> selectChannelAdaptList(Pager pager) throws ServiceException;
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectCount 
     * @param pager
     * @return 渠道适配数量
     * @Date	2015年3月26日
     * @Description:根据条件查询渠道数量
     */
    public int selectCount(Pager pager) throws ServiceException;
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectAdaptListByCon 
     * @param adapt
     * @return 渠道适配信息
     * @Date	2015年3月26日
     * @Description:根据条件查询渠道适配信息
     */
    public List<PayChannelAdapt> selectAdaptListByCon(PayChannelAdapt adapt) throws ServiceException;
    /**
     * @Author  huangguoqing 
     * @MethodName  insertAppInfo 
     * @param adapt
     * @return 
     * @Date    2015年3月26日
     * @Description:新增渠道适配
     */
    public int insertAdaptInfo(PayChannelAdapt adapt) throws ServiceException;
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectAdaptById 
     * @param id
     * @return 渠道适配信息
     * @Date	2015年3月26日
     * @Description:根据ID查询渠道适配信息
     */
    public PayChannelAdapt selectAdaptById(Integer id) throws ServiceException;
    
    /**
     * @Author	huangguoqing 
     * @MethodName	updateAdapt 
     * @param adapt
     * @return 更新结果
     * @Date	2015年3月26日
     * @Description:更新渠道适配信息
     */
    public int updateAdapt(PayChannelAdapt adapt) throws ServiceException;
}
