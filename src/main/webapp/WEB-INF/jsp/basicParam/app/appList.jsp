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
        <!-- /.page-header -->

        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <div class="row">
                    <div class="col-xs-12">
                        <div class="table-header">
                            产品列表
                        </div>
                        <div class="space-4"></div>
                        <div class="space-4"></div>
                        <form class="form-horizontal" id="queryForm" action="getAppList.j" method="post">
                            <div class="form-group">
                                <span class="col-sm-3 control-label no-padding-right"> 产品名称    </span>&nbsp;&nbsp;
                                <input name="appName" type="text" value="${appName }"/>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="labelName">所属公司：</span>
                                <select name="belongCompany" data-placeholder="请选择..." class="chosen_select110">
                                    <option value="">全部</option>
                                    <c:forEach items="${companyMap}" var="entry">
                                        <option value="${entry.key}" <c:if
                                                test="${entry.key==belongCompany }"> selected</c:if>>${entry.value}</option>
                                    </c:forEach>
                                </select>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="labelName">接入状态：</span>
                                <select name="status" data-placeholder="请选择..." class="chosen_select110">
                                    <option value="">全部</option>
                                    <c:forEach items="${statusMap}" var="entry">
                                        <option value="${entry.key}" <c:if
                                                test="${entry.key ==status }"> selected</c:if>>${entry.value}</option>
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
                        <div class="table-responsive">
                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>产品ID</th>
                                    <th>产品名称</th>
                                    <th>所属公司</th>
                                    <th>接入状态</th>
                                    <th>接入时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="app" items="${appList }">
                                    <tr>
                                        <input type="hidden" name="id" value="app.id">
                                        <td>${app.appId }</td>
                                        <td>${app.appName }</td>
                                        <td>${app.companyName }</td>
                                        <td>${app.statusStr}</td>
                                        <td>${app.createTimeStr }</td>
                                        <td>
                                            <a href="showApp.j?flag=detail&id=${app.id }"><i
                                                    class="icon-arrow-right"></i> 详情</a>&nbsp;|&nbsp;<a
                                                class="edit" href="showApp.j?flag=update&id=${app.id }"><i
                                                class="icon-edit bigger-120"></i>修改</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="../assets/js/jquery.min.js"></script>
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
        window.location.href = "addApp.j";
    }
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
