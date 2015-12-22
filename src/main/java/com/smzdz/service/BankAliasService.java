package com.smzdz.service;

import com.smzdz.entity.BankAlias;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:29
 */
public interface BankAliasService {
    public int selectCount(Pager pager) throws ServiceException;
    public List<BankAlias> queryBankAliasList(Pager pager) throws ServiceException;

    public BankAlias queryBankAliasDetailById(Integer id) throws ServiceException;

    public int insertBankAlias(BankAlias bankAlias) throws ServiceException;

    public int updateBankAlias(BankAlias bankAlias) throws ServiceException;

    public int deleteBankAlias(Integer aliasId) throws ServiceException;

    public int getCountByConn(String agencyCode,String bankCardType,String bankCode)throws ServiceException;

}
