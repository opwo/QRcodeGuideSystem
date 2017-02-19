<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<!-- 获取地理位置 返回 var = remote_ip_info;-->
<script type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js"></script>
<script language=Javascript> 
  function time(){
    //获得显示时间的div
    t_div = document.getElementById('showtime');
   var now=new Date()
    //替换div内容 
   t_div.innerHTML =now.getFullYear()
    +"年"+(now.getMonth()+1)+"月"+now.getDate()
    +"日"+now.getHours()+"时"+now.getMinutes()
    +"分"+now.getSeconds()+"秒";
    //等待一秒钟后调用time方法，由于settimeout在time方法内，所以可以无限调用
   setTimeout(time,1000);
  }
  document.write(remote_ip_info.country+remote_ip_info.province+remote_ip_info.city);
</script>
</head>
<body style="background-color: #FF9D00; width: 100%;height: 100%;" onload="time()">
<%
String name="";
if(session.getAttribute("name")==null){
	%>
	<script type="text/javascript">
	window.top.location.href='Login.jsp';
	</script>
	<%
}
	name =(String) session.getAttribute("name");


%>
<div id="showtime"></div>
	<center>
		<h1>二维码导游后台</h1><span style="color: red;">[<%=name %>]</span>登陆成功 <a href="exit.jsp">退出</a>
		</center>
</body>
</html>