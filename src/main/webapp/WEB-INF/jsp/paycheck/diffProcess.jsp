<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/31
  Time: 16:54
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

<jsp:include page="../common/head.jsp"></jsp:include>


<%--<div id="mainContent">--%>
    <%--<div id="leftBar">--%>
        <%--<ul id="navTree" class="ztree"></ul>--%>
    <%--</div>--%>
    <div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->对账管理-></span></div>
        <div class="pageTitle">差异处理</div>

        <!-- start交易详情页 -->
        <div id="transactionDetail" style="display: block">
            <form action="processDiff.j" method="post" id ="queryForm">
                <input type="hidden" name="id" value="${id}"/>
                <input type="hidden" name="checkDate" value="${pager.f.checkDate}"/>
                <input type="hidden" name="agencyCode" value="${pager.f.agencyCode}"/>
                <input type="hidden" name="bizCode" value="${pager.f.bizCode}"/>

                <input type="hidden" name="returnUrl" value="${returnUrl}"/>
            <ul class="transactionDetailUl pageUl">
                <li><span class="labelName">平台流水号：</span><span class="value">${payCheckDiffModel.instructId}</span></li>
                <li><span class="labelName">机构流水号：</span><span class="value">${payCheckDiffModel.outOrderId}</span></li>

                <div class="clear"></div>

                <li><span class="labelName">平台金额：</span> <span class="value"><fmt:formatNumber value="${payCheckDiffModel.bizAmt}" pattern="#,##0.00#"/></span></li>
                <li><span class="labelName">机构金额：</span> <span class="value"><fmt:formatNumber value="${payCheckDiffModel.outBizAmt}" pattern="#,##0.00#"/></span></li>

                <div class="clear"></div>

                <li><span class="labelName">交易时间：</span> <span class="value"><fmt:formatDate  value="${payCheckDiffModel.outTransTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>
                <li><span class="labelName">差异类型：</span> <span class="value">${checkDiffTypeMap[payCheckDiffModel.diffType]}</span></li>

                <div class="clear"></div>

                <li><span class="labelName">备注：</span>
                    <input type="textArea" name = "remark"  class="userText"/>
                </li>
            </ul>
        </div>

        <div class="clear"></div>

        <!-- end交易详情页 -->
        <input type="button" class="cancel btn70_2" value="确认" onclick="doSubmit()">
        <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">
    </div>
</div>
</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script>

    function doSubmit(){
        $("#queryForm").submit();
    }
    function cancel(){
        window.location.href="javascript:history.go(-1)";
    }
</script>
</html>
