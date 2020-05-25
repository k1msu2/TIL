<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.*, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1eb82a611b357dbfc3eb3e227b6ec2d3&libraries=services&libraries=clusterer"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<!--  
aptListAll
cafeListAll
martListAll
circleListAll
-->
<!-- 
${vo.id}
${vo.name}
${vo.addr}
${vo.lat}
${vo.lng}
${vo.aptname}
${vo.aptlat}
${vo.aptlng}
${vo.catlat}
${vo.catlng}
 -->
<style>
.map_wrap, .map_wrap * {
	margin: 0;
	padding: 0;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	font-size: 12px;
}

.map_wrap {
	position: relative;
	width: 100%;
	height: 350px;
}

#category {
	float: left;
	position: absolute;
	top: 10px;
	left: 10px;
	border-radius: 5px;
	border: 1px solid #909090;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
	background: #fff;
	/* overflow: hidden; */
	z-index: 2;
}

#category2 {
	float: left;
	position: absolute;
	top: 10px;
	left: 220px;
	border-radius: 5px;
	border: 1px solid #909090;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
	background: #fff;
	/* overflow: hidden; */
	z-index: 2;
}

#category li {
	float: left;
	list-style: none;
	width: 200px; px;
	border-right: 1px solid #acacac;
	padding: 6px 0;
	text-align: center;
	cursor: pointer;
	left: 10px;
	z-index: 1;
}

#category2 li {
	float: left;
	list-style: none;
	width: 120px; px;
	border-right: 1px solid #acacac;
	padding: 6px 0;
	text-align: center;
	cursor: pointer;
	left: 10px;
	z-index: 1;
}

#category li.on {
	background: #eee;
}

/* #category li:hover {
	background: #ffe6e6;
	border-left: 1px solid #acacac;
	margin-left: -1px;
} */
#category li:last-child {
	margin-right: 0;
	border-right: 0;
}

#category li span {
	display: block;
	margin: 1 auto 3px;
	width: 27px;
	height: 28px;
}

/* search bar */
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #e9e9e9;
}

.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 14px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #2196F3;
	color: white;
}

.topnav .search-container {
	float: right;
}

.topnav input[type=text] {
	padding: 6px;
	margin-top: 8px;
	font-size: 13px;
	border: none;
}

.topnav .search-container button {
	float: right;
	padding: 6px;
	margin-top: 8px;
	margin-right: 16px;
	background: #ddd;
	font-size: 13px;
	border: none;
	cursor: pointer;
}

.topnav .search-container button:hover {
	background: #ccc;
}

@media screen and (max-width: 600px) {
	.topnav .search-container {
		float: none;
	}
	.topnav a, .topnav input[type=text], .topnav .search-container button {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
}

/* drop down */
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	overflow: scroll;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>
</head>
<body>
	<div class="topnav">
		<a class="active" href="#home">HA</a> <a href="#about">APT</a> <a
			href="#contact">HERE</a>
		<div class="search-container">
			<form action="/action_page.php">
				<input type="text" placeholder="아파트명" name="search">
				<button type="submit">검색</button>
			</form>
		</div>
	</div>

	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 200%; position: relative; overflow: hidden;"></div>

		<ul id="category" class="dropdown">
			<li id="BK9" data-order="0">서울특별시 > <a href="#" >중구</a> 
			  <a href="#" class="dropdown-content">Link 1</a>
		  <a href="#" class="dropdown-content">Link 2</a>
		  <a href="#" class="dropdown-content">Link 3</a>
			
			> 
			<a href="#">명동</a>
			</li>
		</ul>

<!-- 		<div class="dropdown">
		  <a href="test">test</a>
		  <div class="dropdown-content">
		  <a href="#">Link 1</a>
		  <a href="#">Link 2</a>
		  <a href="#">Link 3</a>
		  </div>
		</div>
		 -->
		
		<ul id="category2">
			<li id="BK9" data-order="0">1순위 > <a href="#">카테고리</a>
			</li>
			<li id="BK9" data-order="0">2순위 > <a href="#">카테고리</a>
			</li>
			<li id="BK9" data-order="0">3순위 > <a href="#">카테고리</a>
			</li>
		</ul>

		<div id="localInfoList">
			<!--  class="LocalInfoList"> -->
			<div id="localInfoList.province" class="box HIDDEN"
				style="left: 512px;">
				<ul id="localInfoList.province.list" class="province">
					<!-- 	<li class="list_active"><span class="check"></span><a
							href="https://map.kakao.com/?#">서울특별시</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">부산광역시</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">대구광역시</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">인천광역시</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">광주광역시</a></li>
						<li class=""><span class="check"></span><a
							href="https://map.kakao.com/?#">대전광역시</a></li>
						<li class=""><span class="check"></span><a
							href="https://map.kakao.com/?#">울산광역시</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">세종특별자치시</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">경기도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">강원도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">충청북도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">충청남도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">전라북도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">전라남도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">경상북도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">경상남도</a></li>
						<li><span class="check"></span><a
							href="https://map.kakao.com/?#">제주특별자치도</a></li> -->
				</ul>
			</div>
			<div id="localInfoList.county" class="box HIDDEN">
				<ul id="localInfoList.county.list" class="county"></ul>
			</div>
			<div id="localInfoList.town" class="box HIDDEN">
				<ul id="localInfoList.town.list" class="town"></ul>
			</div>
		</div>
	</div>


	<div>
		<a href="/h2/apt/강남구">아파트</a> <a href="/h2/cafe/500/강남구">까페</a>
	</div>

	<c:if test="${empty aptListAll}">
		아파트 데이터가 없습니다!!!!!
	</c:if>

	<c:if test="${empty cafeListAll}">
		까페 데이터가 없습니다!!!!!
	</c:if>

	<script>
		var markers = []; // 객체
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		mapOption = {
			center : new kakao.maps.LatLng(37.564214, 127.001699), // 지도의 중심좌표
			level : 8
		// 지도의 확대 레벨
		};
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
		var imageSize = new kakao.maps.Size(24, 35);
		var cafeImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
		var clusterer = new kakao.maps.MarkerClusterer({
			map : map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
			averageCenter : true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
			minLevel : 7, // 클러스터 할 최소 지도 레벨
			disableClickZoom : true
		// 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
		});
	</script>

	<script>
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
			return function() {
				infowindow.open(map, marker);
			};
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
			return function() {
				infowindow.close();
			};
		}

		// 마커를 생성하고 지도위에 표시하는 함수입니다
		function addMarker(position, addr, name, markerImage) {

			// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			var iwContent = '<div style="padding:5px;">' + name + '</div><hr>'
					+ '<div style="padding:5px;">' + addr + '</div><hr>'
					+ '<div style="padding:5px;">' + position + '</div><hr>'

			var iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
				content : iwContent
			});

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				position : position
			});
			// 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
				// 마커 위에 인포윈도우를 표시합니다
				infowindow.open(map, marker);
			});
			kakao.maps.event.addListener(marker, 'click', makeOverListener(map,
					marker, infowindow));
			kakao.maps.event.addListener(marker, 'mouseout',
					makeOutListener(infowindow));

			// 마커가 지도 위에 표시되도록 설정합니다
			//marker.setMap(map);
			// 생성된 마커를 배열에 추가합니다
			markers.push(marker);
			clusterer.addMarkers(markers);

		}

		// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
		function setMarkers(map) {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}

		// 마커를 생성하고 지도위에 표시하는 함수입니다
		function addMarkerCircle(position1, position2, name) {

			var centerPosition = position1;
			var drawingCircle = new kakao.maps.Circle({
				strokeWeight : 1, // 선의 두께입니다
				strokeColor : '#00a0e9', // 선의 색깔입니다
				strokeOpacity : 0.1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
				strokeStyle : 'solid', // 선의 스타일입니다
				fillColor : '#00a0e9', // 채우기 색깔입니다
				fillOpacity : 0.2
			// 채우기 불투명도입니다 
			});
			var circleOptions = {
				center : centerPosition,
				radius : 500,
			};
			drawingCircle.setOptions(circleOptions);
			drawingCircle.setMap(map);

			// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			/* 			var iwContent = '<div style="padding:5px;">' + name + '</div><hr>'
			 + '<div style="padding:5px;">' + addr + '</div><hr>'
			 + '<div style="padding:5px;">' + position + '</div><hr>'

			 var iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

			 // 인포윈도우를 생성합니다
			 var infowindow = new kakao.maps.InfoWindow({
			 content : iwContent
			 }); */

			// 마커를 생성합니다
			var marker1 = new kakao.maps.Marker({
				position : position1,
				clickable : true
			});

			var marker2 = new kakao.maps.Marker({
				position : position2,
				clickable : true
			});
			// 마커에 클릭이벤트를 등록합니다
			/* kakao.maps.event.addListener(marker, 'click', function() {
				// 마커 위에 인포윈도우를 표시합니다
				infowindow.open(map, marker);
			}); */
			/* 			kakao.maps.event.addListener(marker, 'click', makeOverListener(map,
			 marker, infowindow));
			 kakao.maps.event.addListener(marker, 'mouseout',
			 makeOutListener(infowindow)); */

			// 마커가 지도 위에 표시되도록 설정합니다
			//marker1.setMap(map);
			//marker2.setMap(map);
			// 생성된 마커를 배열에 추가합니다
			//markers.push(marker1);
			//markers.push(marker2);
		}
	</script>


	<c:if test="${!empty aptListAll}">
		<script>
			<c:forEach var="vo" items="${aptListAll}" varStatus="status">
			addMarker(new kakao.maps.LatLng("${vo.lat}", "${vo.lng}"),
					"${vo.addr}", "${vo.name}");

			</c:forEach>
			/* setMarkers(map); */
			kakao.maps.event.addListener(clusterer, 'clusterclick', function(
					cluster) {

				// 현재 지도 레벨에서 1레벨 확대한 레벨
				var level = map.getLevel() - 1;

				// 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
				map.setLevel(level, {
					anchor : cluster.getCenter()
				});
			});
		</script>
	</c:if>

	<c:if test="${!empty cafeListAll}">
		<script>
			<c:forEach var="vo" items="${cafeListAll}" varStatus="status">
			addMarker(new kakao.maps.LatLng("${vo.lat}", "${vo.lng}"),
					"${vo.addr}", "${vo.name}", cafeImage);
			</c:forEach>
		</script>
	</c:if>

	<c:if test="${!empty circleListAll}">
		<script>
			<c:forEach var="vo" items="${circleListAll}" varStatus="status">
			addMarkerCircle(new kakao.maps.LatLng("${vo.aptlat}",
					"${vo.aptlng}"), new kakao.maps.LatLng("${vo.catlat}",
					"${vo.catlng}"), "${vo.aptname}");
			</c:forEach>
		</script>
	</c:if>

</body>
</html>