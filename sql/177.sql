select * from news where rownum = (select count(*) from news);

select rownum, id from news;
select count(*) from news;
select rownum, id from news where rownum = 1;

select rownum, id from news;

select * from (select rownum, id from news) a where a.rownum='2';
SELECT ROWNUM AS RNUM, id FROM news T;
SELECT ROWNUM AS RNUM, id FROM news T order by id;

SELECT * FROM (SELECT ROWNUM AS RNUM, id FROM news T order by id desc) A WHERE A.RNUM between 1 and 20;
select * from (select rownum as rnum, id from news T order by id desc) a where a.rnum between 1 and 20;
select max(id) from news;
delete from news where id = 82;
commit;

select
    length(last_name)
from
    emp
where emp_id = 123;  

select
nvl(vsize(last_name),0),
from
    emp where emp_id = 123;
