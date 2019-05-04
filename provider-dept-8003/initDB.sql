drop database if exists cloudDB03;
create database cloudDB03;
use cloudDB03;

create table dept(
                   deptno int not null auto_increment,
                   dname varchar(300),
                   db_source varchar(60),
                   primary key (deptno)
);

insert into dept(dname, db_source)
values ('开发部3', database());

insert into dept(dname, db_source)
values ('人事部3', database());

insert into dept(dname, db_source)
values ('财务部3', database());

insert into dept(dname, db_source)
values ('市场部3', database());

insert into dept(dname, db_source)
values ('运维部3', database());

select *
from dept;