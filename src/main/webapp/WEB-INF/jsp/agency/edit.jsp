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
<%@ include file="../common/head.jsp" %>
<div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->支付机构管理->修改</span></div>
        <div class="pageTitle">支付机构修改</div>

        <!-- start产品详细页 -->
        <div id="agencyinfoEdit" style="display: block">
        <form action="doEdit.j" method="post" id="aaa">
        	<input type = "hidden" name="id" value="${info.id }"/>
   				 <ul class="addNewProductUl pageUl detail">
                        <li>
							<span class="labelName">接入平台：</span>
                            <c:forEach items="${accessMap}" var="entry">  
	                            <c:if test="${entry.key==info.accessPlatform }">
	                            	<span class="">${entry.value}</span>
	                            </c:if>
                            </c:forEach>
                        </li>
                        <li>
                            <span class="labelName">支付机构编码：</span>
                            <span class="">${info.agencyCode }</span>
                        </li>
                        <div class="clear"></div>
                        <li>
                            <span class="labelName">支付机构类型：</span> 
                            <c:forEach items="${map}" var="entry">  
	                            <c:if test="${entry.key==info.agencyType }">
	                            	<span class="">${entry.value}</span>
	                            </c:if>
                            </c:forEach>
                            
                        </li>
                        
                        <li>
                            <span class="labelName">是否存在银行别名：</span> 
                            <select name="aliasFlag" data-placeholder="请选择..." class="chosen_select150">
	                            <c:forEach items="${aliasMap}" var="entry">  
								     <option value="${entry.key}"<c:if test="${entry.key==info.aliasFlag }"> selected</c:if>>${entry.value}</option>
								</c:forEach>
                            </select>
                        </li>
                        <div class="clear"></div>
                        <li>
                             <span class="labelName">支付机构名称：</span>
                            <input type="text"  maxlength="20" name = "agencyName" value="${info.agencyName }" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <li>
                            <span class="labelName">支付地址：</span>
                             <input type="text" maxlength="100" name = "payUrl" value="${info.payUrl }" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <div class="clear"></div>
                       <li>
                            <span class="labelName">退款地址：</span>
                             <input type="text" maxlength="100" name = "refundUrl" value="${info.refundUrl }" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <li>
                            <span class="labelName">退款查询地址：</span>
                            <input type="text" maxlength="100" name = "queryRefundUrl" value="${info.queryRefundUrl }" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                        <div class="clear"></div>
                       <li>
                            <span class="labelName">订单查询地址：</span>
                             <input type="text" maxlength="100" name = "queryUrl" value="${info.queryUrl }" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <li>
                            <span class="labelName">手机预支付地址：</span>
                             <input type="text" maxlength="100" name = "prepayUrl" value="${info.prepayUrl }" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                       <li>
                            <span class="labelName">手机验证码地址：</span>
                             <input type="text" maxlength="100" name = "sendPhoneUrl"  value="${info.sendPhoneUrl }" class="userText"></input>
                            <span class="require">*</span>
                            <span class="point">请填写必填项</span>
                       </li>
                    </ul>
                    <div class="clear"></div>
                    <div class="op">
                        <input type="button" value = "提交" class="save btn70_1" id ="userSave" onclick="check()"/>
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
		var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#aaa").find(".userText").each(function(){
        	if ($(this).val() == "") {
                $(this).siblings(".point").css("display", "inline-block");
                emptyArr.push($(this));
            }
            else {
                $(this).siblings(".point").css("display", "none");
            }
        });
        
        /* 下拉框验证：只能验证第一个，所以先注释掉
        
        $('#aaa').find('.chosen_select150').each(function() {
           if (!$(this).find('option:selected').not($(this).find('option').eq(0)).length) {
	            errorInfo = $(this).siblings(".point").css("display", "inline-block");;
	            emptyArr.push($(this));
	        } else {
	            $(this).siblings(".point").css("display", "none");
	        }
        }); */
        
        flag = !emptyArr.length ? 1 : 0;
        
        //return false;
        
        if (flag) {
            //alert("提交成功");
            $("#aaa").submit();
        } 
        
	
    }
	
</script>
</html>
