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
    <div>当前位置:<span class="pageLocation">运营系统->用户管理</span></div>
    <div class="pageTitle">用户列表</div>
    <!-- start 用户列表页 -->
    <div id="userList" style="display: block">
        <form id="queryForm" action="query.j" method="post">
            <ul class="userListUl pageUl">
                <li>
                    <span class="labelName">姓名：</span>
                    <input type="text" name="name" value="${name}"></input>
                </li>
                <li>
                    <span class="labelName">邮箱：</span>
                    <input type="text" name="mail" value="${mail}"></input>
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
                    <th>姓名</th>
                    <th>邮箱</th>
                    <th>部门</th>
                    <th>权限</th>
                    <th>创建时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="user" items="${userList }" varStatus="xh">
                    <tr>
                        <td>${xh.count}</td>
                        <td>${user.name }</td>
                        <td>${user.mail }</td>
                        <td>${user.appIdStr }</td>
                        <td>${user.typeStr }</td>
                        <td>${user.createTimeStr }</td>
                        <td>${user.statusStr }</td>
                        <c:choose>
                            <c:when test="${user.status== '1' }">
                                <td><a class="find"
                                       href="updateUser.j?flag=unusing&mail=${user.mail }&queryMail=${mail }&queryName=${name}">禁用</a>&nbsp;|&nbsp;<a
                                        class="find"
                                        href="deleteUserInfo.j?mail=${user.mail }&queryMail=${mail }&queryName=${name}">删除</a>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td><a class="find"
                                       href="updateUser.j?flag=using&mail=${user.mail }&queryMail=${mail}&queryName=${name}">启用</a>&nbsp;|&nbsp;<a
                                        class="find"
                                        href="deleteUserInfo.j?mail=${user.mail }&queryMail=${mail }&queryName=${name}">删除</a>
                                </td>
                            </c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="bankAliasListPager paginator"></div>
        </div>
    </div>
    <!-- end用户列表页 -->
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
