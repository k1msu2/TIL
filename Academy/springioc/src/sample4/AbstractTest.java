package sample4;
import java.util.Calendar;
import java.util.GregorianCalendar;
public abstract class AbstractTest {
	public abstract String dayInfo();	
	
	// 팩토리가 되려면....
	// 조건 1. static
	// 조건 2. return 값이 class 명과 일치 
	// AbstractTest.getInstance()로 객체 생성해된다.
	// 생성자로는 객체 생성이 안된다.
	// runtime.getruntime() 과 같은 경우...
	// factory-method="getInstance" 구문으로 팩토리 메서드를 명시해줄 수 있다.
	// 기본은 생성자로 객체 생성을 하는데 팩토리 메서드로 객체를 생성을 해야하는 경우
	public static AbstractTest getInstance(){
		GregorianCalendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_WEEK);
		AbstractTest test = null;
		switch(day)
		{
			case 1 : test = new Sunday(); break;
			case 2 : test = new Monday(); break;
			case 3 : test = new Tuesday(); break;
			case 4 : test = new Wednesday(); break;
			case 5 : test = new Thursday(); break;
			case 6 : test = new Friday(); break;
			case 7 : test = new Saturday(); break;
		}
		return test;
	}
}
