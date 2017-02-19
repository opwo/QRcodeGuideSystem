package com.wt.managerServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JPopupMenu.Separator;
import javax.websocket.Session;

import com.wt.manager.Manager;
import com.wt.manager.OperManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String admin = request.getParameter("admin");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if(session!=null){
		if(admin ==null || password ==null){
		admin = (String) session.getAttribute("name");
		password = (String) session.getAttribute("pwd");
		}
		}
		if(admin ==null || password ==null)
			response.setHeader("refresh", "2;URL=Login.jsp");//2秒后。跳回登录页面
		else{
		
		
		if(OperManager.verifyLogin(admin, password)){
			session.setAttribute("name", admin);
			session.setAttribute("pwd", password);
			response.sendRedirect("main.jsp");
			//request.getRequestDispatcher("main.jsp").forward(request, response);
			
		}
		else {response.getWriter().println(" (╰_╯)#  用户名或密码错误");
		response.setHeader("refresh", "2;URL=Login.jsp");//2秒后。跳回登录页面
		}
		
		}
	}

}
