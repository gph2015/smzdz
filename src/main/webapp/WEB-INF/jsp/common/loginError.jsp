<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../static/c/reset.css">
    <link rel="stylesheet" href="../static/c/main.css">
    <link rel="stylesheet" href="../static/3rd/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="../static/3rd/chosen/chosen.css">
    <link rel="stylesheet" href="../static/3rd/jqueryui/jquery-ui.min.css">
    <title>错误</title>
</head>
<body>
<div class="errorBox">
    <img src="../static/i/img/search.jpg">

    <div class="errorRelate">
        <h2 class="errorTitle"><span></span>操作失败！</h2>

        <h2 class="errorDetail">无此系统权限！请联系管理员</h2>
        <h2  class="errorBack" onclick="toErrorBack()"></h2>
    </div>

</div>
</body>
<script type="text/javascript">
    function toErrorBack() {
        window.location.href = "loginOut.j";
    }
</script>
</html>