package jdbcsrc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prob {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		kaja("E");		
	}

	public static void kaja(String fn) {
		
		String sql3 ="select first_name, last_name, to_char(salary, '999,999')||'원' "
				+ "from employees "
				+ "where substr(first_name, 1,1) = '"+ fn.toUpperCase() +"'";

		String sql2 = fn + '%';
		
		String sql ="select first_name, last_name, to_char(salary, '999,999')||'원' "
				+ "from employees "
				+ "where first_name like '"+ fn + "%'";
		
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);){
			
		if(rs.next()){
			do {				
				System.out.println((rs.getString(1) + '(' + rs.getString(2) + ')') + rs.getString(3));
			}while(rs.next());
		}
		else {
			System.out.println("데이터가 없습니다.");
		}
		}
		catch (SQLException e) {
			System.err.println("DB연동 오류 발생 : "+ e);
		}
		
		
	}
}