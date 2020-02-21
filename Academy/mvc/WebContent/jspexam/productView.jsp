<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "model.vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{
text-decoration:none;
background-image: linear-gradient(-90deg, yellow, pink, lime);
}
</style>
</head>
<body>
<h1>스크립트 태그</h1>
<%
ProductVO vo = (ProductVO)session.getAttribute("psession");
%>
<h1>선택된 상품의 정보는 다음과 같습니다. </h1>
<hr>
<h3> 선택된 사과의 개수 :<%=vo.getAppleNum() %> </h3>
<h3> 선택된 바나나의 개수 : <%=vo.getBananaNum() %></h3>
<h3> 선택된 한라봉의 개수 : <%=vo.getHallabongNum() %></h3>
<hr>
<h1>액션 태그</h1>
<jsp:useBean id="psession" class="model.vo.ProductVO" scope="session"/>
<h1>선택된 상품의 정보는 다음과 같습니다. </h1>
<hr>
<h3> 선택된 사과의 개수 :<jsp:getProperty name = "psession" property ="appleNum"/></h3>
<h3> 선택된 바나나의 개수 :<jsp:getProperty name = "psession" property ="bananaNum"/></h3>
<h3> 선택된 한라봉의 개수 :<jsp:getProperty name = "psession" property ="hallabongNum"/></h3>
<hr>
<h1>EL 태그</h1>

<h1>선택된 상품의 정보는 다음과 같습니다. </h1>
<hr>
<h3> 선택된 사과의 개수 :${sessionScope.psession.appleNum}</h3>
<h3> 선택된 바나나의 개수 :${sessionScope.psession.bananaNum }</h3>
<h3> 선택된 한라봉의 개수 :${sessionScope.psession.hallabongNum}></h3>
<hr>
<hr>
<section>
<a href= "${header.referer}">상품 선택화면</a>
</section>
</body>
</html>