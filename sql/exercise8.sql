select user from dual;
create table visitor(
    name VARCHAR2(18),
    writedate date,
    memo VARCHAR2(180)
    );
 insert into visitor values ('루피',sysdate,'고무고무'); 
 insert into visitor values ('조로',to_date('171225','rrmmdd'),'검'); 
 insert into visitor values ('상디',to_date('990811','rrmmdd'),'발'); 
 select * from visitor;
 rollback;
 commit;
 
 create table member(
    m_id VARCHAR2(12) primary key,
    m_pwd VARCHAR2(12) NOT NULL,
    name VARCHAR2(18) NOT NULL,
    joindate date DEFAULT sysdate
 );
 
 select * from member;
 insert into member(m_id,m_pwd,name) values ('1','2','sy'); 
 
create table news(
    id NUMBER(8) primary key,
    writer VARCHAR2(18),
    title VARCHAR2(120),
    content VARCHAR2(900),
    writedate date,
    cnt NUMBER(8)
 );
 select *from news;
 
 create table meeting(
    id NUMBER(8) primary key,
    writer VARCHAR2(18),
    title VARCHAR2(120),
    content VARCHAR2(900),
    writedate date,
    cnt NUMBER(8)
 );
 
 create table imgtest(
    name VARCHAR2(18) primary key,
    imgcontent blob
 );
 
 select * from tab;
 select * from user_constraints
 where table_name = 'MEETING'; -- 제약조건 확인
 -- select * from user_constraints where table_name = '테이블명(대문자)';