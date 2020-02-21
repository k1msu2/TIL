package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.LottoDAO;
@Service //스프링 컨테이너가 ..
public class LottoService {
	public LottoService()  {
		System.out.println("LottoService 객체생성");
	}
	@Autowired // LottoDAO에 의존적, 이 객체를 찾아서 주입을 시켜줘야하는 상황
	LottoDAO lottoDAO = null;
	public boolean getLottoProcess(int lottoNum) {
		boolean result = false;		
		int randomNumber = lottoDAO.getLottoNumber();
		System.out.println("--- 난수: " + randomNumber);
		System.out.println("--- 입력한 수: " + lottoNum);
		if(randomNumber == lottoNum) 
			result = true;
		return result;
	}
} 
