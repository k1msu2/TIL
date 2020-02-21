## JSP

JavaServer Pages

![image-20200123141218306](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200123141218306.png)

CGI(어떤언어로든 개발 가능, API없음)

->ASP, PHP 

| Servlet(1998) |             JSP(1999)              |
| :-----------: | :--------------------------------: |
|  자바 + HTML  | HTML + JSP 태그 + 약간의 Java 코드 |
|               |    실행 시 Servlet 으로 변경됨     |

----------------------------------------------------------------------------

서블릿의 장단점, JSP의 장단점 으로 MVC 패턴으로 진화..

Servlet(요청) + JSP(응답)



(1) 내장 객체

​	HTTP 세션 객체를 사용하려면 미리 준비해야하지만 JSP 는 내장 객체라서 가져다가 쓰면 된다.

```jsp
request
response
session
out   // 출력
application
config
exception (예외객체가 만들어 질때 사용)
page
pageContext
```



(2) JSP 태그

```jsp
<%@ %>   지시자 태그 :  import 선언, content-type
 ㄴ <%@ page 속성명="속성값" .....%>	
		속성명 : language, ContentType, pageEncoding, errorPage, isErrorPage, import, 					session, buffer, isELignored, ......

<%@ include file = "포함하려는 대상파일의 로컬 URL"%> : include 지시자 태그
포함하는 위치 : 이 지시자태그가 사용된 위치
포함하는 시기 : JSP 를 Servlet 으로 변환하기 전
포함하는 대상 : html, jsp, jspf(jsp fragment - 다른파일 jsp 소스의 일부분)

<%! %>   선언문 태그 : 매서드/멤버변수
<%= %>   표현식 태그 : 프린트문(string..?)
<% %>    수행문 태그 : 자바코드(if문..)
<%-- --%>  주석 태그

<!-- include action 태그 : 각각의 서블릿, 동적 포함, 결과만 포함 -->
<!-- include 지시자  태그 : 1개의 서블릿, 정적 포함, 소스 코드 포함, 구문적으로 오류날 수 있음  --> 
```

(3) 액션 태그

```jsp
<jsp:include />
<jsp:forward />
<jsp:param />
```

(4) 커스텀 태그

``` jsp
JSTL
```

* jsp -> Servlet 변환 파일 위치

  C:\Users\student\Documents\eclipse-jee-2019-09-R-win32-x86_64\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\sedu\org\apache\jsp\jspexam

* exam2.jsp 파일

![](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200122143342482.png)

* exam2.jsp 파일 -> servlet 파일로 자동 변환됨

![image-20200122143256869](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200122143256869.png)



![image-20200122143308345](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200122143308345.png)



* context 는 프로그램이 메모리에 올라갔을 때, 실행되기 위해서 필수로 필요한 메모리영역, 레지스터의 값등의 리소스들을 총칭하는 것



![image-20200123094306235](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200123094306235.png)



[실습]

include action 태그 실행시 

![image-20200123133738373](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200123133738373.png)



![image-20200123133634782](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200123133634782.png)

include 지시자 태그 수행 시 



first.html 로 forward 할 때 한글이 깨집니다. 

[해결방법]

방법 1 : <meta> 태그의 charset 을 "euc-kr" 로 변경

방법2 : forward 가 아니라 redirect 로 해결

![image-20200123162624851](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200123162624851.png)



jsp -> servlet 변환

forward 기능이 더 실행이 안되도록 servlet 소스에서 return; 구문을 넣어준다.





[예제]

![image-20200123171706578](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200123171706578.png)



xxxVO - Value Object - 값을 보관하는 용도의 객체

xxxDAO - Data Access Object  - DB 연동기능(JDBC)을 지원하는 객체

xxxService(xxxBiz) - Service Object  - 이런 저런 서비스 로직을 지원하는 객체



### Request  - MVC 패턴에서 많이 사용

```java
public class ShareTestServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		CountVO vo = new CountVO();
		vo.setNumber(param);
		request.setAttribute("objreq", vo);
		request.getRequestDispatcher("/jspexam/share1.jsp").
		              forward(request, response);
	}
}
```

### Session 

``` java
public class ShareTestServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		if(session.getAttribute("objsession") == null) {
			session.setAttribute("objsession", new CountVO());
		}
		CountVO vo = (CountVO)session.getAttribute("objsession");
		vo.setNumber(param);
		
		request.getRequestDispatcher("/jspexam/share2.jsp").
		              forward(request, response);
	}
}
```

### Application

```java
public class ShareTestServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param = Integer.parseInt(request.getParameter("num"));
		System.out.println(param);
		ServletContext context = getServletContext();
		if(context.getAttribute("objapp") == null) {
			context.setAttribute("objapp", new CountVO());
		}
		CountVO vo = (CountVO)context.getAttribute("objapp");
		vo.setNumber(param);
		
		request.getRequestDispatcher("/jspexam/share3.jsp").
		              forward(request, response);
	}
}

```

