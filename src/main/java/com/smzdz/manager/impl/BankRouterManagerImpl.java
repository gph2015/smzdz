package com.smzdz.manager.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.smzdz.manager.BankRouterManager;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.service.AppInfoService;
import com.smzdz.service.BankRouterService;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.smzdz.entity.BankRouter;
import com.smzdz.manager.BankRouterManager;
import com.smzdz.model.BankRouterModel;
import com.smzdz.service.AgencyInfoService;
import com.smzdz.service.AppInfoService;
import com.smzdz.service.BankRouterService;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

@Component
@SuppressWarnings("all")
public class BankRouterManagerImpl implements BankRouterManager {

    @Autowired
    private BankRouterService bankRouterService;
    
    @Autowired
    private AgencyInfoService agencyInfoService;
    
    @Autowired
    private ChannelInfoService channelInfoService;
    
    @Autowired
    private AppInfoService appInfoService;
    /**
     * @Author  huangguoqing 
     * @MethodName  getBankRouterList 
     * @param pager
     * @return 银行路由列表
     * @Date    2015年3月13日
     * @Description:根据条件查询银行路由列表
     */
    public ResultListBean<BankRouterModel> getBankRouterList(Pager pager) {
        ResultListBean<BankRouterModel> resultListBean = ResultListBean.build();
        List<BankRouter> pagerList = null;
        List<BankRouter> routerList = null;
        try{
            int totalCount = bankRouterService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                pagerList = bankRouterService.selectBankRouterByPager(pager);
                routerList = bankRouterService.selectBankRouterList(pager);
            }
            resultListBean.success(covertData(routerList,pagerList),totalCount);
            return resultListBean;
        } catch (Exception e){
            resultListBean.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return resultListBean;
    };

    @Override
    public ResultBean insertRouterList(Map map) {
        ResultBean result = ResultBean.build();
        Date now = new Date();
        int appId = Integer.parseInt((String)map.get("appId"));
        String channelCode = (String)map.get("channelCode");
        int bankCardType = Integer.parseInt((String)map.get("bankCardType"));
        List<BankRouter> routerList = new ArrayList<BankRouter>();
        Map<String,Integer> statusMap = new HashMap<String,Integer>();
        Map<String,BigDecimal> scaleMap = new HashMap<String,BigDecimal>();
        BankRouter router = null;
        try{
            Iterator<String> it = map.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                if(key.endsWith("_status")){
                    statusMap.put(key.substring(0, key.indexOf('_')), Integer.parseInt((String)map.get(key)));
                } else if (key.endsWith("_scale")){
                    scaleMap.put(key.substring(0, key.indexOf('_')), new BigDecimal((String)map.get(key)));
                }
            }
            Iterator<String> scaleIt = scaleMap.keySet().iterator();
            while(scaleIt.hasNext()){
                String agencyCode = scaleIt.next();
                router = new BankRouter();
                router.setBankCode(channelCode);
                router.setBankCardType(bankCardType);
                router.setAppId(appId);
                router.setAgencyCode(agencyCode);
                router.setScale(scaleMap.get(agencyCode));
                router.setStatus(statusMap.get(agencyCode));
                router.setCreateTime(now);
                router.setModifyTime(now);
                routerList.add(router);
            }
            bankRouterService.insertBankRouterList(routerList);
        } catch (ServiceException e){
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
        }
        return result;
    }
    
    /**
     * @Author	huangguoqing 
     * @MethodName	covertData 
     * @param allRouterList
     * @return 页面要显示的元素集合
     * @Date	2015年3月17日
     * @Description:数据转换
     */
    private List<BankRouterModel> covertData(List<BankRouter> allRouterList,List<BankRouter> pagerList) throws ServiceException{
        if (null == allRouterList || allRouterList.size() == 0)
            return null;
        //将resultList按照appId,bankCode,bankCardType分组
        List<BankRouterModel> list = new ArrayList<BankRouterModel>();
        Map<Integer,String> appMap = null;
        Map<String,String> channelMap = null;
        Map<String,String> agencyMap = null;
        appMap = appInfoService.selectAppInfoForMap();
        channelMap = channelInfoService.queryChannelInfoForMap();
        agencyMap = agencyInfoService.getAllAgencyInfoForMap();
        Map<String,List<BankRouter>> map = new HashMap<String,List<BankRouter>>();
        BankRouterModel model = null;
        for (BankRouter info : allRouterList) {
            boolean isExist = false;
            for(BankRouter router : pagerList){
                if(info.getBankCode().equals(router.getBankCode()) 
                        && info.getBankCardType() == router.getBankCardType() 
                        && info.getAppId().intValue() == router.getAppId().intValue()){
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                continue;
            }
            String key = info.getAppId()+"_"+info.getBankCode()+"_"+info.getBankCardType();
            if(map.containsKey(key)){
                List<BankRouter> routerList = map.get(key);
                routerList.add(info);
            } else {
                List<BankRouter> routerList = new ArrayList<BankRouter>();
                routerList.add(info);
                map.put(key, routerList);
            }
        }
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            List<BankRouter> valueList = map.get(it.next());
            model = new BankRouterModel(valueList.get(0));
            model.setBankName(channelMap.get(model.getBankCode()));
            model.setAppName(appMap.get(model.getAppId()));
            for(BankRouter r : valueList){
                r.setAgencyName(agencyMap.get(r.getAgencyCode()));
                r.setStatusStr(Constant.ISUSEDMAP.get(r.getStatus()));
            }
            model.setRouterList(valueList);
            list.add(model);
        }
        return list;
    }
    
    @Override
    public ResultBean<Integer> getCountByconn(Map map) {
        ResultBean<Integer> result = ResultBean.build();
        int count;
        try {
            count = bankRouterService.selectCountByconn(map);
            result.setValue(count);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public ResultBean<BankRouterModel> selectBankRouter(Map map) {
        ResultBean<BankRouterModel> resultBean = ResultBean.build();
        //查询信息
        List<BankRouter> routerList;
        try {
            routerList = bankRouterService.selectBankRouterListByConn(map);
            resultBean.success(covertData(routerList));
        } catch (ServiceException e) {
            resultBean.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return resultBean;
    }
    
    private BankRouterModel covertData(List<BankRouter> routerList) throws ServiceException{
        if (null == routerList || routerList.size() == 0)
            return null;
        BankRouterModel model = null;
        Map<Integer,String> appMap = null;
        Map<String,String> channelMap = null;
        Map<String,String> agencyMap = null;
        appMap = appInfoService.selectAppInfoForMap();
        channelMap = channelInfoService.queryChannelInfoForMap();
        agencyMap = agencyInfoService.getAllAgencyInfoForMap();
        for(BankRouter r : routerList){
            if(!StringUtils.isEmpty(r.getBankCode())){
                model = new BankRouterModel(r);
                break;
            }
        }
        model.setBankName(channelMap.get(model.getBankCode()));
        model.setAppName(appMap.get(model.getAppId()));
        for(BankRouter r : routerList){
            if(null == r.getScale()){
                r.setScale(new BigDecimal(0));
            }
            r.setAgencyName(agencyMap.get(r.getAgencyCode()));
            r.setStatusStr(Constant.ISUSEDMAP.get(r.getStatus()));
        }
        //插入新加入的支付机构
        model.setRouterList(routerList);
        return model;
    }
    
    @Override
    @Transactional
    public ResultBean updateRouterList(Map map) {
        ResultBean result = ResultBean.build();
        Date now = new Date();
        int appId = Integer.parseInt((String)map.get("appId"));
        String channelCode = (String)map.get("bankCode");
        int bankCardType = Integer.parseInt((String)map.get("bankCardType"));
        //根据条件查询路由信息
        try {
            List<BankRouter> routerList = bankRouterService.selectAgencyCodeList(map);
            List<String> existAgencyList = new ArrayList<String>();
            for(BankRouter r : routerList){
                existAgencyList.add(r.getAgencyCode());
            }
            List<BankRouter> insertList = new ArrayList<BankRouter>();
            List<BankRouter> updateList = new ArrayList<BankRouter>();
            Map<String,Integer> insertStatusMap = new HashMap<String,Integer>();
            Map<String,BigDecimal> insertScaleMap = new HashMap<String,BigDecimal>();
            Map<String,Integer> updateStatusMap = new HashMap<String,Integer>();
            Map<String,BigDecimal> updateScaleMap = new HashMap<String,BigDecimal>();
            BankRouter router = null;
            Iterator<String> it = map.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                if(key.endsWith("_status")){
                    String agencyCodetemp = key.substring(0, key.indexOf('_'));
                    if(existAgencyList.contains(agencyCodetemp)){
                        updateStatusMap.put(agencyCodetemp, Integer.parseInt((String)map.get(key)));
                    } else {
                        insertStatusMap.put(agencyCodetemp, Integer.parseInt((String)map.get(key)));
                    }
                } else if (key.endsWith("_scale")){
                    String agencyCodetemp = key.substring(0, key.indexOf('_'));
                    if(existAgencyList.contains(agencyCodetemp)){
                        updateScaleMap.put(agencyCodetemp, new BigDecimal((String)map.get(key)));
                    } else {
                        insertScaleMap.put(agencyCodetemp, new BigDecimal((String)map.get(key)));
                    }
                }
            }
            //插入路由信息
            Iterator<String> insertIt = insertScaleMap.keySet().iterator();
            while(insertIt.hasNext()){
                String agencyCode = insertIt.next();
                router = new BankRouter();
                router.setBankCode(channelCode);
                router.setBankCardType(bankCardType);
                router.setAppId(appId);
                router.setAgencyCode(agencyCode);
                router.setScale(insertScaleMap.get(agencyCode));
                router.setStatus(insertStatusMap.get(agencyCode));
                router.setCreateTime(now);
                router.setModifyTime(now);
                insertList.add(router);
            }
            if(insertList.size()>0)
                bankRouterService.insertBankRouterList(insertList);
            //更新路由信息
            Iterator<String> updateIt = updateScaleMap.keySet().iterator();
            while(updateIt.hasNext()){
                String agencyCode = updateIt.next();
                router = new BankRouter();
                router.setBankCode(channelCode);
                router.setBankCardType(bankCardType);
                router.setAppId(appId);
                router.setAgencyCode(agencyCode);
                router.setScale(updateScaleMap.get(agencyCode));
                router.setStatus(updateStatusMap.get(agencyCode));
                router.setModifyTime(now);
                bankRouterService.updateBankRouter(router);
            }
        } catch (ServiceException e){
            result.withError(ResultStatus.SYSTEM_DB_ERROR);
            e.printStackTrace();
        }
        return result;
    }
}
