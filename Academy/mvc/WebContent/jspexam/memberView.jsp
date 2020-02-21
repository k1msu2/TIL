<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "model.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스크립트 태그</h1>
<%
	MemberVO vo = (MemberVO)request.getAttribute("membervo");
%>
<%if(vo != null){%>
<ul>
<li> 회원 이름 : <%=vo.getName() %></li>
<li> 계정 : <%=vo.getId() %></li>
<li> 암호 : <%=vo.getPasswd() %></li>
<li> 전화번호 : <%=vo.getPhone() %></li>
</ul>
<%}else{%>
	<h1>객체 없음</h1>
<%}%>

<hr>
<h1>액션 태그 - java 코드 x</h1>
<jsp:useBean id="membervo" class="model.vo.MemberVO" scope="request"/>
<!--
jsp:useBean
jsp 에서 사용되는 class 를 Bean 이라고 한다.

scope="request"
session
page

id : 객체로 꺼낼때 어떤이름으로..변수도 된다.

  -->
<%if(vo != null){%>
<ul>
<!-- 
property="name"
 -->
<li> 회원 이름 : <jsp:getProperty name="membervo" property="name"/></li>
<li> 계정 : <jsp:getProperty name="membervo" property="id"/></li>
<li> 암호 : <jsp:getProperty name="membervo" property="passwd"/></li>
<li> 전화번호 : <jsp:getProperty name="membervo" property="phone"/></li>
</ul>
<%}else{%>
	<h1>객체 없음</h1>
<%}%>

<hr>
<h1>표현언어(EL) 태그</h1>
<%if(vo != null){%>
<ul>
<li> 회원 이름 : ${requestScope.membervo.name}</li>
<li> 계정 : ${requestScope.membervo.id}</li>
<li> 암호 : ${requestScope.membervo.passwd}</li>
<li> 전화번호 : ${requestScope.membervo.phone}</li>
</ul>
<%}else{%>
	<h1>객체 없음</h1>
<%}%>

<hr>
</body>
</html>