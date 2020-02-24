CREATE TABLE meminfo
(
    mem_id               INT              NOT NULL, 
    mem_userid           INT              NOT NULL, 
    mem_password         VARCHAR2(90)     NOT NULL, 
    mem_username         VARCHAR2(90)     NOT NULL, 
    mem_email            VARCHAR2(150)    NOT NULL, 
    mem_age              INT              NOT NULL, 
    mem_birthday         NVARCHAR2(20)    NOT NULL, 
    mem_sex              VARCHAR2(16)     NOT NULL, 
    mem_phone            VARCHAR2(30)     NOT NULL, 
    mem_address          VARCHAR2(300)    NOT NULL, 
    mem_register_date    DATE             NOT NULL, 
    mem_photo            VARCHAR2(300)    NOT NULL, 
    mem_is_employer      INT              NOT NULL, 
    CONSTRAINT MEMINFO_PK PRIMARY KEY (mem_id)
)

commit;
select * from tab;
desc meminfo;

CREATE SEQUENCE meminfo_SEQ
START WITH 1
INCREMENT BY 1;

desc meminfo;

-- 테이블 컬럼 수정하기
alter table meminfo modify mem_userid VARCHAR2(90);


