package core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ForwardServlet 수행 시작");
		//getRequestDispatcher 팩토리 메서드? 
		RequestDispatcher rd = request.getRequestDispatcher("first.html");
		//컨텍스트패스 /sedu 이후 부분을 줘야한다. 
		rd.forward(request, response);
		System.out.println("ForwardServlet 수행 종료");
	}

}
