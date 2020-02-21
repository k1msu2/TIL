### JavaScript

Ajax 

세상은 Ajax  출현 전 후 로 나뉜다. 모든 Sns의 개발도구?

![image-20200106165820837](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200106165820837.png)



자바스크립트로 데이터 분석, 라즈베리 파이에서도 사용가능

웹페이지의 동적인 부분을 만드는데 언어 공부

ECMA 스크립트 6

JavaScript는 **ECMAScript 사양을 준수하는 범용 스크립팅 언어**입니다.



1. JavaScript 코드 작성 방법

2. 데이터타입과 변수선언

   --------------------------

   숫자, 문자열 타입, 논리 타입, 객체 타입(배열 타입), undefined 타입

   > ```javascript
   > var 변수명;
   > 
   > var 변수명=초기값;
   > 
   > v1 = 10; // number
   > v1 = '10'; // string
   > v1 = true; // boolean
   > 
   > typeof 변수의 타입을 알려줌.
   > ```

   

   함수나 매서드를 만들때 매개변수도 타입형이 없음

   이때 typeof 연산자가 필요함

3. 연산자(자바와 85% 비슷)

   ==, ===, !=, !--, &&, ||, delete, typeof

4. 제어문

   for, foreach, while, do ~ while, break, continue 

5. 함수의 정의와 활용

   R의 함수와 비슷.

6. 객체의 생성과 활용(생성자 함수, 객체 리터럴) cf. 자바는 생성자 메서드가 있음

7. 예외처리

8. API 

   표준 API : 함수(그냥 사용), 생성자 함수(객체 생성해서 사용)

   BOM(Browser Object Model) API : 브라우저가 자바스크립트에게 제공하는 것으로 내장 객체 형식이다. 

   DOM(Document Object Model) API 

   HTML5 API - Canvas, WebStorage, drag&drop, geolocation

   *Canvas:대기업에서 많이 사용, 공장자동화, 생산라인을 관리하는 우리 회사만의 애플리케이션에서 생산라인을 그래프로 그려서 비주얼화 함. 

   *모바일은 gps 로 위치정보를 받아오고, PC 는 네트워크 기지국(가장가까운 관공서)으로 나옴.

   브라우저는 샌드박스 시스템이라서 로컬에서는 저장 불가. 

    
   
   



웹페이지의 주인공은 html

예외처리 구문이 있기는 하나 사용을 지양하고 

최대한 예외가 발생하지 않도록해라. 비용이 많이 드므로. 





[웹페이지를 디자인 할때]

(1) PC만

(2) 모바일만

(3) PC, 모바일 : 반응형 웹디자인 - www.w3schools.com

​                           PC디자인, 모바일 디자인 분리- www.naver.com / m.naver.com





모바일에서 지원하는 지 확인.

https://caniuse.com/

![image-20200107093008617](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200107093008617.png)



![image-20200107093345303](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200107093345303.png)



자바스크립트 <script> 태그에서 

![image-20200107101747004](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200107101747004.png)

운영체제를 대체하려는 웹 브라우저

웹서핑, 글작성, 클라우드화 시키려고 함. 

웹OS를 표방한 여러 프로젝트 실행 중.

응용 프로그램도 자바스크립로 만드는 시기가 올 것이다라고 예측..



```javascript
 비교식1 && 비교식2
   비교식1 || 비교식 2
   ---> && 와 || 를 이용해서
   
   if(a>b)
       window.alert(a);

앞이 참이면 뒤 있는 것을 실행해라
많이 사용하는 문법. 
자바에서는 지원하지 않음

---> a>b && window.alert(a);
---> a<=b || window.alert(a);

window.alert() - 경고 메시지를 출력하는 서브창을 디스플레이
window.prompt() - 사용자로부터 데이터를 입력받는 서브창을 디스플레이
window.confirm() - 확인받는 목적으로 사용되는 API로서 yes/no 형식의 데이터 입력받는 서브창을 디스플레이

   
```
[배열]

(1) 다양한 타입의 데이터를 하나의 배열에 구성 가능

(2) 배열 생성 후에도 크기 변경이 가능

- 생성

  var a1 = [];

  var a2 = [10, 20, 30];

  var a3 = [true, '가나다', 100];

  a1.length

  a2.length

  a3.length

  a3[1]

* 표준 API(Array 라는 생성자 함수를 이용)

  var a4 = new Array();

  var a5 = new Array(10); // 배열의 크기

  var a55 = new Array('abc');

  var a6 = new Array(10, 20);

  var a7 = new Array(true, 3.5, 'aaa', 'aa');



#### 함수 : 수행 문장들을 담고 있는 호출 가능 모듈, 단독으로 호출 가능, 객체를 통해서만 호출 가능

#### 메서드: 수행 문장들을 담고 있는 호출 가능 모듈, 객체를 통해서만 호출 가능. 객체의 멤버 정의되는 함수

#### 전역코드 : <script> 수행문장들..</script>

[명시적인(선언적) 함수 정의]

function 함수 이름([매개변수 선언...]){

}

[리터럴(표현식) 방식 함수 정의]

함수를 만들어서 전달하는 용도



function ([매개변수 선언..]){

}([아규먼트..]); // 즉시 실행 함수



function ([매개변수 선언..]){

};



이변수는 함수를 담고 있는 변수..함수명..

var 함수명 = function ([매개변수 선언..]){

};

함수명([아규먼트..]); // 호출 방법

var 함수명2= 함수명;

함수명2(아규먼트..]);





