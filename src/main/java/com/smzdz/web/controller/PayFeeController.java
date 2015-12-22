package com.smzdz.web.controller;

import java.util.Date;

import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.manager.PayFeeManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.enums.OperationLogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smzdz.entity.PayFee;
import com.smzdz.model.PayFeeModel;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/payfee")
public class PayFeeController extends BaseController{

	private static final String DEFAULT_RESPONSE = "redirect:query.j"; // 重定向到列表页面
	
	@Autowired
	private PayFeeManager manaer;
	
	@Autowired
	private AgencyInfoManager agencyManager;
	
	/**
     *手续费查询列表
     * @param code 支付机构编码
     * @return
     */
    @RequestMapping("/query")
	public ModelAndView queryList(String code) {
		ModelAndView modelAndView = new ModelAndView(
				"/payfee/list");
		ResultListBean<PayFeeModel> result = manaer.selectPayFeeList(null, code);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
		modelAndView.addObject("code", code);
		modelAndView.addObject("resultList", result.getValue());
		return modelAndView;
	}
    
    /**
     *详情
     * @param 
     * @return
     */
    @RequestMapping("/details")
	public ModelAndView queryDetails(String id) {
		ModelAndView modelAndView = new ModelAndView(
				"/payfee/detail");
		ResultBean<PayFeeModel> result = manaer.getById(id);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
		modelAndView.addObject("info", result.getValue());
		return modelAndView;
	}
    
    @RequestMapping("/toAdd")
	public ModelAndView toAdd() {
		ModelAndView modelAndView = new ModelAndView(
				"/payfee/toAdd");
		modelAndView.addObject("payFeeTypeMap", Constant.PAY_FEETYPE_MAP);
		modelAndView.addObject("feeTypeMap", Constant.FEE_TYPE_MAP);
		modelAndView.addObject("statusMap", Constant.FEE_STAUTS_MAP);
		modelAndView.addObject("accessPlatformMap", Constant.ACCESSPLAT_MAP);
		modelAndView.addObject("agencyMap", agencyManager.getAllAgencyInfoForMap());
		return modelAndView;
	}
    
    @RequestMapping("/doAdd")
	public ModelAndView doAdd(PayFee payFee) {
		ModelAndView modelAndView = new ModelAndView("common/optSuccess");

		payFee.setCreateTime(new Date());
		payFee.setModifyTime(new Date());
		Result<Boolean> result = manaer.insertPayFee(payFee);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
        toLog(OperationLogType.INSERT, "insertPayFee", payFee);
		return modelAndView;
	}
    
    @RequestMapping("/toEdit")
 	public ModelAndView toEdit(String id) {
 		ModelAndView modelAndView = new ModelAndView("/payfee/edit");
		modelAndView.addObject("payFeeTypeMap", Constant.PAY_FEETYPE_MAP);
		modelAndView.addObject("feeTypeMap", Constant.FEE_TYPE_MAP);
		modelAndView.addObject("statusMap", Constant.FEE_STAUTS_MAP);
		modelAndView.addObject("accessPlatformMap", Constant.ACCESSPLAT_MAP);
		modelAndView.addObject("agencyMap", agencyManager.getAllAgencyInfoForMap());
 		ResultBean<PayFeeModel> result = manaer.getById(id);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
		modelAndView.addObject("info", result.getValue());
		return modelAndView;
 	}
    
	@RequestMapping("/doEdit")
	public ModelAndView doEdit(PayFee payFee) {
		ModelAndView modelAndView = new ModelAndView("common/optSuccess");
		payFee.setModifyTime(new Date());
		Result<Boolean> result = manaer.updatePayFee(payFee);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
        toLog(OperationLogType.UPDATE, "updatePayFee", payFee);
		return modelAndView;
	}
    
}
