select * from visitor;
select rownum, name, writedate from visitor;
select rownum, name, writedate from visitor where to_char(writedate, 'yyyymm') = '202001';
select rownum, name, writedate from visitor order by name;

select rownum, name, writedate from visitor 
where to_char(writedate, 'yyyymm') = '202001' 
and rownum >= 1 and rownum <= 5;

select rownum, name, writedate from visitor 
where to_char(writedate, 'yyyymm') = '202001' 
and rownum >= 1 and rownum <= 10;

select oldrownum, name, writedate from 
(select rownum oldrownum, name, writedate 
from visitor where to_char(writedate, 'yyyymm') = '202001')  
where oldrownum >= 1 and oldrownum <= 5;

select oldrownum, name, writedate from 
(select rownum oldrownum, name, writedate 
from visitor where to_char(writedate, 'yyyymm') = '202001')  
where oldrownum >= 6 and oldrownum <= 10;