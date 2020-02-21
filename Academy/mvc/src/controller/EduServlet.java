package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edu")
public class EduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int studentScore = Integer.parseInt(request.getParameter("score"))/10;
		switch(studentScore) {
		case 9: 
			request.getRequestDispatcher("/jspexam/gradeA.jsp").forward(request, response);
			break;
		case 8:
			request.getRequestDispatcher("/jspexam/gradeB.jsp").forward(request, response);
			break;
		case 7:
			request.getRequestDispatcher("/jspexam/gradeC.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/jspexam/gradeD.jsp").forward(request, response);
			break;
		}
		
	}

}
