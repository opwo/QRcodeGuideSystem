<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$(function() {
		 $("#id").blur(function() {
			if($("#id").val() == ""){
				$("#checkId").html("ID不能为空！！！");
				$("#id").focus();
			}else{
				$.get("checkID.jsp",{id:$("#id").val()},function(data){$("#checkId").html(data);$("#checkId").show();});
			}
		}); 

	});
</script>
<div style="margin-top: 8%">
<center>
		<form action="AddServlet" method="post">
		
			ID：<input type="number" name="id" id="id"  /><br /><span id="checkId" style="color: red"></span><br />
			用户名：<input type="text" name="admin" /><br /><br />
			密&nbsp;码：<input type="password" name="password" /><br />
			<input type="submit" value="添加" />
		</form>
		</center>
		</div>
</body>
</html>