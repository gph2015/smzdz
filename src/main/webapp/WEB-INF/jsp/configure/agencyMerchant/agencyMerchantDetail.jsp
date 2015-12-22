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
    <div>当前位置:<span class="pageLocation">运营系统->支付机构商户管理</span></div>
    <div class="pageTitle">支付机构商户详情</div>

    <!-- start商户详细页 -->
    <div id="transactionDetail" style="display: block">
        <ul class="productDetailUl pageUl detail detail">
            <li><span class="labelName">支付机构编码：</span><span
                    class="value">${merchantInfo.agencyCode }</span></li>
            <li><span class="labelName">支付机构商户ID：</span> <span
                    class="value">${merchantInfo.merchantNo }</span></li>
            <div class="clear"></div>
            <li>
                <span class="labelName">签约公司名称：</span>
                <span class="value">${merchantInfo.companyName }</span>
            </li>
            <li>
                <span class="labelName">产品名称：</span>
                <span class="value">${merchantInfo.appName}</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">商户邮箱（公众号）：</span>
                <span class="value">${merchantInfo.sellerEmail }</span>
            </li>
            <li>
                <span class="labelName">加密方式：</span>
                <span class="value">${merchantInfo.encryptionTypeStr }</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">密钥：</span>
                <span class="value">${merchantInfo.encryptKey }</span>
            </li>
            <li>
                <span class="labelName">公钥路径：</span>
                <span class="value">${merchantInfo.pubKeypath }</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">私钥路径：</span>
                <span class="value">${merchantInfo.privateKeypath }</span>
            </li>
            <li>
                <span class="labelName">页面回调地址：</span>
                <span class="value">${merchantInfo.pageBackUrl }</span>
            </li>
            <div class="clear"></div>
            <li>
                <span class="labelName">点对点回调地址：</span>
                <span class="value">${merchantInfo.notifyBackUrl }</span>
            </li>
            <li>
                <span class="labelName">接入状态：</span>
                <c:forEach items="${isUsedMap}" var="entry">
                    <input type="radio" disabled <c:if
                            test="${entry.key ==merchantInfo.isUsed }"> checked</c:if>>${entry.value}</input>
                </c:forEach>

            </li>
            <div class="clear"></div>
            <span class="labelName">商户接入时间：</span>
            <span class="value">${merchantInfo.createTimeStr }</span>
            </li>
            <li>
                <span class="labelName">修改时间：</span>
                <span class="value">${merchantInfo.modifyTimeStr }</span>
            </li>
            <div class="clear">
                <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">
            </div>
        </ul>
    </div>
    <!-- end商户详细页 -->
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