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
                <div>当前位置:<span class="pageLocation">运营系统->渠道适配管理->修改渠道适配信息</span></div>
                <div class="pageTitle">修改渠道适配信息</div>
                <!-- start添加新产品页 -->
                <form id="updateForm" action="updateSubmit.j" method="post">
                <input name="id" type="hidden" value="${adaptInfo.id }">
                <div id="addNewProduct" style="display: block">
                    <ul class="addNewProductUl pageUl">
                        <li>
                            <span class="labelName">渠道名称：</span>
                            <span class="value">${adaptInfo.channelName }</span>
                        </li>
                        <li>
                            <span class="labelName">接入产品：</span>
                            <span class="value">${adaptInfo.channelName }</span>
                        </li>
                        <div class="clear"></div>
                        <li>
                            <span class="labelName">接入平台：</span>
                            <span class="value">${adaptInfo.accessPlatformStr }</span>
                        </li>
                        <li>
                            <span class="labelName">银行卡类型：</span>
                            <span class="value">${adaptInfo.bankCardTypeStr }</span>
                        </li>
                        <div class="clear"></div>
                        <li>
                            <span class="labelName">渠道方式：</span>
                            <span class="value">${adaptInfo.channelTypeStr}</span>
                        </li>
						<li>
                            <span class="labelName">状态：</span>
                            <c:forEach items="${statusMap}" var="entry">
   		                        <input type="radio" name="status" value="${entry.key}" <c:if test="${entry.key ==adaptInfo.status }"> checked</c:if>>${entry.value}</input>  
							</c:forEach>
						</li>
						<div class="clear"></div>
						<li>
                            <span class="labelName">排序：</span>
                            <input type="text" name="sort" value="${adaptInfo.sort}"/>
						</li>
                    </ul>
                    <div class="clear"></div>
                    <div class="op">
                        <input type="button" class="save btn70_1" value="保存" onclick="updateSubmit()">
                        <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
                    </div>
                </div>
                </form>
                <!-- end添加新产品页 -->
            </div>
		</div>
		</body>
		</html>
<script>
	function updateSubmit(){
		var sort = $("input[name=sort]").val();
		var reg = new RegExp("^[1-9]([0-9](.*))?$");
		if(!reg.test(sort)){
			alert("排序必须为数字！");
			return false;
	    }
		$("#updateForm").submit();
	}
	function cancel(){
		window.location.href="javascript:history.go(-1)";
	}
</script>
<jsp:include page="../../common/foot.jsp"></jsp:include>