## Servlet_DB

(1) JDBC 드라이버 로딩(Class.forName())

(2) DB 서버(DriverManager.getConnection("jdbcurl", "계정", "암호"))

(3) SQL 문을 수행하기 위한 Statement, PreparedStatement 객체를 생성

(4) SELECT - executeQuery() : ResultSet(next, getXXX)

​     INSERT, DELETE, UPDATE, CREATE TABLE, DROP TABLE...

     - executeUpdate() : int(SQL 명령에 의해 변화된 행의 갯수)



[실습]

visitorMain.html -  방명록 리스트 보기 ---> /visitordb(GET)

 							    방명록 작성하기 ---> visitorForm.html ---> /visitordb(POST)

VisitorDBServlet(/visitordb) 

​     GET - visitor 테이블의 데이터들을 모두 읽어 와서 테이블 형식으로 브라우저로 출력 

​     POST - 전송되는 Query 문자열을 가지고 visitor 테이블에 저장

![image-20200122110902229](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200122110902229.png)



라이브러리 드라이버 로딩 오류 발생 시 ojdbc6.jar 압축 상태에서 

WEB-INF > lib 에 복붙한다

- ![image-20200122111235916](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200122111235916.png)