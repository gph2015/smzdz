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
        <div>当前位置:<span class="pageLocation">运营系统->支付机构管理</span></div>
        <div class="pageTitle">支付机构列表</div>

        <!-- start 产品列表页 -->
        <div id="productList" style="display: block">
        <form action="query.j" method="post" id ="queryForm"  class="ajaxfrm" >
            <ul class="productListUl pageUl">
                
                <li>
                    <span class="labelName">支付机构名称</span>
                    <input class="key" type="text" name="code" value="${code}">
                </li>
                <li>
                   <span class="select btn100" onclick="doSubmit();">查询</span>
                </li>
                 <li>
                   <span class="select btn100" onclick="doAdd();">新增</span>
                </li>
            </ul>
		</form>
            <div class="clear"></div>
            <div class="tableWrap table1">
                <table class="tableList">
                    <tr>
                   	    <th>序号</th>
                        <th>支付机构名称</th>
                        <th>支付机构编码</th>
                        <th>接入平台</th>
                        <th>机构类型</th>
                        <th>创建时间</th>
                        <th>操作</th>
                        
                    </tr>
                    <c:forEach items="${resultList}" var="item" varStatus="xh">
                        <tr>
                            <td>${xh.count}</td>
                            <td>${item.agencyName}</td>
                            <td>${item.agencyCode}</td>
                            <td>${item.accessPlatformSrt}</td>
                            <td>${item.agencyTypeStr}</td>
                            <td><fmt:formatDate  value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><a href="${ctx }/agency/toEdit.j?id=${item.id}">修改</a>  |  <a href="${ctx }/agency/details.j?id=${item.id}">详情</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
        <!-- end产品列表页 -->


    </div>
</div>

</body>

<%@include file="../common/foot.jsp"%>

<script type="text/javascript">

    function doSubmit(){

        $("#queryForm").submit();
    }
    
    function doAdd(){

    	window.location.href="toAdd.j"; 
    }
    
</script>

</html>


