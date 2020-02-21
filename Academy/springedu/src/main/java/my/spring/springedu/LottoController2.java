package my.spring.springedu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.LottoService;
import vo.CountVO;
import vo.LottoVO;

@Controller
@SessionAttributes({ "cvo" })
public class LottoController2 {
	boolean flag = true;
	
	@Autowired
	private LottoService lottoService;

	@ModelAttribute("cvo")
	public CountVO countMethod() {
		return new CountVO();
	}

	@RequestMapping("/lotto2")
	public String lottoProcess(@ModelAttribute("cvo") CountVO cvo, LottoVO vo) {
		if (flag && cvo.getCountNum() > 3) {
			vo.setResult("3번 참여하였습니다. 더 이상 참여할 수 없습니다.");
		} else {
			if (flag && lottoService.getLottoProcess(vo.getLottoNum())) {
				vo.setResult("추카추카!! 더 이상 참여할 수 없습니다.");
				flag = false;
			} else if (flag) {
				vo.setResult("아쉽네요 .. 다음 기회를!!");
			} else if (!flag) {
				vo.setResult("더 이상 참여할 수 없습니다.");
			}	
			
		}

		return "lottoView2";
		
	}
}
