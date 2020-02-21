package sample8;

public class Engineer{
	private Emp emp;
	private String dept;

	public Engineer() {
		super();
	}
	//첫번쨰 생성자 객체 emp
	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return emp.toString() + " Department : " + dept;
	}
}
