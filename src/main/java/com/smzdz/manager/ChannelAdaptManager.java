package com.smzdz.manager;

import com.smzdz.model.PayChannelAdaptModel;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.model.PayChannelAdaptModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;

/**
 * @Author	huangguoqing 
 * @ClassName	ChannelAdaptManager 
 * @Date	2015年3月13日 
 * @Description:渠道适配Manager
 */
public interface ChannelAdaptManager {

    /**
     * @Author	huangguoqing 
     * @MethodName	getChannelAdaptList 
     * @param pager
     * @return 渠道适配列表
     * @Date	2015年3月13日
     * @Description:根据条件查询渠道适配列表
     */
    public ResultListBean<PayChannelAdaptModel> getChannelAdaptList(Pager pager);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	getAdaptListByCon 
     * @param model
     * @return 渠道信息
     * @Date	2015年3月26日
     * @Description:根据条件查询渠道适配信息
     */
    public ResultListBean<PayChannelAdapt> getAdaptListByCon(PayChannelAdaptModel model);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	insertAppInfo 
     * @param model
     * @return 
     * @Date	2015年3月26日
     * @Description:新增渠道适配
     */
    public ResultBean insertAdaptInfo(PayChannelAdaptModel model);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	getChannelAdaptById 
     * @param id
     * @return 渠道适配信息
     * @Date	2015年3月26日
     * @Description:根据ID查询渠道适配信息
     */
    public ResultBean<PayChannelAdaptModel> getChannelAdaptById(Integer id);
    
    public ResultBean updateAdaptInfo(PayChannelAdaptModel model);
}
