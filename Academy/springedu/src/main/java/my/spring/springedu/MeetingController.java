package my.spring.springedu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MeetingDAO;
import vo.MeetingVO;

@Controller
public class MeetingController {
	@Autowired
	MeetingDAO dao;
	
	@RequestMapping("/meetingForm")
	protected String form() {
		return "meetingView_jstl";
	}	
	
	@RequestMapping("/meeting")
	public ModelAndView handle(
			MeetingVO vo, String action, 
			String keyword, String id) {
		String msg = null;
		ModelAndView mav = new ModelAndView();
		List<MeetingVO> list;
		System.out.println(vo);
		System.out.println(action);
		System.out.println(keyword);
		System.out.println(id);
		if(keyword == null) {
			if(action != null && action.equals("delete")) {
				boolean result = dao.delete(Integer.parseInt(id));
				System.out.println("delete!!!!");
				if (result) {
					msg = "글이 성공적으로 삭제되었습니다.";
				} else {
					msg = "글이 삭제되지 않았습니다.";
				}
			}else if(action != null && action.equals("insert")) {
				System.out.println("insert!!!!!!");
				boolean result = dao.insert(vo);
				if (result) {	
					msg = "성공적으로 입력되었습니다.";
				} else {
					msg = "글이 입력되지 않았습니다.";
					
				}
			} else if(action != null && action.equals("update")){
				System.out.println("update!!!!!!!!!");
				vo.setId(vo.getId());
				boolean result = dao.update(vo);
				if (result) {		
					msg = "글이 성공적으로 수정되었습니다.";			
				} else {
					msg = "글이 수정되지 않았습니다.";
				}
			}else if(action != null && action.equals("listall")) {
				System.out.println("listall!!!!!!!!!");
			}
			list = dao.listAll();
			
		} else {
			System.out.println("search!!!!!");
			list = dao.search(keyword);
			if (list != null && list.size() == 0) {
				msg = keyword + "(이)가 포함된 글이 없습니다.";
			} 
		}
		System.out.println(list);
		mav.addObject("list",list);
		mav.addObject("msg", msg);
		mav.setViewName("meetingView_jstl");
		return mav;
	}
	
}
