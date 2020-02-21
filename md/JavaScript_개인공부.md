JavaScript 



윈도우 객체

- 전역 객체
- 전역 변수는 window 객체의 프로퍼티
- 웹 브라우저에서 사용하는 개체가 모두 window 객체



Location 객체 

* 창에 표시되는 문서의 URL을 관리

* window.location 또는 location 객체를 참조

  ```javascript
  //URL 이 가리키는 문서를 읽어들임
  //이력남음, 뒤로가기 가능
  location.href = "http://www.gilbut.co.kr/";
  location.assign("http://www.gilbut.co.kr/");
  // 문서를 읽어들일때 이력을 남기지 않으려면 
  // 뒤로 가기 불가능
  location.replace("http://www.gilbut.co.kr/");
  // 다른 페이지로 이동(리다이렉트)
  setTimeout(function(){
    Location.replace("/book/bookLIst.aspx")  ;
  }, 3000);
  //현재페이지 다시 읽어들이기
  location.reload();
  //HTML 요소로 스크롤
  location.hash = "#header";
  //서버에 질의 문자열 보내기
  location.search = "some data" // ?sume%20data
  ```

  

History 객체

* 웹 페이지 열람 이력을 관리
* window.history 또는 history



Navigator 객체

* 스크립트가 실행 중인 웹 브라우저 등의 애플리케이션 정보를 관리
* window.navigator, navigator



Screen 객체

* 화면 크기와 색상 등의 정보를 관리



Document 객체

* 창에 표시되고 있는 웹 페이지를 관리
* 웹 페이지의 내용물인 DOM 트리를 읽거나 쓸 수 있음
* window.document, document 
* 가장 중요한 객체



DOM 트리

* DOM : 문서를 제어하는 API 
* HTML 요소를 삽입하고 삭제하는 방법
* CSS 스타일 변경하는 방법



이벤트 처리기 등록하기

``` javascript
//HTML 요소의 이벤트 처리기 속성에 설정하는 방법
<input type="button" onclick="changeColor();">
//DOM 요소 객체의 이벤트 처리기 프로퍼티에 설정하는 방법
var btn = document.getElementById("button");
btn.onclick=changeColor();
//addEventListener 메서드를 사용하는 방법
var btn = document.getElementById("button");
btn.addEventListener("click", changeColor, false);
    
 

```

이벤트 리스너를 등록하고 삭제하는 방법

```javascript
target.addEventListener(type, listener, useCapture);

//target : 이벤트 리스너를 등록할 DOM 노드
//type : 이벤트 유형을 뜻하는 문자열("click", "mouseup" 등)
//listener : 이벤트가 발생했을 처리를 담당하는 콜백 함수의 참조
//useCapture : 이벤트 단계
// -true : 캡처링 단계
// -false : 버블링 단계

window.onload = function(){
    var element = document.getElementById("box");
    element.addEventListener("click", function(e) {
        e.currentTarget.style.backgroundColor = "red";
    }, false);
}

//e: 이벤트 객체 - 이벤트 객체 안에는 발생한 이벤트이 다양한 정보가 담겨 있음
//e.currentTarget 은 클릭한 요소를 참조하는 요소 객체
// 

```

속성값의 읽기와 쓰기

1) 요소 객체 - 일반적인 HTML 속성(id, class, name ,src, href..) + 이벤트 처리기 프로퍼티(onclick, onmousedown, ...)

2) 요소 객체.속성이름 - 읽기와 쓰기가 가능

```javacript

//요소의 href 속성을 가져오기
<a id="school" href = "http://naver.com"> 네이버 </a>
<script>
	var anchor = document.getElementById("school");
	console.log(anchor.href);
</script>
```

3) 요소 객체.getAttribute(속성의 이름 ) - 속성 값 가져오기

```javascript
<body>
    <form id="favorite">
        <input type="checkbox"  name="dog" value="pome">포메라이언<br>
    </form>
	<script>
        var fm = document.getElementById("favorite");
		var list = fm.children;
		for(var i = 0; i < list.length; i++){
            for(list[i].nodeName == "INPUT" && list[i].type == "checkbox"){
                result.push(list[i].getAttribute("value"));
            }
        }
    </script>
</body>
```



4) 요소 객체.setAttribute(속성 이름, 속성 값) - 속성 값 설정하기

