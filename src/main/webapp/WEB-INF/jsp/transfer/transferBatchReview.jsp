<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ include file="../common/taglibs.jsp" %>
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
<%--<div id="mainContent">--%>
<div id="rightContent">
    <div>当前位置:<span class="pageLocation">运营系统->代付管理-></span></div>
    <div class="pageTitle">付款单审批</div>

    <!-- start交易详情页 -->
    <form id="updateForm" action="doReview.j" method="post">
    	<input name="batchNo" type="hidden" value="${transferBatch.batchNo}">
        <input name="appId" type="hidden" value="${transferBatch.appId}">
        <input id="tradeState" name="tradeState" type="hidden">
        <div id="transferBatch" style="display: block">
            <ul class="transferBatchUl pageUl detail">
                <li><span class="labelName">接入产品：</span><span
                        class="value">${appMap[transferBatch.appId]}</span></li>

                <li><span class="labelName">批次号：</span> <span
                        class="value">${transferBatch.batchNo}</span></li>
                <li><span class="labelName">公司名称：</span> <span
                        class="value">${transferBatch.companyName}</span></li>
                <li><span class="labelName">转出账号：</span> <span
                        class="value">${transferBatch.dbtAcc}</span></li>
                <div class="clear"></div>
                <li><span class="labelName">计划笔数：</span> <span class="value">${transferBatch.planTotal}</span></li>
                <li><span class="labelName">计划金额：</span> <span class="value"><fmt:formatNumber
                        value="${transferBatch.planAmt}" pattern="#,##0.00000"/></span></li>
                <div class="clear"></div>

                <li><span class="labelName">分行代码：</span> <span class="value">${transferBatch.bbkNbr}</span></li>
                <li><span class="labelName">业务类型：</span> <span class="value">${transferBatch.busCod}</span></li>
                <div class="clear"></div>

                <li><span class="labelName">业务模式编号：</span> <span class="value">${transferBatch.busMod}</span></li>
                <li><span class="labelName">交易代码：</span> <span class="value">${transferBatch.trsTyp}</span></li>
                <div class="clear"></div>
                <li><span class="labelName">生成时间：</span> <span class="value"><fmt:formatDate
                        value="${transferBatch.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">处理意见：</span>
                    <input name="auditDesc" maxlength="30" type="text"/>
                </li>
                <div class="clear"></div>
                <div class="op">
                    <input type="button" class="cancel btn70_2" value="审核通过" onclick="doSubmit(2)">
                    <input type="button" class="cancel btn70_2" value="审核不通过" onclick="doSubmit(3)">
                </div>
            </ul>
        </div>

        <div class="clear"></div>

        <!-- end交易详情页 -->
</form>
</div>
</div>
</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script>
    function doSubmit(tradeState){
    	$("#tradeState").val(tradeState);
        $("#updateForm").submit();
    }
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
</script>
</html>
