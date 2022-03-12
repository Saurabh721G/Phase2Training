create tables (for oracle specific query)
====================
 create table emp2(id number primary key,name varchar2(100),email varchar2(20),password varchar2(20),salary float,permission varchar2(20) default 'user' );
 insert into emp2 values(102,'abhay','abhay@gmail.com','abhay',40000.0,'user');
 insert into emp2 values(101,'sg','sg721@gmail.com','sg',50000.0,'admin');
