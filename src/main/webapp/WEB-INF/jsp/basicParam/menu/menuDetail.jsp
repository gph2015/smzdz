<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../static/c/reset.css">
    <link rel="stylesheet" href="../static/c/main.css">
    <link rel="stylesheet" href="../static/3rd/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="../static/3rd/chosen/chosen.css">
    <link rel="stylesheet" href="../static/3rd/jqueryui/jquery-ui.min.css">
</head>
<body>
<%@ include file="../../common/head.jsp" %>
<div id="rightContent">
    <div>当前位置:<span class="pageLocation">运营系统->菜单管理->详情</span></div>
    <div class="pageTitle">菜单详情</div>

    <!-- start菜单详细页 -->
    <div id="productDetail" style="display: block">
        <ul class="productDetailUl pageUl">
            <li><span class="labelName">菜单名称：</span><span class="value">${menu.name }</span></li>
            <li><span class="labelName">url：</span> <span class="value">${menu.url }</span></li>
            <div class="clear"></div>
            <li>
                <span class="labelName">菜单层级：</span>
                <span class="value">${menu.level }</span>
            </li>
            <li>
                <span class="labelName">菜单状态：</span>
                <span class="value">${menu.status }</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">父菜单：</span>
                <span class="value">${menu.parent }</span>
            </li>
            <div class="clear"></div>
            <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">
        </ul>
    </div>
    <!-- end菜单详细页 -->
</div>
</div>
</body>
</html>
<script>
    function onSubmit() {
        $("#queryForm").submit();
    }
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
</script>
<jsp:include page="../../common/foot.jsp"></jsp:include>