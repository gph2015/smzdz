<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/25
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ include file="../common/taglibs.jsp"%>
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

<%@ include file="../common/head.jsp"%>
    <div id="rightContent">
        <div>当前位置:<span class="pageLocation">运营系统->对账管理-></span></div>
        <div class="pageTitle">对账列表</div>

        <div id="home">
        </div>

        <!-- start对账结果列表页 -->
        <div id="transactionList" style="display: block">
            <form action="payCheck.j" method="post" id ="queryForm"  refreshId="list-page"  class="ajaxfrm" >
                <ul class="productListUl pageUl">
                    <li>
                        <span class="labelName labelName">对账日期：</span>
                        <input type="text" class="datepicker datepickerStart"  value="${checkDate}" name="checkDate"/>
                    </li>
                    <li>
                        <span class="labelName">支付机构：</span>
                        <select data-placeholder="请选择..." class="chosen_select110"  name="agencyCode" >
                            <option value="">请选择</option>
                            <c:forEach items="${agencyInfoMap}" var="agency">
                                <option value="${agency.key}"  <c:if test="${agency.key==agencyCode }">selected</c:if>>${agency.value}</option>
                            </c:forEach>
                        </select>
                    </li>



                    <li>
                        <span class="labelName">对账类型：</span>
                        <select data-placeholder="请选择..." class="chosen_select110"  name="bizCode" >
                            <option value="" >请选择</option>
                            <c:forEach items="${checkTypeMap}" var="checkType">
                                <option value="${checkType.key}" <c:if test="${checkType.key ==bizCode}"> selected</c:if>>${checkType.value}</option>
                            </c:forEach>
                        </select>
                    </li>

                    <li>
                        <span class="labelName">状态：</span>
                        <select data-placeholder="请选择..." class="chosen_select110"   name="status" >
                            <option value="" >请选择</option>
                            <c:forEach items="${checkStatusMap}" var="checkStatus">
                                <option value="${checkStatus.key}" <c:if test="${checkStatus.key ==status}"> selected</c:if>>${checkStatus.value}</option>
                            </c:forEach>
                        </select>
                    </li>

                    <div class="clear"></div>

                    <li>
                        <span class="select btn100" onclick="doSubmit();">查询</span>
                    </li>
                </ul>

                <div class="clear"></div>
                <div class="tableWrap">
                    <table class="tableList">
                        <tr>
                            <th nowrap="nowrap">序号</th>
                            <th nowrap="nowrap">对账日期</th>
                            <%--<th nowrap="nowrap">机构编码</th>--%>
                            <th nowrap="nowrap">机构名称</th>
                            <th nowrap="nowrap">对账类型</th>
                            <th nowrap="nowrap">平台总笔数</th>
                            <th nowrap="nowrap">平台总金额</th>
                            <th nowrap="nowrap">对方总笔数</th>
                            <th nowrap="nowrap">对方总金额</th>
                            <th nowrap="nowrap">创建时间</th>
                            <th nowrap="nowrap">状态</th>
                            <th nowrap="nowrap">操作</th>
                        </tr>
                        <c:forEach items="${resultList}" var="item" varStatus="xh">
                            <tr>
                                <td nowrap="nowrap">${xh.count}</td>
                                <td nowrap="nowrap">${item.checkDate}</td>
                                <%--<td nowrap="nowrap">${item.agencyCode}</td>--%>
                                <td nowrap="nowrap">${agencyInfoMap[item.agencyCode]}</td>
                                <td nowrap="nowrap">${checkTypeMap[item.bizCode]}</td>
                                <td nowrap="nowrap">${item.totalNum}</td>
                                <td nowrap="nowrap"><fmt:formatNumber value="${item.totalAmt}" pattern="#,##0.00#"/></td>
                                <td nowrap="nowrap">${item.outTotalNum}</td>
                                <td nowrap="nowrap"><fmt:formatNumber value="${item.outTotalAmt}" pattern="#,##0.00#"/></td>
                                <td nowrap="nowrap"><fmt:formatDate  value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td nowrap="nowrap">${checkStatusMap[item.status]}</td>
                                <td nowrap="nowrap"><c:if test="${item.status==2}"><a href="payCheckDiff.j?f[checkDate]=${item.checkDate}&f[agencyCode]=${item.agencyCode}&f[bizCode]=${item.bizCode}&f[diffType]=0&checkDate=${checkDate}&agencyCode=${agencyCode}&bizCode=${bizCode}&status=${status}">详情</a></c:if></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <%--<div class="transactionListPager paginator"></div>--%>
                </div>
            </form>
        </div>
        <!-- end对账列表页 -->

    </div>
</div>

</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script type="text/javascript">

    function doSubmit(){
        $("#queryForm").submit();
    }
</script>

</html>
