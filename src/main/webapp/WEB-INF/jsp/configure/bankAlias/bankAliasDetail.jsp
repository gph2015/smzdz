<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ include file="../../common/taglibs.jsp"%>
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
        <div>当前位置:<span class="pageLocation">运营系统->银行卡别名管理</span></div>
        <div class="pageTitle">银行卡别名详情</div>

        <!-- start银行卡别名详细页 -->
        <div id="productDetail" style="display: block">
            <ul class="productDetailUl pageUl">
                <li><span class="labelName">支付机构编码：</span><span
                        class="value">${bankAliasInfo.agencyCode }</span></li>
                <li>
                    <span class="labelName">银行卡类型：</span>
                    <span class="value">${bankAliasInfo.bankCardTypeStr }</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">银行简称：</span>
                    <span class="value">${bankAliasInfo.bankCode }</span>
                </li>
                <li>
                    <span class="labelName">银行别名：</span>
                    <span class="value">${bankAliasInfo.aliasName }</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">预留字段：</span>
                    <span class="value">${bankAliasInfo.reserved }</span>
                </li>
                <li>
                    <span class="labelName">创建时间：</span>
                    <span class="value">${bankAliasInfo.createTimeStr }</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">修改时间：</span>
                    <span class="value">${bankAliasInfo.modifyTimeStr }</span>
                </li>
                <div class="clear">
                    <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">
                </div>
            </ul>
        </div>
        <!-- end银行卡别名详细页 -->
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