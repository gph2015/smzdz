package com.smzdz.web.controller;

import com.smzdz.manager.*;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.DateUtil;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.TransferBatch;
import com.smzdz.entity.User;
import com.smzdz.enums.OperationLogType;
import com.smzdz.model.AppReportModel;
import com.smzdz.model.TransQueryModel;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
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
@RequestMapping("/login")
public class LoginController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserManager userManager;
    @Autowired
    private TransManager transManager;

    @Autowired
    private AppInfoManager appInfoManager;
    @Autowired
    private AppReportManager appReportManager;
    @Autowired
    private AgencyInfoManager agencyInfoManager;
    @Autowired
    private ChannelInfoManager channelInfoManager;
    @Autowired
    private TransferBatchManager batchManager;

    /**
     * 登录入口
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(HttpServletRequest request, Pager pager) {
        //1.获取登录用户邮箱.
//        String mail = RequestUtil.fetchUserId(request);
        String mail = "gaopenghui@sogou-inc.com";
        logger.info("mail =" + mail);
        if (mail == null) {
            logger.error("mail == null");
            ModelAndView errmodelAndView = new ModelAndView("common/loginError");
            return errmodelAndView;
        }
        //2.查询用户详细信息
        ResultBasicBean<User> userResultBasicBean = userManager.queryUserInfoByMail(mail);
        //3.记录系统关键日志
        logger.info("userResultBasicBean =" + userResultBasicBean.toString());
        if (!Result.isSuccess(userResultBasicBean)) {
            logger.error("!Result.isSuccess(userResultBasicBean)");
            ModelAndView errmodelAndView = new ModelAndView("common/loginError");
            return errmodelAndView;
        }
        User loginUser = userResultBasicBean.getValue();
        if (loginUser == null) {
            logger.error("loginUser == null");
            ModelAndView errmodelAndView = new ModelAndView("common/loginError");
            return errmodelAndView;
        }
        //4.设置系统通用session和超时时间
        HttpSession session = request.getSession();
        session.setAttribute(CURRENT_USER, loginUser);
        session.setMaxInactiveInterval(30 * 60);
        toLog(OperationLogType.LOGIN, "login-User", mail);
        //5.根据用户角色权限不同跳转不同页面
        ModelAndView modelAndView;
        pager.getF().put("appId", loginUser.getAppId().toString());
        if (loginUser.getType() == 3) {
          modelAndView = getModelAndViewByTransfer(pager);

        } else {
          modelAndView = getModelAndViewByTrans(pager);
        }
        return modelAndView;
    }

    /**
     * 登出系统
     */
    @RequestMapping("/loginOut")
    public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("common/loginOut");
        return modelAndView;
    }

    /**
     * 用户权限为支付中心则跳转交易列表页
     */
    public ModelAndView getModelAndViewByTrans(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/trans/transList");

        User user = getCurrentUser();

        if (user != null && user.getAppId() != 1000) {
            pager.getF().put("appId", "" + user.getAppId());
        }
        modelAndView.addObject("user", user);

        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("status"))) {
            pager.getF().put("status", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("accessPlatform"))) {
            pager.getF().put("accessPlatform", "0");
        }
        String startDate = pager.getF().get("startDate");
        if (StringUtils.isEmpty(startDate)) {
            pager.getF().put("startDate", DateUtil.formatDate(DateUtil.get7DayAgoDate()));
        }
        String endDate = pager.getF().get("endDate");
        if (StringUtils.isEmpty(endDate)) {
            pager.getF().put("endDate", DateUtil.formatDate(new Date()));
        }


        //产品查询
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());
        //支付状态map
        modelAndView.addObject("statusMap", Constant.PAYORDER_STATUS_MAP);
        //接入平台map
        HashMap<Integer, String> accessplatMap = (HashMap<Integer, String>) Constant.ACCESSPLAT_MAP.clone();
        accessplatMap.remove(99);
        modelAndView.addObject("accessplatMap", accessplatMap);
        //支付渠道map
        Map channelMap = channelInfoManager.queryChannelInfoForMap();
        modelAndView.addObject("channelMap", channelMap);
        ResultListBean<TransQueryModel> resultListBean = transManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }

    /**
     * 用户权限为业务线则跳转财务报表页面
     */
    public ModelAndView getModelAndViewByApp(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/appReport/appReport");

        User user = getCurrentUser();
//        User user = new User();
//        user.setAppId(1000);
        if (user != null && user.getAppId() != 1000) {
            pager.getF().put("appId", String.valueOf(user.getAppId()));
        }
        modelAndView.addObject("user", user);

        String startDate = pager.getF().get("startDate");
        String endDate = pager.getF().get("endDate");

        if (StringUtils.isEmpty(startDate)) {
            pager.getF().put("startDate", DateUtil.formatDate(DateUtil.get7DayAgoDate()));
        }
        if (StringUtils.isEmpty(endDate)) {
            pager.getF().put("endDate", DateUtil.formatDate(new Date()));
        }
        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("accessPlatform"))) {
            pager.getF().put("accessPlatform", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("payType"))) {
            pager.getF().put("payType", "0");
        }

        Map<String, String> agencyMap = agencyInfoManager.getAllAgencyInfoForMap();
        modelAndView.addObject("agencyMap", agencyMap);
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());

        HashMap<Integer, String> accessplatMap = (HashMap<Integer, String>) Constant.ACCESSPLAT_MAP.clone();
        accessplatMap.remove(99);
        modelAndView.addObject("accessplatMap", accessplatMap);
        HashMap<Integer, String> payTypeMap = (HashMap<Integer, String>) Constant.PAY_FEETYPE_MAP.clone();
        payTypeMap.remove(99);
        modelAndView.addObject("payTypeMap", payTypeMap);

        HashMap<Integer, String> refundStatusMap = (HashMap<Integer, String>) Constant.PAYORDER_REFUND_STATUS_MAP;
        modelAndView.addObject("refundStatusMap", refundStatusMap);

        Map channelMap = channelInfoManager.queryChannelInfoForMap();
        modelAndView.addObject("channelMap", channelMap);
        //汇总查询
        ResultBean<AppReportSumModel> sumBean = appReportManager.selectSum(pager);
        modelAndView.addObject("appSum", sumBean.getValue());

        //分页查询
        ResultListBean<AppReportModel> resultListBean = appReportManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }

    /**
     * 用户权限为代付则跳代付管理页面
     */
    public ModelAndView getModelAndViewByTransfer(Pager pager) {
        ModelAndView modelAndView = new ModelAndView("/transfer/transferBatchList");
        User user = getCurrentUser();
        if (user != null && user.getAppId() != 1000) {
            pager.getF().put("appId", "" + user.getAppId());
        }
        modelAndView.addObject("user", user);
        if (StringUtils.isEmpty(pager.getF().get("appId"))) {
            pager.getF().put("appId", "0");
        }
        if (StringUtils.isEmpty(pager.getF().get("tradeState"))) {
            pager.getF().put("tradeState", "0");
        }
        //产品查询
        ResultBean<Map> appMapBean = appInfoManager.selectAppInfoForMap(1);
        //用户查询
        ResultBean<Map> userMapBean = userManager.selectUserInfoForMap(1);
        modelAndView.addObject("appMap", appMapBean.getValue());
        modelAndView.addObject("userMap", userMapBean.getValue());
        //代付状态
        modelAndView.addObject("tradeMap", Constant.TRADE_STATUS_MAP);
        ResultListBean<TransferBatch> resultListBean = batchManager.selectByPaging(pager);
        modelAndView.addObject("resultList", resultListBean.getValue());
        return modelAndView;
    }

    /**
     * 系统出错跳出页
     */
    @RequestMapping("/loginErrorOut")
    public ModelAndView loginErrorOut(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("common/loginErrorOut");
        return modelAndView;
    }

}
