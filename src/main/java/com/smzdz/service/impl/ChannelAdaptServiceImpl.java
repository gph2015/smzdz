package com.smzdz.service.impl;

import java.util.List;

import com.smzdz.util.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smzdz.dao.ChannelAdaptDao;
import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.service.ChannelAdaptService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

/**
 * @Author	huangguoqing 
 * @ClassName	ChannelAdaptServiceImpl 
 * @Date	2015年3月13日 
 * @Description:渠道适配业务
 */
@Component
public class ChannelAdaptServiceImpl implements ChannelAdaptService {

    @Autowired
    private ChannelAdaptDao channelAdaptDao;
    @Override
    public List<PayChannelAdapt> selectChannelAdaptList(Pager pager) throws ServiceException{
        return channelAdaptDao.selectChannelAdaptList(pager);
    }

    /**
     * @Author  huangguoqing 
     * @MethodName  selectCount 
     * @param pager
     * @return 渠道适配数量
     * @Date    2015年3月26日
     * @Description:根据条件查询渠道数量
     */
    public int selectCount(Pager pager){
        return channelAdaptDao.selectCount(pager);
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAdaptListByCon 
     * @param adapt
     * @return 渠道适配信息
     * @Date    2015年3月26日
     * @Description:根据条件查询渠道适配信息
     */
    @Override
    public List<PayChannelAdapt> selectAdaptListByCon(PayChannelAdapt adapt) throws ServiceException{
        return channelAdaptDao.selectAdaptListByCon(adapt);
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  insertAppInfo 
     * @param adapt
     * @return 
     * @Date    2015年3月26日
     * @Description:新增渠道适配
     */
    public int insertAdaptInfo(PayChannelAdapt adapt) throws ServiceException{
            return channelAdaptDao.insertChannelAdapt(adapt);
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAdaptById 
     * @param id
     * @return 渠道适配信息
     * @Date    2015年3月26日
     * @Description:根据ID查询渠道适配信息
     */
    public PayChannelAdapt selectAdaptById(Integer id) throws ServiceException{
        return channelAdaptDao.selectChannelAdaptById(id);
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  updateAdapt 
     * @param adapt
     * @return 更新结果
     * @Date    2015年3月26日
     * @Description:更新渠道适配信息
     */
    public int updateAdapt(PayChannelAdapt adapt) throws ServiceException{
            return channelAdaptDao.updateChannelAdapt(adapt);
    }
}
