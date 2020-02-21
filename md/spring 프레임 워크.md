### spring 프레임 워크

* 목표
  * 스프링MVC



1998년 EJB - enterprise java bean : FrameWork 의 시초

2005년 정도부터 FrameWork 기반의 개발이 주류를 이루게 된다

** Framwork

반제품 형태의 SW

개발 생산성과 유지보수성이 높다

Struts, Spring, **Mybatis(iBatis o, jdbc x)**, Hibernate....

* Spring

  * ***Spring IoC, Spring JDBC***, Spring MVC, Spring Android, Spring Hadoop(중단)

  * Spring IoC - Inversion of Conversion - > 모든 Spring XXX의 Base



Eclipse EE => Eclipse for Java Developer + WTP(플러그인plugin) + STS(Spring Tool Shoot) 추가 설치



브라우저는 HTML, XML, js 만 처리할 수 있다.

브라우저에서 pdf 볼수 있는 이유는 플러그인을 설치해서임.

플러그인 : 기능을 확장하는 용어로 사용.

![image-20200205141401276](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205141401276.png)



이클립스의 플러그인 설치하기 - help-eclipsemarket- 첫번째 설치

![image-20200205141937425](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205141937425.png)





(1) Spring IoC --> Java Application --> SpringIoC

(2) Spring MVC --> Web 기반 --> springedu

(3) Mybitis --> Web 기반 -->



<스프링 프로젝트 만들기>

![image-20200205143318772](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143318772.png)

![image-20200205143401047](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143401047.png)

![image-20200205143542961](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143542961.png)

![image-20200205143645964](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143645964.png)

![image-20200205143717357](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143717357.png)





pom.xml파일 생성됨

![image-20200205143757895](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205143757895.png)

### Maven 이란

* 메이븐을 쓴 이유 : 
* maven repository 통해 사용하고자하는 api 를 손쉽게 내려받아서 쓸수있다.
* 주로 api를 관리한다
* 프로젝트 관리 도구라고 생각하면 된다.
* pom.xml

![image-20200205144536711](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205144536711.png)

![image-20200205144600872](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205144600872.png)

복붙할 위치

-> 이 xml 코드를 복붙하고 저장을 하면  로컬 리포지토리에 저장을 하게 된다.

![image-20200205144802847](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205144802847.png)

이중에서 파일이 변경된다면 maven이 알아서 내려받게 된다.

컴퓨터를 새로 키게된다면 먼저 실행된다.  버젼체크



메이븐에 의해 관리되는 리포지토리

![image-20200205144947634](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205144947634.png)



설치하고싶은 라이브러리를 해당 싸이트에서 찾아서 디펜던시 코드를 pom.xml에 저장하면 관리를 할 수 있다.

graddle 도 많이 사용한다

![image-20200205145134427](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205145134427.png)

### DL(dependency lookup)

### DI(dependency injection)



* bean : 스프링 컨테이너가 관리해주는 자바 객체
* 



Scope(singleton) - 한번만 객체 생성
sample2.Foo@544fe44c
sample2.Foo@544fe44c
sample2.Foo@544fe44c



Scope(prototype) - 요청시 마다 객체 생성

(InterFoo)factory.getBean("foo0") -> getBean할때마다 객체 생성

Foo - Create object
sample2.Foo@544fe44c
Foo - Create object
sample2.Foo@31610302
Foo - Create object
sample2.Foo@71318ec4

http://www.springframework.org/schema/beans/spring-beans.xsd

.xsd -> 스키마 파일이라는 의미

빈 설정 파일 만들기

![image-20200205164329567](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205164329567.png)

![image-20200205164654086](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200205164654086.png)

네임스페이스를 추가/제거 할 수 있다.



필드에 설정된 @Autowired - Spring FW 전용

(1)타입으로 찾아서 1개이면 해당 객체 주입

(2) 타입으로 찾아서 2개 이상이면 변수명과 동일한 id





<!-- msg 인자가 있는 생성자  -->
<bean id="msg"  class="java.lang.String">
	<constructor-arg value="Happy Friday"/>
</bean>
<!--getMessage  -->
<bean id="message"  class="java.lang.String">
	<constructor-arg value="Happy Friday2"/>



제일 먼저 오토와이어링이 되는 

1. msg 가 인자로 있는 생성자를 찾는다.
2. msg 인자가 없으면 set 함수명을 찾는다.



## Spring MVC 프로젝트

![image-20200207133303747](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207133303747.png)

![image-20200207133328282](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207133328282.png)

![image-20200207133452498](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207133452498.png)

my.spring.springedu --> sts 가 이렇게 쓰라고 정해놓음

![image-20200207134115046](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207134115046.png)

![image-20200207134159733](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207134159733.png)

* /src/main/java
  * 주로 개발하는 폴더

![image-20200207134550409](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207134550409.png)

![image-20200207134527110](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207134527110.png)



* 테스트하기
* http://localhost:8000/springedu/

![image-20200207134713319](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207134713319.png)

![image-20200207141517311](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207141517311.png)

html, img 등 클라이언트에서 요청하는 리소스 폴더 

 : sprinngedu > src>main>webapp>resources



![image-20200207141659068](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207141659068.png)

![image-20200207141739043](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207141739043.png)

![image-20200207142056135](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207142056135.png)



#### 시스템 설정



1. springedu > Properties > text file encoding

![image-20200207142215150](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207142215150.png)



2. web_xml 에 넣을 내용

- 한글 문제를 해결하기 위한 필터

- @는 소스가 없으면 못 사용해서

  ```xml
  <filter>
      <filter-name>encodingFilter</filter-name>
      <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
      <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
      </init-param>
    </filter>
    <filter-mapping>
      <filter-name>encodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>
  ```

  ![image-20200207142712406](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207142712406.png)

3. 자바 / 스프링 프레임워크 버전 변경

![image-20200207142811015](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207142811015.png)





* 예제 소스 넣기
* ![image-20200207151617817](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207151617817.png)

![image-20200207152052447](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207152052447.png)



* [1번째 예제]HelloController.java

  POJO - Plain Old Java Object - 순수한 자바 객체(상속x)

  ![image-20200207153218997](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207153218997.png)



* 빈객체 설정하는 파일
* ![image-20200207154341133](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207154341133.png)

![image-20200207154404068](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207154404068.png)



![image-20200207154539283](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207154539283.png)

mvc 기반의 beans만 beans 가 안 붙는다 (디폴트 이기 때문)



```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven /> 	<!--mvc 라 beans가 안 붙음 -->

	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<context:component-scan base-package="my.spring.springedu" />
	
	
	
</beans:beans>

```

* [2번째 예제] multl.html

![image-20200207154853847](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207154853847.png)



http://localhost:8000/springedu/character/detail/kakao/1

WEB-INF > views 에 있는 jsp는 direct 로 응답하지 못한다



* 컴파일러의 자바 버젼 변경하는 방법
* ![image-20200210134615543](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200210134615543.png)



어노테이션 적용하기



![image-20200211114636590](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200211114636590.png)

![image-20200211152431546](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200211152431546.png)



jackson-databind : @ response body 에서 필요한 라이브러리를 다운 받기 위한 디펜던시 태그.

jsp 를 안거치고 컨트롤러가 바로 응답하게끔한다.

![image-20200211152639781](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200211152639781.png)



<파일업로드>

* 빈 객체 생성

![image-20200212142841034](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200212142841034.png)



<>

servlet context 의 getrealpath

업로드

![image-20200212154819512](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200212154819512.png)



데이터 url 형식으로 저장됨

서버와 로컬에도 저장될 수 있다.





