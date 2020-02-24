select * from SEQUENCE;

select * from user_sequences;


DROP TABLE BOARD_GROUP CASCADE CONSTRAINT;
DROP TABLE JOBAD CASCADE CONSTRAINT;
DROP TABLE JOBAD_REVIEW CASCADE CONSTRAINT;
DROP TABLE MEMINFO CASCADE CONSTRAINT;
DROP TABLE WANTAD CASCADE CONSTRAINT;
DROP TABLE WANTAD_REVIEW CASCADE CONSTRAINT;
drop trigger jobad_AI_TRG;
drop trigger jobad_AI_TRG;
select * from meminfo;

drop table meminfo cascade constraint;

CREATE TABLE meminfo
(
    mem_userid           VARCHAR2(90)     NOT NULL, 
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
    CONSTRAINT MEMINFO_PK PRIMARY KEY (mem_userid)
)
/

CREATE TABLE jobad
(
    post_id              INT               NOT NULL, 
    mem_userid           VARCHAR2(90)      NOT NULL, 
    post_title           VARCHAR2(300)     NOT NULL, 
    post_content         VARCHAR2(3000)    NOT NULL, 
    post_writedate       DATE              NOT NULL, 
    post_hit             INT               NOT NULL, 
    post_location        VARCHAR2(300)     NOT NULL, 
    post_payment         INT               NOT NULL, 
    post_phone           VARCHAR2(30)      NOT NULL, 
    post_review_count    INT               NOT NULL, 
    CONSTRAINT JOBAD_PK PRIMARY KEY (post_id)
)
/

CREATE SEQUENCE jobad_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER jobad_AI_TRG
BEFORE INSERT ON jobad 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT jobad_SEQ.NEXTVAL
    INTO :NEW.post_id
    FROM DUAL;
END;
/

CREATE TABLE wantad
(
    post_id              INT               NOT NULL, 
    mem_userid           VARCHAR2(90)      NOT NULL, 
    post_title           VARCHAR2(300)     NOT NULL, 
    post_content         VARCHAR2(3000)    NOT NULL, 
    post_writedate       DATE              NOT NULL, 
    post_hit             INT               NOT NULL, 
    post_location        VARCHAR2(300)     NOT NULL, 
    post_payment         INT               NOT NULL, 
    post_review_count    INT               NOT NULL, 
    CONSTRAINT WANTAD_PK PRIMARY KEY (post_id)
)
/

CREATE SEQUENCE wantad_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER wantad_AI_TRG
BEFORE INSERT ON wantad 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT wantad_SEQ.NEXTVAL
    INTO :NEW.post_id
    FROM DUAL;
END;

ALTER TABLE jobad
    ADD CONSTRAINT FK_jobad_mem_userid_meminfo_me FOREIGN KEY (mem_userid)
        REFERENCES meminfo (mem_userid)
        

ALTER TABLE wantad
    ADD CONSTRAINT FK_wantad_mem_userid_meminfo_m FOREIGN KEY (mem_userid)
        REFERENCES meminfo (mem_userid)
        
        
CREATE TABLE jobreview
(
    review_id         INT              NOT NULL, 
    post_id           INT              NOT NULL, 
    review_userid     VARCHAR2(90)     NOT NULL, 
    review_comment    VARCHAR2(300)    NOT NULL, 
    review_date       DATE             NOT NULL, 
    review_rate       FLOAT            NOT NULL, 
    CONSTRAINT JOBREVIEW_PK PRIMARY KEY (review_id)
)
/

CREATE SEQUENCE jobreview_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER jobreview_AI_TRG
BEFORE INSERT ON jobreview 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT jobreview_SEQ.NEXTVAL
    INTO :NEW.review_id
    FROM DUAL;
END;

ALTER TABLE jobreview
    ADD CONSTRAINT FK_jobreview_post_id_jobad_pos FOREIGN KEY (post_id)
        REFERENCES jobad (post_id)
/

ALTER TABLE jobreview
    ADD CONSTRAINT FK_jobreview_review_userid_mem FOREIGN KEY (review_userid)
        REFERENCES meminfo (mem_userid)
/

CREATE TABLE wantreview
(
    review_id         INT              NOT NULL, 
    post_id           INT              NOT NULL, 
    review_userid     VARCHAR2(90)     NOT NULL, 
    review_comment    VARCHAR2(300)    NOT NULL, 
    review_date       DATE             NOT NULL, 
    review_rate       FLOAT            NOT NULL, 
    CONSTRAINT WANTREVIEW_PK PRIMARY KEY (review_id)
)
/

CREATE SEQUENCE wantreview_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER wantreview_AI_TRG
BEFORE INSERT ON wantreview 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT wantreview_SEQ.NEXTVAL
    INTO :NEW.review_id
    FROM DUAL;
END;
/
ALTER TABLE wantreview
    ADD CONSTRAINT FK_wantreview_post_id_wantad_p FOREIGN KEY (post_id)
        REFERENCES wantad (post_id)
/

ALTER TABLE wantreview
    ADD CONSTRAINT FK_wantreview_review_userid_me FOREIGN KEY (review_userid)
        REFERENCES meminfo (mem_userid)
/

select * from tab;
SELECT * FROM USER_SEQUENCES;
DROP SEQUENCE JOBAD_REVIEW_SEQ;
DROP SEQUENCE WANTAD_REVIEW_SEQ;
DROP SEQUENCE BOARD_GROUP_SEQ;
DROP SEQUENCE MEMINFO_SEQ;

-- 컬럼명 변경---
desc meminfo;
alter table MEMINFO modify MEM_BIRTHDAY DATE;
alter table MEMINFO modify MEM_PHOTO NULL;
alter table MEMINFO drop COLUMN MEM_AGE;
------테스트 케이스 만들기-----

select * from meminfo;

INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem01', '1234', 'username01', 'mem01@gmail.com', sysdate, 'male', '01012345678', '서울시 강동구', sysdate, '/images/mem01.png', 1);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem02', '1234', 'username02', 'mem02@gmail.com', sysdate, 'male', '01012345678', '서울시 강서구', sysdate, '/images/mem02.png', 0);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem03', '1234', 'username03', 'mem03@gmail.com', sysdate, 'male', '01012345678', '서울시 관악구', sysdate, '/images/mem03.png', 1);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem04', '1234', 'username04', 'mem04@gmail.com', sysdate, 'male', '01012345678', '서울시 광진구', sysdate, '/images/mem04.png', 0);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem05', '1234', 'username05', 'mem05@gmail.com', sysdate, 'male', '01012345678', '서울시 강남구', sysdate, '/images/mem05.png', 1);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem06', '1234', 'username06', 'mem06@gmail.com', sysdate, 'female', '01012345678', '서울시 동대문구', sysdate, '/images/mem06.png', 0);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem07', '1234', 'username07', 'mem07@gmail.com', sysdate, 'female', '01012345678', '서울시 금천구', sysdate, '/images/mem07.png', 1);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem08', '1234', 'username08', 'mem08@gmail.com', sysdate, 'female', '01012345678', '서울시 마포구', sysdate, '/images/mem08.png', 0);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem09', '1234', 'username09', 'mem09@gmail.com', sysdate, 'female', '01012345678', '서울시 서대문구', sysdate, '/images/mem09.png', 1);
INSERT INTO meminfo (mem_userid, mem_password, mem_username, mem_email, mem_birthday, mem_sex, mem_phone, mem_address, mem_register_date, mem_photo, mem_is_employer) VALUES ('mem10', '1234', 'username10', 'mem10@gmail.com', sysdate, 'female', '01012345678', '서울시 종로구', sysdate, '/images/mem10.png', 0);

select * from meminfo;

commit;

select * from wantad;

INSERT INTO wantad (mem_userid, post_title, post_content, post_writedate, 
post_hit, post_location, post_payment, post_review_count) 
VALUES ('mem04', '구직게시판테스트2', '구직게시판테스트2', sysdate, 0, '서울시 강남구', 11000, 0);
commit;
select * from wantad;
commit;
drop table wantad cascade constraint;