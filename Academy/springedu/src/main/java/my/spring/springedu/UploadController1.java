package my.spring.springedu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.FileVO;
@Controller
public class UploadController1 {
	//WEB-INF에 존재. 웹클라이언트는 접근하지 못한다.
	@RequestMapping("/uploadForm1")
	public void formFile() { // view 이름을 mapping 명으로 사용한다. uploadForm1.jsp
		//view 로 접근하기 위해서 존재하는 컨트롤러 메서드.
	}
	@RequestMapping("/upload")
	public ModelAndView saveFile(FileVO vo) {
		// setUploadFile 자동호출됨	
		// request에 fileVO 로 찾은 후에 없으면 생성
	     String fileName =  vo.getUploadFile().getOriginalFilename();
	     System.out.println(fileName);
	     
	     byte[] content = null;
	     ModelAndView mav = new ModelAndView();
	     mav.setViewName("uploadForm1"); //uploadForm1.jsp
	     try {
	    	 content =  vo.getUploadFile().getBytes(); // 파일의 데이터를 바이트로. 
	    	 // getBytes() 이미지에대한 추가적인 액션(흑백사진)을 하려고 할떄 바이트형으로 받아서 처리
	    	 File f = new File("c:/uploadtest/"+fileName);
	    	 if ( f.exists() ) {
	    		 mav.addObject("msg", fileName + " : 파일이 이미 존재해요!!");
	    	 } else {
	    		 FileOutputStream fos = new FileOutputStream(f);
	    		 fos.write(content);
	    		 fos.close();
	    		 mav.addObject("msg", fileName + ": 파일이 저장되었어요!!");
	    	 }
	     } catch (IOException e) {
	    	 e.printStackTrace();
	    	 mav.addObject("msg", "오류가 발생했어요!!");
	     }	    
	    return mav;
	}
}

