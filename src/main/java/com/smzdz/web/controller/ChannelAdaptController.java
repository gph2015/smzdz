package com.smzdz.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smzdz.enums.OperationLogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smzdz.entity.PayChannelAdapt;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.ChannelAdaptManager;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.model.AppInfoModel;
import com.smzdz.model.ChannelInfoModel;
import com.smzdz.model.PayChannelAdaptModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;

@Controller
@RequestMapping("/adapt")
@SuppressWarnings("all")
public class ChannelAdaptController extends BaseController{
    
    @Autowired
    private ChannelAdaptManager channelAdaptManager;
    
    @Autowired
    private ChannelInfoManager channelInfoManager;
    
    @Autowired
    private AppInfoManager appInfoManager;
    
    private static final String BACK_URL="getAdaptList.j";
    
    @RequestMapping("/getAdaptList")
    public ModelAndView getAdaptList(Pager pager){
        ModelAndView view = new ModelAndView("/basicParam/adapt/adaptList");
        ResultListBean<PayChannelAdaptModel> resultList = channelAdaptManager.getChannelAdaptList(pager);
        List<PayChannelAdaptModel> adaptList = resultList.getValue();
        //产品列表
        PMap paramMap = new PMap();
        paramMap.put("status", 1);
        ResultListBean<AppInfoModel> appResultList = appInfoManager.selectAppInfo(paramMap); 
        if(!ResultListBean.isSuccess(appResultList))
            return setErrorPage(appResultList.getStatus().getMessage(), 
                    appResultList.getStatus().getCode(),BACK_URL);
        List<AppInfoModel> appList =  appResultList.getValue();
        //产品列表
        view.addObject("appList", appList);
        //适配列表
        view.addObject("adaptList", adaptList);
        //接入平台
        view.addObject("accessPlatformMap", Constant.ACCESSPLAT_MAP);
        //渠道方式
        view.addObject("channelTypeMap",Constant.PAY_FEETYPE_MAP);
        //状态
        view.addObject("statusMap",Constant.APPISUSEDMAP);
        //银行卡类型
        view.addObject("bankCardTypeMap", Constant.BANKCARDMAP);
        return view;
    }
    
    @RequestMapping("/toAddAdapt")
    public ModelAndView toAddAdapt(){
        ModelAndView view = new ModelAndView("/basicParam/adapt/addAdapt");
        //渠道列表
        ResultListBean<ChannelInfoModel> channelResultList = channelInfoManager.queryChannelInfoList();
        if(!ResultListBean.isSuccess(channelResultList))
            return setErrorPage(channelResultList.getStatus().getMessage(), 
                    channelResultList.getStatus().getCode(),BACK_URL);
        List<ChannelInfoModel> channelList = channelResultList.getValue();
        //产品列表
        PMap paramMap = new PMap();
        paramMap.put("status", 1);
        ResultListBean<AppInfoModel> appResultList = appInfoManager.selectAppInfo(paramMap); 
        if(!ResultListBean.isSuccess(appResultList))
            setErrorPage(appResultList.getStatus().getMessage(), appResultList.getStatus().getCode());
        List<AppInfoModel> appList =  appResultList.getValue();
        //渠道列表
        view.addObject("channelList", channelList);
        //产品列表
        view.addObject("appList", appList);
        //接入平台
        view.addObject("accessPlatformMap", Constant.ACCESSPLAT_MAP);
        //渠道方式
        view.addObject("channelTypeMap",Constant.PAY_FEETYPE_MAP);
        //银行卡类型
        view.addObject("bankCardTypeMap", Constant.BANKCARDMAP);
        //状态
        view.addObject("statusMap",Constant.APPISUSEDMAP);
        return view;
    }
    
    @RequestMapping("/addSubmit")
    public ModelAndView addSubmit(PayChannelAdaptModel model){
        ModelAndView view = new ModelAndView("redirect:getAdaptList.j");
        System.out.println(model);
        //去重检查
        ResultListBean<PayChannelAdapt> resultList = channelAdaptManager.getAdaptListByCon(model);
        if(resultList != null && resultList.getValue() !=null && resultList.getValue().size() > 0)
            return setErrorPage(ResultStatus.ADD_ADAPT_ERROR.getMessage(), 
                    ResultStatus.ADD_ADAPT_ERROR.getCode(),BACK_URL);
        //添加到数据库
        ResultBean result = channelAdaptManager.insertAdaptInfo(model);
        if(!ResultBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(),
                    result.getStatus().getCode(),BACK_URL);
        toLog(OperationLogType.INSERT, "insertAdaptInfo", model);
        return toSuccess(BACK_URL);
    }
    
    @RequestMapping("/showAdapt")
    public ModelAndView showAdapt(HttpServletRequest request,HttpServletResponse response){
        ModelAndView view = new ModelAndView("/basicParam/adapt/updateAdapt");
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResultBean<PayChannelAdaptModel> result = channelAdaptManager.getChannelAdaptById(id);
        if(!ResultBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(), 
                    result.getStatus().getCode(),BACK_URL);
        PayChannelAdaptModel adaptInfo = result.getValue();
        view.addObject("adaptInfo",adaptInfo);
        //接入状态
        view.addObject("statusMap",Constant.APPISUSEDMAP);
        return view;
    }
    @RequestMapping("/updateSubmit")
    public ModelAndView updateSubmit(PayChannelAdaptModel model){
        ResultBean result = channelAdaptManager.updateAdaptInfo(model);
        if(!ResultBean.isSuccess(result))
            return setErrorPage(result.getStatus().getMessage(), 
                    result.getStatus().getCode(),BACK_URL);
        toLog(OperationLogType.UPDATE, "updateAdaptInfo", model);
        return toSuccess(BACK_URL);
    }
}
