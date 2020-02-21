package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitordb")
public class VisitorDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// visitor data 모두 출력
		// 메서드 오버라이딩한 메서드라서 throws 할 수 없다.
		// 조상에서 ServletException, IOException 만 throws 하고있기 때문에 이것만 가능, 안하는 건 가능

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// oracle 이 빠져도 됨.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		}

		// DB 서버 접속, Statement 객체 생성, "select * from visitor" SQL 명령 수행
		String sql = "select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"') writedate, memo from" + " visitor";
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest",
				"jdbctest"); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
			out.print("<h1> 방명록 리스트 </h1><hr>");
			out.print("<table border='1'>");
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString("name")+"</td>");
				out.print("<td>" + rs.getString("writedate")+"</td>");
				out.print("<td>" + rs.getString("memo")+"</td>");
				out.print("</tr>");
			}
		} catch (SQLException e) { // try 구문을 정의를 안해주면 에러 뜸
			e.printStackTrace();
		}
		out.println("<hr> <a href = '/sedu/html/visitorMain.html'> 방명록 메인화면으로 가기 </a>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8"); // POST 에서 한글 인코딩 처리 꼭 해주기 
		String name = request.getParameter("gname");
		String memo = request.getParameter("gmemo");
		
		System.out.println(name);
		System.out.println(memo);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// oracle 이 빠져도 됨.
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
		}

		//String sql = "select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"') writedate, memo from" + " visitor";
		String sql="insert into visitor values('" + name + "', sysdate, '" + memo + "')";
		System.out.println(sql);
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jdbctest","jdbctest"); 
				Statement stmt = conn.createStatement();) {// () 소괄호 안에는 객체 생성 가능 + 클러저블 한 것만 올 수 있다
			stmt.executeUpdate(sql); // try-catch 문이 있기 떄문에 리턴값 확인 x
			out.println("<h2>방명록 저장 성공!!</h2>");
		} catch (SQLException e) { 
			out.println("<h2>방명록 저장 실패!!</h2>");
			e.printStackTrace();
		}
		out.println("<hr> <a href = '/sedu/html/visitorMain.html'> 방명록 메인화면으로 가기 </a>");
		out.close();
	}

}
