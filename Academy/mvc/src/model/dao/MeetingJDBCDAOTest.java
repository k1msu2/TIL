package model.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.vo.MeetingVO;

class MeetingJDBCDAOTest {

	@Test
	void test() {
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		List<MeetingVO> list = dao.listAll();
		System.out.println(list.size());
		for(MeetingVO vo : list) {
			System.out.println(vo);
		}			
	}
	
	@Test
	public void test2() {
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName("라이언");
		vo.setTitle("화요일 저녁 6시에 만납시다!");	
		vo.setMeetingDate("2019-07-01T13:40");
		dao.insert(vo);
		List<MeetingVO> list = dao.listAll();
		for(MeetingVO data : list)
			System.out.println(data);
		System.out.println("화요일이 들어간 글**"); 
		list = dao.search("화요일");
		for(MeetingVO data : list)
			System.out.println(data);
	}
	
	@Test
	public void test3() {
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		dao.delete(26);
		
	}

}
