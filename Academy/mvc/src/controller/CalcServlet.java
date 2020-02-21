package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operator = request.getParameter("operator");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 =  Integer.parseInt(request.getParameter("num2"));		
		
		if(operator.equals("divide") && num2 == 0) {
			String errorRes= "나눗셈 연산시 두번째 숫자는 0일 수 없습니다!!";
			request.setAttribute("result", errorRes);
			request.getRequestDispatcher("/jspexam/errorResult.jsp").forward(request, response);
		}else {
			int calcRes = 0;
			switch(operator) {
			case "plus":
				calcRes = num1 + num2;
				break;
			case "minus":
				calcRes = num1 - num2;
				break;
			case "multiply":
				calcRes = num1 * num2;
				break;
			case "divide":
				calcRes = num1 / num2;
				break;
			}
			
			request.setAttribute("result", calcRes);
			request.getRequestDispatcher("/jspexam/calcResult.jsp").forward(request, response);
		}
	}

}
