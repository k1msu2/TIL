package my.spring.springedu;
import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController extends HttpServlet {
	@RequestMapping("/calc")
	public ModelAndView calc(String operator, int num1, int num2) {
		ModelAndView mav = new ModelAndView();
		String url;
		if(operator.equals("divide") && num2 == 0) {
			url = "/errorResult";
			String errorRes= "나눗셈 연산시 두번째 숫자는 0일 수 없습니다!!";
			mav.addObject("result", errorRes);
		}else {
			int calcRes = 0;
			url = "/calcResult";
			if(operator.equals("plus")) calcRes = num1 + num2;
			else if(operator.equals("minus")) calcRes = num1 - num2;
			else if(operator.equals("multiply")) calcRes = num1 * num2;
			else if(operator.equals("divide")) calcRes = num1 / num2;
			mav.addObject("result", calcRes);
		}
		mav.setViewName(url);
		return mav;
	}
	

}
