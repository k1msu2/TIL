### JSTL



JSP ------------> Servlet

Custom Tag : 필요한 기능의 태그를 직접 만들 수 있는 기능

​						Apache Open Group : JSTL(만들어진 태그들의 표준)

​							ㄴ  core library* , xml library*, sql library, fmt library, fn library

​							ㄴ if tag -> else 태그 없음, if 문을 두개 써야함

Action Tag : JSP 가 제공하는 태그로 기능, 구현 방법이 정해져 있는 태그들..

ASP, PHP---->CGI (요청시마다 메모리에 올랐다 내려갔다)



브라우저에 현재시간 - js

서버시간 클라이언트시간 



서버단에서 사용하는 언어

jsp - java 언어

asp - 비주얼베이직

php - php 언어





JSP ----> 웹페이지 -------------> HTML + JSP 태그 + Java

​              규격화된 문서 ------> XML + JSP 태그 + Java

​                                                 JSON + JSP 태그 + Java



<jsp:forward  />   -> jsp는 prefix --> forward 는 jsp 에 속하는 태그이다.

<jsp:useBean />

서버단에서 처리할  jsp 태그가 아니면 전부다 브라우저에 전부 출력

<c:if / > ---- > JSTL 의 core lib 에 가서 if 를 찾는다



#### XML library

* **XPath**(XML Path Language)는 W3C의 표준으로 확장 생성 언어 문서의 구조를 통해 경로 위에 지정한 구문을 사용하여 항목을 배치하고 처리하는 방법을 기술이다
* XPath는 XML 문서의 노드를 정의하기 위하여 경로식을 사용하며, 수학 함수와 기타 확장 가능한 표현들이 있다

XML 예제 문서

```xml
<?xml version="1.0" encoding="utf-8"?>
<wikimedia>
  <projects>
    <project name="Wikipedia" launch="2001-01-05">
      <editions>
        <edition language="English">en.wikipedia.org</edition>
        <edition language="German">de.wikipedia.org</edition>
        <edition language="French">fr.wikipedia.org</edition>
        <edition language="Polish">pl.wikipedia.org</edition>
      </editions>
    </project>
    <project name="Wiktionary" launch="2002-12-12">
      <editions>
        <edition language="English">en.wiktionary.org</edition>
        <edition language="French">fr.wiktionary.org</edition>
        <edition language="Vietnamese">vi.wiktionary.org</edition>
        <edition language="Turkish">tr.wiktionary.org</edition>
      </editions>
    </project>
  </projects>
</wikimedia>
```

아래의 XPath 식은

```xaml
/wikimedia/projects/project/@name
```

모든 project 요소의 name 속성을 선택하고, 아래의 XPath 식은

```
/wikimedia/projects/project/editions/edition[@language="English"]/text()
```

모든 영문 Wikimedia 프로젝트의 주소(`language` 속성이 *English*인 모든 `edition` 요소의 문자열)를 선택하고, 아래의 XPath 식은

```
/wikimedia/projects/project[@name="Wikipedia"]/editions/edition/text()
```

모든 위키백과의 주소(*Wikipedia*의 이름 특성을 가진 `project` 요소 아래에 존재하는 모든 `edition` 요소의 문자열)를 선택한다.



```
//edition[@language="English"]
/wikimedia//edition[@language="English"]
```



```
<abc>
ㅋㅋㅋ    ---> css 선택자는 태그 위주라 찾지 못하지만 xpath 는 찾을 수 있다, 자식 노드의 순서로.
<def> MMM </def>
ㅠㅠㅠㅠ
</abc>

```



