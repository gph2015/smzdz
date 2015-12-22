package com.smzdz.manager;

import java.util.Map;

import com.smzdz.entity.AppInfo;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.entity.AppInfo;
import com.smzdz.model.AppInfoModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;

/**
 * @Author	huangguoqing 
 * @ClassName	AppInfoManager 
 * @Date	2015年3月11日 
 * @Description:业务平台Manager
 */
public interface AppInfoManager {
    
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfoList 
     * @return 业务平台列表
     * @Date    2015年3月13日
     * @Description:查询所有业务平台
     */
    public ResultListBean<AppInfoModel> selectAppInfo(PMap map);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectAppInfoById 
     * @param id
     * @return 业务平台信息
     * @Date	2015年3月13日
     * @Description:根据ID获得业务平台信息
     */
    public ResultBean<AppInfoModel> selectAppInfoById(Integer id);
    
    /**
     * @Author  huangguoqing 
     * @MethodName  insertAppInfoManager 
     * @param map 业务平台字段map
     * @return ResultBean
     * @Date    2015年3月11日
     * @Description: 新增业务平台
     */
    public ResultBean insertAppInfo(PMap map);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	updateAppInfo 
     * @param map 业务平台字段map
     * @return ResultBean
     * @Date	2015年3月13日
     * @Description:更新业务平台信息
     */
    public ResultBean updateAppInfo(PMap map);

    /**
     * @Author	huangguoqing
     * @MethodName	selectAppInfoForMap
     * @return 产品Map
     * @Date	2015年3月30日
     * @Description:所以产品Map
     */
    public  ResultBean<Map>  selectAppInfoForMap() ;

    public ResultBean<Map> selectAppInfoForMap(int status) ;
    /**
     * @Author  huangguoqing 
     * @MethodName  selectAppInfo 
     * @return 业务平台信息
     * @Date    2015年3月13日
     * @Description:查询所有业务平台信息，排重用
     */
    public ResultListBean<AppInfo> selectAppInfo(String appName,Integer appId);
    
}
