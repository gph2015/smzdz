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

    <link rel="stylesheet" type="text/css" href="../static/c/reset.css">
    <link rel="stylesheet" href="../static/c/main.css">
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
        <!-- .breadcrumb -->

        <div class="nav-search" id="nav-search">
            <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off"/>
									<i class="icon-search nav-search-icon"></i>
								</span>
            </form>
        </div>
        <!-- #nav-search -->
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <div class="table-header">
                    产品列表
                </div>
                <div class="space-4"></div>
                <div class="space-4"></div>
                <!-- start 产品列表页 -->
                <form class="form-horizontal" id="queryForm" action="routerList.j" method="post">

                    <div class="form-group">
                        <span class="col-sm-3 control-label no-padding-right"> 银行简称：    </span>&nbsp;&nbsp;
                        <input name="f[channelName]" type="text" value="${pager.f.channelName }"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <span class="labelName">银行卡类型：</span>
                        <select name="f[bankCardType]" data-placeholder="请选择..." class="chosen_select110">
                            <option value="">全部</option>
                            <c:forEach items="${bankCardTypeMap}" var="entry">
                                <option value="${entry.key}" <c:if
                                        test="${pager.f.bankCardType==entity.key }"> selected</c:if>>${entry.value}</option>
                            </c:forEach>
                        </select>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <span class="labelName">接入产品：</span>
                        <select name="f[appId]" data-placeholder="请选择..." class="chosen_select110">
                            <option value="">全部</option>
                            <c:forEach var="app" items="${appList }">
                                <option value="${app.appId }"
                                        <c:if test="${pager.f.appId==app.appId }">selected</c:if>>${app.appName }</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">
                            <button class="btn" type="reset">
                                <i class="icon-undo bigger-110"></i>
                                重置
                            </button>
                            &nbsp; &nbsp; &nbsp;
                            <button class="btn btn-info" type="button" onclick="onSubmit();">
                                <i class="icon-ok bigger-110"></i>
                                查询
                            </button>
                            &nbsp; &nbsp; &nbsp;
                            <button class="btn btn-info" type="button" onclick="add();">
                                <i class="icon-ok bigger-110"></i>
                                新增
                            </button>

                        </div>
                    </div>
                </form>
                <div class="tableWrap table1">
                    <%--<table class="tableList">--%>
                    <%--<div class="table-responsive">--%>
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>银行名称</th>
                            <th>接入产品</th>
                            <th>银行卡类型</th>
                            <th>机构编码</th>
                            <th>机构名称</th>
                            <th>比例</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="router" items="${routerList }">
                        <c:forEach var="agency" items="${router.routerList }" varStatus="status">
                        <tr>
                            <c:if test="${status.index == 0 }">
                                <td rowspan="${fn:length(router.routerList) }">${router.bankName }</td>
                                <td rowspan="${fn:length(router.routerList) }">${router.appName }</td>
                                <td rowspan="${fn:length(router.routerList) }">${router.bankCardTypeStr }</td>
                            </c:if>
                            <td>${agency.agencyCode }</td>
                            <td>${agency.agencyName }</td>
                            <td>${agency.scale }</td>
                            <td>${agency.statusStr }</td>
                            <c:if test="${status.index == 0 }">
                                <td rowspan="${fn:length(router.routerList) }"><a class="edit"
                                                                                  href="showRouter.j?bankCode=${router.bankCode}&appId=${router.appId}&bankCardType=${router.bankCardType}">编辑</a>
                                </td>
                            </c:if>
                        </tr>
                        </c:forEach>
                        </c:forEach>
                    </table>
                        <div class="transactionListPager paginator" style="width:900px; padding-right:350px"></div>
                    </tbody>

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../static/j/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../static/3rd/chosen/chosen.jquery.min.js"></script>
<script src="../static/j/paginator.js"></script>
<script type="text/javascript" src="../static/j/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="../static/j/validate.pack.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='../assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='../assets/js/jquery-1.10.2.min.js'>" + "<" + "/script>");
</script>
<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/typeahead-bs2.min.js"></script>
<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="../assets/js/ace-elements.min.js"></script>
<script src="../assets/js/ace.min.js"></script>
<script type="text/javascript">
    function onSubmit() {
        $("#queryForm").submit();
    }

    function add() {
        window.location.href = "toAddRouter.j";
    }
    $(function ($) {
        renderpage(".transactionListPager", "routerList.j?${pager.fullUrl}", ${pager.pageNo}, ${pager.totalPages});

    });
    jQuery(function ($) {
        var oTable1 = $('#sample-table-2').dataTable({
            "aoColumns": [
                {"bSortable": false},
                null, null, null, null, null,
                {"bSortable": false}
            ]
        });
        $('table th input:checkbox').on('click', function () {
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function () {
                        this.checked = that.checked;
                        $(this).closest('tr').toggleClass('selected');
                    });

        });
        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            var w2 = $source.width();
            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }
    })
</script>
</body>
</html>
