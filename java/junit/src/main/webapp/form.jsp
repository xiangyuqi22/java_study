<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>表单页面</title>
</head>
<body>
	
	<form action="info.jsp">
		
		用户名：<input type="text" name="username" value=""> <br>
		性别 ：男<input type="radio" name="gender" value="boy">  &nbsp; &nbsp; &nbsp;  女<input type="radio" name="gender" value="girl"> <br>
		爱好： <select name="fav" id="" width = 100>
				<option value="play">玩</option>
				<option value="sleep">睡</option>
				<option value="eat">吃</option>
				<option value="drink">喝</option>
			</select>
		<br>
		<input type="submit" value="提交">
	</form>
	
</body>
</html>