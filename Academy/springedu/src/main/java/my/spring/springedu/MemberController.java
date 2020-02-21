package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

@Controller
public class MemberController {
	@RequestMapping("/member")
	public ModelAndView member(MemberVO membervo) {
		ModelAndView mav = new ModelAndView();
		
		if(membervo.getId().equals("")) membervo.setId("없음");
		if(membervo.getName().equals("")) membervo.setName("없음");
		if(membervo.getPhone().equals("")) membervo.setPhone("없음");
		if(membervo.getPasswd().equals("")) membervo.setPasswd("없음");
		
		///방법1
		mav.addObject("id", membervo.getId());
		mav.addObject("name", membervo.getName());
		mav.addObject("phone", membervo.getPhone());
		mav.addObject("passwd", membervo.getPasswd());
		
		//방법2 
		mav.addObject("membervo",membervo);
		
		mav.setViewName("memberView");
		return mav;
	}
	
}
