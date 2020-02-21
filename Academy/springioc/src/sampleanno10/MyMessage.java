package sampleanno10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // myMessage 객체 
@Scope("prototype") 
public class MyMessage {
	@Autowired // 객체를 넣어주는 것을 인젝션이라고 한다
	String message;
	
	public MyMessage(){
		System.out.println("Create object 0 : "+message);		
	}
	//@Autowired //객체 생성할 생성자
	public MyMessage(String msg){
		System.out.println("Create object 1 : "+msg);		
	}
	@Autowired
	public void setMessage(String message) {
		System.out.println("SETTER : "+message);
		this.message = message;
	}
	@Autowired
	public void ccc(String message) {
		System.out.println("ccc : "+message);
		this.message = message;
	}
	@Autowired
	public void aaa(String message) {
		System.out.println("aaa : "+message);
		this.message = message;
	}
	@Autowired
	public void bbb(String message) {
		System.out.println("bbb : "+message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}	
}
