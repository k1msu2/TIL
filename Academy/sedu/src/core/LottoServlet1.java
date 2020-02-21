package core;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lottonumstr = request.getParameter("lottonum");
		String url = "";
		if(lottonumstr != "") {
			int lottonum = Integer.parseInt(lottonumstr);
			Random random = new Random();
			int randnum = random.nextInt(6)+1;
			String jsonstr = "{ \"전달된 값\" : \"" + lottonum + "\" , \"추출된 값\" : \"" + randnum + "\"}";
			System.out.println(jsonstr);
			
			if(lottonum == randnum) {
				url = "/jspexam/success.jsp";
			}else {
				url = "/jspexam/fail.jsp";
			}			
		}else {
			url = "/html/lottoForm.html";
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
