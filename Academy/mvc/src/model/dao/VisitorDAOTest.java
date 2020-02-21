package model.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import model.vo.VisitorVO;
import static java.lang.System.out;
import static org.junit.Assert.fail;

class VisitorDAOTest {

	@Test
	void test() {
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.listAll();
		out.println(list.size());
		for(VisitorVO vo : list) {
			out.println(vo);
		}
	}
	@Test
	void test3() {
		out.println("검색 기능 테스트");
		VisitorDAO dao = new VisitorDAO();
		List<VisitorVO> list = dao.search("요");
		out.println(list.size());
		for(VisitorVO vo : list) {
			out.println(vo);
		}
	}
	@Test
	void test2() {
		out.println("삽입 테스트");
		VisitorDAO dao = new VisitorDAO();
		VisitorVO vo = new VisitorVO();
		vo.setName("희동이112");
		vo.setMemo("~~~오늘은 그냥 금요일~");
		boolean result = dao.insert(vo);
		if(result) out.println("삽입 성공");
		else fail("삽입 실패");
	}

}
