package com.smzdz.manager;

import com.smzdz.entity.BankAlias;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.BankAlias;
import com.smzdz.model.BankAliasModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:28
 */
public interface BankAliasManager {

    /**
     * 查询支付机构银行别名列表
     */
    public ResultListBean<BankAliasModel> queryBankAliasList(Pager pager);

    /**
     * 根据ID获得单条支付机构银行别名信息
     *
     * @return ResultBean<BankAlias>
     */
    public ResultBean<BankAliasModel> queryBankAliasDetailById(Integer id);

    /**
     * 新增支付机构银行别名信息
     *
     * @return ResultBean<BankAlias>
     */
    public Result<Boolean> insertBankAlias(PMap map);

    /**
     * 修改支付机构银行别名信息
     *
     * @return ResultBean<BankAlias>
     */
    public Result<Boolean> updateBankAlias(BankAlias bankAlias);

    public Result<Boolean> deleteBankAlias(PMap map);

}
