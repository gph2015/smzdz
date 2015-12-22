<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Bootstrap表格插件 - Bootstrap后台管理系统模版Ace下载</title>
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="../assets/css/ace.min.css"/>
    <link rel="stylesheet" href="../assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="../assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="../assets/css/ace-ie.min.css"/>
    <script src="../assets/js/ace-extra.min.js"></script>
    <script src="../assets/js/html5shiv.js"></script>
    <script src="../assets/js/respond.min.js"></script>
</head>

<body>
<jsp:include page="../../common/head.jsp"></jsp:include>
<!-- /.nav-list -->

<div class="sidebar-collapse" id="sidebar-collapse">
    <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
       data-icon2="icon-double-angle-right"></i>
</div>

<script type="text/javascript">
    try {
        ace.settings.check('sidebar', 'collapsed')
    } catch (e) {
    }
</script>
</div>

<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try {
                ace.settings.check('breadcrumbs', 'fixed')
            } catch (e) {
            }
        </script>

        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">运营中心</a>
            </li>

            <li>
                <a href="#">权限管理</a>
            </li>
            <li class="active">产品管理</li>
        </ul>
        <div class="page-content">
            <div class="table-header">
                新增产品
            </div>
            <div class="space-4"></div>
            <div class="space-4"></div>
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->


                    <!-- start添加新产品页 -->
                    <form class="form-horizontal" id="addForm" action="addSubmit.j" method="post">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 产品名称：</label>

                            <div class="col-sm-9">
                                <input name="appName" type="text" placeholder="产品名称" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 所属公司：</label>

                            <div class="col-sm-9">
                                <select name="company" data-placeholder="请选择...">
                                    <c:forEach items="${companyMap}" var="entry">
                                        <option value="${entry.key}">${entry.value}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 产品ID：</label>

                            <div class="col-sm-9">
                                <input name="appId" type="text" placeholder="产品ID" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 微信公众号：</label>

                            <div class="col-sm-9">
                                <input name="wxServiceNo" type="text" placeholder="微信公众号" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 接入状态：</label>

                            <div class="col-sm-9">
                                <c:forEach items="${statusMap}" var="entry" varStatus="status">
                                    <input type="radio" name="status" value="${entry.key}"
                                           <c:if test="${status.index==0 }">checked</c:if>>
                                    ${entry.value}</input>
                                </c:forEach>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 签名KEY：</label>

                            <div class="col-sm-9">
                                <input name="signKey" type="text" placeholder="签名KEY" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <button class="btn btn-info" type="button" onclick="onSubmit()">
                                    <i class="icon-ok bigger-110"></i>
                                    保存
                                </button>
                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset" onclick="cancel()">
                                    <i class="icon-undo bigger-110"></i>
                                    取消
                                </button>
                            </div>
                        </div>
                    </form>
                    <!-- end添加新产品页 -->
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function onSubmit() {
        var emptyArr = Array();
        var flag = true;
        $("#addForm").find(".userText").each(function () {
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
            $("#addForm").submit();
        } else {
            //alert('False');
        }
    }
    function cancel() {
        window.location.href = "javascript:history.go(-1)";
    }
</script>
<jsp:include page="../../common/foot.jsp"></jsp:include>