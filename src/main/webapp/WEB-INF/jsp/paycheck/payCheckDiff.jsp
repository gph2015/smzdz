<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/26
  Time: 10:44
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
        <div class="pageTitle">对账差异</div>

        <div id="home">
        </div>

        <!-- start对账结果列表页 -->
        <div id="transactionList" style="display: block">
            <form action="payCheckDiff.j" method="post" id ="queryForm"  >
                <input type="hidden" name="f[checkDate]" value="${pager.f.checkDate}"/>
                <input type="hidden" name="f[agencyCode]" value="${pager.f.agencyCode}"/>
                <input type="hidden" name="f[bizCode]" value="${pager.f.bizCode}"/>
                <!-- 返回 使用 start-->
                <input type="hidden" name="checkDate" value="${checkDate}"/>
                <input type="hidden" name="agencyCode" value="${agencyCode}"/>
                <input type="hidden" name="bizCode" value="${bizCode}"/>
                <input type="hidden" name="status" value="${status}"/>
                <!-- 返回 使用 end-->
                <ul class="productListUl pageUl">
                    <li><span class="labelName">对账机构：</span><span class="value">${pager.f.agencyCode}</span></li>
                    <li><span class="labelName">差异总比数：</span><span class="value">${diffMap['total_count']}</span></li>
                    <li><span class="labelName">平台总金额：</span><span class="value"><fmt:formatNumber value="${diffMap['total_amt']}" pattern="#,##0.00#"/></span></li>
                    <li><span class="labelName">机构总金额：</span><span class="value"><fmt:formatNumber value="${diffMap['out_biz_amt']}" pattern="#,##0.00#"/></span></li>

                    <%--<input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">--%>

                    <div class="clear"></div>

                    <li>
                        <span class="labelName">差异类型：</span>
                        <select data-placeholder="请选择..." class="chosen_select110"   name="f[diffType]" >
                            <option value="" >请选择</option>
                            <c:forEach items="${checkDiffTypeMap}" var="checkDiffType">
                                <option value="${checkDiffType.key}" <c:if test="${checkDiffType.key ==pager.f.diffType}"> selected</c:if>>${checkDiffType.value}</option>
                            </c:forEach>
                        </select>
                    </li>
                        <span class="select btn100" onclick="doSubmit();">查询</span>
                    </li>

                </ul>

                <div class="clear"></div>
                <div class="tableWrap">
                    <table class="tableList">
                        <tr>
                            <th nowrap="nowrap">序号</th>
                            <th nowrap="nowrap">平台流水号</th>
                            <th nowrap="nowrap">机构流水号</th>
                            <th nowrap="nowrap">平台金额</th>
                            <th nowrap="nowrap">机构金额</th>
                            <th nowrap="nowrap">交易时间</th>
                            <th nowrap="nowrap">差异类型</th>
                            <th nowrap="nowrap">操作</th>
                        </tr>

                        <c:forEach items="${resultList}" var="payCheckDiffModel" varStatus="xh">
                            <tr>
                                <td nowrap="nowrap">${(pager.pageNo-1) * pager.pageRows + xh.count}</td>
                                <td nowrap="nowrap">${payCheckDiffModel.instructId}</td>
                                <td nowrap="nowrap">${payCheckDiffModel.outOrderId}</td>
                                <td nowrap="nowrap"><fmt:formatNumber value="${payCheckDiffModel.bizAmt}" pattern="#,##0.00"/></td>
                                <td nowrap="nowrap"><fmt:formatNumber value="${payCheckDiffModel.outBizAmt}" pattern="#,##0.00"/></td>
                                <td nowrap="nowrap"><fmt:formatDate  value="${payCheckDiffModel.outTransTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td nowrap="nowrap">${checkDiffTypeMap[payCheckDiffModel.diffType]}</td>
                                <td nowrap="nowrap">
                                    <c:if test="${payCheckDiffModel.handleStatus==0}">
                                        <a href="toDiffProcess.j?id=${payCheckDiffModel.id}&f[checkDate]=${pager.f.checkDate}&f[agencyCode]=${pager.f.agencyCode}&f[bizCode]=${pager.f.bizCode}&f[diffType]=0">处理</a>
                                    </c:if>
                                    <c:if test="${payCheckDiffModel.handleStatus==1}">
                                       已处理
                                    </c:if>
                                        <%--<a href="toDiffProcess.j?id=${payCheckDiffModel.id}&f[checkDate]=${pager.f.checkDate}&f[agencyCode]=${pager.f.agencyCode}&f[bizCode]=${pager.f.bizCode}&f[diffType]=0">处理</a>--%>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="transactionListPager paginator"></div>
                </div>
            </form>
        </div>
        <!-- end对账列表页 -->
        <%--<input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">--%>
    </div>
</div>

</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script type="text/javascript">

    function doSubmit(){
        $("#queryForm").submit();
    }
    function cancel(){
//        window.location.href="javascript:history.go(-1)";

        window.location.href="payCheck.j?checkDate=${checkDate}&agencyCode=${agencyCode}&bizCode=${bizCode}&status=${status}"
    }
    $(function($){
        renderpage(".transactionListPager","payCheckDiff.j?${pager.fullUrl}",${pager.pageNo},${pager.totalPages});
    });
</script>

</html>

