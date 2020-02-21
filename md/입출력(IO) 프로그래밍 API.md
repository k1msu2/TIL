## 입출력(I/O) 프로그래밍 API

- java.io.javax.nio
- FIle : 시스템에 존재하는 파일에 대한 처리, 정보 추출..
- 입력용 API, 출력용 API
- 입력 단위 : 바이트 단위(1.0) --> 문자 단위(1.1) --> InputStreamReader
- 스트림 이라는 논리적 구조 이용한다
- 입력 스트림과 출력 스트림으로 구분한다
- xxxIputStream, xxxoutputStream : 바이트 스트림
- xxxReader, xxxWriter : 문자 스트림



#### 문자스트림

FileReader, FileWriter - 파일 오픈 기능

BufferedReader, BufferdWriter



#### 바이트스트림

FileInputStream, FileOutputStream - 파일 오픈 기능

DataInputStream, DataOutputStream

ObjectInputSTream, ObjectOutputStream



#### InputStreamReader, OutputStreamWriter



\s:공백

*:0개 이상

ab* : abb abbb abbbb











