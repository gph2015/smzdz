package com.smzdz.dao;

import com.smzdz.entity.BankAlias;
import com.smzdz.util.utils.Pager;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 支付机构银行别名对应DAO
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/11 15:50
 */
@Repository
public interface BankAliasDao {

    public int selectCount(Pager pager);

    /**
     * 0.获得支付机构银行别名信息列表
     *
     * @return List<BankAlias>
     */
    public List<BankAlias> queryBankAliasList(Pager pager);

    /**
     * 1.新增支付机构银行别名信息
     */
    public int insertBankAlias(BankAlias bankAlias);

    /**
     * 2.根据支付机构编码查询支付机构银行别名信息列表
     */
    public List<BankAlias> queryBankAlias(@Param("agencyCode") String agencyCode,
                                          @Param("bankCode") String bankCode);

    /**
     * 3.根据自增主键id查询支付机构银行别名记录详情
     */
    public BankAlias queryBankAliasDetail(Integer alias_id);

    /**
     * 4.修改支付机构银行别名信息
     */
    public int updateBankAlias(BankAlias bankAlias);

    /**
     * 5.删除支付机构银行别名信息
     */
    public int deleteBankAlias(@Param("aliasId") Integer aliasId);

    public int getBankAliasByConn(@Param("agencyCode") String agencyCode, @Param("bankCardType") String bankCardType, @Param("bankCode") String bankCode);
}
