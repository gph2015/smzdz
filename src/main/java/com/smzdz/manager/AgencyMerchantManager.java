package com.smzdz.manager;

import com.smzdz.entity.AgencyMerchant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.entity.AgencyMerchant;
import com.smzdz.model.AgencyMerchantModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:28
 */
public interface AgencyMerchantManager {
    /**
     * 查询支付机构商户列表
     */
    public ResultListBean<AgencyMerchantModel> queryAgencyMerchantList(String agencyCode);

    /**
     * 根据ID获得单条支付机构商户信息
     *
     * @return ResultBean<AgencyMerchant>
     */
    public ResultBean<AgencyMerchantModel> queryAgencyMerchantDetailById(Integer id);

    /**
     * 新增支付机构商户信息
     *
     * @return ResultBean<AgencyMerchant>
     */
    public Result<Boolean> insertAgencyMerchant(PMap map);

    /**
     * 修改支付机构商户信息
     *
     * @return Result<Boolean>
     */
    public Result<Boolean> updateAgencyMerchant(AgencyMerchant agencyMerchant);

    /**
     * 删除支付机构商户信息
     *
     * @return ResultBean<AgencyMerchant>
     */
    public Result<Boolean> deleteMerchant(PMap map);


}
