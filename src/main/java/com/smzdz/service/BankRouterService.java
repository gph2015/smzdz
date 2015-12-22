package com.smzdz.service;

import java.util.List;
import java.util.Map;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.BankRouter;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

/**
 * @Author	huangguoqing 
 * @ClassName	BankRouterService 
 * @Date	2015年3月16日 
 * @Description:银行路由Service
 */
public interface BankRouterService {
    
    public List<BankRouter> selectBankRouterList(Pager pager) throws ServiceException;
    
    public int selectCount(Pager pager) throws ServiceException;
    
    public List<BankRouter> selectBankRouterByPager(Pager pager) throws ServiceException;
    
    public int insertBankRouterList(List<BankRouter> routerList) throws ServiceException;
    
    public int selectCountByconn(Map map) throws ServiceException;
    
    public List<BankRouter> selectBankRouterListByConn(Map map) throws ServiceException;
    
    public int updateBankRouter(BankRouter router) throws ServiceException;
    
    public List<BankRouter> selectAgencyCodeList(Map map) throws ServiceException;
}
