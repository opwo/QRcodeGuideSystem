<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/body.css"/> 
</head>
<body>
<div class="container">
	<section id="content">
		<form action="LoginServlet" method="post">
			<h1>管理员登录</h1>
			<div>
				<input type="text" placeholder="管理员" required="" id="username" name="admin" />
			</div>
			<div>
				<input type="password" placeholder="密码" required="" id="password" name="password" />
			</div>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div> 
			<div style="align-content: center;">
				<!-- <input type="submit" value="Log in" /> -->
				<input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
				<!-- <a href="#">Register</a> -->
			</div>
		</form>
		 <div class="button">
			<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
			<a href="QRCode.jsp">二维码生成</a>	
		</div> <!-- button -->
	</section><!-- content -->
</div>
<!-- container -->
<!-- 我就是想测试 -->

<br><br><br><br>
<div style="text-align:center;">
<p><h3>二维码景区导游系统</h3></p>
</div>
</body>
</html>