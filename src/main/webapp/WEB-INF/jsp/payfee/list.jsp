
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
    <div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->手续费管理</span></div>
        <div class="pageTitle">手续费列表</div>

        <!-- start 产品列表页 -->
        <div id="productList" style="display: block">
        <form action="query.j" method="post" id ="queryForm"  class="ajaxfrm" >
            <ul class="productListUl pageUl">
                
                <li>
                    <span class="labelName">支付机构编码</span>
                    <input class="key" type="text"   name="code" value="${code }" value="${code }"></input>
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
            <div class="tableWrap">
                <table class="tableList">
                    <tr>
                   	    <th nowrap="nowrap">序号</th>
                        <th nowrap="nowrap">费率名称</th>
                        <th nowrap="nowrap">支付类型</th>
                        <th nowrap="nowrap">支付机构编码</th>
                        <th nowrap="nowrap">手续费类型</th>
                        <th nowrap="nowrap">接入平台</th>
                        <th nowrap="nowrap">费率</th>
                         <th nowrap="nowrap">商户号</th>
                          <th nowrap="nowrap">状态</th>
                          <th nowrap="nowrap">创建时间</th>
                          <th nowrap="nowrap">操作</th>
                        
                    </tr>
                    <c:forEach items="${resultList}" var="item" varStatus="xh">
                        <tr>
                            <td>${xh.count}</td>
                            <td nowrap="nowrap">${item.name}</td>
                            <td nowrap="nowrap">${item.payFeeTypeStr}</td>
                            <td nowrap="nowrap">${item.agencyCode}</td>
                            <td nowrap="nowrap">${item.feeTypeStr}</td>
                            <td nowrap="nowrap">${item.accessPlatformStr}</td>
                            <td nowrap="nowrap">${item.feeRate}</td>
                            <td nowrap="nowrap">${item.merchantNo}</td>
                            <td nowrap="nowrap">${item.statusStr}</td>
                            <td nowrap="nowrap"><fmt:formatDate  value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td nowrap="nowrap"><a href="${ctx }/payfee/toEdit.j?id=${item.id}">修改</a>  |  <a href="${ctx }/payfee/details.j?id=${item.id}">详情</a></td>
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


