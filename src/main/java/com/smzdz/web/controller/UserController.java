package com.smzdz.web.controller;

import com.smzdz.manager.AppInfoManager;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.entity.User;
import com.smzdz.enums.OperationLogType;
import com.smzdz.manager.AppInfoManager;
import com.smzdz.manager.UserManager;
import com.smzdz.model.AppInfoModel;
import com.smzdz.model.UserModel;
import com.smzdz.util.Constant;
import com.smzdz.util.cache.RedisUtils;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/25 14:34
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final String DEFAULT_RESPONSE = "redirect:userList.j"; // 重定向到列表页面

    @Autowired
    private UserManager userManager;
    @Autowired
    private AppInfoManager appInfoManager;

    @RequestMapping("/query")
    public ModelAndView getUserList(HttpServletRequest request,String name, String mail) {
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView("/basicParam/user/userList");
        ResultListBean<UserModel> resultList = userManager.queryAllUser(name, mail);
        if (!Result.isSuccess(resultList))
            return setErrorPage(resultList.getStatus().getMessage(), resultList
                .getStatus().getCode());
        //产品列表
        PMap paramMap = new PMap();
        paramMap.put("status", 1);
        ResultListBean<AppInfoModel> appResultList = appInfoManager.selectAppInfo(paramMap);
        if(!ResultListBean.isSuccess(appResultList))
            return setErrorPage(appResultList.getStatus().getMessage(),
                    appResultList.getStatus().getCode(),DEFAULT_RESPONSE);
        List<AppInfoModel> appList =  appResultList.getValue();
        //产品列表
        modelAndView.addObject("appList", appList);
        List<UserModel> userList = resultList.getValue();
        modelAndView.addObject("name", name);
        modelAndView.addObject("mail", mail);
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView("/basicParam/user/addUser");
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap();
        modelAndView.addObject("appMap", appMapBean.getValue());
        modelAndView.addObject("typeMap", Constant.USER_TYPE_MAP);
        return modelAndView;
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
        PMap map = new PMap();
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String appId = request.getParameter("appId");
        String type = request.getParameter("type");
        User user = new User();
        user.setName(name);
        user.setMail(mail);
        int appIdInt = Integer.valueOf(appId).intValue();
        user.setAppId(appIdInt);
        user.setCreateTime(new Date());
        user.setType(Integer.parseInt(type));
        Result<Boolean> result = userManager.addUser(user);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                .getStatus().getCode());
        }
        toLog(OperationLogType.INSERT, "addUser", user);
        return toSuccess();
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) {
        String flag = request.getParameter("flag");
        User newUser = new User();
        if ("unusing".equals(flag)) {
            newUser.setMail(request.getParameter("mail"));
            newUser.setModifyTime(new Date());
            newUser.setStatus(2);
        } else if ("using".equals(flag)) {
            newUser.setMail(request.getParameter("mail"));
            newUser.setModifyTime(new Date());
            newUser.setStatus(1);
        }
        Result<Boolean> result =  userManager.updateUserInfo(newUser);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                .getStatus().getCode());
        }
        toLog(OperationLogType.UPDATE, "updateUser", newUser);
        return toSuccess();
    }

    @RequestMapping("/deleteUserInfo")
    public ModelAndView deleteUserInfo(HttpServletRequest request, HttpServletResponse response) {
        String maillId = request.getParameter("mail");
        Result<Boolean> result = userManager.deleteUserInfo(request.getParameter("mail"));
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                .getStatus().getCode());
        }
        toLog(OperationLogType.DELETE, "deleteUserInfo", request.getParameter("mail"));
        return toSuccess();
    }
}
