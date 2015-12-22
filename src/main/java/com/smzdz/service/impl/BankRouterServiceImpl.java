package com.smzdz.service.impl;

import java.util.List;
import java.util.Map;

import com.smzdz.dao.BankRouterDao;
import com.smzdz.service.BankRouterService;
import com.smzdz.util.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smzdz.dao.BankRouterDao;
import com.smzdz.entity.BankRouter;
import com.smzdz.service.BankRouterService;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

/**
 * @Author	huangguoqing 
 * @ClassName	BankRouterServiceImpl 
 * @Date	2015年3月16日 
 * @Description:银行路由Service
 */
@Service
public class BankRouterServiceImpl implements BankRouterService {

    @Autowired
    private BankRouterDao bankRouterDao;
    
    @Override
    public List<BankRouter> selectBankRouterList(Pager pager) throws ServiceException{
        return bankRouterDao.selectBankRouterList(pager);
    }
    @Override
    
    public int selectCount(Pager pager) throws ServiceException{
        return bankRouterDao.selectCount(pager);
    }
    
    @Override
    public List<BankRouter> selectBankRouterByPager(Pager pager) throws ServiceException{
        return bankRouterDao.selectBankRouterByPager(pager);
    }
    
    @Override
    public int insertBankRouterList(List<BankRouter> routerList) throws ServiceException{
        return bankRouterDao.insertBankRouterList(routerList);
    }
    
    @Override
    public int selectCountByconn(Map map) throws ServiceException{
        return bankRouterDao.selectCountByconn(map);
    }
    
    @Override
    public List<BankRouter> selectBankRouterListByConn(Map map) throws ServiceException{
        return bankRouterDao.selectBankRouterListByConn(map);
    }
    
    @Override
    public int updateBankRouter(BankRouter router) throws ServiceException{
        return bankRouterDao.updateBankRouter(router);
    }
    
    @Override
    public List<BankRouter> selectAgencyCodeList(Map map) throws ServiceException{
        return bankRouterDao.selectAgencyCodeList(map);
    }
}
