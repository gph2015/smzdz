<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/3/26
  Time: 13:32
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
        <div class="pageTitle">手续费对账差异</div>

        <div id="home">
        </div>

        <!-- start对账结果列表页 -->
        <div id="transactionList" style="display: block">
            <form action="payCheckFeeDiff.j" method="post" id ="queryForm"  >
                <input type="hidden" name="f[checkDate]" value="${pager.f.checkDate}"/>
                <input type="hidden" name="f[agencyCode]" value="${pager.f.agencyCode}"/>
                <input type="hidden" name="f[bizCode]" value="${pager.f.bizCode}"/>
                <ul class="productListUl pageUl">
                    <li><span class="labelName">对账机构：</span><span class="value">${pager.f.agencyCode}</span></li>
                    <li><span class="labelName">差异总比数：</span><span class="value">${diffMap['total_count']}</span></li>
                    <li><span class="labelName">平台总手续费金额：</span><span class="value">${diffMap['total_fee_amt']}</span></li>
                    <li><span class="labelName">对方总手续费金额：</span><span class="value">${diffMap['out_total_fee_amt']}</span></li>
                </ul>

                <input type="button" class="cancel btn70_2" value="返回" onclick="cancel()">

                <div class="clear"></div>
                <div class="tableWrap">
                    <table class="tableList">
                        <tr>
                            <th>序号</th>
                            <th>平台流水号</th>
                            <th>机构流水号</th>
                            <th>平台手续费金额</th>
                            <th>对方手续费金额</th>
                            <th>交易时间</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach items="${resultList}" var="payCheckFeeDiffModel" varStatus="xh">
                            <tr>
                                <td>${(pager.pageNo-1) * pager.pageRows + xh.count}</td>
                                <td>${payCheckFeeDiffModel.instructId}</td>
                                <td>${payCheckFeeDiffModel.outOrderId}</td>
                                <td><fmt:formatNumber value="${payCheckFeeDiffModel.feeAmt}" pattern="#,##0.00000"/></td>
                                <td><fmt:formatNumber value="${payCheckFeeDiffModel.outFeeAmt}" pattern="#,##0.00000"/></td>
                                <td><fmt:formatDate  value="${payCheckFeeDiffModel.outTransTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>
                                    <c:if test="${payCheckFeeDiffModel.handleStatus==0}">
                                        <a href="toFeeDiffProcess.j?id=${payCheckFeeDiffModel.id}&f[checkDate]=${pager.f.checkDate}&f[agencyCode]=${pager.f.agencyCode}&f[bizCode]=${pager.f.bizCode}">处理</a>
                                    </c:if>
                                    <c:if test="${payCheckFeeDiffModel.handleStatus==1}">
                                        已处理
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="transactionListPager paginator"></div>
                </div>
            </form>
        </div>
        <!-- end对账列表页 -->

    </div>
</div>

</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script type="text/javascript">
    function cancel(){
//        window.location.href="javascript:history.go(-1)";

        window.location.href="payCheckFee.j?checkDate=${pager.f.checkDate}&agencyCode=${pager.f.agencyCode}&bizCode=${pager.f.bizCode}"
    }

    function doSubmit(){
        $("#queryForm").submit();
    }
    $(function($){
        renderpage(".transactionListPager","payCheckFeeDiff.j?${pager.fullUrl}",${pager.pageNo},${pager.totalPages});
    });
</script>

</html>