package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestModelController2 {
	@ModelAttribute("data1") // request 객체 내에 data1 <- 리턴값 100
	public int createModel1() {	
		System.out.println("createModel() call - data1");
		return 100;
	}
	@ModelAttribute("data2")//  request 객체 내에 data2 <- 리턴값 200
	public int createModel2() {	
		System.out.println("createModel() call - data2");
		return 200;
	}
	@RequestMapping(value="/testmodel2") // request 객체 내의  data1 -> vo1
	public String handle(@ModelAttribute("data1") int vo1, 
			      @ModelAttribute("data2") int vo2) {// request 객체 내의  data1 -> vo2
		System.out.println("handle() : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
	}	
}


