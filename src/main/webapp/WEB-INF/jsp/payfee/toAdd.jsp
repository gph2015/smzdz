<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/24
  Time: 11:08
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

<%@ include file="../common/head.jsp"%>


<div id="mainContent">
    <div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->手续费管理->新增</span></div>
        <div class="pageTitle">手续费新增</div>

        <!-- start产品详细页 -->
        <div id="agencyinfoAdd" style="display: block">
        <form action="doAdd.j" method="post" id="payfeeForm">
   				 <ul class="addNewProductUl pageUl detail">
                        <li>
                            <span class="labelName">支付机构：</span>
                            <select name="agencyCode" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${agencyMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                        </li>
                        <li>
                            <span class="labelName">支付类型：</span>
                            <select name="payFeeType" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${payFeeTypeMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                        </li>
                        <div class="clear"></div>
                        <li>
                            <span class="labelName">手续费名称：</span>
                             <input type="text" maxlength="30" name = "name" value="" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                        </li>
                        
                        <li>
                            <span class="labelName">手续费类型：</span> 
                            <select name="feeType" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${feeTypeMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                        </li>
                        <div class="clear"></div>
                        <li>
                            <span class="labelName">固定手续费：</span>
                             <input type="text" name = "fee" value="" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <li>
                            <span class="labelName">费率：</span>
                             <input type="text" name = "feeRate" value="" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <div class="clear"></div>
                       <li>
                            <span class="labelName">保底手续费：</span>
                             <input type="text" name = "lowerLimit" value="" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <li>
                            <span class="labelName">封顶手续费：</span>
                             <input type="text" name = "upperLimit" value="" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <div class="clear"></div>
                       <li>
                            <span class="labelName">商户号：</span>
                             <input type="text" maxlength="30" name = "merchantNo" value="" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <li>
                            <span class="labelName">接入平台：</span>
                             <select name="accessPlatform" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${accessPlatformMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <div class="clear"></div>
                       <li>
                            <span class="labelName">状态：</span>
                             <select name="status" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${statusMap}" var="entry">  
								       <option value="${entry.key}">${entry.value}</option>
								</c:forEach>
                            </select>
                       </li>
                    </ul>
                    <div class="clear"></div>
                    <div class="op">
                       <input type="button" value = "提交" class="save btn70_1" id ="payfeeSave" onclick="check()"/>
						<input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
                    </div>
                    </form>
                    
                </div>
        <!-- end产品详细页 -->

    </div>
</div>
</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script>
	function cancel(){
		window.location.href="javascript:history.go(-1)";
	}
	
	function check(){
		//检查金额格式
		var fee = $("input[name=fee]").val();
		var feeRate = $("input[name=feeRate]").val();
		var lowerLimit = $("input[name=lowerLimit]").val();
		var upperLimit = $("input[name=upperLimit]").val();
		if(!checkAmount("fee",fee) || !checkAmount("feeRate",feeRate) 
				|| !checkAmount("lowerLimit",lowerLimit) || !checkAmount("upperLimit",upperLimit)){
			alert("输入格式有误，请重新输入！");
			return;
		}
		var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#payfeeForm").find(".userText").each(function(){
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
            $("#payfeeForm").submit();
        }         
    }
	
	function checkAmount(inputName,amount){
		var reg = new RegExp("^((([1-9][0-9]{0,7})|([0]{1}))(\\.[0-9]{2}))|([-1])|([0])$");
		var regRate = new RegExp("^((([0]{1}))(\\.[0-9]{0,3}[1-9]))$");
		if("feeRate" == inputName){
			if(!regRate.test(amount)){
				return false;
		    }	
		} else {
			if(!reg.test(amount)){
				return false;
		    }
		}
		return true;
	}
</script>
</html>


