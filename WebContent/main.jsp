<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<title>Insert title here</title>
</head>

<frameset rows="20%,*,15%" frameborder="0"  >

			<frame src="title.jsp" scrolling="no" />
			
			<frameset cols="15%,*">
				<frame name="left" src="left2.html" scrolling="no" />
				<frame name="right" src="notification.jsp" scrolling="yes"/>
			</frameset>
			<frame name="footer" src="footer.html" scrolling="no" />
		</frameset>

</html>