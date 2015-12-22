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
    <div class="pageTitle">修改银行卡别名</div>
    <!-- start修改新银行卡别名页 -->
    <div id="addNewAgencyMerchant" style="display: block">
        <form id="updateBankAliasForm" action="updateBankAlias.j" method="post">
            <input type="hidden" name="aliasId" value="${bankAliasInfo.aliasId }"/>
            <ul class="addNewAgencyMerchantUl pageUl">
                <li>
                    <span class="labelName">支付机构编码：</span>
                    <span class="value">${bankAliasInfo.agencyCode }</span>
                </li>
                <li>
                    <span class="labelName">银行卡类型：</span>
                    <select name="bankCardType" data-placeholder="请选择..."
                            class="chosen_select150">
                        <c:forEach items="${bankCardTypeMap}" var="entry">
                            <option value="${entry.key}" <c:if
                                    test="${entry.key == bankAliasInfo.bankCardType }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <li>
                    <span class="labelName">银行简称：</span>
                    <span class="value">${bankAliasInfo.bankCode }</span>
                </li>
                <li>
                    <span class="labelName">银行别名：</span>
                    <input name="aliasName" type="text" value="${bankAliasInfo.aliasName }"
                           class="userText" maxlength="10"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
            </ul>
            <div class="clear"></div>
            <div class="op">
                <input type="button" class="save btn70_1" value="提交" onclick="updateSubmit()">
                <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
            </div>

        </form>
    </div>
    <!-- end修改银行卡别名页 -->
</div>
</div>
</body>
<jsp:include page="../../common/foot.jsp"></jsp:include>
<script>
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
    function updateSubmit() {
        $("#updateBankAliasForm").submit();
    }
    function check() {
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#updateBankAliasForm").find(".userText").each(function () {
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
            $("#updateBankAliasForm").submit();
        }


    }
</script>
</html>