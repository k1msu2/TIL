package sample1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloSpringApp {
	public static void main(String[] args) {
		ApplicationContext factory //beans.xml을 사용하여 스프링 컨테이너 초기화하는 코드, src폴더 기준으로 찾음
		    	= new ClassPathXmlApplicationContext("sample1/beans.xml");
		System.out.println("**** Container Initialization End ****");
		
		MessageBean bean=(MessageBean)factory.getBean("messageBean");
		bean.sayHello(); // 객체의 멤버 변수 호출                
		bean.sayHello("banana", 1500);  // 매개변수 호출
		
		///////----참조값 똑 같음----/////
		System.out.println(bean);
		System.out.println(factory.getBean("messageBean"));
		System.out.println(factory.getBean("messageBean"));
		((ClassPathXmlApplicationContext)factory).close();
	}
}





