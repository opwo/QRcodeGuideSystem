package com.wt.notificationServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.manager.Manager;
import com.wt.manager.OperManager;
import com.wt.notification.Notification;
import com.wt.notification.OperNotification;
import com.wt.tools.Paging;

/**
 * Servlet implementation class LookNotifiServlet
 */
@WebServlet("/LookNotifiServlet")
public class LookNotifiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookNotifiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		List<Notification> list =  OperNotification.selectNotifi();
		
//		Paging page = new Paging(list, 5);
//		String oper = request.getParameter("oper");
//		if("prev".equals(oper)) page.prevPage();
//		if("next".equals(oper)) page.nextPage();
//		
//		list = page.getAllRecords();
		
		
		request.setAttribute("nlist", list);
		request.getRequestDispatcher("notificationAll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
