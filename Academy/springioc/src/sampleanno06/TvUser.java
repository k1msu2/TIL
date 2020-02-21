package sampleanno06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {
	public static void main(String[] args) {
		
		// 스프링컨테이너가 실행될때 객체가 전부 생성된다.
		ApplicationContext factory
		        = new ClassPathXmlApplicationContext("sampleanno06/bean.xml");
		
		Tv tv=factory.getBean(args[0], Tv.class);   //samsung or lg
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
