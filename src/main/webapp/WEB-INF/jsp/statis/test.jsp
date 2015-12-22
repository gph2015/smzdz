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
    <script type="text/javascript" src="../static/j/fusioncharts/js/fusioncharts.js"></script>
    <script type="text/javascript" src="../static/j/fusioncharts/js/themes/fusioncharts.theme.fint.js"></script>
</head>
<body>

<%@ include file="../common/head.jsp"%>
<div id="rightContent">
    <div>当前位置:<span class="pageLocation">运营系统->统计报表-></span></div>
    <div class="pageTitle">统计报表</div>

    <!-- start对账结果列表页 -->
    <div id="transactionList" style="display: block">
            <div id="chart" ></div>
    </div>
</div>
</div>

</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
<script type="text/javascript">


    var payFeeCountChart  = new FusionCharts({
        "type": "pie3d",
        "renderAt": "chart",
        "width": 700,
        "height": 600,
        "dataFormat": "json",
        "dataSource":  {
            "chart": {
                "caption": "支付方式(笔数)",
                "numberSuffix":"笔",
                "paletteColors": "#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000",
                "bgColor": "#ffffff",
                "showBorder": "0",
                "use3DLighting": "0",
                "showShadow": "0",
                "enableSmartLabels": "0",
                "startingAngle": "0",
                "showPercentValues": "1",
                "showPercentInTooltip": "0",
                "decimals": "1",
                "captionFontSize": "14",
                "subcaptionFontSize": "14",
                "subcaptionFontBold": "0",
                "toolTipColor": "#ffffff",
                "toolTipBorderThickness": "0",
                "toolTipBgColor": "#000000",
                "toolTipBgAlpha": "80",
                "toolTipBorderRadius": "2",
                "toolTipPadding": "5",
                "showHoverEffect": "1",
                "showLegend": "1",
                "legendBgColor": "#ffffff",
                "legendBorderAlpha": "0",
                "legendShadow": "0",
                "legendItemFontSize": "10",
                "legendItemFontColor": "#666666",
                "useDataPlotColorForLabels": "1"
            },
            "data": [
                {
                    "label": "支付宝",
                    "value": "5607"
                },
                {
                    "label": "微信扫码",
                    "value": "1557"
                },

                {
                    "label": "财付通",
                    "value": "579"
                },
                {
                    "label": "支付宝扫码支付",
                    "value": "550"
                },
                {
                    "label": "支付宝-一键支付",
                    "value": "530"
                },
                {
                    "label": "中国建设银行",
                    "value": "1365"
                },
                {
                    "label": "中国农业银行",
                    "value": "436"
                },
//                {
//                    "label": "中国邮政储蓄银行",
//                    "value": "354 "
//                },
//                {
//                    "label": "中国银行",
//                    "value": "316"
//                },
//                {
//                    "label": "招商银行",
//                    "value": "265"
//                },
//                {
//                    "label": "交通银行",
//                    "value": "110"
//                },
                {
                    "label": "其它银行",
                    "value": "1221"
                }
            ]
        }
    });
    payFeeCountChart.render();


</script>

</html>