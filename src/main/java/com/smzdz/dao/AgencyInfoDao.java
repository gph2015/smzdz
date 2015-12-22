package com.smzdz.dao;

import java.util.List;

import com.smzdz.entity.AgencyInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 高朋辉 on 2015/3/3.
 */
@Repository
public interface AgencyInfoDao {

    /**
     * 获得支付机构列表
     * @param 
     * @return List<AgencyInfo>
     */
    public List<AgencyInfo> getAgencyInfoList(@Param("code")String code);

    /**
     * 获取支付机构基本信息
     * @param id 主键
     * @return AgencyInfo
     */
    public  AgencyInfo getById(Integer id);
    
    /**
     * 新增
     * @param info
     * @return int
     */
    public int insertAgencyInfo(AgencyInfo info);
    
    /**
     * 修改
     * @param info
     * @return int
     */
    public int updateAgencyInfo(AgencyInfo info);
    
    /**
     * 获取支付机构基本信息
     * @param agencyCode 编码
     * @param accessPlatform 1：PC 2：移动 3：不区分 
     * @param agencyType:1：网关支付 2：第三方支付 3：扫码支付 4:SDK 5：全部  
     * @return AgencyInfo
     */
    public int getAgencyInfoByConn(@Param("agencyCode")String agencyCode,
                                          @Param("accessPlatform")String accessPlatform,
                                          @Param("agencyType")String agencyType);

}
