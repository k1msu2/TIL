### `dplyr` tutorial

https://wsyang.com/2014/02/introduction-to-dplyr/



(1) `Anaconda` 설치

(2) `Jupyter` 설치

(3) `dplyr` 설치

(4) 관련 라이브러리 설치



`dplyr` 패키지란

- `dplyr` 패키지는 Hadley Wickham가 작성한 데이터 처리에 특화된 R 패키지
- `dplyr`은 C++로 작성되어 매우 빠른 처리 속도를 자랑



`dplyr` 패키지 사용법

`dplyr` 패키지와 데이터 셋 hflights 를 설치하고 함수를 이용해 함수군과 데이터를 불러옴

```R
> install.packages(c("dplyr", "hflights"))
> library(dplyr)
> library(hflights)
```

| 함수명      | 내용                             | 유사함수                   |
| :---------- | :------------------------------- | :------------------------- |
| filter()    | 지정한 조건식에 맞는 데이터 추출 | subset()                   |
| select()    | 열의 추출                        | data[, c(“Year”, “Month”)] |
| mutate()    | 열 추가                          | transform()                |
| arrange()   | 정렬                             | order(), sort()            |
| summarise() | 집계                             | aggregate()                |



tbl_df() 함수를 이용하여 큰 데이터 프레임을 보기 쉽도록 해주고 조작하기 쉽게 해준다. data.frame인 처럼 사용



파일 읽기

[https://kamang-it.tistory.com/entry/R-14%ED%8C%8C%EC%9D%BC-%EC%9D%BD%EA%B8%B0xlsxlsx?category=718115](https://kamang-it.tistory.com/entry/R-14파일-읽기xlsxlsx?category=718115)

헤더 한글 깨짐

https://m.blog.naver.com/PostView.nhn?blogId=iimaster&logNo=90114213426&proxyReferer=https%3A%2F%2Fwww.google.com%2F



소스 디렉토리 읽어오기

https://rfriend.tistory.com/219