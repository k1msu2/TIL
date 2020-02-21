package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.vo.NewsVO;

public class NewsDAO {

	private Connection connectDB() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@70.12.115.177:1521:xe", "jdbctest", "jdbctest");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public boolean insert(NewsVO vo) {
		boolean result = false;
		String sql = "insert into news values (news_seq.nextval, ?, ?, ?, sysdate, ?)";
		try (Connection conn = connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, 0);
			System.out.println(vo);
			pstmt.executeUpdate();
			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean update(NewsVO vo) {
		System.out.println("update 1: " + vo.getWriter());
		boolean result = false;
		System.out.println(vo);
		String sql = "update news set writer = ?, title = ?, content = ?, "
				+ "writedate = sysdate where id = ?";
		try (Connection conn = connectDB(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getId());
			System.out.println(pstmt.executeUpdate());
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		String sql = "delete from news where id=" + id;
		System.out.println(sql);
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<NewsVO> listAll() {
		List<NewsVO> list = new ArrayList<>();
		String sql = "select id, writer, title, content, writedate, cnt from news order by id desc";
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			NewsVO vo;
			System.out.println("----------------------------------");
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(Integer.parseInt(rs.getString(6)));
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public NewsVO listOne(int id) {
		NewsVO vo = null;
		int cnt = 0;
		String sql = "select id, writer, title, content, writedate, cnt from news where id="
				+ id;

		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			vo = new NewsVO();
			while (rs.next()) {
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				cnt = Integer.parseInt(rs.getString(6)) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("cnt: " + cnt);
		System.out.println("id: " + id);
		String sql2 = "update news set cnt = ? where id = ? ";
		try (Connection conn = connectDB(); 
				PreparedStatement pstmt = conn.prepareStatement(sql2);) {
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, id);
			System.out.println(pstmt.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public List<NewsVO> listWriter(String writer){
		List<NewsVO> list = new ArrayList<>();
		String sql = "select id, writer, title, content, "
				+ "writedate, cnt from news where writer = '" + writer
				+ "' order by id";
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			NewsVO vo;
			System.out.println("----------------------------------");
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(Integer.parseInt(rs.getString(6)));
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<NewsVO> search(String key, String searchType){
		
		List<NewsVO> list = new ArrayList<>();
		String sql = null;
		//searchType : title, content, all
		if(!searchType.equals("all")) {
		sql = "select id, writer, title, content, "
				+ "writedate, cnt from news where " + searchType + " like '%"+key+"%'";
		} else {
			sql = "select id, writer, title, content, "
					+ "writedate, cnt from news where title like '%"+key
					+"%' union select id, writer, title, content,"
					+ "writedate, cnt from news where content like '%"+key
					+"%'";
		}
		
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			NewsVO vo;
			System.out.println("----------------------------------");
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(Integer.parseInt(rs.getString(6)));
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<NewsVO> paging(List<NewsVO> list, int page){
		System.out.print("page: ");
		System.out.println(page);
		List<NewsVO> list2 = new ArrayList<>();

		System.out.print("리스트 사이즈 : ");
		System.out.println(list.size());
		int lsize = list.size();
		int pagenum = page;
		int start = (pagenum - 1) * 5 + 1;
		int end = pagenum * 5;
		
		if (end > lsize) {
			end = lsize;
		}

		for (int i = start - 1; i < end; i++) {
			list2.add(list.get(i));
		}
		
		return list2;
	}
	
	public List<NewsVO> listAll(int start, int end, int selected) {
		List<NewsVO> list = new ArrayList<>();

		String sql = "select id, writer, title, content, writedate, cnt from "
				+ "(select rownum as rnum, id, writer, title, content, writedate, cnt "
				+ "from news T order by id desc) a where a.rnum between " + start +" and " + end;
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			NewsVO vo;
			System.out.println("----------------------------------");
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(Integer.parseInt(rs.getString(6)));
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public List<NewsVO> listWriter(String writer, int start, int end, int selected){
		List<NewsVO> list = new ArrayList<>();
		String sql = "select id, writer, title, content, "
				+ "writedate, cnt from news where writer = '" + writer
				+ "' order by id";
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			NewsVO vo;
			System.out.println("----------------------------------");
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(Integer.parseInt(rs.getString(6)));
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<NewsVO> search(String key, String searchType, int start, int end, int selected){
		
		List<NewsVO> list = new ArrayList<>();
		String sql = null;
		//searchType : title, content, all
		if(!searchType.equals("all")) {
		sql = "select id, writer, title, content, "
				+ "writedate, cnt from news where " + searchType + " like '%"+key+"%'";
		} else {
			sql = "select id, writer, title, content, "
					+ "writedate, cnt from news where title like '%"+key
					+"%' union select id, writer, title, content,"
					+ "writedate, cnt from news where content like '%"+key
					+"%'";
		}
		
		try (Connection conn = connectDB();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			NewsVO vo;
			System.out.println("----------------------------------");
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(Integer.parseInt(rs.getString(1)));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(Integer.parseInt(rs.getString(6)));
				list.add(vo);
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	

}
