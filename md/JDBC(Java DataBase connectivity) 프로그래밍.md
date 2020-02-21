JDBC(Java DataBase connectivity) 프로그래밍

- Java API
- Java.sql
- javax.sql



DMBS에 무관하게 프로그램을 개발 할 수 있다.

- 구성 : JDBC API(인터페이스)  + JDBC Driver(인터페이스들의 구현 클래스)
- API(인터페이스)는 무관
- Driver는 DBMS 에 따라 달라짐



팩토리 메서드 : 객체 생성을 대신 해주는 일반 메서드



SQL 명령을 수행시키는 기능을 지원하는 객체 - statement

executeQuery(): ResultSet - SELECT

executeUpdate():int - 그 외의 모든 SQL, 리턴값 int : 변경된 행 수

Statement stmt = Connection 객체의 createStatement();



JDBC 프로그램의 구현 순서

1. JDBC Driver 로딩 - Class.forName()
2. DBMS 에 접속 - DriverManager.getConnection("jdbc url", "계정", "암호")

3. Statement/PreparedStatement 객체 생성

4. 처리하려는 기능에 따라서 SQL 문을 전달하고 수행시킨다

5. 결과 처리

   ResultSet 객체

   next() : 행단위로 옮김, getXXX() : 행의 데이터값 getint, getdouble, getstring(varchar형일경우), getdate

6. 종료시 close()



java build path 에 라이브러리 추가

C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar



[URL]

인터넷 사이트(웹 사이트, 웹 페이지) 의 주소 문자열 -> http URL 

Uniform Resource Locator 의 약어로 어떤 자원의 위치를 알리는 단일화(규격화) 된 형식의 문자열

프로토콜명:........................

http://www.naver.com/

https://www.naver.com/

http://www.html5test.com

http://www.w3schools.com

http://www.w3.org



jdbc url : 어떤 DBMS 를 어떤 JDBC Driver 를 통해서 접속할 것 인지 하나의 문자열로 구성

jdbc (프로토콜):DBMS이름(접속할DBMS공식이름):JDBCDriver이름(thin-oralc driver 명, 간단한드라이버):Driver에서원하는대로

jdbc:oracle:thin:@DBMS가설치된네트워크주소:리스너포트번호:SID

-------------

DatabaseMetaData - 접속된 DB에 대한 정보, JDBC 드라이버에 대한 정보 추출/체크

ResultSetMetaData - SELECT 명령을 수행하고 생성된 ResultSet 객체에 대한 정보를 추출