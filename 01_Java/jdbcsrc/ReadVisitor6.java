package jdbcsrc;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * CREATE TABLE VISITOR (
            NAME             VARCHAR2(18),
            WRITEDATE       DATE,
            MEMO            VARCHAR2(180)
);

 * */
public class ReadVisitor6 {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//대장클래스(OracleDriver) 지정 명시적 jvm 영역에 로딩
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.115.177:1521:XE", "jdbctest", "jdbctest");
		System.out.println(conn);
		Statement stmt = conn.createStatement();
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요. :");
		String searchWord = scan.nextLine();
		scan.close();
		String sql = "select name, writedate, memo from visitor where name = '" + searchWord+"'";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next())
		{
			System.out.println(rs.getString("name") + ":"
					+ rs.getDate("writedate") + ":"
					+ rs.getString("memo"));
		} else {
			System.out.println("이름에" + searchWord+"님이 작성한 글이 없습니다.");
		}
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
