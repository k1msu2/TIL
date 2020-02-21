package my.spring.springedu;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
	
	public HelloController() {
		System.out.println("HelloController Create object");
	}
	@RequestMapping("/hello") //controller method, handler method
	public ModelAndView xxx(){//이름은 중요하지 않음		
		ModelAndView mav = new ModelAndView(); // view + model(vo)
		mav.setViewName("helloView");
		mav.addObject("msg", getMessage()); // addObject = setattribute
		return mav;
	}
	private String getMessage() { // 일반 method
		int hour = Calendar.getInstance()
				.get(Calendar.HOUR_OF_DAY);		
		if(hour >= 6 && hour <= 10){
			return "Good Morning!!";
		}else if(hour >= 12 && hour <= 15){
			return "Good Afternoon";
		}else if(hour >= 18 && hour <= 22){
			return "Good Evening!!";
		}else{ 
			return "Hello!!";
		}
	}
}




