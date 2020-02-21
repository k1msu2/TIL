package sampleanno04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //스프링 컨테이너가 객체 생성을 대신 해준다는 어노테이션
public class Engineer {
	//@Autowired // 멤버변수, setter메서드 가능
	//@Qualifier("emp1") // autowired의 서브 역할. "emp1"으로 오토와이어링 해줘.
	@Resource(name="emp1")
	private Emp emp;
	private String dept;
	
	public Engineer() {
		super();
	}
	@Autowired //일반 메서드 도 가능
	public void ddd(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp.toString()+"\n"+ "and works at the "+dept+" department.";
	}
}








