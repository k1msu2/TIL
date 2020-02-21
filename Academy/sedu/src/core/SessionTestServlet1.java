package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessiontest1")
public class SessionTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L; // 객체 직렬화 - 하둡에서 공부할 것임
	int member_v = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int local_v = 0; // 요청시마다 메모리 할당을 해줌.
		response.setContentType("text/html; charset=utf-8"); // 응답의 형식을 알려줘야지 한글이 안깨진다
		PrintWriter out = response.getWriter(); // 컨텐트 타입을 먼저 설정 후에 호출한다
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt")==null)
				session.setAttribute("cnt", new int[1]); // 데이터를 저장할 방을 등록
		int[] session_v = (int[]) session.getAttribute("cnt"); // object 형으로 리턴됨.
		session_v[0] += 10;
		member_v += 10;
		local_v += 10;
		out.print("<ul>");
		out.print("<li> 멤버 변수 : " + member_v + "</li>");
		out.print("<li> 지역 변수 : " + local_v + "</li>");
		out.print("<li> 세션객체에 저장된 배열 원소 : " + session_v[0] + "</li>");
		out.print("</ul>");
		out.close();
		
	}


}	