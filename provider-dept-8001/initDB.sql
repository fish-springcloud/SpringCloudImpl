drop database if exists cloudDB01;
create database cloudDB01;
use cloudDB01;

create table dept(
                   deptno int not null auto_increment,
                   dname varchar(300),
                   db_source varchar(60),
                   primary key (deptno)
);

insert into dept(dname, db_source)
values ('开发部', database());

insert into dept(dname, db_source)
values ('人事部', database());

insert into dept(dname, db_source)
values ('财务部', database());

insert into dept(dname, db_source)
values ('市场部', database());

insert into dept(dname, db_source)
values ('运维部', database());

select *
from dept;