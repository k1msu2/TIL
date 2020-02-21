package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basket1")
public class BasketServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String path = "c://logtest"; 
	File Folder = new File(path);
	File file = new File("c://logtest//mylog1.txt");
	FileWriter writer;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmm");
	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");		
		String jsondata = "{\"pid\":\""+pid+"\"}";
		out.println(jsondata);
		out.close();
		
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
