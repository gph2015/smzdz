package com.smzdz.manager.impl;

/**
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:30
 */

import com.smzdz.entity.BankAlias;
import com.smzdz.manager.BankAliasManager;
import com.smzdz.service.BankAliasService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.BankAlias;
import com.smzdz.manager.BankAliasManager;
import com.smzdz.model.BankAliasModel;
import com.smzdz.service.BankAliasService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BankAliasManagerImpl implements BankAliasManager {

    private static final Logger logger = LoggerFactory.getLogger(BankAliasManagerImpl.class);

    @Autowired
    private BankAliasService bankAliasService;

    @Override
    public ResultListBean<BankAliasModel> queryBankAliasList(Pager pager) {
        ResultListBean<BankAliasModel> bankAliasBean = ResultListBean.build();
        List<BankAlias> resultList = null;
        try {
            int totalCount = bankAliasService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = bankAliasService.queryBankAliasList(pager);
            }
            bankAliasBean.success(covertData(resultList), totalCount);
        } catch (ServiceException e) {
            bankAliasBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return bankAliasBean;


    }

    private List<BankAliasModel> covertData(List<BankAlias> bankAlias) {
        if (null == bankAlias || bankAlias.size() == 0) {
            return null;
        }
        List<BankAliasModel> list = new ArrayList<BankAliasModel>();
        BankAliasModel model = null;
        for (BankAlias info : bankAlias) {
            model = new BankAliasModel(info);
            list.add(model);
        }
        return list;
    }

    @Override
    public ResultBean<BankAliasModel> queryBankAliasDetailById(Integer id) {
        ResultBean<BankAliasModel> result = ResultBean.build();
        try {
            BankAlias bankAlias = bankAliasService.queryBankAliasDetailById(id);
            BankAliasModel model = new BankAliasModel(bankAlias);
            result.setValue(model);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBasicBean<Boolean> insertBankAlias(PMap map) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        BankAlias bankAlias = new BankAlias();
        bankAlias.setAgencyCode(map.getString("agencyCode"));
        bankAlias.setBankCardType(map.getInt("bankCardType"));
        bankAlias.setBankCode(map.getString("bankCode"));
        bankAlias.setAliasName(map.getString("aliasName"));
        bankAlias.setReserved(map.getString("reserved"));
        bankAlias.setCreateTime(new Date());
        bankAlias.setModifyTime(new Date());
        try {
            int count = bankAliasService.getCountByConn(map.getString("agencyCode"),
                    String.valueOf(map.getInt("bankCardType")), map.getString("bankCode"));
            if (count > 0) {
                result.withError(ResultStatus.ADD_BANKALIAS_ERROR);
                return result;
            }
            bankAliasService.insertBankAlias(bankAlias);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<Boolean> updateBankAlias(BankAlias bankAlias) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        try {
            bankAliasService.updateBankAlias(bankAlias);
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
    public ResultBasicBean<Boolean> deleteBankAlias(PMap map) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        Integer aliasId = map.getInt("id");
        try {
            bankAliasService.deleteBankAlias(aliasId);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

}
