package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.vo.MeetingVO;
import model.vo.VisitorVO;

public class MeetingMybatisDAO implements MeetingDAO{
	final String resource = "resource/mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory;
	public MeetingMybatisDAO() {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<MeetingVO> listAll(){
		System.out.println("Mybatis 를 사용 DB 연동-listAll-DAO2");
		List<MeetingVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "resource.MeetingMapper.selectMeeting";
		list = session.selectList(statement);
		session.close();
		return list;
	}
	public boolean insert(MeetingVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-insert-DAO2");
		boolean result = false;
		SqlSession session = sqlSessionFactory.openSession(true);
		String statement = "resource.MeetingMapper.insertMeeting";
		if (session.insert(statement, vo) == 1)
			result = true;
		session.close();
		return result;
		
	}
	public List<MeetingVO> search(String keyword){
		System.out.println("Mybatis 를 사용 DB 연동-search-DAO2");
		List<MeetingVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "resource.MeetingMapper.searchMeeting";
		list = session.selectList(statement, keyword);
		session.close();
		return list;
	
	}
	public boolean delete(int id) {
		int result = 0;
		boolean bresult = false;
		System.out.println("Mybatis 를 사용 DB 연동-delete-DAO2");
		SqlSession session = sqlSessionFactory.openSession(true);
		String statement = "resource.MeetingMapper.deleteMeeting";
		result = session.delete(statement, id);
		session.close();
		
		if(result == 1) bresult = true;
		return bresult;
		
	}
	
	public MeetingVO list(int eNo) {
		System.out.println("Mybatis 를 사용 DB 연동-list-DAO2");
		MeetingVO vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		String statement = "resource.MeetingMapper.selectMeeting1";
		vo = (MeetingVO) session.selectList(statement, eNo);
		session.close();
		return vo;
	}
	
	public boolean update(MeetingVO vo) {
		System.out.println("Mybatis 를 사용 DB 연동-update-DAO2");
		boolean result = false;
		SqlSession session = sqlSessionFactory.openSession(true);
		String statement = "resource.MeetingMapper.updateMeeting";
		if (session.insert(statement, vo) == 1)
			result = true;
		session.close();
		return result;
	}
	
}
