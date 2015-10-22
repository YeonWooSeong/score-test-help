create table Member(
userid varchar2(20);
password varchar2(20);
name varchar2(20);
birth varchar2(20);
phone varchar2(20);
email varchar2(50);
gender varchar2(20);
addr varchar2(50);
regdate varchar2(10);
profile varchar2(20)

);

alter table Member
add constraint Member_pk primary key(userid);