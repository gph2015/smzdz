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
    <div class="pageTitle">添加支付机构商户</div>
    <!-- start添加新支付机构商户页 -->
    <form id="addMerchantForm" action="addMerchant.j" method="post">
        <div id="addNewAgencyMerchant" style="display: block">
            <ul class="addNewAgencyMerchantUl pageUl">
                <li>
                    <span class="labelName">支付机构编码：</span>
                    <input name="agencyCode" type="text" value="" class="userText" maxlength="20"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <li>
                    <span class="labelName">支付机构商户ID：</span>
                    <input name="merchantNo" type="text" value="" class="userText" maxlength="30"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">签约公司名称：</span>
                    <select name="companyCode" data-placeholder="请选择..."
                            class="chosen_select150">
                        <c:forEach items="${companyMap}" var="entry">
                            <option value="${entry.key}">${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <li>
                    <span class="labelName">接入产品：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="appId">
                        <option value="">请选择</option>
                        <c:forEach items="${appList}" var="app">
                            <option value="${app.appId}">${app.appName}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">商户邮箱（公众号）：</span>
                    <input name="sellerEmail" type="text" value="" maxlength="200"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <li>
                    <span class="labelName">加密方式：</span>
                    <select name="encryptionType" data-placeholder="请选择..."
                            class="chosen_select150">
                        <c:forEach items="${encryptionTypeMap}" var="entry">
                            <option value="${entry.key}">${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">密钥：</span>
                    <input name="encryptKey" type="text" value="" class="userText" maxlength="500"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>

                <li>
                    <span class="labelName">公钥路径：</span>
                    <input name="pubKeypath" type="text" value="" class="userText" maxlength="250"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">私钥路径：</span>
                    <input name="privateKeypath" type="text" value="" class="userText" maxlength="250"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>

                <li>
                    <span class="labelName">页面回调地址：</span>
                    <input name="pageBackUrl" type="text" value="" class="userText" maxlength="250"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">点对点回调地址：</span>
                    <input name="notifyBackUrl" type="text" value="" class="userText" maxlength="250"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <li>
                    <span class="labelName">接入状态：</span>
                    <c:forEach items="${isUserdMap}" var="entry">
                        <input type="radio" name="isUsed"
                               value="${entry.key}">${entry.value}
                    </c:forEach>
                </li>
            </ul>
            <div class="clear"></div>
            <div class="op">
                <input type="button" class="save btn70_1" value="保存" onclick="onSubmit()">
                <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
            </div>
        </div>
    </form>
    <!-- end添加新支付机构商户页 -->
</div>
</div>
</body>
<jsp:include page="../../common/foot.jsp"></jsp:include>
<script>
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
    function onSubmit() {
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#addMerchantForm").find(".userText").each(function () {
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
            $("#addMerchantForm").submit();
        } else {
            //alert('False');
        }

    }
</script>
</html>