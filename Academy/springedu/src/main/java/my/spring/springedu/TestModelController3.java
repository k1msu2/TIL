package my.spring.springedu;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
// 세션객체에 저장
// 1. 매개변수로 HttpServletRequest 사용
/*@RequestMapping(value = "/modify", method = RequestMethod.POST)
public ModelAndView modify(Member member, HttpServletRequest request) {

        HttpSession session = request.getSession();

        Member mem = service.memberModify(member);
        session.setAttribute("member", mem);

        ModelAndView mav = new ModelAndView();
        mav.addObject("memAft", mem);
        mav.setViewName("/member/modifyOk");

        return mav;
}
*/
// 1. 매개변수로 httpsession 사용
// 2. @SessionAttributes 애노테이션 사용

@Controller
@Scope("prototype")
@SessionAttributes("data1") // 세션객체에 저장
public class TestModelController3 {
	@ModelAttribute("data1")
	public StringBuffer createModel1() {	
		System.out.println("createModel1() 호출 - data1(session)");
		return new StringBuffer();
	}
	@ModelAttribute("data2") //리퀘스트객체에 보관
	public StringBuffer createModel2() {	
		System.out.println("createModel2() 호출 - data2(request)");
		return new StringBuffer();
	}
	@RequestMapping(value="/testmodel3")
	public String handle(
			@ModelAttribute("data1") StringBuffer vo1, 
			@ModelAttribute("data2") StringBuffer vo2, 
			String str) { // 클라이언트에서 전달받아야함
		vo1.append(str+":");
		vo2.append(str+"@");
		System.out.println("handle 에서 출력 : "+vo1 + " - " + vo2);
		System.out.println("=============================");
		return "modelResult2";
	}	
}
