select user from dual;
create table visitor(
    name VARCHAR2(18),
    writedate date,
    memo VARCHAR2(180)
    );
 insert into visitor values ('����',sysdate,'����'); 
 insert into visitor values ('����',to_date('171225','rrmmdd'),'��'); 
 insert into visitor values ('���',to_date('990811','rrmmdd'),'��'); 
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
 where table_name = 'MEETING'; -- �������� Ȯ��
 -- select * from user_constraints where table_name = '���̺��(�빮��)';