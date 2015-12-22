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
                <div>当前位置:<span class="pageLocation">运营系统->机构路由管理->更新路由配置</span></div>
                <div class="pageTitle">更新路由配置</div>
                <!-- start添加新产品页 -->
                <form id="updateForm" action="updateSubmit.j" method="post">
                <div id="conManageReset" style="display: block">
                    <ul class="conManageResetUl pageUl">
                        <li> 
                            <span class="labelName">银行名称：</span>
                            <input name="bankCode" type="hidden" value="${routerModel.bankCode}"/>
                            <span class="value">${routerModel.bankName }</span>
                        </li>
                        <li> <span class="labelName">接入平台：</span>
                        	<input name="appId" type="hidden" value="${routerModel.appId}"/>
                             <span class="value">${routerModel.appName }</span>
                        </li>
                        <li>
                            <span class="labelName">银行卡类型：</span>
                            <input name="bankCardType" type="hidden" value="${routerModel.bankCardType}"/>
                            <span class="value">${routerModel.bankCardTypeStr }</span>
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
                            <c:forEach var="router" items="${routerModel.routerList }">
                            <tr>
                            	<td>${router.agencyName }</td>
                            	<td><input name="${router.agencyCode }_scale" type="text" value="${router.scale }"></td>
                                <td><input name="${router.agencyCode }_status" type="radio" value="1" <c:if test="${router.status == 1 || router.status == null}">checked</c:if>>启用
                                    <input name="${router.agencyCode }_status" type="radio" value="2" <c:if test="${router.status == 2 }">checked</c:if>>禁用
                                </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="clear"></div>
                        <br>
                        <input type="button" class="save btn70_1" value="保存" onclick="updateSubmit()">
                        <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
                    </div>
                    </div>
                </form>
                <!-- end添加新产品页 -->
            </div>
		</body>
		</html>
<script>
	function updateSubmit(){
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
		$("#updateForm").submit(); 
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