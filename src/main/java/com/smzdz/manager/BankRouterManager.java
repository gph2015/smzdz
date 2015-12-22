package com.smzdz.manager;

import java.util.Map;

import com.smzdz.util.utils.Pager;
import com.smzdz.model.BankRouterModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;

/**
 * @Author	huangguoqing 
 * @ClassName	BankRouterManager 
 * @Date	2015年3月16日 
 * @Description:银行路由Manager
 */
public interface BankRouterManager {

    /**
     * @Author	huangguoqing 
     * @MethodName	getBankRouterList 
     * @param pager
     * @return 页面展示信息
     * @Date	2015年3月16日
     * @Description:根据条件查询银行路由信息
     */
    public ResultListBean<BankRouterModel> getBankRouterList(Pager pager);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	insertRouterList 
     * @param map
     * @return 插入结果
     * @Date	2015年3月30日
     * @Description:插入机构路由信息
     */
    public ResultBean insertRouterList(Map map);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	getCountByconn 
     * @param map
     * @return 个数
     * @Date	2015年3月30日
     * @Description:根据条件查询数据库中是否存在
     */
    public ResultBean<Integer> getCountByconn(Map map);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	selectBankRouter 
     * @param map
     * @return 机构路由信息
     * @Date	2015年3月31日
     * @Description:根据条件查询机构路由信息
     */
    public ResultBean<BankRouterModel> selectBankRouter(Map map);
    
    /**
     * @Author	huangguoqing 
     * @MethodName	updateRouterList 
     * @param map
     * @return 更新信息
     * @Date	2015年3月31日
     * @Description:更新信息
     */
    public ResultBean updateRouterList(Map map);
}
