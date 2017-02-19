package com.wt.scenicServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.scenic.OperScenic;
import com.wt.scenic.ScenicInfo;

/**
 * Servlet implementation class AddScenicServlet
 */
@WebServlet("/AddScenicServlet")
public class AddScenicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScenicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		response.setContentType("text/html; charset=gbk");
		String sequence_id = "scenic_id_seq.nextval";
	
		String scenicName = request.getParameter("scenicName");
		String contents = request.getParameter("contents");
		
		
		
		//Map<String, String> content = new HashMap<String, String>();
		String con_key = String.valueOf(new Date().getTime());
		/**********************将内容写进本地path****************************/
		
		String path =("F:/MyGraduationDesion/QRcodeGuideSystem/WebContent/"+scenicName+con_key+".html") ;
		
		System.out.println(path);
		File htmlFile = new File(path);
		if(!htmlFile.exists()){
			htmlFile.createNewFile();
			
		}
		FileOutputStream fos = new FileOutputStream(htmlFile, true);
		String allCon = "<!DOCTYPE html><html><head><meta charset='gbk'><title>"+scenicName+"</title></head><body>"+contents+"</body></html>";
		fos.write(allCon.getBytes());
		
	    //	content.put(con_key, contents);
		
		ScenicInfo scenic = new ScenicInfo(sequence_id, scenicName, path);
		if(OperScenic.addScenic(scenic)){
		
			response.getWriter().print("生成成功。");
			response.setHeader("refresh", "2;URL=addScenic.jsp");
		}else{
			response.getWriter().print("生成失败。");
			response.setHeader("refresh", "2;URL=addScenic.jsp");
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
