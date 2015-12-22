package com.smzdz.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smzdz.dao.AppInfoDao;
import com.smzdz.entity.AppInfo;
import com.smzdz.service.AppInfoService;
import com.smzdz.util.utils.PMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smzdz.dao.AppInfoDao;
import com.smzdz.entity.AppInfo;
import com.smzdz.service.AppInfoService;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.ServiceException;

/**
 * @Author	huangguoqing 
 * @ClassName	AppInfoServiceImpl 
 * @Date	2015年3月12日 
 * @Description:业务平台Service
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoDao appInfoDao;
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfoList 
     * @return 业务平台列表
     * @Date    2015年3月13日
     * @Description:查询所有业务平台
     */
    @Override
    public List<AppInfo> selectAppInfoList(PMap map) throws ServiceException{
        return appInfoDao.selectAppInfoList(map);
    }
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfoById 
     * @param id
     * @return 业务平台信息
     * @Date    2015年3月13日
     * @Description:根据ID查询业务平台信息
     */
    public AppInfo selectAppInfoById(Integer id)  throws ServiceException{
        return appInfoDao.selectAppInfoById(id);
    }
    
    /**
     * @Author  huangguoqing 
     * @param appInfo 业务平台信息
     * @return 插入结果 
     * @Date    2015年3月11日
     * @Description: 添加业务平台
     */
    @Override
    public int insertAppInfo(AppInfo appInfo) throws ServiceException{
            return appInfoDao.insertAppInfo(appInfo);
    }

    /**
     * @Author  huangguoqing 
     * @param appInfo 业务平台信息
     * @return 更新结果 
     * @Date    2015年3月11日
     * @Description: 更新业务平台信息
     */
    @Override
    public int updateAppInfo(AppInfo appInfo) throws ServiceException{
            return appInfoDao.updateAppInfo(appInfo);
    }
    
    @Override
    public Map<Integer, String> selectAppInfoForMap() throws ServiceException {
        List<AppInfo> appList = appInfoDao.selectAppInfoList(null);
        Map<Integer,String> map = new HashMap<Integer,String>();
        for(AppInfo info : appList){
            map.put(info.getAppId(), info.getAppName());
        }
        return map;
    }

    @Override
    public Map<Integer, String> selectAppInfoForMap(int status) throws ServiceException {
        PMap pMap  = new PMap();
        pMap.put("status",status);
        List<AppInfo> appList = appInfoDao.selectAppInfoList(pMap);
        Map<Integer,String> map = new HashMap<Integer,String>();
        for(AppInfo info : appList){
            map.put(info.getAppId(), info.getAppName());
        }
        return map;
    }
    
    @Override
    public List<AppInfo> selectAppInfo(String appName, Integer appInfo)
            throws ServiceException {
        return appInfoDao.selectAppInfo(appName,appInfo);
    }
    
}
