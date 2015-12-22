<%@page import="java.util.Locale"%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.ResourceBundle" %>
<%
    response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
    response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
    response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
    response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

    Cookie cookie = new Cookie("jpassport-sp","");
    cookie.setMaxAge(0);
    cookie.setPath("/");
    response.addCookie(cookie);
//通知passport同步其它应用退出状态
    String webUrl = ResourceBundle.getBundle("config").getString("projectUrl")+"/login/toLogin.j";
    request.getSession().removeAttribute("UserMenuHtmlCache");
    request.getSession().removeAttribute("GetJsonTypeCache");
    request.getSession().invalidate();
    response.sendRedirect("https://passport.sogou-inc.com/logout.jsp?url="+webUrl);
//#设置session失效.

%>