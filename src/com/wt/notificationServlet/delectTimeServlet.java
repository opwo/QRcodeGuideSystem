package com.wt.notificationServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.manager.OperManager;
import com.wt.notification.OperNotification;

@WebServlet("/delectTimeServlet")
public class delectTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delectTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time = request.getParameter("Time");
		long times = Long.parseLong(time);
		if(OperNotification.deleteNotification(times))
			request.getRequestDispatcher("LookNotifiServlet").forward(request, response);
		else
			response.getWriter().println("É¾³ýÊ§°Ü");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
