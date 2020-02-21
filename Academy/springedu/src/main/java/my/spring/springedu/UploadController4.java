package my.spring.springedu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController4 {
	@Autowired //자동으로 받아온다
	ServletContext context; // 서버가 기동 될때 톰캣이 생성해주는 것, 톰캣 서버는 프로젝트을 context 로 본다.
	@RequestMapping("/uploadForm3")
	public String formFile() {
		//return "uploadForm2"; // jsp 를 공유해서 쓰기 위한것.
		return "uploadForm3";
	}

	@RequestMapping("/upload3")
	public ModelAndView saveFile(MultipartRequest mreq) {
		ModelAndView mav = new ModelAndView();
		List<MultipartFile> list = mreq.getFiles("mfile");
		String resultStr = "";
		mav.setViewName("uploadForm3");
		for (MultipartFile mfile : list) {
			String fileName = mfile.getOriginalFilename();
			try {
				//context.getRealPath("/") 프로젝트의 최상위폴더
				//System.out.println(context.getRealPath("/"));
				//출력 결과 
				// C:\Users\student\Documents\eclipse-jee-2019-09-R-win32-x86_64\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\springedu\
				//String fileInfo = context.getRealPath("/") + "mypage/images/"+fileName;
				String fileInfo = context.getRealPath("/") + "resources/images/"+fileName;
				System.out.println(fileInfo);
				File f = new File(fileInfo);
				if (f.exists()) {
					resultStr += fileName + " : 파일이 이미 존재해요!!<br>";
				} else {
					mfile.transferTo(new File(fileInfo));
					resultStr += fileName + " : 파일이 저장되었어요!!<br>";
				}
			} catch (IOException e) {
				e.printStackTrace();
				resultStr += fileName + " : 오류가 발생했어요!!";				
			}
		}
		mav.addObject("msg", resultStr);	
		return mav;
	}
}
