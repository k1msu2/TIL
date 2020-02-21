package exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.time.LocalDateTime;

public class GreetingTest {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("exam1/beans.xml");
		
		Greeting bean;
		LocalDateTime time =factory.getBean("time",LocalDateTime.class);

		int hour = time.getHour();
		if(6<=hour&&hour<12) {
			bean = factory.getBean("morning",Greeting.class);
		}else if(12<=hour&&hour<17) {
			bean = factory.getBean("afternoon",Greeting.class);
		}else if(17<=hour&&hour<22) {
			bean = factory.getBean("evening",Greeting.class);
		}else {
			bean = factory.getBean("night",Greeting.class);
		}
		
		System.out.println(bean.toString());
		((ClassPathXmlApplicationContext)factory).close();
	}
}
