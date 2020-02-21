package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news2")
public class NewsServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String subaction = request.getParameter("subaction");
		String newsid = request.getParameter("newsid");
		String searchtype = request.getParameter("searchtype");
		String key = request.getParameter("key");
		String writer = request.getParameter("writer");
		String page = request.getParameter("page");
		
		List<NewsVO> list = new ArrayList<>();
		NewsDAO dao = new NewsDAO();
		
		System.out.println(subaction);
		System.out.println(action);
		System.out.println(newsid);
		
		if(page==null) page = "1";
		
		if (subaction == null && action == null & newsid == null) {
			System.out.println("========ListAll=========");
			list = dao.listAll();	
			} else if (action != null && action.equals("read") && newsid != null) {
			System.out.println("========read======");
			request.setAttribute("action", "read");
			request.setAttribute("listOne", dao.listOne(Integer.parseInt(newsid)));
			list = dao.listAll();
			} else if (action != null && subaction == null && action.equals("delete") && newsid != null) {
			System.out.println("========delete======");
			if (dao.delete(Integer.parseInt(newsid))) {
				request.setAttribute("msg", newsid + "번 뉴스 삭제 완료되었습니다.");
			} else {
				request.setAttribute("msg", newsid + "번 뉴스 삭제 실패하였습니다.");
			}
			request.setAttribute("action", "delete");
			list = dao.listAll();
		} else if (action != null && subaction == null && action.equals("search")) {
			System.out.println("========search======");
			request.setAttribute("msg", key + " 로 검색된 뉴스 입니다.");
			request.setAttribute("action", "search");
			request.setAttribute("key", key);
			request.setAttribute("searchtype", searchtype);		
			list = dao.search(key, searchtype);
		} else if (action != null && subaction == null && action.equals("listwriter")) {
			System.out.println("========listwriter======");
			request.setAttribute("msg", writer + " 로 검색된 뉴스 입니다.");
			request.setAttribute("action", "listwriter");
			request.setAttribute("writer", writer);
			list = dao.listWriter(writer);
		} else if (action != null && subaction != null && action.equals("search") && subaction.equals("read")) {
			System.out.println("========search&read======");
			if (newsid == null) request.setAttribute("msg", key + " 로 검색된 뉴스 입니다.");
			else request.setAttribute("listOne", dao.listOne(Integer.parseInt(newsid)));
			request.setAttribute("action", "search");
			request.setAttribute("key", key);
			request.setAttribute("searchtype", searchtype);
			list = dao.search(key,searchtype);
		} else if (action != null && subaction != null && action.equals("listwriter") && subaction.equals("read")) {
			System.out.println("========listwriter&read======");
			if (newsid == null) request.setAttribute("msg", writer + " 로 검색된 뉴스 입니다.");
			else request.setAttribute("listOne", dao.listOne(Integer.parseInt(newsid)));
			request.setAttribute("action", "listwriter");
			request.setAttribute("writer", writer);
			list = dao.listWriter(writer);
		}
		
		request.setAttribute("numPages", 5);  
		request.setAttribute("listAll", dao.listAll(1,25, 0));
		request.getRequestDispatcher("/jspexam/news2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String newsid = request.getParameter("newsid");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String cnt = request.getParameter("cnt");
		String page = request.getParameter("page");
		
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();

		if(page == null) page = "1";
		
		if (action != null && action.equals("insert")) {
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCnt(0);
			if (dao.insert(vo)) {
				request.setAttribute("msg", "뉴스를 정상적으로 등록하였습니다.");
			} else {
				request.setAttribute("msg", "뉴스를 등록하지 못하였습니다.");
			}
		} else if (newsid != null && action != null && action.equals("update")) {
			vo.setId(Integer.parseInt(newsid));
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCnt(vo.getCnt());
			
			if (dao.update(vo)) {
				request.setAttribute("msg", "뉴스를 정상적으로 업데이트하였습니다.");
			} else {
				request.setAttribute("msg", "뉴스를 등록하지 업데이트 하지못하였습니다.");
			}
		} else {
			request.setAttribute("msg", "쿼리문 오류");
			System.out.println(action);
			System.out.println(newsid);
			System.out.println(writer);
			System.out.println(title);
			System.out.println(content);
			System.out.println(cnt);
		}

		List<NewsVO> list = dao.listAll();
		
		request.setAttribute("numPages", 5);
		request.setAttribute("listAll", dao.listAll(1,25, 0));
		request.getRequestDispatcher("/jspexam/news2.jsp").forward(request, response);
	}

}
