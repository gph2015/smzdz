package com.smzdz.manager.impl;
/**
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:42
 */

import com.smzdz.entity.AgencyMerchant;
import com.smzdz.service.AgencyMerchantService;
import com.smzdz.service.AppInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.entity.AgencyMerchant;
import com.smzdz.manager.AgencyMerchantManager;
import com.smzdz.model.AgencyMerchantModel;
import com.smzdz.service.AgencyMerchantService;
import com.smzdz.service.AppInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class AgencyMerchantManagerImpl implements AgencyMerchantManager {

    private static final Logger logger = LoggerFactory.getLogger(AgencyMerchantManagerImpl.class);

    @Autowired
    private AgencyMerchantService agencyMerchantService;
    @Autowired
    private AppInfoService appInfoService;

    @Override
    public ResultListBean<AgencyMerchantModel> queryAgencyMerchantList(String agencyCode) {
        ResultListBean<AgencyMerchantModel> agencyMerchantBean = ResultListBean.build();
        try {
            List<AgencyMerchant>
                    agencyMerchant =
                    agencyMerchantService.queryAgencyMerchantList(agencyCode);

            agencyMerchantBean.success(covertData(agencyMerchant));
        } catch (ServiceException e) {
            agencyMerchantBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return agencyMerchantBean;


    }

    private List<AgencyMerchantModel> covertData(List<AgencyMerchant> agencyMerchant) throws ServiceException {
        if (null == agencyMerchant || agencyMerchant.size() == 0) {
            return null;
        }
        Map<Integer, String> appMap = null;
        appMap = appInfoService.selectAppInfoForMap();
        List<AgencyMerchantModel> list = new ArrayList<AgencyMerchantModel>();
        AgencyMerchantModel model = null;
        for (AgencyMerchant info : agencyMerchant) {
            model = new AgencyMerchantModel(info, appMap);
            list.add(model);
        }
        return list;
    }

    @Override
    public ResultBean<AgencyMerchantModel> queryAgencyMerchantDetailById(Integer id) {
        ResultBean<AgencyMerchantModel> result = ResultBean.build();
        try {
            AgencyMerchant agencyMerchant = agencyMerchantService.queryAgencyMerchantDetailById(id);
            Map<Integer, String> appMap = null;
            appMap = appInfoService.selectAppInfoForMap();
            AgencyMerchantModel model = new AgencyMerchantModel(agencyMerchant, appMap);
            result.setValue(model);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBasicBean<Boolean> insertAgencyMerchant(PMap map) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        AgencyMerchant agencyMerchant = new AgencyMerchant();
        agencyMerchant.setAgencyCode(map.getString("agencyCode"));        //支付机构编码
        agencyMerchant.setCompanyCode(map.getInt("companyCode"));          //所属公司编码 (1:搜狗网络 2:搜狗科技)
        agencyMerchant.setMerchantNo(map.getString("merchantNo"));        //商户号
        agencyMerchant
                .setSellerEmail(map.getString("sellerEmail"));       //第三方开设的收款账号对应（邮箱）或者为微信公众号
        if ("" != map.get("appId")) {
            agencyMerchant
                    .setAppId(map.getInt("appId"));
        }
        agencyMerchant
                .setEncryptionType(map.getInt("encryptionType"));       //加密方式 (1：签名；2：非对称加密 3：对账加密)
        agencyMerchant.setEncryptKey(map.getString("encryptKey"));        //加密密钥
        agencyMerchant.setPubKeypath(map.getString("pubKeypath"));        //第三方公钥证书路径
        agencyMerchant.setPrivateKeypath(map.getString("privateKeypath"));    //本地私钥证书路径
        agencyMerchant.setPageBackUrl(map.getString("pageBackUrl"));       //支付之后页面回调地址
        agencyMerchant.setNotifyBackUrl(map.getString("notifyBackUrl"));     //支付之后服务后端回调地址
        agencyMerchant.setIsUsed(map.getInt("isUsed"));               //是否启用 (0:未启用  1:已启用)
        agencyMerchant.setCreateTime(new Date());          //创建时间
        agencyMerchant.setModifyTime(new Date());          //修改时间
        try {
            agencyMerchantService.insertAgencyMerchant(agencyMerchant);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<Boolean> updateAgencyMerchant(AgencyMerchant agencyMerchant) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        try {
            agencyMerchantService.updateAgencyMerchant(agencyMerchant);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除用户所有信息
     */
    @Override
    public ResultBasicBean<Boolean> deleteMerchant(PMap map) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        Integer id = map.getInt("id");
        try {
            agencyMerchantService.deleteMerchant(id);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

}
