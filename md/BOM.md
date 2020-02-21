### BOM/DOM

window, document, location, history, navigator, screen



location.href : 페이지 이동을 구현하고자 할 떄

location.reload() : 현재 페이지를 재요청

navigator.userAgent : 이 페이지를 렌더링하고 있는 클라이언트 머신과 브라우저 정보를 하나의 문자열로 추출



DOM(Document Object Model) 

브라우저의 HTML 파서가 서버로 부터 전달받은 HTML 문서의 내용을 파싱하고 렌더링 할때 인식된 HTML 태그, 속성 그리고 텍스트로 구성된 컨텐츠를 하나하나 JavaScript 객체로 생성한다.

이때 만들어지는 DOM 객체들(Element 객체, Text 객체) 부모 자식 관계를 유지해서 트리 구조를 형성한다. --> Javascript 코드로 HTML 태그나 속성 그리고 컨텐츠를 읽거나 변경할 수 있게 지원해서 동적인 웹 페이지를 생성



(1) 필요한 태그를 찾는 방법

​	document.getElementsByTagName("태그명") // NodeList

​	document.getElementById("태그의id속성의값") // Node 단수형 

​	document.getElementsByClassName("태그의 class 속성값") // NodeList



​	document.querySelector("CSS선택자") // Node : id 선택자 , 첫번째 자식, 무조건 하나

​	document.querySelectorAll("CSS선택자") // NodeList : 0개 이상

(2) 태그의 내용이나 속성을 읽고 변경하는 방법, 삭제하는 방법

​	찾은 Element 객체. innerHTML

​	찾은 Element 객체.textContent

​	찾은 Element 객체.getAttribute("속성명")

​	찾은 Element 객체.setAttribute("속성명", 속성값)

​	찾은 Element 객체. removeAttribute("속성명")

​	찾은 Element 객체.속성명

​	찾은 Element 객체.속성명 = 속성값

​								:

이벤트 함수 안에서 document.write는 이전에 썻던 내용을 지운다

(3) 태그에서 발생하는 이벤트

​	1) 인라인 이벤트 모델

​			\<button onclick="코드"> 1 \</button>

​	2) 전역적 이벤트 모델(고전 이벤트 모델)

​			\<button> 2 \</button>

​			var dom = document.getElementsTagName("button")[0]; // 첫번째 버튼 태그[0]

​			dom.onclick = function() {코드};

​	3) 표준 이벤트 모델

​			\<button>3</button>

​			var dom = document.getElementsTagName("button")[0];

​			dom.addEventListener("click", function(){코드});

​			dom.removeEvenetListener("click", function(){코드});



이벤트 : 웹 페이지상에서 마우스, 키보드 등을 통해 발생하는 액션

웹 브라우저에서 자동으로 발생하는 액션

이벤트 핸들러(리스너) : 이벤트가 발생했을 때 수행되는 기능을 구현한 함수

이벤트 타겟: 이벤트가 발생한 대상 DOM 객체

(1)this, (2) 핸들러에 매개변수를 하나 정의한 후 : e.target



[디폴트 이벤트 핸들러]

HTML 태그에 디폴트로 등록되어 있는 이벤트 핸들러를 의미한다.

<a> : click 이벤트에 대한 핸들러를 내장 하고 있다.



[이벤트 버블링]

특정 DOM 객체에서 이벤트가 발생하면 그 DOM 객체에 등록된 이벤트 핸들러만 수행된는 것이 아니라 조상 DOM 객체에 등록된 핸들러도 수행된다.