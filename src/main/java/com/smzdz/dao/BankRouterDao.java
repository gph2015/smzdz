package com.smzdz.dao;

import java.util.List;
import java.util.Map;

import com.smzdz.util.utils.Pager;
import org.springframework.stereotype.Repository;

import com.smzdz.entity.BankRouter;

/**
 * @Author	huangguoqing 
 * @ClassName	BankRouterDao 
 * @Date	2015年3月16日 
 * @Description:银行路由Dao
 */
@Repository
public interface BankRouterDao {
    
    public List<BankRouter> selectBankRouterList(Pager pager);
    
    public BankRouter selectBankRouterById(Integer id);
    
    public int insertBankRouter(BankRouter router);
    
    public int selectCount(Pager pager);
    
    public List<BankRouter> selectBankRouterByPager(Pager pager);
    
    public int insertBankRouterList(List<BankRouter> routerList);
    
    public int selectCountByconn(Map map);
    
    public List<BankRouter> selectBankRouterListByConn(Map map);
    
    public int updateBankRouter(BankRouter router);
    
    public List<BankRouter> selectAgencyCodeList (Map map);
}
