package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlocal")
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 객체 직렬화 - 하둡에서 공부할 것임
	int member_v = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v = 0; // 요청시마다 메모리 할당을 해줌.
		response.setContentType("text/html; charset=utf-8"); // 응답의 형식을 알려줘야지 한글이 안깨진다
		PrintWriter out = response.getWriter(); // 컨텐트 타입을 먼저 설정 후에 호출한다
		
		member_v += 10;
		local_v += 10;
		
		out.print("<ul>");
		out.print("<li> 멤버 변수 : " + member_v + "</li>");
		out.print("<li> 지역 변수 : " + local_v + "</li>");
		out.print("</ul>");
		out.close();
		
	}

}
