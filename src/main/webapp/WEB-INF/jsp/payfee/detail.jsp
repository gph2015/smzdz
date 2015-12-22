<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/24
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
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

<%@ include file="../common/head.jsp"%>
    <div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->手续费管理</span></div>
        <div class="pageTitle">手续费详情</div>

        <!-- start产品详细页 -->
        <div id="transactionDetail" style="display: block">
            <ul class="productDetailUl pageUl detail">
                <li><span class="labelName">手续费名称：</span><span class="value">${info.name }</span></li>
                <li><span class="labelName">支付机构编码：</span> <span class="value">${info.agencyCode }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">支付类型：</span><span class="value">${info.payFeeTypeStr }</span></li>
                <li><span class="labelName">手续费类型：</span> <span class="value">${info.feeTypeStr }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">固定手续费：</span><span class="value">${info.fee }</span></li>
                <li><span class="labelName">费率：</span> <span class="value">${info.feeRate }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">封顶手续费：</span><span class="value">${info.upperLimit }</span></li>
                <li><span class="labelName">保底手续费：</span> <span class="value">${info.lowerLimit }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">商户号：</span><span class="value">${info.merchantNo }</span></li>
                <li><span class="labelName">接入平台：</span> <span class="value">${info.accessPlatformStr }</span></li>
                <div class="clear"></div>
                <li><span class="labelName">状态：</span> <span class="value">${info.statusStr }</span></li>
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
