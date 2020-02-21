package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		System.out.println(name);
		if(name=="") name="없음";
		if(phone=="") phone="없음";
		if(id=="") id="없음";
		if(passwd=="") passwd="없음";
		
		MemberVO vo = new MemberVO();
		
		vo.setName(name);
		vo.setPhone(phone);
		vo.setId(id);
		vo.setPasswd(passwd);
		
		request.setAttribute("membervo", vo);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
		              	
	}

}
