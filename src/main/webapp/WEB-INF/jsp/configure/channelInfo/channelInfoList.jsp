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
    <div>当前位置:<span class="pageLocation">运营系统->支付渠道管理</span></div>
    <div class="pageTitle">支付渠道列表</div>

    <!-- start 支付渠道列表页 -->
    <div id="productList" style="display: block">
        <form action="query.j" method="post" id="queryForm" refreshId="list-page"
              class="ajaxfrm">
            <ul class="productListUl pageUl">
                <li>
                    <span class="labelName">支付渠道名称</span>
                    <input class="key" type="text" name="f[channelName]"
                           value="${pager.f.channelName}"/>
                </li>
                <li><span class="labelName">渠道类型：</span>
                    <select data-placeholder="请选择..." class="chosen_select110"
                            name="f[channelType]"
                            value="${pager.f.channelType}">
                        <option value="0"
                                <c:if test="${pager.f.channelType==0 }">selected="true"</c:if>>
                            请选择
                        </option>
                        <c:forEach items="${channelTypeMap}" var="entry">
                            <option value="${entry.key}" <c:if
                                    test="${entry.key== pager.f.channelType }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <li>
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
                    <th>支付渠道名称</th>
                    <th>渠道简称</th>
                    <th>渠道性质</th>
                    <th>渠道类型</th>
                    <th>最低限额</th>
                    <th>最高限额</th>
                    <th>创建时间</th>
                    <th>操作</th>

                </tr>
                <c:forEach items="${channelInfoList}" var="item" varStatus="xh">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.channelName}</td>
                        <td>${item.channelCode}</td>
                        <td>${item.channelTypeStr}</td>
                        <td>${item.channelNatureStr}</td>
                        <td>${item.lowLimit}</td>
                        <td>${item.highLimit}</td>
                        <td>${item.createTimeStr }</td>
                        <td><a
                                href="showChannelInfo.j?flag=detail&id=${item.id }">查看</a> |
                            <a
                                    href="showChannelInfo.j?flag=update&id=${item.id }">修改</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="channelListPager paginator" style="width:500px; padding-right:350px"></div>
        </div>

    </div>
    <!-- end支付渠道列表页 -->
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
    function doAdd() {
        window.location.href = "toAdd.j";
    }
    $(function ($) {

        renderpage(".channelListPager", "query.j?${pager.fullUrl}", ${pager.pageNo},
                ${pager.totalPages});

    });
</script>

</html>




