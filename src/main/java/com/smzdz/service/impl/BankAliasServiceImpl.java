package com.smzdz.service.impl;

import com.smzdz.entity.BankAlias;
import com.smzdz.service.BankAliasService;
import com.smzdz.util.utils.Pager;
import com.smzdz.dao.BankAliasDao;
import com.smzdz.entity.BankAlias;
import com.smzdz.service.BankAliasService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:33
 */
@Service
public class BankAliasServiceImpl implements BankAliasService {

    @Autowired
    BankAliasDao bankAliasDao;
    @Override
    public int selectCount(Pager pager) throws ServiceException {
        return bankAliasDao.selectCount(pager);
    }
    @Override
    public List<BankAlias> queryBankAliasList(Pager pager) throws ServiceException {
        return bankAliasDao.queryBankAliasList(pager);
    }

    @Override
    public BankAlias queryBankAliasDetailById(Integer id) throws ServiceException {
        return bankAliasDao.queryBankAliasDetail(id);
    }

    @Override
    public int insertBankAlias(BankAlias bankAlias) throws ServiceException {
        return bankAliasDao.insertBankAlias(bankAlias);
    }

    @Override
    public int updateBankAlias(BankAlias bankAlias) throws ServiceException {
        return bankAliasDao.updateBankAlias(bankAlias);
    }
    @Override
    public int deleteBankAlias(Integer aliasId) throws ServiceException {
        return bankAliasDao.deleteBankAlias(aliasId);
    }

    @Override
    public int getCountByConn(String agencyCode,String bankCardType,String bankCode)
            throws ServiceException {
        return bankAliasDao.getBankAliasByConn(agencyCode,bankCardType,bankCode);
    }
}
