package my.spring.springedu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vo.CountVO;
@Controller 
@SessionAttributes({"count1", "count2"}) // count1, count2 모두 세션 스코프
public class CountController {
	@ModelAttribute("count1")
	public CountVO countMethod1() {	
		System.out.println("countMethod1 호출 - count1");
		return new CountVO();
	}
	@ModelAttribute("count2")
	public CountVO countMethod2() {
		System.out.println("countMethod2 호출 - count2");		
		return new CountVO();
	}	
	//리턴값이 void 일 경우에는 매핑명과 같은 jsp 파일로 연결됨
	@RequestMapping(value="/count")
	public void handle(
				@ModelAttribute("pnum1")CountVO vo1, 
			    @ModelAttribute("pnum2")CountVO vo2, 
			    int num1, int num2) { ///int 형은 값을 안주면 에러난다, string은 null 값이 알아서..
		vo1.setCountNum(num1);
		vo2.setCountNum(num2);
		System.out.println("handle() : "+ 
			      vo1.getCountNum() + " : " + vo2.getCountNum());
		System.out.println("=============================");
	}
	@RequestMapping(value="/countdel")
	public void handle(SessionStatus s) {
		s.setComplete(); // 세션객체는 남겨놓지만 세션객체에 보관되어 있는 값 제거
		System.out.println("Both count1 and count2 deleted!");	
		System.out.println("=============================");
	}
}



