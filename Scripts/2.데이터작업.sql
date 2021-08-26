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

select * from title;


INSERT INTO erp.department (code, name, floor) VALUES(1, '기획', 10);
select * from department;


INSERT 
  INTO erp.employee (empno, empname, title, manager, salary, dno) 
VALUES(4377, '이성래', 1, null, 4500000, 1);
select * from employee;

