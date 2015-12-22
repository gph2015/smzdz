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
    <div>当前位置:<span class="pageLocation">运营系统->菜单管理</span></div>
    <div class="pageTitle">菜单列表</div>
    <!-- start 菜单列表页 -->
    <div id="userList" style="display: block">
        <form id="queryForm" action="query.j" method="post">
            <ul class="userListUl pageUl">
                <li class="op">
                    <input type="button" class="add btn70_1" value="新增" onclick="doAdd()">
                </li>
            </ul>
        </form>
        <div class="clear"></div>
        <div class="tableWrap table1">
            <table class="tableList">
                <tr>
                    <th>序号</th>
                    <th>父菜单</th>
                    <th>一级菜单</th>
                    <th>二级菜单</th>
                    <th>访问URL</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="menu" items="${menuList }" varStatus="xh">
                    <tr>
                        <td>${xh.count}</td>
                        <td>${menu.oneName }</td>
                        <td>${menu.twoName }</td>
                        <td>${menu.threeName }</td>
                        <td>${menu.url }</td>
                        <td><a href="showMenu.j?flag=detail&id=${menu.id }">查看</a>&nbsp;|&nbsp;<a
                                class="edit" href="deleteMenu.j?id=${menu.id }">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="bankAliasListPager paginator"></div>
        </div>
    </div>
    <!-- end菜单列表页 -->
</div>
</div>
</body>
<%@ include file="../../common/foot.jsp" %>
<script>
    function doSubmit() {

        $("#queryForm").submit();
    }
    function doAdd() {
        window.location.href = "toAdd.j";
    }
</script>
</html>
