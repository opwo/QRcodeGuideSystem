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
	<%
	String path =(String) request.getAttribute("img") ;
	String imgName =(String) request.getAttribute("imgName") ;
	
	System.out.println(path);
	
		%>
		<center>
		<span style="color: red;"> ${imgName}.png </span>已生成<br>
		<img alt="qrcode" src="${img}">
		<br><h4>请鼠标右键另存为进行保存</h4>
		<br> <a href="QRCode.jsp">继续生成</a>
		</center>
		<% 
	
	%>
</div>
</body>
</html>