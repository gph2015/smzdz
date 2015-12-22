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

<jsp:include page="../../common/head.jsp"></jsp:include>
<div id="rightContent">
    <div>当前位置:<span class="pageLocation">运营系统->用户管理</span></div>
    <div class="pageTitle">添加用户</div>
    <!-- start添加新用户页 -->
    <form id="addUserForm" action="addUser.j" method="post">
        <div id="addNewUser" style="display: block">
            <ul class="addNewUserUl pageUl">
                <li>
                    <span class="labelName">姓名：</span>
                    <input type="text" name="name" value="" class="userText"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <li>
                    <span class="labelName">邮箱：</span>
                    <input type="text" name="mail" value="" class="userText"/>
                    <span class="require">*</span>
                    <span class="point">请填写必填项</span>
                </li>
                <li>
                    <span class="labelName">部门：</span>
                    <select name="appId" data-placeholder="请选择..." class="chosen_select150">
                        <c:forEach items="${appMap}" var="entry">
                            <option value="${entry.key}">${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
                <li>
                    <span class="labelName">类型：</span>
                    <select name="type" data-placeholder="请选择..." class="chosen_select150">
                        <c:forEach items="${typeMap}" var="entry">
                            <option value="${entry.key}">${entry.value}</option>
                        </c:forEach>
                    </select>
                    <span class="require">*</span>
                </li>
            </ul>
            <div class="op">
                <input type="button" value="提交" class="save btn70_1" id="userSave"
                       onclick="check()"/>
                <input type="button" class="cancel btn70_2" value="取消" onclick="cancel()">
            </div>
            <!-- end添加新用户页 -->
        </div>
    </form>
</div>
</div>
</body>

<jsp:include page="../../common/foot.jsp"></jsp:include>
<script>
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
    function check() {
        var errorInfo = '';
        var emptyArr = Array();
        var flag = true;
        $("#addUserForm").find(".userText").each(function () {
            if ($(this).val() == "") {
                $(this).siblings(".point").css("display", "inline-block");
                emptyArr.push($(this));
            }
            else {
                $(this).siblings(".point").css("display", "none");
            }
        });
        flag = !emptyArr.length ? 1 : 0;
        if (flag) {
            //alert("提交成功");
            $("#addUserForm").submit();
        } else {
            //alert('False');
        }

    }
</script>
</html>