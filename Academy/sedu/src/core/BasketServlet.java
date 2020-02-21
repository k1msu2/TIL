package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
		String paddr = request.	getContextPath()	
				+"/images/movie2020/"+pid.substring(pid.length()-2, pid.length());
		System.out.println(paddr);
		
		out.println("<h4>선택한 상품: "+request.getParameter("pid")+"</h4>");
		out.println("<div><img src="+paddr+".jpg width='300px'></div>");
		out.println("<div><a href=/sedu/html/productlog.html>상품 선택화면 으로 다시가기</a><div>");
		out.close();
		
	}

}
