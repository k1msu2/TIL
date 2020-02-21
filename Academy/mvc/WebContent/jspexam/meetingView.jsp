<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MeetingVO, java.util.List"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px dashed #ddd;
  table-layout:fixed;
}

tr:hover {background-color: #ddd;}


</style>
</head>
<body>
<h1>미팅 스케쥴</h1>
<hr>
<%
	String msg = (String)request.getAttribute("msg");
	List<MeetingVO> list = (List<MeetingVO>)request.getAttribute("list");
if(list != null){
	for(MeetingVO vo : list){ %>
	<table>
	<tr>
		<%-- <td width=10><%=vo.getId() %></td> --%>
		<td width=100><%=vo.getName()%></td>
		<td width=400><%=vo.getTitle()%></td>
		<td width=200><%=vo.getMeetingDate()%></td>
		<td>
			<a href="/mvc/meeting?action=update&seqid=<%=vo.getId()%>">
			<img src="/mvc/images/update.png" width="20px">
			</a>
		</td>
		<td>
			<a href="/mvc/meeting?action=delete&seqid=<%=vo.getId()%>">
			<img src="/mvc/images/delete.png" width="20px">
			</a>
		</td>
	<tr>
	</table>
	<%}
}else{%>
	<h1>스케쥴이 없습니다.</h1>
<%}
%>
<% if(msg != null) {%>
<h3><%=msg%></h3>
<%}%>
<a href="/mvc/htmlexam/meetingForm.html">미팅 홈 화면으로 가기</a>

</body>
</html>