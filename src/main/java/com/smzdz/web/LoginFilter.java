package com.smzdz.web;

import com.smzdz.entity.User;
import com.smzdz.web.controller.BaseController;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 登录过滤器
 *
 * @author wujingpan
 */
public class LoginFilter extends BaseController implements Filter {
    protected static final String LOGIN_OUT_URL = "/login/loginOut.j";

    public LoginFilter() {
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 获得请求的URL
        String url = req.getRequestURL().toString();
        // 获得session中的对象
        User user = null;
        HttpSession session = req.getSession();
        if (null != session)
            user = (User) session.getAttribute("user");
        // url特殊处理：放行url
        if (url.endsWith("toLogin.j") || url.endsWith("loginOut.j") || null != user) {
            // 满足条件就继续执行
            chain.doFilter(req, res);
        } else {
            // 不满足条件就跳转到其他页面
            res.sendRedirect(ResourceBundle.getBundle("config").getString("projectUrl") + LOGIN_OUT_URL);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
