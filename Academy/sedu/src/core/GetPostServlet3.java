package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getpost3")
public class GetPostServlet3 extends HttpServlet {
	//get 은 서버가 메모리 미리 준비
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String method = request.getMethod();
		if(method.contentEquals("POST"))
			request.setCharacterEncoding("utf-8");
		out.print("<h2> 요청 방식 : " + method + "</h2>");
		out.print("<h2>Query 문자열 : " + method + "</h2>");
		out.close();
		System.out.println(method + "방식 실행");
	}
}



