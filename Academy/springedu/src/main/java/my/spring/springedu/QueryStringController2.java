package my.spring.springedu;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.QueryVO;
@Controller
public class QueryStringController2 {	
	@RequestMapping("/querystring5")
	public ModelAndView proc(QueryVO vo) { // QueryVO-> queryVO 로 Request 객체에 저장된다
		ModelAndView mav = new ModelAndView();
		String name = vo.getTestName();
		int age = vo.getTestAge();
		String addr = vo.getTestAddr();
		mav.addObject("spring", name + "-" + age + "-" + addr);
		mav.setViewName("queryView3");
		return mav;
	}	
	@RequestMapping(value = "/querystring6", 
			                      method = RequestMethod.POST)
	public ModelAndView procPost(QueryVO vo) {
		// 한글 필터 처리해서 설정할 필요 없음.
		ModelAndView mav = new ModelAndView();
		String name = vo.getTestName();
		int age = vo.getTestAge();
		String addr = vo.getTestAddr();
		mav.addObject("spring", name + "@" + age + "@" + addr);
		mav.setViewName("queryView3");
		return mav;
	}
	@RequestMapping("/querystring7")
	//HttpServletRequest request 디스패처서블릿이 알아서 해줌
	public ModelAndView proc(HttpServletRequest request) {
		// 직접 쿼리 추출
		ModelAndView mav = new ModelAndView();
		String name =request.getParameter("testName");
		int age = Integer.parseInt(request.getParameter("testAge"));
		String addr = request.getParameter("testAddr");
		mav.addObject("spring", name + "#" + age + "#" + addr);
		mav.setViewName("queryView3");
		return mav;
	}
	@RequestMapping(value="/locale.do")
	//요청을 보내온 클라이언트의 로케일 정보를 받을 때, DS 가 알아서 해준다
	public ModelAndView proc(Locale l) { // Locale타입의 매개변수. 
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", "Processing locale ............"+
		       l.getDisplayCountry()+"_"+l.getDisplayLanguage());
		mav.setViewName("queryView3");
		return mav;
	}
	
	@RequestMapping(value="/locale.test")
	//요청을 보내온 클라이언트의 로케일 정보를 받을 때, DS 가 알아서 해준다
	public ModelAndView proc(Locale l, HttpServletRequest request) { // Locale타입의 매개변수. 
		String name =request.getParameter("testName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", "Processing locale ............"+
		       l.getDisplayCountry()+"_"+l.getDisplayLanguage() + name);
		mav.setViewName("queryView3");
		return mav;
	}
}






