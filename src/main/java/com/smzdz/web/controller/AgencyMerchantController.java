package com.smzdz.web.controller;

import com.smzdz.entity.AgencyMerchant;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.enums.OperationLogType;
import com.smzdz.manager.AgencyMerchantManager;
import com.smzdz.model.AgencyMerchantModel;
import com.smzdz.model.AppInfoModel;
import com.smzdz.util.result.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/25 11:52
 */
@Controller
@RequestMapping("/merchant")
public class AgencyMerchantController extends BaseController {
    private static final String BACK_URL = "routerList.j";
    @Autowired
    private AppInfoManager appInfoManager;
    @Autowired
    private AgencyMerchantManager agencyMerchantManager;

    @RequestMapping("/query")
    public ModelAndView getMerchantList(String agencyCode) {
        ModelAndView modelAndView = new ModelAndView("/configure/agencyMerchant/agencyMerchantList");
        ResultListBean<AgencyMerchantModel>
                resultList = agencyMerchantManager.queryAgencyMerchantList(agencyCode);
        if (!Result.isSuccess(resultList)) {
            return setErrorPage(resultList.getStatus().getMessage(), resultList
                    .getStatus().getCode());
        }
        List<AgencyMerchantModel> agencyMerchantList = resultList.getValue();
        modelAndView.addObject("agencyCode", agencyCode);
        modelAndView.addObject("agencyMerchantList", agencyMerchantList);
        modelAndView.addObject("agencyCode", agencyCode);
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView(
                "/configure/agencyMerchant/addAgencyMerchant");
        //产品列表
        PMap paramMap = new PMap();
        paramMap.put("status", 1);
        ResultListBean<AppInfoModel> appResult = appInfoManager.selectAppInfo(paramMap);
        if (!ResultListBean.isSuccess(appResult))
            return setErrorPage(appResult.getStatus().getMessage(), appResult
                    .getStatus().getCode());
        List<AppInfoModel> appList = appResult.getValue();
        modelAndView.addObject("appList", appList);
        modelAndView.addObject("isUserdMap", Constant.ISUSEDMAP);
        //所属公司
        modelAndView.addObject("companyMap", Constant.COMPANYMAP);
        modelAndView.addObject("encryptionTypeMap", Constant.ENCRYPTIONMAP);
        return modelAndView;
    }

    @RequestMapping("/addMerchant")
    public ModelAndView addAgencyMerchant(HttpServletRequest request,
                                          HttpServletResponse response) {
        PMap map = new PMap();
        map.put("agencyCode", request.getParameter("agencyCode"));
        map.put("companyCode", request.getParameter("companyCode"));
        map.put("merchantNo", request.getParameter("merchantNo"));
        map.put("sellerEmail", request.getParameter("sellerEmail"));
        map.put("encryptionType", request.getParameter("encryptionType"));
        map.put("encryptKey", request.getParameter("encryptKey"));
        map.put("pubKeypath", request.getParameter("pubKeypath"));
        map.put("privateKeypath", request.getParameter("privateKeypath"));
        map.put("pageBackUrl", request.getParameter("pageBackUrl"));
        map.put("notifyBackUrl", request.getParameter("notifyBackUrl"));
        map.put("isUsed", request.getParameter("isUsed"));
        if (null != request.getParameter("appId")) {
            map.put("appId", request.getParameter("appId"));
        }

        Result<Boolean> result = agencyMerchantManager.insertAgencyMerchant(map);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        toLog(OperationLogType.INSERT, "addAgencyMerchant", map);
        return toSuccess();
    }

    @RequestMapping("/showMerchant")
    public ModelAndView showMerchant(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String flag = request.getParameter("flag");
        if ("detail".equals(flag)) {
            modelAndView.setViewName("/configure/agencyMerchant/agencyMerchantDetail");
        } else if ("update".equals(flag)) {
            modelAndView.setViewName("/configure/agencyMerchant/updateAgencyMerchant");
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResultBean<AgencyMerchantModel>
                result = agencyMerchantManager.queryAgencyMerchantDetailById(id);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        AgencyMerchantModel merchantInfo = result.getValue();
        //商户列表
        modelAndView.addObject("merchantInfo", merchantInfo);
        modelAndView.addObject("isUsedMap", Constant.ISUSEDMAP);
        //所属公司
        modelAndView.addObject("companyMap", Constant.COMPANYMAP);
        modelAndView.addObject("encryptionTypeMap", Constant.ENCRYPTIONMAP);
        return modelAndView;
    }

    @RequestMapping("/updateMerchant")
    public ModelAndView updateMerchant(AgencyMerchant agencyMerchant) {
        agencyMerchant.setModifyTime(new Date());
        Result<Boolean> result = agencyMerchantManager.updateAgencyMerchant(agencyMerchant);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        toLog(OperationLogType.UPDATE, "updateMerchant", agencyMerchant);
        return toSuccess();
    }

    @RequestMapping("/deleteMerchant")
    public ModelAndView deleteMerchant(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("common/optSuccess");
        PMap map = new PMap();
        map.put("id", request.getParameter("id"));
        Result<Boolean> result = agencyMerchantManager.deleteMerchant(map);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        String agencyCode = request.getParameter("agencyCode");
        ResultListBean<AgencyMerchantModel>
                resultList = agencyMerchantManager.queryAgencyMerchantList(agencyCode);
        List<AgencyMerchantModel> agencyMerchantList = resultList.getValue();
        modelAndView.addObject("agencyCode", agencyCode);
        modelAndView.addObject("agencyMerchantList", agencyMerchantList);
        toLog(OperationLogType.DELETE, "deleteMerchant", map);
        return toSuccess();
    }
}
