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
                <div>当前位置:<span class="pageLocation">运营系统->渠道适配管理->添加渠道适配</span></div>
                <div class="pageTitle">添加渠道适配</div>
                <!-- start添加新产品页 -->
                <form id="addForm" action="addSubmit.j" method="post">
                <div id="addNewProduct" style="display: block">
                    <ul class="addNewProductUl pageUl">
                        <li>
                            <span class="labelName">渠道名称：</span>
                            <select name="channelCode" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${channelList}" var="channel">  
								       <option value="${channel.channelCode}">${channel.channelName}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                        </li>
                        <li>
                            <span class="labelName">接入产品：</span>
                            <select name="appId" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${appList}" var="app">  
								       <option value="${app.appId}">${app.appName}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                        </li>
                        <div class="clear"></div>
                        <li>
                            <span class="labelName">接入平台：</span>
                            <select name="accessPlatform" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${accessPlatformMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                        </li>
                        <li>
                            <span class="labelName">银行卡类型：</span>
                            <select name="bankCardType" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${bankCardTypeMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                        </li>
                        <div class="clear"></div>
                        <li>
                            <span class="labelName">渠道方式：</span>
                            <select name="channelType" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${channelTypeMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                        </li>
                        <li>
                            <span class="labelName">状态：</span>
                            <c:forEach items="${statusMap}" var="entry" varStatus="status">
   		                        <input type="radio" name="status" value="${entry.key}" <c:if test="${status.index==0 }">checked</c:if>>
   		                        ${entry.value}</input>  
							</c:forEach>
						</li>
						<div class="clear"></div>
						<li>
                            <span class="labelName">排序</span> 
                            <input name="sort" maxlength="10" type="text"  value=""/>
                        </li>
                    </ul>
                    <div class="clear"></div>
                    <div class="op">
                        <input type="button" class="save btn70_1" value="保存" onclick="onSubmit()">
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
	function onSubmit(){
		var sort = $("input[name=sort]").val();
		var reg = new RegExp("^[1-9]([0-9](.*))?$");
		if(!reg.test(sort)){
			alert("排序必须为数字！");
			return false;
	    }
		$("#addForm").submit();
	}
	function cancel(){
		window.location.href="javascript:history.go(-1)";
	}
</script>
<jsp:include page="../../common/foot.jsp"></jsp:include>