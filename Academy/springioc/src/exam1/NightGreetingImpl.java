package exam1;

public class NightGreetingImpl implements Greeting{
	private String ment;

	@Override
	public void greet() {
		this.ment ="no ment";
	}

	public String getMent() {
		return ment;
	}

	public void setMent(String ment) {
		this.ment = ment;
	}
	
	@Override
	public String toString() {
		return ment;
	}
}
