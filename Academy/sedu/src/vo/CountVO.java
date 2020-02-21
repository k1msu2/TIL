package vo;

public class CountVO { 
	
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number += number;
	}	
}
//VO - value object : 값을 보관하는 데 필요한 생성자 정보, getter, setter 
//ex) StudentVO 