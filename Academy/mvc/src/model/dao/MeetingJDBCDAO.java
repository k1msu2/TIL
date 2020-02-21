package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.vo.MeetingVO;

public class MeetingJDBCDAO implements MeetingDAO{
	public List<MeetingVO> listAll(){
		List<MeetingVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jdbctest";
		String password = "jdbctest";
		String sql = "select id, name, title, meetingdate from meeting order by id";
		try (Connection conn = DriverManager.getConnection(url,user,password);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);){
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean insert(MeetingVO vo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean result = false;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="jdbctest";
		String password = "jdbctest";
		String sql = "insert into meeting values (meeting_seq.nextval, ?, ?, to_date(?)";
		try( Connection conn = DriverManager.getConnection(url, user, password);
			 PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
			pstmt.executeUpdate();
			System.out.println(vo.getMeetingDate());
			result = true;	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<MeetingVO> search(String keyword){
		List<MeetingVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jdbctest";
		String password = "jdbctest";
		String sql = "select id, name, title, to_date(meetingdate)"
				+"from meeting where title like '%"+keyword+"%'";
		System.out.println(sql);
		try (Connection conn = DriverManager.getConnection(url,user,password);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);){
			MeetingVO vo;
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(int eNo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		boolean result = false;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jdbctest";
		String password = "jdbctest";
		String sql = "delete from meeting where id=" + eNo;
		System.out.println(sql);
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public MeetingVO list(int eNo) {
		MeetingVO vo = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jdbctest";
		String password = "jdbctest";
		String sql = "select from meeting where id=" + eNo;
		try(Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				vo = new MeetingVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return vo;
	}
	
	public boolean update(MeetingVO vo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean result = false;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="jdbctest";
		String password = "jdbctest";
		String sql = "update meeting  set name = '?', title = '?', meetingdate = '?' where id = ?";
		try( Connection conn = DriverManager.getConnection(url, user, password);
			 PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();
			result = true;	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
