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
                <div>当前位置:<span class="pageLocation">运营系统->机构路由管理->添加路由配置</span></div>
                <div class="pageTitle">添加路由配置</div>
                <!-- start添加新产品页 -->
                <form id="addForm" action="addSubmit.j" method="post">
                <div id="conManageReset" style="display: block">
                    <ul class="conManageResetUl pageUl">
                        <li> 
                            <span class="labelName">银行名称：</span>
                            <select name="channelCode" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${channelList}" var="channel">  
								       <option value="${channel.channelCode}">${channel.channelName}</option>
								</c:forEach>
                            </select>
                        </li>
                        <li> <span class="labelName">接入产品：</span>
                             <select name="appId" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${appList}" var="app">  
								       <option value="${app.appId}">${app.appName}</option>
								</c:forEach>
                            </select>
                        </li>
                        <li>
                            <span class="labelName">银行卡类型：</span>
                            <select  name="bankCardType" data-placeholder="请选择..." class="chosen_select110">
	                            <c:forEach items="${bankCardTypeMap}" var="entry">  
								       <option value="${entry.key}" <c:if test="${pager.f.bankCardType==entry.key }">selected</c:if>>${entry.value}</option>
								</c:forEach>
	                        </select>
                        </li>
                    </ul>
                    <div class="clear"></div>
                    <div class="tableWrap">
                        <table class="tableList">
                         	<tr>
                                <th>机构名称</th>
                                <th>比例</th>
                                <th>状态</th>
                            </tr>
                        	<c:forEach  var="entry" items="${agencyMap }">
                        		<tr>
                        		<td>${entry.value} </td>
                                <td><input name="${entry.key }_scale" type="text" value="0"></td>
                                <td><input name="${entry.key }_status" type="radio" checked value="1">启用
                                    <input name="${entry.key }_status" type="radio" value="2">禁用
                                </td>
                                </tr>
                        	</c:forEach>
                        </table>
                    <div class="clear"></div>
                    <br/>
                    <div class="op">
                        <input type="button" class="save btn70_1" value="保存" onclick="onSubmit()">
                        <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
                    </div>
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
		var array = [];
		var errorMessage = "";
		$("input").each(function(){
			var name = $(this).attr("name");
			if(name.indexOf('_scale') != -1){
				var scale = $("input[name="+name+"]").val();
				if(!vilidate(scale)){
					errorMessage = "比例必须小于等于1，并且最多4位小数！";
					return false;
				}
				var agencyCode = name.substr(0,name.indexOf('_scale'));
				var status = $("input[name="+agencyCode+"_status"+"]:checked").val();
				if(status == 1){
					array.push(scale);
				}
			}
		})
		if(errorMessage != ""){
			alert(errorMessage);
			return false;
		}
		var sum = 0;
		for(var i=0;i<array.length;i++){
			 sum = sum + array[i] * 1;
		}
		if(sum != 1){
			errorMessage = "所有机构路由比例和必须为1";
			alert(errorMessage);
			return false;
		}
		$("#addForm").submit(); 
	}
	
	function vilidate(value){
		if(value == 0 || value == 1){
			return true;
		}
		var reg = new RegExp("^[0]+(.[0-9]{0,4})?$");  
		if(!reg.test(value)){  
			return false;
	    }
		if(value * 1 > 1){
			return false;
		}
		return true;		
	}
	function cancel(){
		window.location.href="javascript:history.go(-1)";
	}
</script>
<jsp:include page="../../common/foot.jsp"></jsp:include>