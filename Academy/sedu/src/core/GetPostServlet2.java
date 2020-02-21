package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost2")
public class GetPostServlet2 extends HttpServlet {
	//get 은 서버가 메모리 미리 준비
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>요청 방식 : "+request.getMethod()+"</h2>");
		out.print("<h2>Query 문자열 : "+
		                  request.getParameter("name")+"</h2>");
		out.close();
		System.out.println(request.getMethod() + " 방식 수행");
	}
	//post 는 메모리 동적할당
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response); //doPost에서 doGet호출 --> 결과는 같음
	}
}



