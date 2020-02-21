package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost1")
public class GetPostServlet extends HttpServlet {
	//get 은 서버가 메모리 미리 준비
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>요청 방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>Query 문자열 : "+
		                  request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("GET 방식 수행");
	}
	//post 는 메모리 동적할당
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 호출하고 나서 인코딩
		//request.setCharacterEncoding("UTF-8"); 
		out.print("<h2>요청 방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>Query 문자열 : "+request.getParameter("name")+"</h2>");
		out.close();
		System.out.println("POST 방식 수행");
	}
}



