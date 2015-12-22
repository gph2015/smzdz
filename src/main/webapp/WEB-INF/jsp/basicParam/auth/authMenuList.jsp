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
    <div>当前位置:<span class="pageLocation">运营系统->机构路由管理->更新路由配置</span></div>
    <div class="pageTitle">更新路由配置</div>
    <!-- start添加新产品页 -->
    <form id="updateAuthForm" action="updateAuthForm.j?userId=${userId}" method="post">
        <div id="conManageReset" style="display: block">
            <div class="tableWrap">
                <table class="tableList">
                    <tr>
                        <th>序号</th>
                        <th>父权限</th>
                        <th>一级权限</th>
                        <th>二级权限</th>
                        <th>访问URL</th>
                        <th> 是否有此权限</th>
                    </tr>

                    <c:forEach var="user" items="${authList }" varStatus="xh">
                        <tr>
                            <td>${xh.count}</td>
                            <td>${user.oneName }</td>
                            <td>${user.twoName }</td>
                            <td>${user.threeName }</td>
                            <td>${user.url }</td>
                            <%--<c:if test="${user.url !=null}">--%>
                                <td><input name="${user.id }_status" type="radio" value="2"
                                           <c:if test="${user.status == 2 || user.status == null}">checked</c:if>>启用
                                    <input name="${user.id }_status" type="radio" value="1"
                                           <c:if test="${user.status == 1 }">checked</c:if>>禁用
                                </td>
                        </tr>
                    </c:forEach>

                </table>
                <div class="clear"></div>
                <br>
                <input type="button" class="save btn70_1" value="保存" onclick="updateSubmit()">
                <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
            </div>
        </div>
    </form>
    <!-- end添加新产品页 -->
</div>
</body>
<%@ include file="../../common/foot.jsp" %>
<script>
    function updateSubmit() {

        $("#updateAuthForm").submit();
    }
    function doAdd() {
        window.location.href = "toAdd.j";
    }
</script>
</html>
