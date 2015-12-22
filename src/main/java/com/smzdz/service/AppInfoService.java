package com.smzdz.service;


import java.util.List;
import java.util.Map;

import com.smzdz.entity.AppInfo;
import com.smzdz.entity.AppInfo;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.ServiceException;

/**
 * @Author	huangguoqing 
 * @ClassName	AppInfoService 
 * @Date	2015年3月11日 
 * @Description:业务平台Service
 */
public interface AppInfoService {

    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfoList 
     * @return 业务平台列表
     * @Date    2015年3月13日
     * @Description:查询所有业务平台
     */
    public List<AppInfo> selectAppInfoList(PMap map) throws ServiceException;


    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfoById 
     * @param id
     * @return 业务平台信息
     * @Date    2015年3月13日
     * @Description:根据ID查询业务平台信息
     */
    public AppInfo selectAppInfoById(Integer id) throws ServiceException;
    
    /**
     * @Author	huangguoqing 
     * @param appInfo 业务平台信息
     * @return 插入结果 
     * @Date	2015年3月11日
     * @Description: 添加业务平台
     */
    public int insertAppInfo(AppInfo appInfo) throws ServiceException;
    
    /**
     * @Author	huangguoqing 
     * @param appInfo 业务平台信息
     * @return 更新结果 
     * @Date	2015年3月11日
     * @Description: 更新业务平台信息
     */
    public int updateAppInfo(AppInfo appInfo) throws ServiceException;
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectAppInfoForMap 
     * @return 产品Map
     * @throws ServiceException 
     * @Date	2015年3月30日
     * @Description:所以产品Map
     */
    public Map<Integer,String> selectAppInfoForMap() throws ServiceException;


    public Map<Integer, String> selectAppInfoForMap(int status) throws ServiceException;

    /**
     * @Author	huangguoqing 
     * @MethodName	selectAppInfo 
     * @param appName
     * @param appId
     * @return 获得产品信息
     * @throws ServiceException 
     * @Date	2015年4月2日
     * @Description:拍重复用
     */
    public List<AppInfo> selectAppInfo(String appName,Integer appId) throws ServiceException;
}
