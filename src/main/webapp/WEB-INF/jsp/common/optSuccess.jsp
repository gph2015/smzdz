
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

<%@include file="../common/head.jsp"%>
    <div id="rightContent">
                <div class="result" id="success">
                    <div class="result-content">
                        <h2 class="result-point "><span class="success"></span>操作成功！</h2>
                        <input type="button" class="errorBack" onclick="toQuery()">
                    </div>
                </div>
	 <input type="hidden" id="url" value="${backUrl }"/>

    </div>

</body>

<%@include file="../common/foot.jsp"%>

<script type="text/javascript">

    
function toQuery(){
	if($("#url").val() != "")
		{
			window.location.href=$("#url").val();
		}else{
			
			window.location.href="query.j";
		}
	 
}
    
</script>

</html>


