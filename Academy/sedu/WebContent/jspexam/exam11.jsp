<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<HTML>
<HEAD>
<META charset="UTF-8">
<TITLE>INCLUDE 액션태그 예제</TITLE>
</HEAD>
<BODY>
<H3>INCLUDE 액션태그 예제</H3>
<H4>각 나라의 감사 인사말입니다.</H4>
<P>
한국어 :
<!-- include action 태그 : 각각의 서블릿, 동적 포함 -->
<!-- include 지시자  태그 : 1개의 서블릿, 정적 포함  --> 
<!-- 수행 자체는 각각 시키고 결과는 같이 포함하여라  -->
<jsp:include page="greeting.jsp">
   <jsp:param name="country" value="korea" />
</jsp:include>
</P>
<P>
영어 :
<jsp:include page="greeting.jsp"> 
   <jsp:param name="country" value="english" />
</jsp:include>
</P>
<P>
일본어 :
<jsp:include page="greeting.jsp">
   <jsp:param name="country" value="japan" />
</jsp:include>
</P>
</BODY>
</HTML>





