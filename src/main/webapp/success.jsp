<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta charset="utf-8">
    <meta http-equiv="refresh" content="3;URL=http://localhost:8080/SSH_Maven"> 
    	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	</style>
  </head>
  
  <body>
		注册成功！三秒后跳回首页;
  </body>
</html>
