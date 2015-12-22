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
    <div>当前位置:<span class="pageLocation">运营系统->支付渠道管理</span></div>
    <div class="pageTitle">修改支付渠道</div>
    <!-- start 修改新支付渠道页 -->
    <form id="updateChannelInfoForm" action="updateChannelInfo.j?id=${channelInfo.id}&&logo=${channelInfo.logo}"
          method="post"
          enctype="multipart/form-data">
        <div id="updateChannleInfo" style="display: block">
            <input type="hidden" name="id" value="${channelInfo.id }"/>
            <ul class="updateChannleInfoUl pageUl">
                <li>
                    <span class="labelName">渠道logo：</span>
                    <img class="labelNames" src="${channelInfo.logo}"/>
                    <input class="labelName" name="updatelogo" type="file" value="" maxlength="1024"/>

                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">渠道名称：</span>
                    <input name="channelName" type="text" value="${channelInfo.channelName }" class="userText"  maxlength="255"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>

                <li>
                    <span class="labelName">渠道性质：</span>
                    <select name="channelNature" data-placeholder="请选择..."
                            class="chosen_select150">
                        <c:forEach items="${channelNatureMap}" var="entry">
                            <option value="${entry.key}" <c:if
                                    test="${entry.key == channelInfo.channelNature }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">渠道编码：</span>
                    <span class="value">${channelInfo.channelCode }</span>
                </li>
                <li>
                    <span class="labelName">最低限额：</span>
                    <input name="lowLimit" type="text" value="${channelInfo.lowLimit }" class="userText"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">最高限额：</span>
                    <input name="highLimit" type="text" value="${channelInfo.highLimit }" class="userText"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <li>
                    <span class="labelName">页面显示信息：</span>
                    <input name="limitInfo" type="text" value="${channelInfo.limitInfo }"/>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">渠道类型：</span>
                    <select name="channelType" data-placeholder="请选择..."
                            class="chosen_select150">
                        <c:forEach items="${channelTypeMap}" var="entry">
                            <option value="${entry.key}" <c:if
                                    test="${entry.key == channelInfo.channelType }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
            </ul>
            <div class="clear"></div>
            <div class="op">
                <input type="button" class="save btn70_1" value="保存" onclick="onSubmit()">
                <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
            </div>
        </div>
    </form>
    <!-- end 修改新支付渠道页 -->
</div>
</div>
</body>
<jsp:include page="../../common/foot.jsp"></jsp:include>
<script>
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
    function onSubmit() {
        var lowLimit = $("input[name=lowLimit]").val();
        var highLimit = $("input[name=highLimit]").val();
        var reg = new RegExp("^[0-9]+(.[0-9]{2})?$");
        if(!reg.test(lowLimit)){
            alert("金额类型字段必须为正整数或格式为两位小数！");
            return false;
        }
        if(!reg.test(highLimit)){
            alert("金额类型字段必须为正整数或格式为两位小数！");
            return false;
        }
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#updateChannelInfoForm").find(".userText").each(function () {
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
            $("#updateChannelInfoForm").submit();
        } else {
            //alert('False');
        }

    }
</script>
</html>