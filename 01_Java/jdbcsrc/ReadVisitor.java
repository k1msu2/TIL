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
		Class.forName("oracle.jdbc.driver.OracleDriver"); // "oracle.jdbc.driver.OracleDriver" ���� ����̹� ��
		//Connection conn = DriverManager.getConnection("jdbc url", "����", "��ȣ");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost" // @localhost @127.0.0.1 @70.12.115.177
				+ ":1521:XE", "jdbctest", "jdbctest");
		// conn �������̽� - Drviermanager �� �����ϴ� ��ü�� ���� �޴´�
		System.out.println(conn);
		Statement stmt = conn.createStatement();
		String sql = "select name, writedate, memo from visitor"; // ������ sql ��ɾ ��
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
