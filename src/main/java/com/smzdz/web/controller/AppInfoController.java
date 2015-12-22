package com.smzdz.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smzdz.entity.AppInfo;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.enums.OperationLogType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smzdz.entity.AppInfo;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.model.AppInfoModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;

@Controller
@RequestMapping("/app")
public class AppInfoController extends BaseController{
    
    @Autowired
    private AppInfoManager appInfoManager;
    
    private static final String BACK_URL="getAppList.j";
    @RequestMapping("/getAppList")
    public ModelAndView getAppList(HttpServletRequest request,HttpServletResponse response){
        ModelAndView view = new ModelAndView("/basicParam/app/appList");
        String appName = request.getParameter("appName");
        String belongCompany = request.getParameter("belongCompany");
        String status = request.getParameter("status");
        PMap map = new PMap();
        if (!StringUtils.isEmpty(appName)) {
            map.put("appName", appName);
        }
        if (!StringUtils.isEmpty(belongCompany)) {
            map.put("belongCompany", belongCompany);
        }
        if (!StringUtils.isEmpty(status)) {
            map.put("status", status);
        }
        ResultListBean<AppInfoModel> resultList = appInfoManager.selectAppInfo(map);
        if(!ResultListBean.isSuccess(resultList))
            return setErrorPage(resultList.getStatus().getMessage(), 
                    resultList.getStatus().getCode(), BACK_URL);
        List<AppInfoModel> appList = resultList.getValue();
        //产品列表
        view.addObject("appList", appList);
        //接入状态
        view.addObject("statusMap", Constant.APPISUSEDMAP);
        //所属公司
        view.addObject("companyMap", Constant.COMPANYMAP);
        view.addObject("appName", appName);
        view.addObject("belongCompany", belongCompany);
        view.addObject("status", status);
        return view;
    }
    @RequestMapping("/showApp")
    public ModelAndView showApp(HttpServletRequest request,HttpServletResponse response){
        ModelAndView view = new ModelAndView();
        String flag = request.getParameter("flag");
        if ("detail".equals(flag)){
            view.setViewName("/basicParam/app/appDetail");
        } else if ("update".equals(flag)){
            view.setViewName("/basicParam/app/updateApp");
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResultBean<AppInfoModel> result = appInfoManager.selectAppInfoById(id);
        if(!ResultListBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(), 
                    result.getStatus().getCode(), BACK_URL);
        AppInfoModel appInfo = result.getValue();
        //产品列表
        view.addObject("appInfo", appInfo);
        //接入状态
        view.addObject("statusMap",Constant.APPISUSEDMAP);
        //所属公司
        view.addObject("companyMap", Constant.COMPANYMAP);
        return view;
    }
    
    @RequestMapping("/addApp")
    public ModelAndView addApp(){
        ModelAndView view = new ModelAndView("/basicParam/app/addApp");
        view.addObject("statusMap",Constant.APPISUSEDMAP);
        //所属公司
        view.addObject("companyMap", Constant.COMPANYMAP);
        return view;
    }
    
    @RequestMapping("/addSubmit")
    public ModelAndView addSubmit(HttpServletRequest request,HttpServletResponse response){
        PMap map = new PMap();
        String appIdStr = request.getParameter("appId");
        String appName = request.getParameter("appName");
        Integer appId = null;
        //验证参数
        try{
            appId = Integer.parseInt(appIdStr);
        } catch(Exception e){
            return setErrorPage(ResultStatus.ADD_APP_PARAM_ERROR.getMessage(),
                    ResultStatus.ADD_APP_PARAM_ERROR.getCode(),BACK_URL);
        }
        //排重
        ResultListBean<AppInfo> appInfoResult =  appInfoManager.selectAppInfo(appName,appId);
        if(!ResultBean.isSuccess(appInfoResult))
            return setErrorPage(appInfoResult.getStatus().getMessage(), 
                    appInfoResult.getStatus().getCode(),BACK_URL);
        if(appInfoResult != null && appInfoResult.getValue() !=null && appInfoResult.getValue().size() > 0)
            return setErrorPage(ResultStatus.ADD_APP_ERROR.getMessage(), 
                    ResultStatus.ADD_APP_ERROR.getCode(),BACK_URL);
        map.put("appId", appId);
        map.put("appName", appName);
        map.put("company", request.getParameter("company"));
        map.put("status", request.getParameter("status"));
        map.put("signKey", request.getParameter("signKey"));
        map.put("wxServiceNo", request.getParameter("wxServiceNo"));
        ResultBean result = appInfoManager.insertAppInfo(map);
        if(!ResultBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(), 
                    result.getStatus().getCode(),BACK_URL);
        toLog(OperationLogType.INSERT, "insertAppInfo", map);
        return toSuccess(BACK_URL);
    }
    
    @RequestMapping("/updateSubmit")
    public ModelAndView updateSubmit(HttpServletRequest request,HttpServletResponse response){
        PMap map = new PMap();
        map.put("id", request.getParameter("id"));
        map.put("appId", request.getParameter("appId"));
        map.put("appName", request.getParameter("appName"));
        map.put("company", request.getParameter("company"));
        map.put("status", request.getParameter("status"));
        map.put("signKey", request.getParameter("signKey"));
        map.put("wxServiceNo", request.getParameter("wxServiceNo"));
        ResultBean result = appInfoManager.updateAppInfo(map);
        if(!ResultBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(), 
                    result.getStatus().getCode(),BACK_URL);
        toLog(OperationLogType.UPDATE, "updateAppInfo", map);
        return toSuccess(BACK_URL);
    }
}
