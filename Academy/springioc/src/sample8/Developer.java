package sample8;

public class Developer{
	private Emp emp; //포함관계
	private String dept;
	
	public Developer() {
		super();
	}
	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return emp.toString() + " Department : " + dept;
	}
}
