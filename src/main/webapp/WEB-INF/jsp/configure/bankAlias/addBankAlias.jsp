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
    <div>当前位置:<span class="pageLocation">运营系统->银行卡别名管理</span></div>
    <div class="pageTitle">添加银行卡别名</div>
    <!-- start添加新银行卡别名页 -->
    <form id="addBankAliasForm" action="addBankAlias.j" method="post">
        <div id="addNewAgencyMerchant" style="display: block">
            <ul class="addNewAgencyMerchantUl pageUl">
                <li>
                    <span class="labelName">支付机构：</span>
                    <select name="agencyCode" data-placeholder="请选择..."
                            class="chosen_select150">
                        <c:forEach items="${agencyCodeMap}" var="entry">
                            <option value="${entry.key}">${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <li>
                    <span class="labelName">银行卡类型：</span>
                    <select name="bankCardType" data-placeholder="请选择..."
                            class="chosen_select150">
                        <c:forEach items="${bankCardTypeMap}" var="entry">
                            <option value="${entry.key}">${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">银行编码：</span>
                    <input type="text" name="bankCode" value="" class="userText" maxlength="20"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <li>
                    <span class="labelName">银行别名：</span>
                    <input type="text" name="aliasName" value="" class="userText" maxlength="10"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
            </ul>
            <div class="clear"></div>
            <div class="op">
                <input type="button" class="save btn70_1" value="提交" onclick="check()">
                <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
            </div>
        </div>
    </form>
    <!-- end添加新银行卡别名页 -->
</div>
</div>
</body>
<jsp:include page="../../common/foot.jsp"></jsp:include>
<script>
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
    function check() {
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#addBankAliasForm").find(".userText").each(function () {
            if ($(this).val() == "") {
                $(this).siblings(".point").css("display", "inline-block");
                emptyArr.push($(this));
            }
            else {
                $(this).siblings(".point").css("display", "none");
            }
        });
        flag = !emptyArr.length ? 1 : 0;
        if (flag) {
            //alert("提交成功");
            $("#addBankAliasForm").submit();
        } else {
            //alert('False');
        }

    }
</script>
</html>
