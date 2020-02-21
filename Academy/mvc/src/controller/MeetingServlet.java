package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	MeetingJDBCDAO dao = new MeetingJDBCDAO();
	List<MeetingVO> list;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String keyword = request.getParameter("keyword");
		
		if(action != null) {
			if (action.equals("delete")) {
				int seqid = Integer.parseInt(request.getParameter("seqid"));
				if(dao.delete(seqid)) request.setAttribute("msg", "스케쥴 삭제하였습니다.");
				else request.setAttribute("msg", "스케쥴 삭제하지 못했습니다.");
				list = dao.listAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
			}else if(action.equals("listall")) {
				list = dao.listAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
			}
		}
		if(keyword != null){
			list = dao.search(keyword);
			if(!keyword.equals("")) {
				request.setAttribute("msg", "[" + keyword + "]" + " 검색을 완료하였습니다.");
			}else {
				request.setAttribute("msg", "[" + keyword + "]" + " 검색어가 없습니다.");
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String meetingDate = request.getParameter("meetingDate");

		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(meetingDate);

		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		if (dao.insert(vo)) {
			System.out.println("삽입 완료");
			request.setAttribute("msg", "스케줄 등록되었습니다.");
			request.setAttribute("list", list);
		}
		else {
			System.out.println("삽입 실패");
			request.setAttribute("msg", "스케줄 등록에 실패하였습니다.");
		}
		List<MeetingVO> list = dao.listAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jspexam/meetingView_jstl.jsp").forward(request, response);
	}

}
