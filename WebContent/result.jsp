<%@page import="com.wt.manager.Manager"%>
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
<div>
<form action="FuzzySelectServlet">
<INPUT placeholder="    搜索关键字" NAME="userName" TYPE="text" SIZE="29" onmouseover="this.style.borderColor='black';this.style.backgroundColor='plum'"  
style="width: 106; height: 21"  
onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'" style="border-width:1px;border-color=black">
	<input type="submit" value="search" style="background-color: purple;border-bottom-color: purple;">
</form>
</div>
<center>
<div class="usls">
<table border="1px" cellspacing="0">
<tr> 
<th>编号</th>
<th>用户名</th>
<th>密码</th>
<th colspan="2">操作</th>
</tr>
<%
	List<Manager> list = (List<Manager>)request.getAttribute("mlist");
   for (Manager manager : list) {
	   %>
	   
	   		<tr> 
	   		<td width="50"><%=manager.getId()%> </td> 
	   		<td width="100"><%=manager.getName()%> </td> 
	   		<td width="100"><%=manager.getPwd()%> </td> 
	   		<td>
	   			<form action="delectIdServlet" method="post">
	    			 <input type="text" value="<%=manager.getId()%>" style="display: none;" name="id">
	    			 <input type="submit" value="删除">
       			</form>
       	    </td> 
       	    <td>
	   			<form action="modify.jsp" method="post">
	    			 <input type="text" value="<%=manager.getId()%>" style="display: none;" name="id">
	    			 <input type="text" value="<%=manager.getName()%>" style="display: none;" name="name">
	    			 <input type="text" value="<%=manager.getPwd()%>" style="display: none;" name="pwd">
	    			 <input type="submit" value="修改">
       			</form>
       	    </td>
	   		</tr>
	   
	   <%
   }

%>
</table>
</div>
</center>

</body>
</html>