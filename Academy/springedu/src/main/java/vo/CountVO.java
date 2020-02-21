package vo;

import org.springframework.context.annotation.Scope;
@Scope("prototype")
public class CountVO {
	private int countNum;
	public CountVO() {
		System.out.println("CountVO 객체 생성!!");
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		this.countNum += countNum;
	}	
}
