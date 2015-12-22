package com.smzdz.web.controller;

import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.enums.OperationLogType;
import com.smzdz.manager.AuthManager;
import com.smzdz.model.AuthMenuModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/25 14:34
 */
@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {
    @Autowired
    private AuthManager authManager;
    private static final String BACK_URL = "authList.j";

    @RequestMapping("/authList")
    public ModelAndView getUserList(HttpServletRequest request, String name, String mail) {
        ModelAndView modelAndView = new ModelAndView("/basicParam/auth/authList");
        return modelAndView;
    }


    @RequestMapping("/queryAuth")
    public ModelAndView getAuthMenuList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("/basicParam/auth/authMenuList");
        ResultListBean<AuthMenuModel> resultList = authManager.queryAuthMenu(Integer.valueOf(request.getParameter("id")));
        if (!Result.isSuccess(resultList))
            return setErrorPage(resultList.getStatus().getMessage(), resultList
                    .getStatus().getCode());
        List authList = resultList.getValue();
        modelAndView.addObject("authList", authList);
        modelAndView.addObject("userId", request.getParameter("id"));
        return modelAndView;
    }

    @RequestMapping("/updateAuthForm")
    public ModelAndView updateSubmit(HttpServletRequest request, HttpServletResponse response) {
        Map params = getRequestParameterMap(request);
        String userId = request.getParameter("userId");
        ResultBean result = authManager.updateAuthList(params, userId);
        if (!Result.isSuccess(result))
            if (!Result.isSuccess(result))
                return setErrorPage(result.getStatus().getMessage(),
                        result.getStatus().getCode(), BACK_URL);
        toLog(OperationLogType.UPDATE, "updateRouterList", params);
        return toSuccess("/user/query.j");
    }
}
