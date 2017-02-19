<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.wt.notification.Notification"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result</title>
<style type="text/css">
		.usls{
			margin-top: 3%;
			background-color: yellow;
			
		}
</style>
</head>
<body>
<div class="usls">
<table border="1px" cellspacing="0">
<tr> 
<th>标题</th>
<th>内容</th>
<th>发布时间</th>
<th>操作</th>
</tr>
<%
	List<Notification> list = (List<Notification>)request.getAttribute("nlist");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
     for (Notification notification : list) {
    	 String time = sdf.format(notification.getDate().getTime());
	   %>
	   
	   		<tr> 
	   		<td width="50"><%=notification.getTitle()%> </td> 
	   		<td width="500"><%=notification.getContent()%> </td> 
	   		<td width="160"><%= time%> </td> 
	   		<td>
	   			<form action="delectTimeServlet" method="post">
	    			 <input type="text" value="<%=notification.getDate().getTime()%>" style="display: none;" name="Time">
	    			 <input type="submit" value="删除">
       			</form>
       	    </td> 

	   		</tr>
	   
	   <%
   }

%>
</table>
</div>

</body>
</html>