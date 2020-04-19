<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.NewsVO, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon:400"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gugi:400" rel="stylesheet">
<style>
* {
	size: 20px;
	font-family: "Gugi";
}


table {
	text-align: center;
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px dashed #ddd;
	table-layout: fixed;
}
  
.content:hover {
	background-color: #ddd;
}

a{
	text-decoration: none;
	text-decoration: blink;
}

#news_update_box, #news_form_box{
	
	width:500px;
	margin-right:auto;
	margin-left:auto;
	border : 1px solid;
	
}
#news_form, #news_update{
	text-align:left;
	padding : 10px;
}

#searchform{
	text-align:center;
}
#writebtn{
	text-align:right;
	margin-right: 100px;
}

#pages{
	 text-align:center;
}
</style>
</head>
<body>
	<h1>김수이의 뉴스 게시판 NEWS</h1>
	<div id="writebtn">
		<button type="button" onclick="displayWriteForm()">기사 작성하기</button>
	</div>

	<hr>
	<table class="head">
		<tr>
			<th width=100>번호</th>
			<th width=400>제목</th>
			<th width=100>작성자</th>
			<th width=200>날짜</th>
			<th width=200>조회수</th>
		</tr>
	</table>
	<!-- 첫번째 화면에서 page 전달  -->
	<c:if test="${!empty listAll}">
		<c:forEach var="vo" items="${listAll}" varStatus="status">
			<table>
				<tr class="content">
					<td width=100><c:out value="${vo.id}" /></td>					
					<td width=400>
					<c:choose>
						<c:when test="${action eq 'search'}">
							<a href="/springnews/news?action=search&subaction=read&newsid=${vo.id}&searchtype=${searchtype}&key=${key}&page=${page}">
								<c:out value="${vo.title}"/>
							</a>
						</c:when>
						<c:when test="${action eq 'listwriter'}">
							<a href="/springnews/news?action=listwriter&subaction=read&newsid=${vo.id}&writer=${writer}&page=${page}">
								<c:out value="${vo.title}" />
							</a>
						</c:when>
						<c:otherwise>
							<a href="/springnews/news?action=read&newsid=${vo.id}&page=${page}">
								<c:out value="${vo.title}"/>
							</a>
						</c:otherwise>
					</c:choose>
					<td width=100>
					<c:choose>
						<c:when test="${empty action}">
						<a href="/springnews/news?action=listwriter&writer=${vo.writer}">
						<c:out value="${vo.writer}"/>
						</a>
						</c:when>
						<c:when test="${action eq 'read'}">
						<a href="/springnews/news?action=listwriter&writer=${vo.writer}">
						<c:out value="${vo.writer}"/>
						</a>
						</c:when>
						<c:otherwise><c:out value="${vo.writer}"/></c:otherwise>
					</c:choose>
					</td>
					<td width=200><c:out value="${vo.writedate}" /></td>
					<td width=200><c:out value="${vo.cnt}" /></td>
				<tr>
			</table>
		</c:forEach>
	</c:if>

	<hr>
	<br>
	<div id="searchform">
	<form method="get" action="/springnews/news">
		<input id="hidden2" type="hidden" name="action" value="search">
		<select name='searchtype' size='1'>
			<option value='title' selected>제목</option>
			<option value='content'>기사내용</option>
			<option value='all'>제목+기사내용</option>
		</select> <input id="key" type="text" name="key"> 
		<input type="submit" value="뉴스찾기">
		<button type="button" onclick="location.href='news'">뉴스 홈 </button>
		<button type="button" onclick="location.href='news'">뉴스 홈 </button>
	</form>
	</div>
	<br>
	
	<div id="pages">
	</div>
	<br>
	<c:if test="${!empty listOne}">
	<section id="news_update_box">
		<div id="news_update" style="display: block">
			<h2 id="news_header2">뉴스 내용</h2>
			<form method="post" action="/springnews/news">
				<input id="hidden2" type="hidden" name="action" value="update">
				<input id="news_id2" type="text" name="newsid" style="display: none"
					value="${listOne.id}"> 
				작성자 <input id="news_writer2" type="text" name="writer" value="${listOne.writer}"><br>
				<br> 제목 <input id="news_title2" type="text" name="title" value="${listOne.title}"><br>
				<br> 내용  <textarea id="news_content2" rows="3" cols="30" name="content">${listOne.content}</textarea>
				<br>
				<c:choose>
					<c:when test="${action eq 'search'}">
						<button type="button"
							onclick="location.href='/springnews/news?action=search&searchtype=${searchtype}&key=${key}'">확인</button>
					</c:when>
					<c:when test="${action eq 'listwriter'}">
						<button type="button"
							onclick="location.href='/springnews/news?action=listwriter&writer=${writer}'">확인</button>
					</c:when>
					<c:otherwise>
						<button type="button" onclick="location.href='news'">확인</button>
					</c:otherwise>
				</c:choose>
				<input type="submit" value="수정">
				<button type="button"
					onclick="location.href='/springnews/news?action=delete&newsid=${listOne.id}'">삭제</button>
			</form>
		</div>
	</section>
	</c:if>

	<c:if test="${!empty msg}">
		<h4>${msg}</h4>
	</c:if>

	<script>
		// 게시판 페이지     <  1 2 3  >  
		// 한 페이지 당 5 개의  글이 게시
		
		window.onload = function(){
			for(var i = 1; i <= "${numPages}"; i++){
				document.getElementById("pages").innerHTML += "<a href='/springnews/news?page=" + i + "'>"+ i + "</a>&nbsp&nbsp";				
			}
		};
		
		
		function displayWriteForm() {
			document.getElementById("news_form").style.display = "block";
			document.getElementById("news_update").style.display = "none";
		}
	</script>
	<section id="news_form_box">
	<div id="news_form" style="display: none">
		<h2 id="news_header">뉴스 내용</h2>
		<form method="post" action="/springnews/news">
			<input id="hidden1" type="hidden" name="action" value="insert">
			작성자 <input id="news_writer" type="text" name="writer"><br>
			<br> 제목 <input id="news_title" type="text" name="title" required><br>
			<br> 내용
			<textarea id="news_content" rows="3" cols="30" name="content"></textarea>
			<br> <input id="news_id" type="text" name="newsid"
				style="display: none"> <input type="submit" value="등록">
			<input type="reset" value="재작성">
			<button type="button" onclick="location.href='news'">취소</button>
		</form>
	</div>
	</section>
</body>
</html>