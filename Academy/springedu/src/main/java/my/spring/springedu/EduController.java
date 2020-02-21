package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {
	//request 랑 response 가 같은 jsp 면 view 명을 리턴해주지 않아도 된다.
	@RequestMapping(value="/eduform2", method=RequestMethod.POST)
	public String procPost(
			@RequestParam("score") int myscore){
		//ModelAndView mav = new ModelAndView();
		String view;
		switch(myscore/10) {
		case 10:
		case 9:
			view = "gradeA";
			//mav.setViewName("gradeA"); 
			break;
		case 8:
			view = "gradeB";
			//mav.setViewName("gradeB");
			break;
		case 7:
			view = "gradeC";
			//mav.setViewName("gradeC");
			break;
		default:
			view = "gradeD";
			//mav.setViewName("gradeD");
			break;
		}
		return view;
	}
	

}
