drop table memo purge;
drop table mmember purge;
create table mmember(
	USER_EMAIL varchar2(100) primary key,
	USER_PASS varchar2(30)  not null,
	USER_SUB varchar2(30),
	AUTH_TYPE varchar2(100),
	USER_NICK varchar2(30), /* 디폴트는 자바에서 설정*/
	USER_FORM varchar2(30) default 'STUDY'
);

create table memo(
	USER_EMAIL varchar2(100) references mmember(USER_EMAIL),
	MEMO_NUM number(20),
	MEMO_SUB varchar2(30),
	MEMO_POSITION varchar2(20) default('absolute'),
	MEMO_TOP varchar2(20),
	MEMO_LEFT varchar2(20),
	MEMO_COLOR varchar2(20),
	MEMO_ZIN number(20),
	MEMO_TEX CLOB,
	MEMO_DATE date not null,
	MEMO_PRE date,
	PREV_TEX CLOB,	
	MEMO_FAV varchar2(3) default ('N'),
	MEMO_LOC varchar2(3) default ('N')
);

insert into mmember values('admin@admin.net','1','STUDY','NONE','admin','STUDY');

select*from mmember;
select*from memo;


