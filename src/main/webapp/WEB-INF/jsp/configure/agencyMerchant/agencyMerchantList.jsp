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
    <div>当前位置:<span class="pageLocation">运营系统->支付机构商户管理</span></div>
    <div class="pageTitle">支付机构商户列表</div>

    <!-- start 商户列表页 -->
    <div id="productList" style="display: block">
        <form action="query.j" method="post" id="queryForm" class="ajaxfrm">
            <ul class="productListUl pageUl">

                <li>
                    <span class="labelName">支付机构编码</span>
                    <input class="key" type="text" name="agencyCode"
                           value="${agencyCode}"></input>
                </li>

                <li class="op">
                    <input type="button" class="save btn70_1" value="查询" onclick="doSubmit()">
                    <input type="button" class="add btn70_1" value="新增" onclick="doAdd()">
                </li>
            </ul>
        </form>
        <div class="clear"></div>
        <div class="tableWrap table1">
            <table class="tableList">
                <tr>
                    <th>序号</th>
                    <th>公司名称</th>
                    <th>产品名称</th>
                    <th>支付机构编码</th>
                    <th>商户号</th>
                    <th>状态</th>
                    <th>创建时间</th>
                    <th>操作</th>

                </tr>
                <c:forEach items="${agencyMerchantList}" var="item" varStatus="xh">
                    <tr>
                        <td>${xh.count}</td>
                        <td>${item.companyName}</td>
                        <td>${item.appName}</td>
                        <td>${item.agencyCode}</td>
                        <td>${item.merchantNo}</td>
                        <td>${item.isUsedStr}</td>
                        <td>${item.createTimeStr}</td>
                        <td><a
                                href="showMerchant.j?flag=detail&id=${item.id }">查看</a> |
                            <a
                                    href="showMerchant.j?flag=update&id=${item.id }">修改</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
    <!-- end商户列表页 -->
</div>
</div>
</body>
</html>
<script>
    function doSubmit() {
        $("#queryForm").submit();
    }
    function doAdd() {
        window.location.href = "toAdd.j";
    }
</script>
<jsp:include page="../../common/foot.jsp"></jsp:include>
