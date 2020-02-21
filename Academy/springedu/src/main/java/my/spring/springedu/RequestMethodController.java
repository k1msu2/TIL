package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMethodController {

	public RequestMethodController() {
		System.out.println("RequestMethodController 객체생성");
	}

	// default는 GET/POST 둘 다 지원  
	@RequestMapping(value = "/requestmethod", method = RequestMethod.GET)
	public String myGet1() {
		System.out.println("GET ............");
		return "getResult";
	}

	@RequestMapping(value = "/requestmethod", method = RequestMethod.POST)
	public String myPost() {
		System.out.println("POST ............");
		return "postResult";
	}
}






