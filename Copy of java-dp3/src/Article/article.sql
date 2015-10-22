drop table Article;

create sequence seq
start with 1000; -- 4자리 숫자부터 시작.

create table Article(
	seq number not null, -- sequence 정의.
	title varchar2(100)not null,
	content varchar2(500)not null,
	regdate varchar2(10)not null,
	userid varchar2(20)not null,
	constraint article_pk primary key seq,
	constraint article_member_fk 
	foreign key userid references Member(userid)
);