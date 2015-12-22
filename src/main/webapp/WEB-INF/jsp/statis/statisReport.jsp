<%--
  Created by IntelliJ IDEA.
  User: qibaichao
  Date: 2015/4/24
  Time: 15:03
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
    <div>当前位置:<span class="pageLocation">业务自主查询->统计报表-></span></div>
    <div class="pageTitle">统计报表</div>

    <!-- start对账结果列表页 -->
    <div id="transactionList" style="display: block">
        <form action="report.j" method="post" id ="queryForm"  >
            <ul class="productListUl pageUl">

                <!-- 系统管理员-->
                <c:if test="${user.appId==1000}">
                    <li>
                        <span class="labelName">接入产品：</span>
                        <select  data-placeholder="请选择..." class="chosen_select110" name="appId" >
                            <option value="0" >请选择</option>
                            <c:forEach items="${appMap}" var="entry">
                                <option value="${entry.key}" <c:if test="${appId==entry.key }">selected</c:if>>${entry.value}</option>
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
                    <span class="labelName" style="width:auto">交易完成时间：</span>
                    <input type="text" class="datepicker datepickerStart"  value="${startDate}" name="startDate"/>
                    <span class="labelDatepickerEnd labelName" style="width:auto"> 至</span>
                    <input type="text" class="datepicker datepickerEnd" value="${endDate}" name="endDate"/>
                </li>

                <li>
                    <span class="labelName">维度：</span>
                    <select data-placeholder="请选择..." class="chosen_select110"  name="dimension" id="dimension" onchange="changeChart();" >
                        <c:forEach items="${statisDimensionMap}" var="dimensionMap">
                            <option value="${dimensionMap.key}" <c:if test="${dimensionMap.key ==dimension}"> selected</c:if>>${dimensionMap.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <li>
                    <span class="labelName" style="width:auto">指标：</span>
                    <select data-placeholder="请选择..." class="chosen_select110"  name="index" id="index"  onchange="changeChart();" >
                        <c:forEach items="${statisIndexMap}" var="indexMap">
                            <option value="${indexMap.key}" <c:if test="${indexMap.key ==index}">selected</c:if>>${indexMap.value}</option>
                        </c:forEach>
                    </select>
                </li>

                <div class="clear"></div>

                <li>
                    <span class="select btn100" onclick="doSubmit();" >查询</span>
                </li>
                <div class="clear"></div>

                <li><span class="labelName">支付总笔数：</span><span class="value">${successCount}</span></li>
                <li><span class="labelName">支付总金额：</span><span class="value">${successAmt}</span></li>
                <li><span class="labelName">转换率：</span><span class="value"><fmt:formatNumber type="percent"   maxFractionDigits="3" value="${convertRate}" /></span></li>
                <li><span class="labelName">成功率：</span><span class="value"><fmt:formatNumber type="percent"   maxFractionDigits="3" value="${successRate}" /></span></li>
                <li><span class="labelName">掉单率：</span><span class="value"><span class="value"><fmt:formatNumber type="percent"   maxFractionDigits="3" value="${leakageRate}" /></span></span></li>

                <div class="clear"></div>

            </ul>

            <div id="chart" style=" width:500px; height:400px; border:1px;padding-left: 150px;padding-top: 0px"></div>

        </form>
    </div>
</div>
</div>

</body>
<jsp:include page="../common/foot.jsp"></jsp:include>

<script type="text/javascript" src="../static/j/fusioncharts/js/fusioncharts.js"></script>
<script type="text/javascript" src="../static/j/fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript">

   var payFeeCountChart  = new FusionCharts({
        "type": "pie3d",
        "renderAt": "chart",
        "width": 500,
        "height": 400,
        "dataFormat": "json",
        "dataSource":  {
            "chart": {
                "caption": "支付方式(笔数)",
                "numberSuffix":"笔",
                "bgColor": "#effbfb",
//                "showBorder": "1",
                "captionOnTop":0,
//                "chartLeftMargin": "1",
//                "chartTopMargin": "1",
//                "chartRightMargin": "1",
//                "chartBottomMargin": "1",
                "formatNumberScale":0,
                "showShadow":'0' ,
                "showNames":'1',
                "exportEnabled":0,
                "exportAtClient":1,
                "use3DLighting":1,
//                "captionPadding":"1",
//                "xAxisNamePadding": "1",
//                "yAxisNamePadding": "1",
//                "labelPadding": "1",
//                "yAxisValuesPadding": "1"
//                "showLegend": "1",
                "theme": "fint"
            },
            "data": ${payFeeCountJsonData}
        }
    });

    var payFeeAmtChart = new FusionCharts({
        "type": "pie3d",
        "renderAt": "chart",
        "width": 500,
        "height": 400,
        "dataFormat": "json",
        "dataSource":  {
            "chart": {
                "caption": "支付方式(金额)",
                "numberSuffix":"元",
                "bgColor": "#effbfb",
//                "showBorder": "1",
                "captionOnTop":0,
//                "chartLeftMargin": "1",
//                "chartTopMargin": "1",
//                "chartRightMargin": "1",
//                "chartBottomMargin": "1",
                "formatNumberScale":0,
                "showShadow":'0' ,
                "showNames":'1',
                "exportEnabled":0,
                "exportAtClient":1,
                "use3DLighting":1,
//                "captionPadding":"1",
//                "xAxisNamePadding": "1",
//                "yAxisNamePadding": "1",
//                "labelPadding": "1",
//                "yAxisValuesPadding": "1"
//                "showLegend": "1",
                "theme": "fint"
            },
            "data": ${payFeeAmtJsonData}
        }
    });


   var agencyCountChart  = new FusionCharts({
       "type": "pie3d",
       "renderAt": "chart",
       "width": 500,
       "height": 400,
       "dataFormat": "json",
       "dataSource":  {
           "chart": {
               "caption": "支付机构(笔数)",
               "numberSuffix":"笔",
               "bgColor": "#effbfb",
//                "showBorder": "1",
               "captionOnTop":0,
//                "chartLeftMargin": "1",
//                "chartTopMargin": "1",
//                "chartRightMargin": "1",
//                "chartBottomMargin": "1",
               "formatNumberScale":0,
               "showShadow":'0' ,
               "showNames":'1',
               "exportEnabled":0,
               "exportAtClient":1,
               "use3DLighting":1,
//                "captionPadding":"1",
//                "xAxisNamePadding": "1",
//                "yAxisNamePadding": "1",
//                "labelPadding": "1",
//                "yAxisValuesPadding": "1"
//                "showLegend": "1",
               "theme": "fint"
           },
           "data": ${aegncyCountJsonData}
       }
   });

   var agencyAmtChart = new FusionCharts({
       "type": "pie3d",
       "renderAt": "chart",
       "width": 500,
       "height": 400,
       "dataFormat": "json",
       "dataSource":  {
           "chart": {
               "caption": "支付机构(金额)",
               "numberSuffix":"元",
               "bgColor": "#effbfb",
//                "showBorder": "1",
               "captionOnTop":0,
//                "chartLeftMargin": "1",
//                "chartTopMargin": "1",
//                "chartRightMargin": "1",
//                "chartBottomMargin": "1",
               "formatNumberScale":0,
               "showShadow":'0' ,
               "showNames":'1',
               "exportEnabled":0,
               "exportAtClient":1,
               "use3DLighting":1,
//                "captionPadding":"1",
//                "xAxisNamePadding": "1",
//                "yAxisNamePadding": "1",
//                "labelPadding": "1",
//                "yAxisValuesPadding": "1"
//                "showLegend": "1",
               "theme": "fint"
           },
           "data": ${aegncyAmtJsonData}
       }
   });

    function changeChart(){
        var dimension = $("#dimension").val();
        var index = $("#index").val();

        if(dimension==1){
            if(index==1){
                payFeeCountChart.render();
            }else{
                payFeeAmtChart.render();
            }
        }else if(dimension==2){
            if(index==1){
                agencyCountChart.render();
            }else{
                agencyAmtChart.render();
            }
        }
    }

    function doSubmit(){
        $("#queryForm").submit();
    }

    $(function($) {
        changeChart();
    });
</script>

</html>