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
    <div class="pageTitle">代付单列表</div>

    <div id="home">
    </div>

    <!-- start交易列表页 -->
    <div id="transactionList" style="display: block">
        <form action="${ctx}/transfer/transferList.j" method="post" id="queryForm" refreshId="list-page"
              class="ajaxfrm">
            <ul class="productListUl pageUl">
                <li>
                    <span class="labelName">批次单号：</span>
                    <input class="key" type="text" name="f[batchNo]" value="${pager.f.batchNo}"/>
                </li>
                <li>
                    <span class="labelName">付款单号：</span>
                    <input class="key" type="text" name="f[outRef]" value="${pager.f.outRef}"/>
                </li>
                <div class="clear"></div>
                <li>
                    <span class="labelName">支付状态：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="f[payStatus]">
                        <option value="0">请选择</option>
                        <c:forEach items="${payMap}" var="entry">
                            <option value="${entry.key}" <c:if
                                    test="${entry.key ==pager.f.payStatus }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                </li>
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

                <li class="op op1">
                    <span class="select btn100" onclick="doSubmit();">查询</span>
                </li>
            </ul>

            <div class="clear"></div>
            <div class="tableWrap table1">
                <table class="tableList">
                    <tr>
                        <th nowrap="nowrap">序号</th>
                        <th nowrap="nowrap">接入产品</th>
                        <th nowrap="nowrap">批次号</th>
                        <th nowrap="nowrap">付款单号</th>
                        <th nowrap="nowrap">收款方银行账号</th>
                        <th nowrap="nowrap">收款方真实姓名</th>
                        <th nowrap="nowrap">付款金额</th>
                        <th nowrap="nowrap">手续费</th>
                        <th nowrap="nowrap">他行开户行</th>
                        <th nowrap="nowrap">他行开户地</th>
                        <th nowrap="nowrap">结果描述</th>
                        <th nowrap="nowrap">支付状态</th>
                        <th nowrap="nowrap">创建时间</th>

                    </tr>
                    <c:forEach items="${resultList}" var="item" varStatus="xh">
                        <tr>
                            <td nowrap="nowrap">${(pager.pageNo-1) * pager.pageRows + xh.count}</td>
                            <td nowrap="nowrap">${appMap[item.appId]}</td>
                            <td nowrap="nowrap">${item.batchNo}</td>
                            <td nowrap="nowrap">${item.outRef}</td>
                            <td nowrap="nowrap">${item.recBankacc}</td>
                            <td nowrap="nowrap">${item.recName}</td>
                            <td nowrap="nowrap">${item.payAmt}</td>
                            <td nowrap="nowrap">${item.fee}</td>
                            <td nowrap="nowrap">${item.otherBank}</td>
                            <td nowrap="nowrap">${item.otherCity}</td>
                            <td nowrap="nowrap">${item.resultDesc}</td>
                            <td nowrap="nowrap">${payMap[item.payStatus]}</td>
                            <td nowrap="nowrap"><fmt:formatDate value="${item.createTime}"
                                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
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

        renderpage(".transactionListPager", "${ctx}/transfer/transferList.j?${pager.fullUrl}", ${pager.pageNo}, ${pager.totalPages});

    });
</script>

</html>
