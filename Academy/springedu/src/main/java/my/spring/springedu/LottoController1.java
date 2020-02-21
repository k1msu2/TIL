package my.spring.springedu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.LottoService;
import vo.LottoVO;
@Controller
public class LottoController1 {
	//필요한 객체는 
	@Autowired //주입받을 것이라는 어노테이션
	private LottoService lottoService;	
	@RequestMapping("/lotto1")
	public String lottoProcess(LottoVO vo) { // LottoVO에서 lottoNum 멤버변수를 lottoServie에 전달한다
		// lottVO라는 이름을 가진 객체를 디스패쳐 서블릿이 리퀘스트 스코프 영역에 저장한다.
		// 만약에 지역 변수명으로 또다시 lottoService 객체를 다시 만들면 널포인트 입섹션 에러가 발생한다.
		// LottoService lottoService = new LottoService();
		if (lottoService.getLottoProcess(vo.getLottoNum())) {
			vo.setResult("추카추카!!"); // 메시지를 vo 객체에 담고 있다.
		} else {
			vo.setResult("아쉽네요 .. 다음 기회를!!");
		}
		return "lottoView1";
	}
}



