package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query") // 똑같은 매핑명일 경우, LifecycleException 에러 발생, 톰캣기동 못함. 
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 객체 직렬화 - 하둡에서 공부할 것임
	int member_v = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v = 0; // 요청시마다 메모리 할당을 해줌.
		response.setContentType("text/html; charset=utf-8"); // 응답의 형식을 알려줘야지 한글이 안깨진다
		PrintWriter out = response.getWriter(); // 컨텐트 타입을 먼저 설정 후에 호출한다
		String p1 = request.getParameter("p1");
		int p2 = Integer.parseInt(request.getParameter("p2"));
		String p3[] = request.getParameterValues("p3");
		
		out.print("<ul>");
		out.print("<li>p1 : " +p1 +"</li>");
		out.print("<li>p2 : " +p2 +"</li>");
		for(int i = 0; i<p3.length; i++) {
			out.print("<li>p3[" + i + "] :" + p3[i] + "</li>");
		}
		out.print("</ul>");
		
		out.close();
		
	}

}
