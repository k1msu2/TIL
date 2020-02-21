package model.dao;
import java.util.List;
import org.junit.jupiter.api.Test;
import model.vo.NewsVO;

class NewsDAOTest {

	@Test
	void test2() {
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		
		/*
		 * vo.setWriter("이몽룡"); vo.setTitle("춘향이에게"); vo.setContent("ㅎㅎㅎㅎ");
		 * vo.setWritedate("2020-02-03T13:40"); vo.setCnt(vo.getCnt());
		 * 
		 * System.out.println(vo);
		 * 
		 * 
		 * if(dao.insert(vo)) { System.out.println("삽입성공"); }
		 * 
		 */
		/*
		 * List<NewsVO> list = dao.listAll(); for(NewsVO data : list) {
		 * System.out.println(data); }
		 */
		 //List<NewsVO> list;
		
		  NewsVO vo2 = dao.listOne(18);
		  System.out.println(vo2); 
		 
		  vo2.setWriter("test");
		  System.out.println(vo2); 
		  if(dao.update(vo2)) 
		  { 
			System.out.println("업데이트 성공");
		  	System.out.println(vo2.getWriter()); 
		  	vo2.setWriter("test"); 
		  }else {
			  System.out.println("업데이트 실패");
		  }
		  
		  
		/*
		 * if(dao.delete(1)) { System.out.println("삭제 성공"); list = dao.listAll();
		 * for(NewsVO data : list) { System.out.println(data); } }
		 */
		 
		 
		
	}

}
