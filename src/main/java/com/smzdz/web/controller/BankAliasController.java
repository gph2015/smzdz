package com.smzdz.web.controller;

import com.smzdz.entity.BankAlias;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.enums.OperationLogType;
import com.smzdz.manager.BankAliasManager;
import com.smzdz.model.BankAliasModel;
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
@RequestMapping("/bankAlias")
public class BankAliasController extends BaseController {

    @Autowired
    private BankAliasManager bankAliasManager;

    @RequestMapping("/query")
    public ModelAndView getBankAliasList(Pager pager) {
        ModelAndView view = new ModelAndView("/configure/bankAlias/bankAliasList");
        ResultListBean<BankAliasModel>
                resultList = bankAliasManager.queryBankAliasList(pager);
        if (!Result.isSuccess(resultList)) {
            return setErrorPage(resultList.getStatus().getMessage(), resultList
                    .getStatus().getCode());
        }
        List<BankAliasModel> bankAliasList = resultList.getValue();
        view.addObject("bankAliasList", bankAliasList);
        return view;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView("/configure/bankAlias/addBankAlias");
        modelAndView.addObject("bankCardTypeMap", Constant.BANKCARDMAP);
        modelAndView.addObject("agencyCodeMap", Constant.AGENCY_TYPE_MAP);
        return modelAndView;
    }

    @RequestMapping("/addBankAlias")
    public ModelAndView addBankAlias(HttpServletRequest request, HttpServletResponse response) {
        PMap map = new PMap();
        map.put("agencyCode", request.getParameter("agencyCode"));
        map.put("bankCardType", request.getParameter("bankCardType"));
        map.put("bankCode", request.getParameter("bankCode"));
        map.put("aliasName", request.getParameter("aliasName"));
        map.put("reserved", request.getParameter("reserved"));
        Result<Boolean> result = bankAliasManager.insertBankAlias(map);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        toLog(OperationLogType.INSERT, "addBankAlias", map);
        return toSuccess();
    }

    @RequestMapping("/showBankAlias")
    public ModelAndView showBankAlias(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String flag = request.getParameter("flag");
        if ("detail".equals(flag)) {
            modelAndView.setViewName("/configure/bankAlias/bankAliasDetail");
        } else if ("update".equals(flag)) {
            modelAndView.setViewName("/configure/bankAlias/updateBankAlias");
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResultBean<BankAliasModel> result = bankAliasManager.queryBankAliasDetailById(id);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        BankAliasModel bankAliasInfo = result.getValue();
        //商户列表
        modelAndView.addObject("bankCardTypeMap", Constant.BANKCARDMAP);
        modelAndView.addObject("agencyCodeMap", Constant.AGENCY_TYPE_MAP);
        modelAndView.addObject("bankAliasInfo", bankAliasInfo);
        return modelAndView;
    }

    @RequestMapping("/updateBankAlias")
    public ModelAndView updateMerchant(BankAlias bankAlias) {
        bankAlias.setModifyTime(new Date());
        Result<Boolean> result = bankAliasManager.updateBankAlias(bankAlias);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        toLog(OperationLogType.UPDATE, "updateMerchant", bankAlias);
        return toSuccess();
    }

    @RequestMapping("/deleteBankAlias")
    public ModelAndView deleteMerchant(HttpServletRequest request, HttpServletResponse response) {
        PMap map = new PMap();
        map.put("id", request.getParameter("id"));
        Result<Boolean> result = bankAliasManager.deleteBankAlias(map);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        toLog(OperationLogType.DELETE, "deleteMerchant", map);
        return toSuccess();
    }

}
