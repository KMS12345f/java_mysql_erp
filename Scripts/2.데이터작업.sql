select user(), database();
desc title;

insert
  INTO erp.title (code, name) 
values
(1, '사장'),
(2, '부장'),
(3, '과장'),
(4, '대리'),
(5, '사원');

select code, name from title;


INSERT INTO erp.department (code, name, floor) VALUES(1, '기획', 10);
INSERT INTO erp.department (code, name, floor) VALUES(2, '영업', 20);
select * from department;
select * from department where code = 2;
INSERT INTO erp.department (code, name, floor) VALUES(3, '개발', 21);


INSERT 
  INTO erp.employee (empno, empname, title, manager, salary, dno) 
VALUES(4377, '이성래', 1, null, 4500000, 1);
select * from employee;


update department set name = '인사' where code = 4;
delete from department where code = 4;

insert into employee values(1004, '석주명', 2, 4377, 4000000, 2);
insert into employee values(1005, '장준화', null, null, 2000000, null);
insert into employee values(1006, '김혜인', 3, 4377, 2000000, null);
delete from employee where empno = 1004;
update employee
   set empname = '권민성', title = 1, manager = null, salary = 3000000, dno = 1
 where empno = 1004;
select empno, empname,title, manager, salary, dno from employee;
select empno, empname, title, manager, salary, dno from employee where empno = 4377;

delete from employee where empno = 1010;
delete from employee where empno = 1011;
delete from employee where empno = 1012;
delete from employee where empno = 1013;