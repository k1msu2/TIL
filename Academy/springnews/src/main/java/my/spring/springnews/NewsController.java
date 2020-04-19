package my.spring.springnews;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import dao.NewsMybatisDAO;
import vo.NewsQueryVO;
import vo.NewsVO;

@Controller
public class NewsController {

	@Autowired
	//NewsDAO dao;
	NewsMybatisDAO dao;

	@RequestMapping("/news")
	public ModelAndView handle(NewsVO vo, NewsQueryVO qvo) {
		ModelAndView mav = new ModelAndView();
		List<NewsVO> list = new ArrayList<>();
		
		String newsid = qvo.getNewsid();
		String writer = vo.getWriter();
		String action = qvo.getAction();
		String subaction = qvo.getSubaction();
		String searchtype = qvo.getSearchtype();
		String key = qvo.getKey();
		String page = qvo.getPage();
		
		System.out.println(newsid);
		System.out.println(subaction);
		System.out.println(action);
		System.out.println(newsid);

		if (page == null)
			page = "1";

		if (subaction == null && action == null & newsid == null) {
			System.out.println("========ListAll=========");
			list = dao.listAll();
		} else if (action != null && action.equals("read") && newsid != null) {
			System.out.println("========read======");
			mav.addObject("action", "read");
			mav.addObject("listOne", dao.listOne(Integer.parseInt(newsid)));
			list = dao.listAll();
		} else if (action != null && subaction == null && action.equals("delete") && newsid != null) {
			System.out.println("========delete======");
			if (dao.delete(Integer.parseInt(newsid))) {
				mav.addObject("msg", newsid + "번 뉴스 삭제 완료되었습니다.");
			} else {
				mav.addObject("msg", newsid + "번 뉴스 삭제 실패하였습니다.");
			}
			mav.addObject("action", "delete");
			list = dao.listAll();
		} else if (action != null && subaction == null && action.equals("search")) {
			System.out.println("========search======");
			mav.addObject("msg", key + " 로 검색된 뉴스 입니다.");
			mav.addObject("action", "search");
			mav.addObject("key", key);
			mav.addObject("searchtype", searchtype);
			if(searchtype.equals("all")) {
				list = dao.searchAll(key);
			}else {
				list = dao.search(key, searchtype);
			}
			mav.addObject("list", list);
		} else if (action != null && subaction == null && action.equals("listwriter")) {
			System.out.println("========listwriter======");
			mav.addObject("msg", writer + " 로 검색된 뉴스 입니다.");
			mav.addObject("action", "listwriter");
			mav.addObject("writer", writer);
			list = dao.listWriter(writer);
		} else if (action != null && subaction != null && action.equals("search") && subaction.equals("read")) {
			System.out.println("========search&read======");
			if (newsid == null)
				mav.addObject("msg", key + " 로 검색된 뉴스 입니다.");
			else
				mav.addObject("listOne", dao.listOne(Integer.parseInt(newsid)));
			
			mav.addObject("action", "search");
			mav.addObject("key", key);
			mav.addObject("searchtype", searchtype);
			if(searchtype.equals("all")) {
				list = dao.searchAll(key);
			}else {
				list = dao.search(key, searchtype);
			}
			mav.addObject("list", list);
		} else if (action != null && subaction != null && action.equals("listwriter") && subaction.equals("read")) {
			System.out.println("========listwriter&read======");
			if (newsid == null)
				mav.addObject("msg", writer + " 로 검색된 뉴스 입니다.");
			else
				mav.addObject("listOne", dao.listOne(Integer.parseInt(newsid)));
			mav.addObject("action", "listwriter");
			mav.addObject("writer", writer);
			list = dao.listWriter(writer);
		} else if (action != null && action.equals("insert")) {
			System.out.println("========insert======");
			vo.setCnt(0);
			if (dao.insert(vo)) {
				mav.addObject("msg", "뉴스를 정상적으로 등록하였습니다.");
			} else {
				mav.addObject("msg", "뉴스를 등록하지 못하였습니다.");
			}
			list = dao.listAll();
		} else if (newsid != null && action != null && action.equals("update")) {
			vo.setId(Integer.parseInt(newsid));
			vo.setCnt(vo.getCnt());
			if (dao.update(vo)) {
				mav.addObject("msg", "뉴스를 정상적으로 업데이트하였습니다.");
			} else {
				mav.addObject("msg", "뉴스를 등록하지 업데이트 하지못하였습니다.");
			}
			list = dao.listAll();
		} else {
			mav.addObject("msg", "쿼리문 오류");
		}

		
		int lsize = list.size();
		int numPages = lsize % 5 == 0 ? lsize / 5 : lsize / 5 + 1;
		mav.addObject("numPages", numPages);
		mav.addObject("listAll", dao.paging(list, Integer.parseInt(page)));
		mav.addObject("page", page);
		mav.setViewName("news");
		
		//mav.addObject("listAll", list);	
		//mav.setViewName("news");
		
		return mav;
	}

}
