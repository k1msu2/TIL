package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * LocalDate ndate = LocalDate.now();
		 * DateTimeFormatter dateF = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		 * 
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		 * String date = LocalDate.now().format(formatter);
		* out.print(
				String.format(Locale.KOREAN, "<h2>%s 님이 %s에 남긴 글입니다</h2>",name, date));
				
				
				
				+day.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN)
				
		 * */
		
		//String.format(Locale.KOREAN, "%s, args
		
		out.println("<h2> " + request.getParameter("gname") + "님이 " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")) + "에 남긴 글입니다. </h2><hr>");
		out.println("<h2> " + request.getParameter("gname") + "님이 " + new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date()) + "에 남긴 글입니다. </h2><hr>");
		out.println("<p>" + request.getParameter("inputtext")+"</p>");
		out.println("<a href=\"/sedu/html/visitorForm.html\">입력화면으로</a>");
	}

}
