<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/body.css"/> 
<title>Insert title here</title>
</head>
<body>
<div style="margin-top: 8%">
<center>
<font size="8" color="#FFFFFF">制作二维码</font>
<form action="QRServlet" method="post">
<textarea rows="10" cols="5" name="contents" style="width: 20%;height:30%">文本内容</textarea><br>
<br>
<font size="3" color="#FFFFFF">生成文件名</font><input type="text" name="imgName" required="required"><br>

<input type="submit" value="生成">
 </form>
 </center>
</div>

</body>
</html>