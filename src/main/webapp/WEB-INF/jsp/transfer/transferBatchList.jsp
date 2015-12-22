<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ include file="../common/taglibs.jsp" %>
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
<%@ include file="../common/head.jsp" %>
<div id="rightContent">
    <div>当前位置:<span class="pageLocation">运营系统->代付管理-></span></div>
    <div class="pageTitle">付款单审批列表</div>

    <div id="home">
    </div>

    <!-- start交易列表页 -->
    <div id="transactionList" style="display: block">
        <form action="${ctx}/transferBatch/transferBatchList.j" method="post" id="queryForm" refreshId="list-page"
              class="ajaxfrm">
            <ul class="productListUl pageUl">
                <!-- 系统管理员-->
                <c:if test="${user.appId==1000}">
                    <li>
                        <span class="labelName">接入产品：</span>
                        <select data-placeholder="请选择..." class="chosen_select110" name="f[appId]">
                            <option value="0">请选择</option>
                            <c:forEach items="${appMap}" var="entry">
                                <option value="${entry.key}"
                                        <c:if test="${pager.f.appId==entry.key }">selected</c:if>>${entry.value}</option>
                            </c:forEach>
                        </select>
                    </li>
                </c:if>
                <!-- 产品线-->
                <c:if test="${user.appId != 1000}">
                    <li>
                        <span class="labelName">接入产品：</span>
                        <span class="labelName" style="width:auto">${appMap[user.appId]}</span>
                    </li>
                </c:if>
                <li>
                    <span class="labelName">批次号：</span>
                    <input class="key" type="text" name="f[batchNo]" value="${pager.f.batchNo}"/>
                </li>
                <li>
                    <span class="labelName">交易状态：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="f[tradeState]">
                        <option value="0">请选择</option>
                        <c:forEach items="${tradeMap}" var="entry">
                            <option value="${entry.key}" <c:if
                                    test="${entry.key ==pager.f.tradeState }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <div class="clear"></div>

                <li class="op op1">
                    <span class="select btn100" onclick="doSubmit();">查询</span>
                </li>
            </ul>

            <div class="clear"></div>
            <div class="tableWrap table1">
                <table class="tableList">
                    <tr>
                        <th nowrap="nowrap">序号</th>
                        <th nowrap="nowrap">公司名称</th>
                        <th nowrap="nowrap">批次号</th>
                        <th nowrap="nowrap">计划笔数</th>
                        <th nowrap="nowrap">成功笔数</th>
                        <th nowrap="nowrap">计划金额</th>
                        <th nowrap="nowrap">成功金额</th>
                        <th nowrap="nowrap">转出账号</th>
                        <th nowrap="nowrap">交易状态</th>
                        <th nowrap="nowrap">创建时间</th>
                        <th nowrap="nowrap">审批时间</th>
                        <th nowrap="nowrap">审批人</th>
                        <th nowrap="nowrap">操作</th>

                    </tr>
                    <c:forEach items="${resultList}" var="item" varStatus="xh">
                        <tr>
                            <td nowrap="nowrap">${(pager.pageNo-1) * pager.pageRows + xh.count}</td>
                            <td nowrap="nowrap">${item.companyName}</td>
                            <td nowrap="nowrap">${item.batchNo}</td>
                            <td nowrap="nowrap">${item.planTotal}</td>
                            <td nowrap="nowrap">${item.sucTotal}</td>
                            <td nowrap="nowrap">${item.planAmt}</td>
                            <td nowrap="nowrap">${item.sucAmt}</td>
                            <td nowrap="nowrap">${item.dbtAcc}</td>
                            <td nowrap="nowrap">${tradeMap[item.tradeState]}</td>
                            <td nowrap="nowrap"><fmt:formatDate value="${item.createTime}"
                                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td nowrap="nowrap"><fmt:formatDate value="${item.auditTime}"
                                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td nowrap="nowrap">${userMap[item.userId]}</td>


                            <c:choose>
                                <c:when test="${item.tradeState== '1' }">
                                    <td nowrap="nowrap"><a
                                            href="${ctx}/transferBatch/transferBatchDetail.j?batchNo=${item.batchNo}&appId=${item.appId}">详情</a>&nbsp;|&nbsp;<a
                                            href="${ctx}/transferBatch/transferBatchReview.j?batchNo=${item.batchNo}&appId=${item.appId}">审批</a>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td nowrap="nowrap"><a
                                            href="${ctx}/transferBatch/transferBatchDetail.j?batchNo=${item.batchNo}&appId=${item.appId}">详情</a>
                                    </td>
                                </c:otherwise>
                            </c:choose>

                        </tr>
                    </c:forEach>
                </table>
                <div class="transactionListPager paginator"></div>
            </div>
        </form>
    </div>
    <!-- end交易列表页 -->

</div>
</div>

</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script type="text/javascript">

    function doSubmit() {
        //当前时间的秒数和输入框秒数
        $("#queryForm").submit();
    }
    function dateDiff(endDate, startDate) {
        var objDate1, objDate2, intDays;
        objDate1 = new Date(endDate);
        objDate2 = new Date(startDate);
        intDays = parseInt(Math.abs(objDate1 - objDate2) / 1000 / 60 / 60 / 24);
        return intDays;
    }


    $(function ($) {

        renderpage(".transactionListPager", "${ctx}/transferBatch/transferBatchList.j?${pager.fullUrl}", ${pager.pageNo}, ${pager.totalPages});

    });
</script>

</html>
