drop database if exists cloudDB02;
create database cloudDB02;
use cloudDB02;

create table dept(
                   deptno int not null auto_increment,
                   dname varchar(300),
                   db_source varchar(60),
                   primary key (deptno)
);

insert into dept(dname, db_source)
values ('开发部2', database());

insert into dept(dname, db_source)
values ('人事部2', database());

insert into dept(dname, db_source)
values ('财务部2', database());

insert into dept(dname, db_source)
values ('市场部2', database());

insert into dept(dname, db_source)
values ('运维部2', database());

select *
from dept;