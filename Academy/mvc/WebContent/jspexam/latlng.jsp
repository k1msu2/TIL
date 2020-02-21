<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${ pageContext.request.method == 'GET' }">
<h2>주소를 입력하세요</h2>
<hr>
<form method="post" action="/mvc/jspexam/latlng.jsp">
주소 : <input type="text" name = "address">
<input type="submit" value="검색">
</form>
</c:when>
<c:otherwise>
<c:catch var="ex"> 
<c:import var="xmldata" url="https://maps.googleapis.com/maps/api/geocode/xml">
	<c:param name="address" value="${param.address}"/>
	<c:param name="language" value="ko"/>
	<c:param name="key" value="AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c"/>
</c:import>

<%-- <c:import var="xmldata" url="https://maps.googleapis.com/maps/api/geocode/xml?&language=ko&key=AIzaSyD8k2DWC_7yFHCrH6LDR3RfITsmWMEqC8c&address=${URLEncoder.encode(param.address, 'UTF-8')}"/> --%>

<x:parse xml="${xmldata}" varDom="xdata"/>
<x:if select="$xdata//status = 'OK'">
<h2> ${param.address} 정보</h2>
<hr>
<ul>
<li>주소 : <x:out select="$xdata//formatted_address"/>
<li>위도 : <x:out select = "$xdata//geometry/location/lat"/>
<li>경도 : <x:out select = "$xdata//geometry/location/lng"/>
</ul>
</x:if>

<x:if select="$xdata//status != 'OK'">
<h2>서비스 사용허가를 받지 못했습니다.</h2>
서버로 부터 전달된 오류 메시지 : <x:out select="$xdata//error_message"/>
</x:if>
</c:catch>
<c:if test="${!empty ex}">
<h2>잘못된 요청입니다.</h2>
</c:if>
</c:otherwise>
</c:choose>
</body>
</html>