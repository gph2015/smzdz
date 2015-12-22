package com.smzdz.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.manager.ChannelAdaptManager;
import com.smzdz.model.PayChannelAdaptModel;
import com.smzdz.service.ChannelAdaptService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.manager.ChannelAdaptManager;
import com.smzdz.model.PayChannelAdaptModel;
import com.smzdz.service.ChannelAdaptService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

@Component
public class ChannelAdaptManagerImpl implements ChannelAdaptManager {

    private static final Logger logger = LoggerFactory.getLogger(ChannelAdaptManagerImpl.class);
    
    @Autowired
    private ChannelAdaptService channelAdaptService;
    
    /**
     * @Author  huangguoqing 
     * @MethodName  getChannelAdaptList 
     * @param pager
     * @return 渠道适配列表
     * @Date    2015年3月13日     * @Description:根据条件查询渠道适配列表
     */
    @Override
    public ResultListBean<PayChannelAdaptModel> getChannelAdaptList(Pager pager) {
        ResultListBean<PayChannelAdaptModel> resultListBean = ResultListBean.build();
        List<PayChannelAdapt> resultList = null;
        try {
            int totalCount = channelAdaptService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = channelAdaptService.selectChannelAdaptList(pager);
            }
            resultListBean.success(covertData(resultList), totalCount);
        } catch (Exception e) {
            resultListBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return resultListBean;
    } 

    private List<PayChannelAdaptModel> covertData(List<PayChannelAdapt> resultList) {
        if (null == resultList || resultList.size() == 0)
            return null;
        List<PayChannelAdaptModel> list = new ArrayList<PayChannelAdaptModel>();
        PayChannelAdaptModel model = null;
        for (PayChannelAdapt info : resultList) {
            model = new PayChannelAdaptModel(info);
            list.add(model);
        }
        return list;
    }

    /**
     * @Author  huangguoqing 
     * @MethodName  getAdaptListByCon 
     * @param model
     * @return 渠道信息
     * @Date    2015年3月26日
     * @Description:根据条件查询渠道适配信息
     */
    @Override
    public ResultListBean<PayChannelAdapt> getAdaptListByCon(
            PayChannelAdaptModel model) {
        ResultListBean<PayChannelAdapt> result = ResultListBean.build();
        PayChannelAdapt adapt = new PayChannelAdapt();
        adapt.setAppId(model.getAppId());
        adapt.setAccessPlatform(model.getAccessPlatform());
        adapt.setBankCardType(model.getBankCardType());
        adapt.setChannelType(model.getChannelType());
        adapt.setChannelCode(model.getChannelCode());
        List<PayChannelAdapt> list;
        try {
            list = channelAdaptService.selectAdaptListByCon(adapt);
            result.success(list);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  insertAppInfo 
     * @param model
     * @return 
     * @Date    2015年3月26日
     * @Description:新增渠道适配
     */
    public ResultBean insertAdaptInfo(PayChannelAdaptModel model){
        ResultBean result = ResultBean.build();
        Date now = new Date();
        PayChannelAdapt adapt = new PayChannelAdapt();
        adapt.setAppId(model.getAppId());
        adapt.setAccessPlatform(model.getAccessPlatform());
        adapt.setChannelCode(model.getChannelCode());
        adapt.setChannelType(model.getChannelType());
        adapt.setBankCardType(model.getBankCardType());
        adapt.setStatus(model.getStatus());
        adapt.setSort(model.getSort());
        adapt.setCreateTime(now);
        adapt.setModifyTime(now);
        try {
            channelAdaptService.insertAdaptInfo(adapt);
        } catch (Exception e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  getChannelAdaptById 
     * @param id
     * @return 渠道适配信息
     * @Date    2015年3月26日
     * @Description:根据ID查询渠道适配信息
     */
    public ResultBean<PayChannelAdaptModel> getChannelAdaptById(Integer id){
        ResultBean<PayChannelAdaptModel> result = ResultBean.build();
        PayChannelAdapt adapt = null;
        try {
            adapt = channelAdaptService.selectAdaptById(id);
            PayChannelAdaptModel model = new PayChannelAdaptModel(adapt);
            result.setValue(model);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    
    }
    
    /**
     * @Author	huangguoqing 
     * @MethodName	updateAdaptInfo 
     * @param model
     * @return 
     * @Date	2015年3月26日
     * @Description:
     */
    @Override
    public ResultBean updateAdaptInfo(PayChannelAdaptModel model) {
        ResultBean result = ResultBean.build();
        PayChannelAdapt adapt = new PayChannelAdapt();
        adapt.setId(model.getId());
        adapt.setStatus(model.getStatus());
        adapt.setSort(model.getSort());
        try{
            channelAdaptService.updateAdapt(adapt);
        }catch(ServiceException e){
            result.withError(e.getStatus());
            e.printStackTrace();
        }
        return result;
    }
}
