package com.wt.QRcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QRServlet
 */
@WebServlet("/QRServlet")
public class QRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String contents = request.getParameter("contents");
		contents = contents.replaceAll("<br>", "\n");
		String imgName = request.getParameter("imgName");
		String imgPath = this.getServletContext().getRealPath("img/logo.png");
		System.out.println(imgPath);
		String savePath = this.getServletContext().getRealPath("/WEB-INF/QRcode/");
		
		boolean iscode = QRCode.insertImgCreateQRCode(imgName,imgPath, contents, 256,savePath);
		if(iscode){ response.getWriter().println("生成成功");
		String path = savePath+imgName+".png";
		request.setAttribute("img", path);
		request.setAttribute("imgName", imgName);
		request.getRequestDispatcher("qrimg.jsp").forward(request, response);
		//response.setHeader("refresh", "2;URL=QRCode.jsp");
		}
	 	else{ response.getWriter().println("生成失败");
	 	response.setHeader("refresh", "2;URL=QRCode.jsp");
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
