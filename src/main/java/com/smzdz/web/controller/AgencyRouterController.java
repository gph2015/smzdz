package com.smzdz.web.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smzdz.enums.OperationLogType;
import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.BankRouterManager;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.model.AppInfoModel;
import com.smzdz.model.BankRouterModel;
import com.smzdz.model.ChannelInfoModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author	huangguoqing 
 * @ClassName	AgencyRouterController 
 * @Date	2015年3月27日 
 * @Description:机构路由Controller
 */
@Controller
@RequestMapping("/router")
public class AgencyRouterController extends BaseController{

    private static final String BACK_URL = "routerList.j";
    @Autowired
    private AppInfoManager appInfoManager;
    
    @Autowired
    private BankRouterManager routerManager;
    
    @Autowired
    private ChannelInfoManager channelInfoManager;
    
    @Autowired
    private AgencyInfoManager agencyInfoManager;
    
    @RequestMapping("/routerList")
    public ModelAndView routerList(Pager pager){
        ModelAndView view = new ModelAndView("/basicParam/router/routerList");
        pager.setPageRows(4);
        ResultListBean<BankRouterModel> result = routerManager.getBankRouterList(pager);
        if(!ResultListBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(),
                    result.getStatus().getCode(), BACK_URL);
        List<BankRouterModel> routerList = result.getValue();
        PMap paramMap = new PMap();
        paramMap.put("status", 1);
        ResultListBean<AppInfoModel> appResult = appInfoManager.selectAppInfo(paramMap);
        if(!ResultListBean.isSuccess(appResult))
            return setErrorPage(appResult.getStatus().getMessage(),
                    appResult.getStatus().getCode(), BACK_URL);
        List<AppInfoModel> appList = appResult.getValue();
        //适配列表
        view.addObject("routerList",routerList);
        //接入产品
        view.addObject("appList",appList);
        //银行卡类型
        view.addObject("bankCardTypeMap", Constant.BANKCARDMAP);
        return view;
    }
    
    @RequestMapping("/toAddRouter")
    public ModelAndView toAddRouter(HttpServletRequest request,HttpServletResponse response){
        ModelAndView view = new ModelAndView("/basicParam/router/addRouter");
        ResultListBean<ChannelInfoModel> resultChannelList = channelInfoManager.queryChannelInfoList();
        if(!ResultListBean.isSuccess(resultChannelList))
            return setErrorPage(resultChannelList.getStatus().getMessage(),
                    resultChannelList.getStatus().getCode(), BACK_URL);
        List<ChannelInfoModel> channelList = resultChannelList.getValue();
        for (Iterator<ChannelInfoModel> iter = channelList.iterator(); iter.hasNext();) {  
            ChannelInfoModel model = iter.next();  
            if (model.getChannelType() !=1) {  
                iter.remove();  
            }  
        }  
        //获取产品信息
        PMap paramMap = new PMap();
        paramMap.put("status", 1);
        ResultListBean<AppInfoModel> appResult = appInfoManager.selectAppInfo(paramMap);
        if(!ResultListBean.isSuccess(appResult))
            return setErrorPage(appResult.getStatus().getMessage(),
                    appResult.getStatus().getCode(), BACK_URL);
        List<AppInfoModel> appList = appResult.getValue();
        //银行名称
        view.addObject("channelList",channelList);
        //接入产品
        view.addObject("appList",appList);
        //银行卡类型
        view.addObject("bankCardTypeMap", Constant.BANKCARDMAP);
        //机构列表
        view.addObject("agencyMap",agencyInfoManager.getAllAgencyInfoForMap());
        return view;
    }
    
    @RequestMapping("/addSubmit")
    public ModelAndView addSubmit(HttpServletRequest request,HttpServletResponse response){
        Map params = getRequestParameterMap(request);
        //排重
        ResultBean<Integer> resultCount = routerManager.getCountByconn(params);
        int count = resultCount.getValue();
        if(count > 0){
            return setErrorPage(ResultStatus.ADD_ROUTER_ERROR.getMessage(),
                    ResultStatus.ADD_ROUTER_ERROR.getCode(),BACK_URL);
        }
        //新增机构路由
        ResultBean result = routerManager.insertRouterList(params);
        if(!Result.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(),
                    result.getStatus().getCode(), BACK_URL);
        toLog(OperationLogType.INSERT, "insertRouterList", params);
        return toSuccess(BACK_URL);
    }
    
    @RequestMapping("/showRouter")
    public ModelAndView showRouter(HttpServletRequest request,HttpServletResponse response){
        ModelAndView view = new ModelAndView("/basicParam/router/updateRouter");
        Map map = new HashMap();
        map.put("bankCode", request.getParameter("bankCode"));
        map.put("appId", Integer.parseInt(request.getParameter("appId")));
        map.put("bankCardType", request.getParameter("bankCardType"));
        ResultBean<BankRouterModel> result = routerManager.selectBankRouter(map);
        if(!Result.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(),
                    result.getStatus().getCode(), BACK_URL);
        BankRouterModel routerModel = result.getValue();
        view.addObject("routerModel",routerModel);
        return view;
    }
    
    @RequestMapping("/updateSubmit")
    public ModelAndView updateSubmit(HttpServletRequest request,HttpServletResponse response){
        Map params = getRequestParameterMap(request);
        //更新机构路由
        ResultBean result = routerManager.updateRouterList(params);
        if(!Result.isSuccess(result))
            if(!Result.isSuccess(result))
                return setErrorPage(result.getStatus().getMessage(),
                        result.getStatus().getCode(), BACK_URL);
        toLog(OperationLogType.UPDATE, "updateRouterList", params);
        return toSuccess(BACK_URL);
    }
}
