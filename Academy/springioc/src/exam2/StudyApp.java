package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("exam2/bean2.xml");
		
		Student st;
		
		st = factory.getBean("st1", Student.class);
		System.out.println(st.toString());
		//System.out.println(String.format("%s는 %s를 학습합니다.", st.getName(), st.getMyHomework().getHomeworkName()));
		
		st = factory.getBean("st2", Student.class);
		System.out.println(st.toString());
		//System.out.println(String.format("%s는 %s를 학습합니다.", st.getName(), st.getMyHomework().getHomeworkName()));

		st = factory.getBean("st3", Student.class);
		System.out.println(st.toString());
		//System.out.println(String.format("%s는 %s를 학습합니다.", st.getName(), st.getMyHomework().getHomeworkName()));
	}

}
