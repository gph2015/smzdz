<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/30
  Time: 13:59
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
    <link rel="stylesheet" href="../static/c/main.css">
    <link rel="stylesheet" href="../static/3rd/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="../static/3rd/chosen/chosen.css">
    <link rel="stylesheet" href="../static/3rd/jqueryui/jquery-ui.min.css">
</head>
<body>

<%@ include file="../common/head.jsp" %>
<div id="rightContent">
    <div>当前位置:<span class="pageLocation">运营系统->报表管理-></span></div>
    <div class="pageTitle">收支报表</div>

    <!-- start交易列表页 -->
    <div id="transactionList" style="display: block">
        <form action="${ctx}/report/reportList.j" method="post" id="queryForm" refreshId="list-page" class="ajaxfrm">
            <ul class="productListUl pageUl">

                <li>
                    <span class="labelName">流水号：</span>
                    <input class="key" type="text"  name="f[instructId]" value="${pager.f.instructId}"/>
                </li>

                <li>
                    <span class="labelName">支付机构：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="f[agencyCode]">
                        <option value="">请选择</option>
                        <c:forEach items="${agencyMap}" var="entry">
                            <option value="${entry.key}" <c:if test="${entry.key ==pager.f.agencyCode }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <li>
                    <span class="labelName">业务类型：</span>
                    <select data-placeholder="请选择..." class="chosen_select110" name="f[bizCode]">
                        <option value="0">请选择</option>
                        <c:forEach items="${bizTypeMap}" var="entry">
                            <option value="${entry.key}" <c:if test="${entry.key ==pager.f.bizCode }"> selected</c:if>>${entry.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <li>
                    <span class="labelName labelName">交易时间：</span>
                    <input type="text" class="datepicker datepickerStart" value="${pager.f.startDate}"
                           name="f[startDate]" id="startDate"/>
                    <span class="labelDatepickerEnd labelName" style="width: 12px">至</span>
                    <input type="text" class="datepicker datepickerEnd" value="${pager.f.endDate}" name="f[endDate]" id="endDate"/>
                </li>

                <div class="clear"></div>

                <li>
                    <span class="select btn100" onclick="doSubmit();">查询</span>
                    <span class="select btn100" onclick="doExport();">导出</span>
                </li>

                <div class="clear"></div>

                <li><span class="labelName">交易总笔数：</span><span class="value">${pager.totalCount}</span></li>

                <c:if test="${0 ==pager.f.bizCode}">
                    <li><span class="labelName">支付总金额：</span><span class="value"><fmt:formatNumber value="${totalPayAmt}" pattern="#,##0.00"/></span></li>
                    <li><span class="labelName">退款总金额：</span><span class="value"><fmt:formatNumber value="${totalRefundAmt}" pattern="#,##0.00"/></span></li>
                    <li><span class="labelName">手续费支出：</span><span class="value"><fmt:formatNumber value="${totalPayFee}" pattern="#,##0.00"/></span></li>
                    <li><span class="labelName">手续费退还：</span><span class="value"><fmt:formatNumber value="${totalRefundFee}" pattern="#,##0.00"/></span></li>
                    <li><span class="labelName">入账金额合计：</span><span class="value"><fmt:formatNumber value="${totalIncome}" pattern="#,##0.00"/></span></li>
                </c:if>

                <c:if test="${1 ==pager.f.bizCode}">
                    <li><span class="labelName">支付总金额：</span><span class="value"><fmt:formatNumber value="${totalPayAmt}" pattern="#,##0.00"/></span></li>
                    <li><span class="labelName">手续费支出：</span><span class="value"><fmt:formatNumber value="${totalPayFee}" pattern="#,##0.00"/></span></li>
                </c:if>

                <c:if test="${3==pager.f.bizCode}">
                    <li><span class="labelName">退款总金额：</span><span class="value"><fmt:formatNumber value="${totalRefundAmt}" pattern="#,##0.00"/></span></li>
                    <li><span class="labelName">手续费退还：</span><span class="value"><fmt:formatNumber value="${totalRefundFee}" pattern="#,##0.00"/></span></li>
                </c:if>

            </ul>

            <div class="clear"></div>
            <div class="tableWrap">
                <table class="tableList">
                    <tr>
                        <th nowrap="nowrap">序号</th>
                        <th nowrap="nowrap">类型</th>
                        <th nowrap="nowrap">流水号</th>
                        <th nowrap="nowrap">支付机构</th>
                        <th nowrap="nowrap">付款方式</th>
                        <th nowrap="nowrap">支付渠道</th>
                        <th nowrap="nowrap">交易金额</th>
                        <th nowrap="nowrap">费率</th>
                        <th nowrap="nowrap">手续费</th>
                        <th nowrap="nowrap">交易完成时间</th>
                    </tr>
                    <c:forEach items="${resultList}" var="item" varStatus="xh">
                        <tr>
                            <td nowrap="nowrap">${(pager.pageNo-1) * pager.pageRows + xh.count}</td>
                            <td nowrap="nowrap">${bizTypeMap[item.bizCode]}</td>
                            <td nowrap="nowrap">${item.instructId}</td>
                            <td nowrap="nowrap">${agencyMap[item.agencyCode]}</td>
                            <td nowrap="nowrap">${payTypeMap[item.payType]}</td>
                            <td nowrap="nowrap">${channelMap[item.bankCode]}</td>
                            <td nowrap="nowrap"><fmt:formatNumber type="currency" value="${item.bizAmt}" pattern="#,##0.00#"/></td>
                            <td nowrap="nowrap"><fmt:formatNumber type="percent"   maxFractionDigits="3" value="${item.feeRate}" /></td>
                            <td nowrap="nowrap">
                                <fmt:formatNumber value="${item.commissionFeeAmt}" pattern="#,##0.00000"/>
                            </td>
                            <td nowrap="nowrap"><fmt:formatDate value="${item.outTransTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
    //表单提交
    function doSubmit(){
        //当前时间的秒数和输入框秒数
        var startDate = $("#startDate").val().replace(/-/g,"/");
        var endDate = $("#endDate").val().replace(/-/g,"/");

        //开始日期不能小于结束日期
        if(startDate>endDate){
            alert("起始日期不能晚于结束日期")
            return false;
        }
//        if(dateDiff(endDate,startDate)>30){
//            alert("日范围不要超过30天");
//            return false;
//        }
        $("#queryForm").submit();
    }
    function dateDiff(endDate,startDate){
        var objDate1,objDate2,intDays;
        objDate1=new Date(endDate);
        objDate2=new Date(startDate);
        intDays=parseInt(Math.abs(objDate1-objDate2)/1000/60/60/24);
        return intDays;
    }
    //导出Excel
    function doExport() {
        var size = ${fn:length(resultList)};
        if (size == 0) {
            alert("没有要导出的数据!");
            return false;
        }
        window.location.href = "exportExcel.j?f[agencyCode]=${pager.f.agencyCode}&f[bizCode]=${pager.f.bizCode}&f[startDate]=${pager.f.startDate}&f[endDate]=${pager.f.endDate}";
    }
    //分页js
    $(function ($) {
        renderpage(".transactionListPager", "reportList.j?${pager.fullUrl}", ${pager.pageNo}, ${pager.totalPages});
    });
</script>

</html>