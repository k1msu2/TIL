package jdbcsrc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/*
 * CREATE TABLE VISITOR (
            NAME             VARCHAR2(18),
            WRITEDATE       DATE,
            MEMO            VARCHAR2(180)
);

 * */
public class ReadVisitor {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver"); // "oracle.jdbc.driver.OracleDriver" 무료 드라이버 명
		//Connection conn = DriverManager.getConnection("jdbc url", "계정", "암호");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost" // @localhost @127.0.0.1 @70.12.115.177
				+ ":1521:XE", "jdbctest", "jdbctest");
		// conn 인터페이스 - Drviermanager 가 리턴하는 객체를 전달 받는다
		System.out.println(conn);
		Statement stmt = conn.createStatement();
		String sql = "select name, writedate, memo from visitor"; // 순수한 sql 명령어만 줌
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsm = rs.getMetaData();
		
		System.out.println(rsm.getColumnClassName(1));
		System.out.println("--------------");
		
		while(rs.next())
		{
			System.out.println(rs.getString("name") + ":"
					+ rs.getDate("writedate") + ":"
					+ rs.getString("memo"));
		}
		
	}

}
