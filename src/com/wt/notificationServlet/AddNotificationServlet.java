package com.wt.notificationServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.manager.OperManager;
import com.wt.notification.Notification;
import com.wt.notification.OperNotification;

/**
 * Servlet implementation class AddNotificationServlet
 */
@WebServlet("/AddNotificationServlet")
public class AddNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		Date date = new Date();
		String contents = request.getParameter("contents");
		String title = request.getParameter("title");
		title = title.replaceAll("<br>", "\n");
		title = title.replaceAll("&nbsp;", " ");
		Notification noti = new Notification(title, contents, date);
		if(OperNotification.AddNotification( noti)){
			response.getWriter().println("发布成功");
			response.setHeader("refresh", "2;URL=notification.jsp");
			//request.getRequestDispatcher("notificationAll.jsp").forward(request, response);
		}else{
			response.getWriter().println("发布失败");
			response.setHeader("refresh", "2;URL=notification.jsp");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
