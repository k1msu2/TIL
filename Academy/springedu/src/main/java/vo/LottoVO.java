package vo;

public class LottoVO {
	// lottoNum 클라이언트에서 전송된 쿼리문자열이 자동으로 저장된다
	// 컨트롤러와 뷰가 공유하는 객체이다
	private int lottoNum;
	private String result; // result 는 클라이언트한테 전송할 메시지를 저장하기 위한 멤버 변수
	public LottoVO()  {
		System.out.println("LottoVO Create object");
	}
	public int getLottoNum() {
		return lottoNum;
	}
	public void setLottoNum(int lottoNum) {
		this.lottoNum = lottoNum;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}	
}
