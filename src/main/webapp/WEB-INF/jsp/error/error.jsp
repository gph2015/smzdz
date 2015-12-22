<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	*{margin:0;padding:0;}
	ul{list-style: none;}
	body{background: none;}
	img{border: none;}
	a{text-decoration:none;}
	.errorBox{width: 540px;margin: 200px auto;}
	.errorBox:after,.errorBox:before{  content: "";display: table;}
	.errorBox img{float: left;width: 145px;height: 167px;}
	.errorRelate{float: left;width: 395px;}
	.errorTitle{font-size: 20px;color: #000;font-family: "微软雅黑";line-height: 37px;text-align: center;position: relative;}
	.errorTitle span{width: 37px;height: 37px;background: url(img/error.jpg) no-repeat;position: absolute;top: 0;left: 100px;}
	.errorDetail{font-size: 25px;color: #000;font-family: "微软雅黑";line-height: 80px;}
	.errorBack{display: block;width: 151px;height: 33px;background: url(img/btn.gif) no-repeat;border: none;margin: 15px auto;cursor:pointer;}
</style>
<title>错误</title>
</head>
<body>
	<div class="errorBox">
		<img src="img/search.jpg">
		<div class="errorRelate">
			<h2 class="errorTitle"><span></span>操作失败！用户无此系统权限！</h2>
			<h2 class="errorDetail">${message}</h2>
			<input type="button" class="errorBack">
		</div>
	</div>
</body>
</html>