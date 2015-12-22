package com.smzdz.dao;

import com.smzdz.entity.AgencyMerchant;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 支付机构商户对应DAO
 *
 * @author 用户平台事业部---高朋辉3
 * @version 1.0
 * @date 2015/3/11 15:40
 */
@Repository
public interface AgencyMerchantDao {

    /**
     * 0.获得支付机构商户信息列表
     *
     * @return List<AgencyInfo>
     */
    public List<AgencyMerchant> queryAgencyMerchantList(@Param("agencyCode") String agencyCode);

    /**
     * 1.新增支付机构商户信息
     */
    public int insertAgencyMerchant(AgencyMerchant agencyMerchant);

    /**
     * 2.根据支付机构编码查询支付机构商户信息列表
     */
    public List<AgencyMerchant> queryAgencyMerchants(String agencyCode);

    /**
     * 3.获取支付机构商户详细信息
     *
     * @param id 主键
     * @return AgencyMerchant
     */
    public AgencyMerchant queryAgencyMerchantDetail(Integer id);

    /**
     * 4.修改支付机构商户信息
     */
    public int updateAgencyMerchant(AgencyMerchant agencyMerchant);

    /**
     * 5.删除支付机构商户信息
     */
    public int deleteMerchant(@Param("id") Integer id);

}
