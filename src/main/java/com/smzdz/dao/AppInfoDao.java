package com.smzdz.dao;

import java.util.List;

import com.smzdz.entity.AppInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smzdz.util.utils.PMap;

/**
 * @Author	huangguoqing 
 * @ClassName	AppInfoDao 
 * @Date	2015年3月11日 
 * @Description:业务平台数据库操作
 */
@Repository 
public interface AppInfoDao {

    /**
     * @Author	huangguoqing 
     * @MethodName	selectAppInfoList 
     * @return 业务平台列表
     * @Date	2015年3月13日
     * @Description:查询所有业务平台
     */
    public List<AppInfo> selectAppInfoList(PMap map);



    /**
     * @Author	huangguoqing 
     * @MethodName	selectAppInfoById 
     * @param id
     * @return 业务平台信息
     * @Date	2015年3月13日
     * @Description:根据ID查询业务平台信息
     */
    public AppInfo selectAppInfoById(Integer id);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	insertAppInfo 
     * @param appInfo 业务平台信息
     * @return 插入结果
     * @Date	2015年3月11日
     * @Description:新增业务平台
     */
    public int insertAppInfo(AppInfo appInfo);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	updateAppInfo 
     * @param appInfo 业务平台信息
     * @return 更新结果
     * @Date	2015年3月11日
     * @Description:更新业务平台信息
     */
    public int updateAppInfo(AppInfo appInfo);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectAppInfo 
     * @param appName
     * @param appId
     * @return 产品信息
     * @Date	2015年4月2日
     * @Description:根据产品名称或ID查询产品信息
     */
    public List<AppInfo> selectAppInfo(@Param("appName") String appName,@Param("appId") Integer appId);
}
