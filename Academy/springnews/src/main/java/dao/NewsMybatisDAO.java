package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;

@Repository
public class NewsMybatisDAO {

	@Autowired
	SqlSession session = null;
	
	public boolean insert(NewsVO vo) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-insert-DAO2");
		boolean result = false;
		String statement = "resource.NewsMapper.insertNews";
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}

	public boolean update(NewsVO vo) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-update-DAO2");
		boolean result = false;
		String statement = "resource.NewsMapper.updateNews";
		System.out.println(vo);
		if (session.insert(statement, vo) == 1)
			result = true;
		return result;
	}


	public boolean delete(int id) {
		boolean result = false;
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-delete-DAO2");
		String statement = "resource.NewsMapper.deleteNews";
		if (session.delete(statement, id) == 1)
			result = true;
		return result;
	}

	public List<NewsVO> listAll() {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-listAll-DAO2");
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.selectNews";
		list = session.selectList(statement);
		return list;

	}

	public NewsVO listOne(int id) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-list-DAO2");
		NewsVO vo = null;
		boolean result = false;
		String statement = "resource.NewsMapper.selectNews1";
		vo = session.selectOne(statement, id);
		
		statement = "resource.NewsMapper.updateNewsView";
		if (session.update(statement, id) == 1) {
			result = true;
			System.out.println("count 증가함");
		}
		System.out.println("vo : " + vo);
		if(result) return vo;
		else return null;
		
	}

	public List<NewsVO> listWriter(String writer) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-search-DAO2");
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.searchNews1";
		list = session.selectList(statement, writer);
		return list;
	}
	
	public List<NewsVO> search(String key, String searchType) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-search-DAO2");
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.searchNewsTitleAndContent";
		Map<String, String> hmap = new HashMap<String, String>();
		hmap.put("key", key);
		hmap.put("searchtype", searchType);
		list = session.selectList(statement, hmap);
		return list;
	}
	public List<NewsVO> searchAll(String key) {
		System.out.println("[Spring] Mybatis 를 사용 DB 연동-search-DAO2");
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.searchNewsAll";
		list = session.selectList(statement, key);
		return list;
	}
	public List<NewsVO> paging(List<NewsVO> list, int page) {
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
}
