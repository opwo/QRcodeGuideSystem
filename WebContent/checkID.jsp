<%@page import="com.wt.manager.OperManager"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String ids = request.getParameter("id");
int id = Integer.parseInt(ids);
boolean flag = OperManager.verifyID(id);
if(flag) out.print("ID已被注册");
else out.print("恭喜你可以用");

%>
</body>
</html>