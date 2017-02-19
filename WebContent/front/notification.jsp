<%@page import="com.wt.tools.Paging"%>
<%@page import="com.wt.notification.OperNotification"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wt.notification.Notification"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>

<%
response.setHeader("refresh", "2");

List<Notification> list2 =  OperNotification.selectNotifi();

for(int i=list2.size();i>0;i--)
//for (Notification notification : list2)
	
{
	   %>
	 
	  <%--  <a href="" ><%=notification.getTitle() %></a><br> --%>
	  <a href="" ><%=list2.get(i-1).getTitle() %></a><span><%=list2.get(i-1).getDate() %></span><br>
	   <%
   }
%>
</div>
<center>
<h1> </h1>
</center>
</body>
</html>