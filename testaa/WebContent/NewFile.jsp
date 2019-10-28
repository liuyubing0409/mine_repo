<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + 
		":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" href="static/bootstrap-4.1.3-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="static/bootstrap-table-master/dist/bootstrap-table.min.css">
<script type="text/javascript" src="static/bootstrap-4.1.3-dist/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="static/bootstrap-4.1.3-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
<script type="text/javascript" src="static/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
	
</body>
</html>