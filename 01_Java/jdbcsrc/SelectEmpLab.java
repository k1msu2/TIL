package jdbcsrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) {
		String sql = "";
		String result = "";
		boolean rand = new Random().nextBoolean();

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		if(rand)
			sql = "select ename, to_char(sal, '9,999') || '원' from emp";
		else
			sql = "select ename, to_char(hiredate,'yyyy\"년\" mm\"월\" dd\"일\"') from emp";

		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				) {

			if(rs.next())
			{
				if(rand)
				{
					do {
						result = String.format("%s 직원의 월급은 %s 입니다.", rs.getString(1), rs.getString(2));
						System.out.println(result);
					}
					while(rs.next());
				}
				else
				{
					do {	
						result = String.format("%s 직원은 %s에 입사하였습니다. ", rs.getString(1), rs.getString(2));
						System.out.println(result);
					}
					while(rs.next());
				}

			}
			else
			{
				System.out.println("데이터가 없습니다.");
			}


		}catch(Exception e){
			System.err.println(e);

		}finally {

		}

	}

}
