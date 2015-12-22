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
    <div>当前位置:<span class="pageLocation">运营系统->菜单管理->修改菜单</span></div>
    <div class="pageTitle">修改菜单</div>
    <!-- start添加新菜单页 -->
    <form id="updateForm" action="updateSubmit.j" method="post">
        <div id="addNewProduct" style="display: block">
            <ul class="addNewProductUl pageUl">
                <li>
                    <span class="labelName">父菜单：</span>
                    <select name="parent" data-placeholder="请选择..." class="chosen_select150">
                        <c:forEach items="${twoMenuMap}" var="entry">
                            <option value="${entry.key}"<c:if
                                    test="${entry.key==menu.menuName }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">菜单名称：</span>
                    <input name="name" maxlength="30" type="text" value="${menu.name }"> </input>
                    <span class="require">*</span>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">url：</span>
                    <input name="url" value="${menu.url }"/>
                    <span class="require">*</span>
                </li>
            </ul>
            <div class="clear"></div>
            <div class="op">
                <input type="button" class="save btn70_1" value="保存" onclick="updateSubmit()">
                <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
            </div>
        </div>
    </form>
    <!-- end添加新菜单页 -->
</div>
</div>
</body>
</html>
<script>
    function updateSubmit() {
        $("#updateForm").submit();
    }
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
</script>
<jsp:include page="../../common/foot.jsp"></jsp:include>