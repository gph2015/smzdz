<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/23
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../static/c/reset.css">
    <link rel="stylesheet" type="text/css" href="../static/c/main.css">
    <link rel="stylesheet" type="text/css" href="../static/3rd/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="../static/3rd/chosen/chosen.css">
    <link rel="stylesheet" type="text/css" href="../static/3rd/jqueryui/jquery-ui.min.css">
</head>
<body>

<%@ include file="../common/head.jsp" %>
<div id="rightContent">
    <div>当前位置:<span class="pageLocation">运营系统->交易管理-></span></div>
    <div class="pageTitle">交易列表</div>

    <div id="home">
    </div>

    <!-- start交易列表页 -->
    <div id="transactionList" style="display: block">
        <form action="${ctx}/trans/transList.j" method="post" id="queryForm" refreshId="list-page" class="ajaxfrm">
            <ul class="productListUl pageUl">

                <li>
                    <span class="labelName">账号：</span>
                    <input class="key" type="text" name="f[buyHomeAccount]" value="${pager.f.buyHomeAccount}"/>
                </li>
                <li>
                    <span class="labelName">订单号：</span>
                    <input class="key" type="text" name="f[orderId]" value="${pager.f.orderId}"/>
                </li>
                <li>
                    <span class="labelName">支付单号：</span>
                    <input class="key" type="text" name="f[payId]" value="${pager.f.payId}"/>
                </li>

                <div class="clear"></div>

                <%--<li>--%>
                <%--<span class="labelName">接入产品：</span>--%>
                <%--<select  data-placeholder="请选择..." class="chosen_select110" name="f[appId]" value="${pager.f.appId}">--%>
                <%--<option value="0" >请选择</option>--%>
                <%--<c:forEach items="${appMap}" var="entry">--%>
                <%--<option value="${entry.key}"  <c:if test="${pager.f.appId==entry.key }">selected</c:if>>${entry.value}</option>--%>
                <%--</c:forEach>--%>
                <%--</select>--%>
                <%--</li>--%>

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
                    <span class="labelName">接入平台：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="f[accessPlatform]">
                        <option value="0">请选择</option>
                        <c:forEach items="${accessplatMap}" var="accessplat">
                            <option value="${accessplat.key}" <c:if
                                    test="${accessplat.key ==pager.f.accessPlatform }"> selected</c:if>>${accessplat.value}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <span class="labelName">支付渠道：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="f[channelCode]">
                        <option value="">请选择</option>
                        <c:forEach items="${channelMap}" var="channel">
                            <option value="${channel.key}" <c:if
                                    test="${channel.key ==pager.f.channelCode }"> selected</c:if>>${channel.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <li>
                    <span class="labelName">状态：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="f[status]">
                        <option value="0">请选择</option>
                        <c:forEach items="${statusMap}" var="entry">
                            <option value="${entry.key}" <c:if
                                    test="${entry.key ==pager.f.status }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <div class="clear"></div>

                <li>
                    <span class="labelName">交易完成时间：</span>
                    <input type="text" class="datepicker datepickerStart" value="${pager.f.startDate}"
                           name="f[startDate]" id="startDate"/>
                    <span class="labelDatepickerEnd labelName" style="width:auto"> 至</span>
                    <input type="text" class="datepicker datepickerEnd" value="${pager.f.endDate}" name="f[endDate]"
                           id="endDate"/>
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
                        <th nowrap="nowrap">支付单号</th>
                        <th nowrap="nowrap">订单号</th>
                        <th nowrap="nowrap">账号</th>
                        <th nowrap="nowrap">接入产品</th>
                        <th nowrap="nowrap">支付渠道</th>
                        <th nowrap="nowrap">金额</th>
                        <th nowrap="nowrap">已退款金额</th>
                        <th nowrap="nowrap">接入平台</th>
                        <th nowrap="nowrap">状态</th>
                        <th nowrap="nowrap">订单生成时间</th>
                        <th nowrap="nowrap">交易完成时间</th>
                        <th nowrap="nowrap">操作</th>
                    </tr>
                    <c:forEach items="${resultList}" var="item" varStatus="xh">
                        <tr>
                            <td nowrap="nowrap">${(pager.pageNo-1) * pager.pageRows + xh.count}</td>
                            <td nowrap="nowrap">${item.payId}</td>
                            <td nowrap="nowrap">${item.orderId}</td>
                            <td nowrap="nowrap">${item.buyHomeAccount}</td>
                            <td nowrap="nowrap">${appMap[item.appId]}</td>
                            <td nowrap="nowrap">${channelMap[item.channelCode]}</td>
                            <td nowrap="nowrap"><fmt:formatNumber value="${item.orderMoney}" pattern="#,##0.00#"/></td>
                            <td nowrap="nowrap"><fmt:formatNumber value="${item.refundMoney}" pattern="#,##0.00#"/></td>
                            <td nowrap="nowrap">${accessplatMap[item.accessPlatForm]}</td>
                            <td nowrap="nowrap">${statusMap[item.payOrderStatus]}</td>
                            <td nowrap="nowrap"><fmt:formatDate value="${item.orderCreateTime}"
                                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td nowrap="nowrap"><fmt:formatDate value="${item.paySuccessTime}"
                                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td nowrap="nowrap"><a href="${ctx}/trans/transDetail.j?payId=${item.payId}">详情</a></td>
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
        var startDate = $("#startDate").val().replace(/-/g, "/");
        var endDate = $("#endDate").val().replace(/-/g, "/");

        //开始日期不能小于结束日期
        if (startDate > endDate) {
            alert("起始日期不能晚于结束日期")
            return false;
        }
//        if(dateDiff(endDate,startDate)>30){
//            alert("日范围不要超过30天");
//            return false;
//        }
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

        renderpage(".transactionListPager", "${ctx}/trans/transList.j?${pager.fullUrl}", ${pager.pageNo}, ${pager.totalPages});

    });
</script>

</html>
