package com.smzdz.web.controller;

import com.smzdz.entity.AgencyInfo;
import com.smzdz.util.Constant;
import com.smzdz.enums.OperationLogType;
import com.smzdz.manager.AgencyInfoManager;
import com.smzdz.model.AgencyInfoModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.ConvertUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller 
@RequestMapping("/agency")
public class AgencyInfoController extends BaseController{

	private static final String DEFAULT_RESPONSE = "redirect:query.j"; // 重定向到列表页面

	@Autowired
	private AgencyInfoManager agencyManager;

    /**
     *支付机构基本信息查询
     * @param
     * @return
     */
    @RequestMapping("/query")
	public ModelAndView queryList(String code) {
                ModelAndView modelAndView = new ModelAndView("/agency/agencyList");
		ResultListBean<AgencyInfoModel> result = agencyManager.getAgencyList(code);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
		modelAndView.addObject("code", code);
		modelAndView.addObject("resultList", result.getValue());
		return modelAndView;
	}

    /**
     *支付机构基本信息查询
     * @param
     * @return
     */
    @RequestMapping("/details")
	public ModelAndView queryDetails(String id) {
                ModelAndView modelAndView = new ModelAndView(
				"/agency/agencyDetails");
		ResultBean<AgencyInfoModel> result = agencyManager.getById(ConvertUtil.toInt(id));
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
		modelAndView.addObject("info", result.getValue());
		return modelAndView;
	}

    @RequestMapping("/toAdd")
	public ModelAndView toAdd() {
                ModelAndView modelAndView = new ModelAndView(
				"/agency/toAdd");
		modelAndView.addObject("map", Constant.PAY_FEETYPE_MAP);
		modelAndView.addObject("aliasMap", Constant.ALIAS_MAP);
		modelAndView.addObject("accessMap", Constant.ACCESSPLAT_MAP);
		return modelAndView;
	}

    @RequestMapping("/doAdd")
	public ModelAndView doAdd(AgencyInfo model) {
		model.setCreateTime(new Date());
		model.setModifyTime(new Date());
		Result<Boolean> result = agencyManager.insertAgencyInfo(model);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
        toLog(OperationLogType.INSERT, "doAddAgency", model);
		return toSuccess();
	}

    @RequestMapping("/toEdit")
 	public ModelAndView toEdit(String id) {
                ModelAndView modelAndView = new ModelAndView("/agency/edit");
		modelAndView.addObject("map", Constant.PAY_FEETYPE_MAP);
		modelAndView.addObject("aliasMap", Constant.ALIAS_MAP);
		modelAndView.addObject("accessMap", Constant.ACCESSPLAT_MAP);
 		ResultBean<AgencyInfoModel> result = agencyManager.getById(ConvertUtil.toInt(id));
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
		modelAndView.addObject("info", result.getValue());
		return modelAndView;
 	}

    @RequestMapping("/doEdit")
	public ModelAndView doEdit(AgencyInfo model) {
		model.setModifyTime(new Date());
		Result<Boolean> result = agencyManager.updateAgencyInfo(model);
		if (!Result.isSuccess(result))
			return setErrorPage(result.getStatus().getMessage(), result
					.getStatus().getCode());
        toLog(OperationLogType.UPDATE, "doEditAgency", model);
		return toSuccess();
	}

}
