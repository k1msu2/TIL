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
			sql = "select ename, to_char(sal, '9,999') || '��' from emp";
		else
			sql = "select ename, to_char(hiredate,'yyyy\"��\" mm\"��\" dd\"��\"') from emp";

		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				) {

			if(rs.next())
			{
				if(rand)
				{
					do {
						result = String.format("%s ������ ������ %s �Դϴ�.", rs.getString(1), rs.getString(2));
						System.out.println(result);
					}
					while(rs.next());
				}
				else
				{
					do {	
						result = String.format("%s ������ %s�� �Ի��Ͽ����ϴ�. ", rs.getString(1), rs.getString(2));
						System.out.println(result);
					}
					while(rs.next());
				}

			}
			else
			{
				System.out.println("�����Ͱ� �����ϴ�.");
			}


		}catch(Exception e){
			System.err.println(e);

		}finally {

		}

	}

}
