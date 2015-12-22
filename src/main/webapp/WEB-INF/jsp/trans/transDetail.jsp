<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/23
  Time: 17:44
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
    <link rel="stylesheet" type="text/css" href="../static/c/main.css">
    <link rel="stylesheet" type="text/css" href="../static/3rd/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="../static/3rd/chosen/chosen.css">
    <link rel="stylesheet" type="text/css" href="../static/3rd/jqueryui/jquery-ui.min.css">
</head>
<body>

<%@ include file="../common/head.jsp"%>


<%--<div id="mainContent">--%>
    <div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->交易管理-></span></div>
        <div class="pageTitle">交易详情</div>

        <!-- start交易详情页 -->
        <div id="transactionDetail" style="display: block">
            <ul class="transactionDetailUl pageUl detail" >
                <li><span class="labelName">支付单状态：</span><span class="value">${statusMap[transQueryModel.payOrderStatus]}</span></li>
                <li><span class="labelName">产品线：</span><span class="value">${appMap[transQueryModel.appId]}</span></li>

                <div class="clear"></div>

                <li><span class="labelName">接入平台：</span> <span class="value">${accessplatMap[transQueryModel.accessPlatForm]}</span></li>
                <li><span class="labelName">支付单生成时间：</span> <span class="value"><fmt:formatDate  value="${transQueryModel.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>

                <div class="clear"></div>

                <li><span class="labelName">支付单号：</span> <span class="value">${transQueryModel.payId}</span></li>
                <li><span class="labelName">支付金额：</span> <span class="value"><fmt:formatNumber value="${transQueryModel.orderMoney}" pattern="#,##0.00#"/></span></li>

                <div class="clear"></div>

                <li><span class="labelName">已退款金额：</span> <span class="value"><fmt:formatNumber value="${transQueryModel.refundMoney}" pattern="#,##0.00#"/></span></li>
                <li><span class="labelName">支付单完成时间：</span> <span class="value"><fmt:formatDate  value="${transQueryModel.paySuccessTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>

                <div class="clear"></div>

                <li><span class="labelName">支付流水号：</span> <span class="value">${transQueryModel.payDetailId}</span></li>
                <li><span class="labelName">支付渠道流水号：</span> <span class="value">${transQueryModel.bankOrderId}</span></li>

                <div class="clear"></div>

                <li><span class="labelName">支付机构流水号：</span> <span class="value">${transQueryModel.agencyOrderId}</span></li>
                <li><span class="labelName">支付机构：</span> <span class="value">${agencyMap[transQueryModel.agencyCode]}</span></li>

                <div class="clear"></div>

                <li><span class="labelName">付款方式：</span> <span class="value">${payFeeTypeMap[transQueryModel.payFeeType]}</span></li>
                <li><span class="labelName">支付渠道：</span> <span class="value">${channelMap[transQueryModel.bankCode]}</span></li>

                <div class="clear"></div>

                <li><span class="labelName">业务订单号：</span> <span class="value">${transQueryModel.orderId}</span></li>
                <li><span class="labelName">渠道手续费：</span> <span class="value"><fmt:formatNumber value="${transQueryModel.payFee}" pattern="#,##0.00000"/></span></li>

                <div class="clear"></div>

                <li><span class="labelName">业务平台收入：</span> <span class="value"><fmt:formatNumber value="${transQueryModel.income}" pattern="#,##0.00"/></span></li>
                <li><span class="labelName">商品信息：</span> <span class="value">${transQueryModel.productInfo}</span></li>
            </ul>
        </div>

        <div class="clear"></div>

        <!-- end交易详情页 -->
        <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">
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
