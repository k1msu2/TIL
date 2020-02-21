package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

enum DayKor {
	MONDAY("월"), TUESDAY("화"), WEDNESDAY("수"), THURSDAY("목"), 
	FRIDAY("금"), SATURDAY("토"), SUNDAY("일");
	
	private final String value;
	DayKor(String value){this.value=value;}
	public String getValue() {return value;}
}



@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LocalDate currentDate = LocalDate.now();		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String weekkor = currentDate.getDayOfWeek().toString();
		int weeknum = currentDate.getDayOfWeek().getValue();
		String dayofweekArray[] = {"", "월", "화", "수", "목", "금", "토", "일"};

		//System.out.println();
		if(name==null) {
			name = "GUEST";			
		}
		
		//enum 방식
		out.println("<h2> "+ name+ "님 반가워요.. 오늘은 "+ DayKor.valueOf(weekkor).getValue()+"요일입니다!! </h2>");
		// 배열방식
		out.println("<h2> "+ name+ "님 반가워요.. 오늘은 "+ dayofweekArray[weeknum] +"요일입니다!! </h2>");
		// api 방식
		out.println("<h2>" + name+ "님 반가워요.. 오늘은 "+currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN)+"입니다!! </h2>" );
	}
}
