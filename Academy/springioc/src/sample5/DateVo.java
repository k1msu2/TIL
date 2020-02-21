package sample5;
public class DateVo {
	private String name;
	private String birth;
	// 생성자 메서드가 없음
	// setter 메서드 관련 소스임.
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return name + "'s birthday : " + birth;
	}
}
