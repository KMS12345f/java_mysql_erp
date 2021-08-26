select code, name from title;
  
select code, name
   from title
  where code = 1;
  
insert INTO title values (6, '인턴');

update title set name = '계약직' where code =6;

delete from title where code = 6;

