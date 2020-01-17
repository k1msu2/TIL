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
public class ReadEmp {

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.115.177:1521:XE", "scott", "tiger");
		System.out.println(conn);
		Statement stmt = conn.createStatement();
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 부서 번호를 입력하세요. :");
		String num = scan.nextLine();
		scan.close();
		String sql = "select ename, sal, deptno from emp "
				+ "where deptno = " + num;
		String sql2 = "select name, writedate, memo from visitor ";

		ResultSet rs = stmt.executeQuery(sql);
		
			
		if(rs.next())
		{
			do{
				System.out.println(rs.getString("ename") + ":"
						+ rs.getInt("sal") + ":"
						+ rs.getInt("deptno"));

			}while(rs.next());
		} else {
			
			System.out.println(num+"번 부서에는 아무도 없습니다.");

		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
