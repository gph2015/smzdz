package com.smzdz.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.smzdz.entity.AppInfo;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.service.AppInfoService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smzdz.entity.AppInfo;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.model.AppInfoModel;
import com.smzdz.service.AppInfoService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.ServiceException;

@Component
@SuppressWarnings("unchecked")
public class AppInfoManagerImpl implements AppInfoManager {

    private static final Logger logger = LoggerFactory.getLogger(AppInfoManagerImpl.class);
    
    @Autowired
    private AppInfoService appInfoService;
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfoList 
     * @return 业务平台列表
     * @Date    2015年3月13日
     * @Description:查询所有业务平台
     */
    @Override
    public ResultListBean<AppInfoModel> selectAppInfo(PMap map) {
        ResultListBean<AppInfoModel> resultListBean = ResultListBean.build();
        List<AppInfo> resultList = null;
        try {
            resultList = appInfoService.selectAppInfoList(map);
            resultListBean.success(covertData(resultList));
        } catch (ServiceException e) {
            resultListBean.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return resultListBean;
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfoById 
     * @param id
     * @return 业务平台信息
     * @Date    2015年3月13日
     * @Description:根据ID获得业务平台信息
     */
    public ResultBean<AppInfoModel> selectAppInfoById(Integer id){
        ResultBean<AppInfoModel> result = ResultBean.build();
        AppInfo appInfo = null;
        try {
            appInfo = appInfoService.selectAppInfoById(id);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
            return result;
        }
        AppInfoModel model = new AppInfoModel(appInfo);
        result.setValue(model);
        return result;
    }
    /**
     * @Author	huangguoqing 
     * @MethodName	insertAppInfoManager 
     * @param map 业务平台字段map
     * @return ResultBean
     * @Date	2015年3月11日
     * @Description: 新增业务平台
     */
    @Override
    public ResultBean insertAppInfo(PMap map) {
        ResultBean result = ResultBean.build();
        AppInfo appInfo = new AppInfo();
        Date now = new Date();
        try{
            appInfo.setAppId(map.getInt("appId"));
            appInfo.setAppName(map.getString("appName"));
            appInfo.setBelongCompany(map.getInt("company"));
            appInfo.setSignKey(map.getString("signKey"));
            appInfo.setWxServiceNo(map.getString("wxServiceNo"));
            appInfo.setStatus(map.getInt("status"));
            appInfo.setCreateTime(now);
            appInfo.setModifyTime(now);
            appInfoService.insertAppInfo(appInfo);
        } catch (ServiceException e){
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  updateAppInfo 
     * @param map 业务平台字段map
     * @return ResultBean
     * @Date    2015年3月13日
     * @Description:更新业务平台信息
     */
    @Override
    public ResultBean updateAppInfo(PMap map) {
        ResultBean result = ResultBean.build();
        AppInfo appInfo = new AppInfo();
        Date now = new Date();
        try{
            appInfo.setAppId(map.getInt("appId"));
            appInfo.setAppName(map.getString("appName"));
            appInfo.setBelongCompany(map.getInt("company"));
            appInfo.setSignKey(map.getString("signKey"));
            appInfo.setWxServiceNo(map.getString("wxServiceNo"));
            appInfo.setStatus(map.getInt("status"));
            appInfo.setModifyTime(now);
            appInfoService.updateAppInfo(appInfo);
        } catch (ServiceException e){
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBean<Map> selectAppInfoForMap() {
        ResultBean result = ResultBean.build();
        try{
             Map<Integer,String>  map  =appInfoService.selectAppInfoForMap();
            result.success(map);
        } catch (ServiceException e){
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBean<Map> selectAppInfoForMap(int status) {
        ResultBean result = ResultBean.build();
        try{
            Map<Integer,String>  map  =appInfoService.selectAppInfoForMap(status);
            result.success(map);
        } catch (ServiceException e){
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    private List<AppInfoModel> covertData(List<AppInfo> resultList) {
        if (null == resultList || resultList.size() == 0)
            return null;
        List<AppInfoModel> list = new ArrayList<AppInfoModel>();
        AppInfoModel model = null;
        for (AppInfo info : resultList) {
            model = new AppInfoModel(info);
            list.add(model);
        }
        return list;
    }
    
    @Override
    public ResultListBean<AppInfo> selectAppInfo(String appName, Integer appId) {
        ResultListBean<AppInfo> result = ResultListBean.build();
        List<AppInfo> appList;
        try {
            appList = appInfoService.selectAppInfo(appName,appId);
            result.setValue(appList);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        } 
        return result;
    }
}
