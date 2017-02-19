<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<center>
<br><br>
<h3>发布通知</h3>
<form action="AddNotificationServlet" method="post">
标题：<input type="text" name="title"><br><br>
<textarea rows="10" cols="5" name="contents" style="width: 30%;height: 100%">通知内容</textarea><br>
<br><br>
<input type="submit" value="发布" width="100px">
 </form>
 </center>
</div>
</body>
</html>