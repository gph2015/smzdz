package com.smzdz.manager;

import java.util.Map;

import com.smzdz.entity.AgencyInfo;
import com.smzdz.model.AgencyInfoModel;
import com.smzdz.entity.AgencyInfo;
import com.smzdz.model.AgencyInfoModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;

public interface AgencyInfoManager {

    /**
     * 查询支付机构列表
     * @return ResultListBean<AgencyInfoModel>
     */
    public ResultListBean<AgencyInfoModel> getAgencyList(String code);

    /**
     * 根据ID获得单条支付机构信息
     * @return ResultBean<AgencyInfo>
     */
    public ResultBean<AgencyInfoModel> getById(Integer id);

    /**
     * 新增支付机构信息
     * @return ResultBean<AgencyInfo>
     */
    public Result<Boolean> insertAgencyInfo(AgencyInfo info);

    /**
     * 修改支付机构信息
     * @return ResultBean<AgencyInfo>
     */
    public Result<Boolean> updateAgencyInfo(AgencyInfo info);

    public Map<String,String> getAllAgencyInfoForMap();
}
