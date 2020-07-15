drop table memo purge;
<<<<<<< HEAD
drop table mmember purge;
CREATE TABLE MEMBER(
	USER_EMAIL VARCHAR2(100) PRIMARY KEY,
	USER_PASS VARCHAR2(30),
	AUTH_TYPE VARCHAR2(100) DEFAULT('WEMO'),
	USER_NICK VARCHAR2(30),
	USER_FORM1 CLOB DEFAULT('¼³Á¤µÈ ÀÚµ¿¿Ï¼º ÆûÀÌ ¾ø½À´Ï´Ù'),
	USER_FORM2 CLOB DEFAULT('¼³Á¤µÈ ÀÚµ¿¿Ï¼º ÆûÀÌ ¾ø½À´Ï´Ù'),
	USER_FORM3 CLOB DEFAULT('¼³Á¤µÈ ÀÚµ¿¿Ï¼º ÆûÀÌ ¾ø½À´Ï´Ù'),
	USER_SUB VARCHAR2(30) DEFAULT('STUDY')
	)	
	
DROP TABLE MEMBER CASCADE Constraints;
INSERT INTO MEMBER VALUES('g@gmail.com', '1234', 'WEMO', 'g@gmail.com', '¼³Á¤µÈ ÀÚµ¿¿Ï¼º ÆûÀÌ ¾ø½À´Ï´Ù', '¼³Á¤µÈ ÀÚµ¿¿Ï¼º ÆûÀÌ ¾ø½À´Ï´Ù', '¼³Á¤µÈ ÀÚµ¿¿Ï¼º ÆûÀÌ ¾ø½À´Ï´Ù', 'STUDY');
INSERT INTO MEMBER VALUES('h@gmail.com', '1234', 'WEMO', 'h@gmail.com', 'No Form Now', 'STUDY');
UPDATE MEMBER SET USER_SUB = 'WORKOUT' WHERE USER_EMAIL = 'g@gmail.com';
DROP TABLE MEMO;
CREATE TABLE MEMO(
	USER_EMAIL VARCHAR2(100) REFERENCES MEMBER(USER_EMAIL),
	MEMO_NUM NUMBER(20) PRIMARY KEY,
	MEMO_SUB VARCHAR2(30) NOT NULL,
	MEMO_POSITION VARCHAR2(20) DEFAULT('ABSOLUTE') NOT NULL,
	MEMO_TOP VARCHAR2(20),
	MEMO_LEFT VARCHAR2(20),
	MEMO_COLOR VARCHAR2(20),
	MEMO_WIDTH VARCHAR2(20),
	MEMO_HEIGHT VARCHAR2(20),
	MEMO_ZID NUMBER(20),
=======
drop table member purge;
create table member(
	USER_EMAIL varchar2(100) primary key,
	USER_PASS varchar2(30)  not null,
	USER_SUB varchar2(30),
	AUTH_TYPE varchar2(100),
	USER_NICK varchar2(30), /* ë””í´íŠ¸ëŠ” ìžë°”ì—ì„œ ì„¤ì •*/
	USER_FORM varchar2(30) default 'STUDY'
);

create table memo(
	USER_EMAIL varchar2(100) references member(USER_EMAIL),
	MEMO_NUM number(20),
	MEMO_SUB varchar2(30),
	MEMO_POSITION varchar2(20) default('absolute'),
	MEMO_TOP varchar2(20),
	MEMO_LEFT varchar2(20),
	MEMO_COLOR varchar2(20),
	MEMO_ZIN number(20),
	MEMO_WIDTH varchar2(20),
	MEMO_HEIGHT varchar2(20),
>>>>>>> refs/remotes/origin/Hyuncheol
	MEMO_TEX CLOB,
	MEMO_DATE VARCHAR2(10),
	PREV_TEX CLOB,
	MEMO_PRE VARCHAR2(10),
	MEMO_FAV VARCHAR2(3) DEFAULT('N'),
	MEMO_LOC VARCHAR2(3) DEFAULT('N'),
	MEMO_TRA VARCHAR2(3) DEFAULT('N'),
	MEMO_KEYW VARCHAR2(20)
);
DROP TABLE MEMO;
UPDATE MEMO SET MEMO_COLOR = 'PURPLE' WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_NUM = 7;
SELECT * FROM MEMO;
SELECT * FROM MEMBER;
SELECT * FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_SUB = 'STUDY';
SELECT * FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_SUB = 'STUDY' AND MEMO_NUM = (SELECT MAX(MEMO_NUM) FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_SUB = 'STUDY')
DELETE FROM MEMO WHERE USER_EMAIL = 'g@gmail.com';
SELECT USER_EMAIL, MEMO_NUM, MEMO_SUB, 
			   MEMO_POSITION, MEMO_TOP, MEMO_LEFT, 
			   MEMO_COLOR, MEMO_WIDTH, MEMO_HEIGHT, MEMO_ZID, 
			   MEMO_TEX, TO_DATE(TRUNC(MEMO_DATE, 'DD'), 'YY-MM-DD') MEMO_DATE, 
			   PREV_TEX, TO_DATE(TRUNC(MEMO_PRE, 'DD'), 'YY-MM-DD') MEMO_PRE, 
			   MEMO_FAV, MEMO_LOC, MEMO_KEYW 
		FROM MEMO 
		WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_SUB = 'STUDY'
		ORDER BY MEMO_ZID DESC
INSERT INTO MEMO VALUES('g@gmail.com', 4, 'MONEY', 'ABSOLUTE', '100px', '100px', 'khaki', '350px', '200px', 999, 'WeMo¿¡ ¿À½Å°ÍÀ» È¯¿µÇÕ´Ï´Ù', TO_CHAR(2020-07-15, 'YYYY-MM-DD'), 'WeMo¿¡ ¿À½Å°ÍÀ» È¯¿µÇÕ´Ï´Ù', TO_CHAR(2020-07-15, 'YYYY-MM-DD'), 'N', 'N', 'N', 'Àá±Ý Å°¿öµå');
INSERT INTO MEMO VALUES('g@gmail.com', 5, 'HEALTH', 'ABSOLUTE', '100px', '100px', 'khaki', '350px', '200px', 999, 'WeMo¿¡ ¿À½Å°ÍÀ» È¯¿µÇÕ´Ï´Ù', TO_CHAR(2020-07-16, 'YYYY-MM-DD'), 'WeMo¿¡ ¿À½Å°ÍÀ» È¯¿µÇÕ´Ï´Ù', TO_CHAR(2020-07-16, 'YYYY-MM-DD'), 'N', 'N', 'N', 'Àá±Ý Å°¿öµå');
INSERT INTO MEMO VALUES('g@gmail.com', 6, 'STUDY', 'ABSOLUTE', '100px', '100px', 'khaki', '350px', '200px', 999, 'WeMo¿¡ ¿À½Å°ÍÀ» È¯¿µÇÕ´Ï´Ù', TO_CHAR(2020-07-17, 'YYYY-MM-DD'), 'WeMo¿¡ ¿À½Å°ÍÀ» È¯¿µÇÕ´Ï´Ù', TO_CHAR(2020-07-17, 'YYYY-MM-DD'), 'N', 'N', 'N', 'Àá±Ý Å°¿öµå');

SELECT MEMO_SUB, COUNT(MEMO_SUB) COUNT FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_TRA = 'N' GROUP BY MEMO_SUB;
SELECT MEMO_SUB, COUNT(MEMO_SUB) CNT FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' GROUP BY MEMO_SUB;
UPDATE MEMO SET MEMO_ZID = MEMO_ZID-1 
		WHERE USER_EMAIL = 'g@gmail.com'
		  AND MEMO_SUB = 'STUDY' 
		  AND MEMO_NUM != 1;
		  
SELECT TO_CHAR(SYSDATE, 'D') FROM DUAL;

SELECT (SELECT COUNT(MEMO_SUB) FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_SUB = 'STUDY' AND MEMO_TRA = 'N') STUDY,
	   (SELECT COUNT(MEMO_SUB) FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_SUB = 'HEALTH' AND MEMO_TRA = 'N') HEALTH,
	   (SELECT COUNT(MEMO_SUB) FROM MEMO WHERE USER_EMAIL = 'g@gmail.com' AND MEMO_SUB = 'MONEY' AND MEMO_TRA = 'N') MONEY
FROM DUAL;
		  
		  
SELECT MEMO_DATE, TO_CHAR(TO_DATE(MEMO_DATE, 'yy-mm-dd'), 'DAY') DAY, COUNT(TO_CHAR(TO_DATE(MEMO_DATE, 'yy-mm-dd'), 'DAY')) COUNT 
FROM MEMO 
WHERE USER_EMAIL = 'g@gmail.com' 
AND MEMO_DATE BETWEEN (SELECT MAX(TO_DATE(MEMO_DATE))-7 FROM MEMO WHERE USER_EMAIL = 'g@gmail.com') 
				  AND (SELECT MAX(TO_DATE(MEMO_DATE)) FROM MEMO WHERE USER_EMAIL = 'g@gmail.com') 
GROUP BY MEMO_DATE 
ORDER BY MEMO_DATE;
