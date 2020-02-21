package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("id");
		String room = request.getParameter("room");
		String date = request.getParameter("date");
		String ReqParam[] = request.getParameterValues("option");
		
		out.println("<h1>"+name+"님의 예약 내용</h1><hr>");
		out.println("<ul>"+room+"</ul>");
		
		String result="";
		if(ReqParam == null){
			result = "없음";
		}else {
			for(int i = 0; i < ReqParam.length ; i++) {
				if(ReqParam[i] =="") continue;
				else result += ReqParam[i]+ ", ";
			}
			result.substring(0,result.length()-1);
		}
		
		try {
			String date2="2020-01-17";
			String pattern = "(\\d{4})-(\\d{2})-(\\d{2})";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(date);
			//System.out.println(matcher);
			out.println("<ul>"+result+"</ul>");
			out.println("<ul>"+date+"</ul>");
			while(m.find()) {
				out.println("<ul>"+m.group(1)+"년"+m.group(2)+"월"+m.group(2)+"일</ul>");
			}
			out.println("<a href=\"/sedu/html/reservation.html\">예약 입력화면으로</a>");
			}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
