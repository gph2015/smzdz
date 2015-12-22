<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ include file="../../common/taglibs.jsp"%>
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
    <div>当前位置:<span class="pageLocation">运营系统->权限管理</span></div>
    <div class="pageTitle">权限列表</div>
    <!-- start 权限列表页 -->
    <div id="userList" style="display: block">
        <div class="clear"></div>
        <div class="tableWrap table1">
            <table class="tableList">
                <tr>
                    <th>序号</th>
                    <th>父权限</th>
                    <th>一级权限</th>
                    <th>二级权限</th>
                    <th>访问URL</th>
                </tr>
                <c:forEach var="user" items="${authList }" varStatus="xh">
                    <tr>
                        <td>${xh.count}</td>
                        <td>${user.oneName }</td>
                        <td>${user.twoName }</td>
                        <td>${user.threeName }</td>
                        <td>${user.url }</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="bankAliasListPager paginator"></div>
        </div>
    </div>
    <!-- end权限列表页 -->
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
