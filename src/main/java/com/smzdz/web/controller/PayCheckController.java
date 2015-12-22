package com.smzdz.web.controller;

import com.smzdz.manager.PayCheckManager;
import com.smzdz.model.PayCheckDiffModel;
import com.smzdz.model.PayCheckFeeDiffModel;
import com.smzdz.model.PayCheckFeeResultModel;
import com.smzdz.model.PayCheckResultModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.PayCheckFeeManager;
import com.smzdz.manager.PayCheckManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.DateUtil;
import com.smzdz.util.utils.Pager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 对账查询
 * Created by qibaichao on 2015/3/13.
 */
@Controller
@RequestMapping("/paycheck")
public class PayCheckController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(PayCheckController.class);

    @Autowired
    private AgencyInfoManager agencyInfoManager;
    @Autowired
    private PayCheckManager payCheckManager;
    @Autowired
    private PayCheckFeeManager payCheckFeeManager;

    private static String DATE_FORMAT = "yyyy-MM-dd";

    private String getYesterday() {

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, -1);
        String yesterday = DateUtil.format(ca.getTime(), DATE_FORMAT);
        return yesterday;
    }

    /**
     * 对账结果查询
     *
     * @param checkDate
     * @param agencyCode
     * @param bizCode
     * @param status
     * @param model
     * @return
     */
    @RequestMapping("/payCheck")
    public String payCheck(String checkDate, String agencyCode, Integer bizCode, Integer status, Model model) {

        if (StringUtils.isEmpty(checkDate)) {
            checkDate = getYesterday();
        }

        model.addAttribute("agencyInfoMap", Constant.AGENCY_TYPE_MAP);
        model.addAttribute("checkDate", checkDate);
        model.addAttribute("agencyCode", agencyCode);
        model.addAttribute("bizCode", bizCode);
        model.addAttribute("status", status);
        ResultListBean<PayCheckResultModel> resultListBean = payCheckManager.selectByDateAndAgency(checkDate, agencyCode, bizCode, status);
        model.addAttribute("resultList", resultListBean.getValue());
        model.addAttribute("checkTypeMap", Constant.CHECK_TYPE_MAP);
        model.addAttribute("checkStatusMap", Constant.CHECK_STATUS_MAP);
        return "/paycheck/payCheck";
    }

    /**
     * 分页对账差异详情查询
     *
     * @param pager
     * @return
     */
    @RequestMapping("/payCheckDiff")
    public String payCheckDiff(Pager pager, Model model, String checkDate, String agencyCode, Integer bizCode, Integer status) {
        model.addAttribute("checkDate", checkDate);
        model.addAttribute("agencyCode", agencyCode);
        model.addAttribute("bizCode", bizCode);
        model.addAttribute("status", status);

        ResultBean<Map> resultBean = payCheckManager.sumDiffCountAndAmt(pager);
        //验证resultBean
        if (!Result.isSuccess(resultBean)) {
            return setErrorPage(resultBean.getStatus().getMessage(), resultBean.getStatus().getCode(), model);
        }
        model.addAttribute("diffMap", resultBean.getValue());
        ResultListBean<PayCheckDiffModel> resultListBean = payCheckManager.selectDiffByPaging(pager);
        model.addAttribute("resultList", resultListBean.getValue());
        model.addAttribute("checkDiffTypeMap", Constant.CHECK_DIFF_TYPE_MAP);
        return "/paycheck/payCheckDiff";
    }

    /**
     * 手续费对账结果
     *
     * @param checkDate
     * @param agencyCode
     * @param bizCode
     * @param status
     * @param model
     * @return
     */
    @RequestMapping("/payCheckFee")
    public String payCheckFee(String checkDate, String agencyCode, Integer bizCode, Integer status, Model model) {

        if (StringUtils.isEmpty(checkDate)) {
            checkDate = getYesterday();
        }
        //去掉财付通，财付通没有手续费对账
        HashMap<String, String> agencyInfoMap = (HashMap<String, String>) Constant.AGENCY_TYPE_MAP.clone();
        agencyInfoMap.remove("TENPAY");
        model.addAttribute("agencyInfoMap", agencyInfoMap);
        model.addAttribute("checkDate", checkDate);
        model.addAttribute("agencyCode", agencyCode);
        model.addAttribute("bizCode", bizCode);
        model.addAttribute("status", status);
        ResultListBean<PayCheckFeeResultModel> resultListBean = payCheckFeeManager.selectByDateAndAgency(checkDate, agencyCode, bizCode, status);
        model.addAttribute("resultList", resultListBean.getValue());
        model.addAttribute("checkTypeMap", Constant.CHECK_TYPE_MAP);
        model.addAttribute("checkStatusMap", Constant.CHECK_STATUS_MAP);
        return "/paycheck/payCheckFee";
    }

    /**
     * 分页查询手续费对账差异详情查询
     *
     * @param pager
     * @param model
     * @return
     */
    @RequestMapping("/payCheckFeeDiff")
    public String payCheckFeeDiff(Pager pager, Model model) {

        ResultBean<Map> resultBean = payCheckFeeManager.sumDiffCountAndAmt(pager);
        model.addAttribute("diffMap", resultBean.getValue());
        ResultListBean<PayCheckFeeDiffModel> resultListBean = payCheckFeeManager.selectDiffByPaging(pager);
        model.addAttribute("resultList", resultListBean.getValue());
        return "/paycheck/payCheckFeeDiff";
    }

    /**
     * 跳转到处理对账差异详情页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/toDiffProcess")
    public String toDiffProcess(Long id, Pager pager, Model model) {

        ResultBean<PayCheckDiffModel> resultBean = payCheckManager.selectDiffById(id);
        model.addAttribute("id", id);
        model.addAttribute("returnUrl", "payCheckDiff.j?" + pager.getFullUrl());
        model.addAttribute("payCheckDiffModel", resultBean.getValue());
        model.addAttribute("checkDiffTypeMap", Constant.CHECK_DIFF_TYPE_MAP);
        return "/paycheck/diffProcess";
    }

    /**
     * 对账差异详情处理
     *
     * @param id
     * @return
     */
    @RequestMapping("/processDiff")
    public String processDiff(Long id, String remark, String returnUrl, Model model,
                              String checkDate, String agencyCode, Integer bizCode) {

        ResultBean<PayCheckDiffModel> resultBean = payCheckManager.processDiff(id, remark);

        if (!Result.isSuccess(resultBean))
            return setErrorPage(resultBean.getStatus().getMessage(), resultBean
                    .getStatus().getCode(), model);
        payCheckManager.processResultStatus(checkDate, agencyCode, bizCode);
        model.addAttribute("backUrl", returnUrl);
        return toSuccess(model);
    }


    /**
     * 跳转到处理手续费对账差异详情页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/toFeeDiffProcess")
    public String toFeeDiffProcess(Long id, Pager pager, Model model) {

        ResultBean<PayCheckFeeDiffModel> resultBean = payCheckFeeManager.selectDiffById(id);
        model.addAttribute("id", id);
        model.addAttribute("returnUrl", "payCheckFeeDiff.j?" + pager.getFullUrl());
        model.addAttribute("payCheckFeeDiffModel", resultBean.getValue());
        return "/paycheck/feeDiffProcess";
    }

    /**
     * 手续费对账差异处理
     *
     * @param id
     * @return
     */
    @RequestMapping("/processFeeDiff")
    public String processFeeDiff(Long id, String remark, String returnUrl, Model model) {

        ResultBean resultBean = payCheckFeeManager.processDiff(id, remark);
        if (!Result.isSuccess(resultBean))
            return setErrorPage(resultBean.getStatus().getMessage(), resultBean
                    .getStatus().getCode(), model);
        model.addAttribute("backUrl", returnUrl);
        return toSuccess(model);
    }

    //操作成功
    protected String toSuccess(Model model) {
        return "common/optSuccess";
    }

}
