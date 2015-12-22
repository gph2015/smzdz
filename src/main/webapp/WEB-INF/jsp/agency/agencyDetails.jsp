<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ include file="../common/taglibs.jsp"%>
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
<%@ include file="../common/head.jsp" %>
<div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->支付机构管理->详情</span></div>
        <div class="pageTitle">支付机构详情</div>

        <!-- start产品详细页 -->
        <div id="transactionDetail" style="display: block">
            <ul class="productDetailUl pageUl detail">
                <li><span class="labelName">名称：</span><span class="value">${info.agencyName }</span></li>
                <li><span class="labelName">编码：</span> <span class="value">${info.agencyCode }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">支付机构类型：</span><span class="value">${info.agencyTypeStr }</span></li>
                <li><span class="labelName">接入平台：</span> <span class="value">${info.accessPlatformSrt }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">是否存在银行别名：</span><span class="value">${info.aliasStr }</span></li>
                <li><span class="labelName">支付URL：</span> <span class="value">${info.payUrl }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">退款URL：</span><span class="value">${info.refundUrl }</span></li>
                <li><span class="labelName">退款查询URL：</span><span class="value">${info.queryRefundUrl }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">订单查询URL：</span> <span class="value">${info.queryUrl }</span></li>
                <li><span class="labelName">手机预支付URL：</span><span class="value">${info.prepayUrl }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">手机验证码URL：</span> <span class="value">${info.sendPhoneUrl }</span></li>
                <div class="clear"></div>
                
                    <div class="op">
                        <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">
                    </div>
                
            </ul>
        </div>
        <!-- end产品详细页 -->

    </div>
</div>
</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script>
	function cancel(){
		window.location.href="javascript:history.go(-1)";
	}
</script>
</html>
