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
    <div>当前位置:<span class="pageLocation">运营系统->银行卡别名管理</span></div>
    <div class="pageTitle">银行卡别名列表</div>
    <!-- start 银行卡别名列表 -->
    <div id="userList" style="display: block">
        <form action="query.j" method="post" id="queryForm" refreshId="list-page"
              class="ajaxfrm">
            <ul class="userListUl pageUl">

                <li>
                    <span class="labelName">银行简称</span>
                    <input class="key" type="text" name="f[bankCode]"
                           value="${pager.f.bankCode}"/>
                </li>
                <li><span class="labelName">支付机构编码：</span>
                    <input class="key" type="text" name="f[agencyCode]"
                           value="${pager.f.agencyCode}"/>
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
                    <th>ID</th>
                    <th>支付机构编码</th>
                    <th>银行卡类型</th>
                    <th>银行简称</th>
                    <th>银行别名</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${bankAliasList}" var="item" varStatus="xh">
                    <tr>
                        <td>${item.aliasId}</td>
                        <td>${item.agencyCode}</td>
                        <td>${item.bankCardTypeStr}</td>
                        <td>${item.bankCode}</td>
                        <td>${item.aliasName}</td>
                        <td>${item.createTimeStr}</td>
                        <td><a
                                href="showBankAlias.j?flag=detail&id=${item.aliasId }">查看</a> |
                            <a
                                    href="showBankAlias.j?flag=update&id=${item.aliasId }">修改</a> |
                            <a
                                    href="deleteBankAlias.j?id=${item.aliasId }&bankCode=${pager.f.bankCode}&agencyCode=${pager.f.agencyCode}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="bankAliasListPager paginator" style="width:500px; padding-right:350px"></div>
        </div>
    </div>
    <!-- 银行卡别名列表 -->
</div>
</div>
</body>
<script type="text/javascript" src="../static/j/jquery-1.11.1.min.js"></script>
<script src="../static/3rd/zTree_v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="../static/3rd/chosen/chosen.jquery.min.js"></script>
<script src="../static/3rd/jqueryui/jquery-ui.min.js"></script>
<script src="../static/j/paginator.js"></script>
<script src="../static/j/main.js"></script>
<script type="text/javascript">
    function doSubmit() {
        $("#queryForm").submit();
    }
    $(function ($) {
        renderpage(".bankAliasListPager", "query.j?${pager.fullUrl}", ${pager.pageNo},
                ${pager.totalPages});
    });
    function doAdd() {
        window.location.href = "toAdd.j";
    }
</script>
</html>