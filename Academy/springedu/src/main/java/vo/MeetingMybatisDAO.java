package vo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//1. MeetingMybatisDAO객체 생성
//2. @Autowired 실행

@Repository
public class MeetingMybatisDAO implements MeetingDAO{
	
	@Autowired
	SqlSession session = null;
	
	public List<MeetingVO> listAll(){
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-listAll-DAO2");
		List<MeetingVO> list = null;
		String statement = "resource.MeetingMapper.selectMeeting";
		list = session.selectList(statement);
		return list;
	}
	public boolean insert(MeetingVO vo) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-insert-DAO2");
		boolean result = false;
		String statement = "resource.MeetingMapper.insertMeeting";
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
		
	}
	public List<MeetingVO> search(String keyword){
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-search-DAO2");
		List<MeetingVO> list = null;
		String statement = "resource.MeetingMapper.searchMeeting";
		list = session.selectList(statement, keyword);
		return list;
	
	}
	public boolean delete(int id) {
		int result = 0;
		boolean bresult = false;
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-delete-DAO2");
		String statement = "resource.MeetingMapper.deleteMeeting";
		result = session.delete(statement, id);
		
		if(result == 1) bresult = true;
		return bresult;
		
	}
	
	public MeetingVO list(int eNo) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-list-DAO2");
		MeetingVO vo = null;
		String statement = "resource.MeetingMapper.selectMeeting1";
		vo = (MeetingVO) session.selectList(statement, eNo);
		return vo;
	}
	
	public boolean update(MeetingVO vo) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-update-DAO2");
		boolean result = false;
		String statement = "resource.MeetingMapper.updateMeeting";
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}
	
}
