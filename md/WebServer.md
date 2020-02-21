WebServer

Web Client : HTML5, CSS3, JavaScript ---> edu

Web Server : Servlet, JSP, (JDBC), Spring FW, MyBatis FW, (Junit FW, Log4J) - Java ---> sedu



dynamic project > properties ->othere

![image-20200116110733788](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116110733788.png)

![image-20200116110913735](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116110913735.png)

![image-20200116110938213](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116110938213.png)

![image-20200116110947436](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116110947436.png)

톰캣에 서버 등록하기

```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> 안녕하세요.<%= request.getParameter("gname") %> 회원님~</h1>
</body>
</html>
```



동적인 처리를 프론트에서 할때는 javascript

동적인 처리를 서버에서 할때는 jsp, servlet



![image-20200116112717122](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116112717122.png)

![image-20200116112746661](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116112746661.png)

![image-20200116112851205](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116112851205.png)

![image-20200116112921223](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116112921223.png)

[Servlet]

- 1998년 가을에 발표된 기술

- CGI(Common Gateway Inteface) - 웹의 표준, 구현언어 투명성, 서버 디펜던시 

- --> Fast CGI : 구현하기 어려움

- --> Servlet : 자바로 구현하여 쉬움

- Server Side Applet(Applet: 웹 브라우저에서 실행되는 Java 프로그램)

- 서버에서 수행되는 자바 프로그램이구나~

- 구현상의 특징

  - HTTPServlet 을 상속해야 한다. is-a 관계
  - main() 구현하지 않는다.
  - main()메서드를 담고 있는 메인 클래스는 톰캣이 내장
  - firstservlet 객체 생성하여 정해저있는 메소드를 호출시켜서 실행함.
  - 수행하는 동안 호출되는 메서드가 정해져 있는데 이때 호출되는 메서는 init(), service(), destory(), doGet(), doPost() 등이다.
  - 하여 이 메서드들을 선택적으로 오버라이딩 해서 구현한다.
  - 서블릿에서는 수행 결과를 출력할때 출력 방향을
    - 요청해온 브라우저로의 출력(응답) - HttpServletResponse 의 getWriter()를 호출해서 클라이언트의 출력 객체를 생성
    - 표준 출력 : System.out.println() - 톰캣서버의 콘솔창에 출력
  - 서블릿이 수행하는데 필요한 데이터를 요청 보내오는 클라이언트로 부터 전달받을 수 있다. 이때 전달 받는 데이터를 쿼리문자열이라고 한다.
    - HttpServletRequest 의 getParameter():String 또는 getParameterValues():String[]를 사용한다. 

- 수행상의 특징

  * 클라이언트가 서블릿을 요청해올 때 누가 요청되었는지 알아서 잘 판단.
  * 서버가 클라인트가 무엇을 요청했는지 무엇을 보고 아나? 
    * .html/.jsp 확장자를 가지고 알수 있는데, 서블릿은 확장자를 주지 않는다. 
    * 자바프로그램의 확장자는 .class 이다. 
    * 서블릿이나 애플릿이나 .class 이다.
    * 하지만 애플릿이 먼저 나왔고. 서블릿은애플릿과 구분하기 위해서 확장자는 쓰지 않는다. 
    * 대신 매핑명을 사용한다. @WebServlet("/firstone")

  * 서블릿을 요청할 때는 "/컨텍스트루트명/서블릿의매핑명" 형식의 URI 를 사용한다. 
  * 서블릿의 요청은 
    * 서블릿을 요청하는 URL 문자열을 브라우저의 주소 필드에 입력해서 직접 요청 (GET방식)
    * <a> 태그로 요청 (GET방식)
    * \<form> 태그를 통해서 요청 (GET/POST방식)

  * 서블릿 객체는 한번 생성되는 서버 종료되거나 컨텍스트가 리로드될때까지 객체 상태를 유지한다.
    * CGI 는 객체를 메모리에 올렸다가 내렸다가 한다. 
    * 서블릿 객체는 처음에 메모리에 올리는데 시간이 걸리나. 한번 올려서 계속 사용한다. 
  * 여러클라이언트가 동일한 서블릿을 동시 요청하면 하나의 서블릿 객체를 공유해서 수행한다.
    * 톰캣이 알아서 관리해준다.
  * 최초 요청시의 수행 흐름
    * init() , service() -> doGet(), doPost() , destroy()
      * service()  : 요청 방식 상관없이 사용할 때 오버라이딩
      * doGet(), doPost() : 요청 방식 지정하여 사용할 때 오버라이딩

- core 패키지 : FlowServlet 수행흐름을 확인하기 위한

  * 매핑명 : /flow

![image-20200116143132882](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116143132882.png)

![image-20200116143159943](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116143159943.png)

![image-20200116143302646](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116143302646.png)

새로운 서블릿을 생성하고 나면 톰캣서버를 재기동 시켜준다.

![image-20200116143902561](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116143902561.png)

![image-20200116143935575](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116143935575.png)

* core패키지: MemberLocalServlet(/memberlocal) - GET 방식



[서블릿 도큐먼트]

http://tomcat.apache.org/tomcat-9.0-doc/servletapi/index.html

![image-20200116150501977](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116150501977.png)

![image-20200116150534676](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200116150534676.png)

[web Server ]

웹 통신에서 서버역할을 수행하는 프로그램(HTTP Server)

Web Server + Application Server = Web Application Server = WAS

TOMCAT = WAS = 코요테(웹서버) + 카탈리나(어플리케이션서버)

* Web Server :  HTML, 이미지  요청하는 것을 찾아서 주면 끝.
* Application Server : 서블릿, jsp 수행 요청시 필요함.
* 티맥스 소프트 - 제우스 WAS, 한국형 WAS
* 톰캣은 학습용 WAS



[실습]

core 패키지 : QueryServlet 수행흐름을 확인하기 위한

* 매핑명 : /
* 똑같은 매핑명일 경우, LifecycleException 에러 발생, 톰캣기동 못함. 



static / return 타입도 같아야한다

```javascript
name=duke&passwd=1234&age=&gender=femail



request.getParameter("name") --> "duke"

request.getParameter("passwd")-->"1234"

request.getParameter("age")-->""

request.getParameter("hobby")-->null // 항목이 없을 때
```



^\d{2,3} - \d{3,4} - \d{4}$

Java: Java SE -> 자바api, 단독 프로그램 사용시 사용

Java EE -> 서버 추가

Java ME -> 신용카드 프로그램, 스마트카드? IOT 에 가까운 기술. 안드로이드가 나오기 전에 작은 프로세서에서 사용.

![image-20200117171555184](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200117171555184.png)

테스트하는 서블릿마다 매번 작성해야함  -> @ 변경



![image-20200117172522760](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200117172522760.png)



톰캣: web server(코요테) + application server(카탈리나) : WAS

httprequest/httpresponse : 요청온 수만큼 객체 생성

서블릿엔진= 서블릿 컨테이너는 서블릿 요청을 처리한다.





OS - 폴더

Eclipse - Web Project

Tomcat  - Context (Context Path : edu, sedu)

Developer - Web Application

