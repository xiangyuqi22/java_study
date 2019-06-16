<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
    
<%
	String username = request.getParameter("username");
	String fav = request.getParameter("fav");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>获取表单信息</title>
</head>
<body>
	<h1>username = <%=username %></h1>
	<h1>fav = <%=fav %></h1>
</body>
</html>