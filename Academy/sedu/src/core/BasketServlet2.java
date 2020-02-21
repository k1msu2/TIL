package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String path = "c://logtest"; 
	File Folder = new File(path);
	File file = new File("c://logtest//mylog1.txt");
	FileWriter writer;
	SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmm");

  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); // 준비
		String jsonmsg="";
		String action = request.getParameter("action");
		
		if(action != null && action.equals("click")) {
			// 세션 
			if(session.getAttribute("products")==null)
				session.setAttribute("products", new int[10]);
			int[] session_p = (int []) session.getAttribute("products");
			
			// 상품정보 저장
			String pid = request.getParameter("pid");
			
			if(pid!=null) {
				int pnum = 0;
				Pattern p = Pattern.compile("[0-9]{3}");
				Matcher m = p.matcher(pid);
				while(m.find())
				{
					pnum = Integer.parseInt(m.group());
					System.out.println(pnum);
				}
				session_p[pnum-1] += 1;	// 상품 번호 1부터
			}
			else {
				System.out.println("상품없음");
			}
			
			// 세션에 저장된 상품정보
			String jsondata = "{";
			for(int i = 0; i < session_p.length; i++) {
				System.out.println(String.format("%03d", i+1));
				if(session_p[i] != 0) {
					jsondata += String.format("\"p%03d\":\"%d\",", i+1, session_p[i]);
				}
			}
			jsondata += "\"null\":\"null\"}";
			System.out.println(jsondata);
			out.println(jsondata);
			writeLog(pid);
		}
		
		// 세션 객체 삭제하기
		if(action != null && action.equals("destroy")) {
			session = request.getSession(false); // 클라이언트로부터 요
	    	if(session.getAttribute("products") != null) {
	    		session.setAttribute("products", null);
	    		session.invalidate(); // 무효화
	    		jsonmsg = "{\"msg\":\"상품이 모두 삭제되었습니다.\"}";
	    	} else {
	    		jsonmsg = "{\"msg\":\"상품이 없습니다.\"}";
	    	}
			out.println(jsonmsg);
			out.close();
			System.out.println(jsonmsg);
		}
	}
	void writeLog(String pid) throws IOException {
		// 로그저장
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); 
			    System.out.println("폴더가 생성되었습니다.");
		        }catch(Exception e){
			    e.getStackTrace();
			} 
		}else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
		
		if(!file.exists()) {
			try {
				if (file.createNewFile()){
					System.out.println("파일을 새로 만들었습니다.");
				}else {
					System.out.println("파일이 존재합니다.");
				}
			}catch(Exception e){
			    e.getStackTrace();
			}
		}
		writer = new FileWriter(file, true);
		String log = format1.format(new Date()) +  " " + pid +"\n";
		writer.write(log);
		writer.close();
	}

}
