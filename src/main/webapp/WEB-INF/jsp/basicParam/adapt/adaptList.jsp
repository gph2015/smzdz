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
                <div>当前位置:<span class="pageLocation">运营系统->渠道适配管理->渠道适配列表</span></div>
                <div class="pageTitle">渠道适配列表</div>

                <!-- start 产品列表页 -->
                <form id="queryForm" action="getAdaptList.j" method="post">
                <div id="productList" style="display: block">
                   <ul class="productListUl pageUl">
                       <li> <span class="labelName">接入产品：</span>
                           <select  name="f[appId]" data-placeholder="请选择..." class="chosen_select110">
                           		<option value="">全部</option>
	                            <c:forEach items="${appList}" var="entry">  
								       <option value="${entry.appId}" <c:if test="${pager.f.appId==entry.appId }">selected</c:if>>${entry.appName}</option>
								</c:forEach>
                        	</select>
                       </li>
                       <li> <span class="labelName">接入平台：</span>
                           <select  name="f[accessPlatform]" data-placeholder="请选择..." class="chosen_select110">
                           		<option value="">全部</option>
	                            <c:forEach items="${accessPlatformMap}" var="entry">  
								       <option value="${entry.key}"  <c:if test="${pager.f.accessPlatform==entry.key }">selected</c:if>>${entry.value}</option>
								</c:forEach>
                        	</select>
                       </li>
                       <li> <span class="labelName">渠道方式：</span>
                           <select  name="f[channelType]" data-placeholder="请选择..." class="chosen_select110">
                           		<option value="">全部</option>
	                            <c:forEach items="${channelTypeMap}" var="entry">  
								       <option value="${entry.key}" <c:if test="${pager.f.channelType==entry.key }">selected</c:if>>${entry.value}</option>
								</c:forEach>
                        	</select>
                       </li>
                       <div class="clear"></div>
                       <li> 
                        <span class="labelName">银行卡类型：</span>
	                        <select  name="f[bankCardType]" data-placeholder="请选择..." class="chosen_select110">
	                            <option value="">全部</option>
	                            <c:forEach items="${bankCardTypeMap}" var="entry">  
								       <option value="${entry.key}" <c:if test="${pager.f.bankCardType==entry.key }">selected</c:if>>${entry.value}</option>
								</c:forEach>
	                        </select>
                       </li>
                       <li> 
                        <span class="labelName">状&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp态：</span>
	                        <select  name="f[status]" data-placeholder="请选择..." class="chosen_select110">
	                        	<option value="">全部</option>
	                            <c:forEach items="${statusMap}" var="entry">  
								       <option value="${entry.key}" <c:if test="${entry.key ==pager.f.status}"> selected</c:if>>${entry.value}</option>
								</c:forEach>
	                        </select>
                       </li>
                       <li> 
                           <span class="labelName">渠道名称：</span>
                           <input name="f[channelName]" type="text" value="${pager.f.channelName }"></input>
                       </li>
                       <div class="clear"></div>
                       <li class="op op1">
                           <input type="button" class="save btn70_1" value="查询" onclick="onSubmit();">
                            <input type="button" class="add btn70_1" value="新增" onclick="add();">
                       </li>
                       
                   </ul>
                   <div class="clear"></div>
                   <div class="tableWrap table1">
                       <table class="tableList">
                           <tr>
                               <th>渠道名称</th>
                               <th>接入平台</th>
                               <th>接入产品</th>
                               <th>渠道方式</th>
                               <th>银行卡类型</th>
                               <th>排序</th>
                               <th>状态</th>
                               <th>创建时间</th>
                               <th>操作</th>
                           </tr>
                           <c:forEach var="adapt" items="${adaptList }">
	                           <tr>
	                           	   <input type="hidden" name="id" value="${adapt.id }">
	                               <td>${adapt.channelName }</td>
	                               <td>${adapt.accessPlatformStr }</td>
	                               <td>${adapt.appName }</td>
	                               <td>${adapt.channelTypeStr }</td>
	                               <td>${adapt.bankCardTypeStr }</td>
	                               <td>${adapt.sort }</td>
	                               <td>${adapt.statusStr }</td>
	                               <td>${adapt.createTimeStr }</td>
	                               <td><a class="edit" href="showAdapt.j?id=${adapt.id }">编辑</a></td>
	                           </tr>
                           </c:forEach>
                       </table>
                       <div class="transactionListPager paginator"></div>
                   </div>
                </div>
                </form>
                <!-- end产品列表页 -->
            </div>
		</div>
		</body>
		</html>
<jsp:include page="../../common/foot.jsp"></jsp:include>
<script>
	function onSubmit(){
		$("#queryForm").submit();
	}
	
	function add(){

		window.location.href="toAddAdapt.j";

	}
    $(function($){

        renderpage(".transactionListPager","getAdaptList.j?${pager.fullUrl}",${pager.pageNo},${pager.totalPages});

       });
</script>