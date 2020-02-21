package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.ProductVO;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		String pName = request.getParameter("pname");
		
		if(session.getAttribute("psession") == null) {
			session.setAttribute("psession", new ProductVO());
		}
		ProductVO vo = (ProductVO)session.getAttribute("psession");
		
		if(pName.equals("del")) {
			if(session!=null) {
				session.invalidate();
			}
			request.getRequestDispatcher("/jspexam/ProductDel.jsp").
            forward(request, response);
		}else {
			if(pName.equals("p001")) vo.setAppleNum();
			if(pName.equals("p002")) vo.setBananaNum();
			if(pName.equals("p003")) vo.setHallabongNum();
			request.getRequestDispatcher("/jspexam/productView.jsp").
	        forward(request, response);
		}

	}
}
