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
    <div>当前位置:<span class="pageLocation">运营系统->支付渠道管理</span></div>
    <div class="pageTitle">支付渠道详情</div>

    <!-- start支付渠道详细页 -->
    <div id="updateChannleInfo" style="display: block">
        <ul class="updateChannleInfoUl pageUl detail detail">
            <li>
                <span class="labelName">渠道logo：</span>
                <img class="labelNames" src="${channelInfo.logo}"/>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">渠道编码：</span>
                <span class="value">${channelInfo.channelCode }</span>
            </li>
            <li>
                <span class="labelName">渠道性质：</span>
                <span class="value">${channelInfo.channelNatureStr }</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">渠道名称：</span>
                <span class="value">${channelInfo.channelName }</span>

            </li>
            <li>
                <span class="labelName">最低限额：</span>
                <span class="value">${channelInfo.lowLimit }</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">最高限额：</span>
                <span class="value">${channelInfo.highLimit }</span>
            </li>
            <li>
                <span class="labelName">页面显示信息：</span>
                <span class="value">${channelInfo.limitInfo }</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">渠道类型：</span>
                <span class="value">${channelInfo.channelTypeStr }</span>
            </li>
            <div class="clear">
                <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">
            </div>
        </ul>
    </div>
    <!-- end支付渠道详细页 -->
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