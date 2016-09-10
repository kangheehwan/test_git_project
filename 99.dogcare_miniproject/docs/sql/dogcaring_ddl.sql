
/*
##회원(맡기미) 스키마 스크립트 파일 
-- 회원테이블 명 : owner
--스크립트 파일 명 : owner.ddl.sql

## 회원 맡기미 엔티티 분석 테이블 명 : OWNER
1. 아이디 : USER_ID VARCHAR(20)    PRIMARY KEY
2. 이름 :  NAME VARCHAR(20)   NOT NULL
3.비밀번호 : USER_PW VARCHAR(20)   NOT NULL
4.등급 : GRADE VARCHAR(10)   NOT NULL
5.연락처 : MOBILE VARCHAR(20)   NOT NULL
6.거주지 : ADDRESS VARCHAR(20)      NOT NULL 


##속성 데이터 
-- 거주지의 경우 시와 동까지만 EX) 서울시 동작구
-- 등급의 경우   OWNER 와 MANAGER로 구분지을 거임

*/
--테이블 삭제
DROP TABLE OWNER;
DROP TABLE OWNER PURGE; /*완전삭제*/


--테이블 생성 
CREATE TABLE  OWNER(
		USER_ID   VARCHAR(20)    PRIMARY KEY,
	        NAME VARCHAR(20)   NOT NULL,
		USER_PW VARCHAR(20)   NOT NULL,
	       GRADE VARCHAR(10)   NOT NULL,
	       MOBILE   VARCHAR(15)   NOT NULL,
	      ADDRESS VARCHAR(20)      NOT NULL
);


/*
##회원(돌보미) 스키마 스크립트 파일 
-- 회원테이블 명 : PETMANAGER
--스크립트 파일 명 : PETMANAGER.ddl.sql

## 회원 돌보미 엔티티 분석 테이블 명 : PETMANAGER
1. 애견관리사 자격번호 : C_NUMBER VARCHAR(20)    PRIMARY KEY
2. 이름 :  NAME VARCHAR(20)   NOT NULL
3. 비밀번호 : USER_PW VARCHAR(20)   NOT NULL
4. 연락처 : MOBILE VARCHAR(20)   NOT NULL
5. 등급 : GRADE VARCHAR(10)   NOT NULL
6. 돌봄가능지역 : POSSIBLE_AREA   VARCHAR(15)   NOT NULL
7. 거주지환경 : ENVIROMENT VARCHAR(20)      NOT NULL 
8. 애견돌봄경력: CARRER   VARCHAR(20)    NOT NULL 
9. 현재돌봄 여부 DOG_CARE VARCHAR(5)



##속성 데이터 
-- 돌봄가능지역의 경우 시와 동까지만 EX) 서울시 동작구
-- 거주지환경  아파트,주택,빌라
-- 현재 돌봄의 경우는 매칭이되면 돌봄중 혹은 돌봄대기중으로 할예정


*/
--테이블 삭제
DROP TABLE PETMANAGER;
DROP TABLE PETMANAGER PURGE; /*완전삭제*/

update owner set user_pw=?, name=?, mobile=?,  POSSIBLE_AREA=?,ENVIROMENT=?,CARRIER   =? where C_NUMBER=?
CREATE TABLE PETMANAGER(
		C_NUMBER VARCHAR(20)    PRIMARY KEY,
		  NAME VARCHAR(20)   NOT NULL,
		 USER_PW VARCHAR(20)   NOT NULL,
		  GRADE VARCHAR(10)   NOT NULL,
		 MOBILE VARCHAR(20)   NOT NULL,
		 POSSIBLE_AREA   VARCHAR(15)   NOT NULL,
		 ENVIROMENT VARCHAR(20)      NOT NULL ,
		CARRIER   VARCHAR(20)    NOT NULL ,
	        DOG_CARE VARCHAR(10)
);
		



/*
##게시판 (돌보미 글등록)스키마 스크립트 파일 
-- 게시판테이블명 : BOARD
--스크립트 파일 명 : board.ddl.sql

## 게시판엔티티 분석 테이블 명 : BOARD
1. 글번호 : BOARD_NUMBER    NUMBER(10)    PRIMARY KEY
2  자격증 번호 : C_NUMBER   VARCHAR(20) NOT NULL
3. 제목 :  TITLE   VARCHAR(100)   NOT NULL
4. 소개글 : CONTENT   VARCHAR(20)   NOT NULL
5. 가격  : PRICE  NUMBER(10)   NOT NULL
6. 가능한 종  : POSSIBLE_DOG_KIND  VARCHAR(10)   NOT NULL


##속성 데이터 
-- 제목 : EX) 현재 ~살고있는 누구입니다. 내 애견이라 생각하면 맡겠습니다~~
-- 내용 : EX) 몇일 부터 몇일까지 시간이 비어서 가능할것 같습니다 자세한 내용은 프로필을 확인해주세요~
-- 가격(24시간 기준): 소형견 2만원 중형견 3만원 대형견 4만원
-- 가능한 종(가능한 종까지 상위개념) : 중형견(include in 소형견) 까지 대형견(include in 소형견,중형견) 까지 


*/
--테이블 삭제
DROP TABLE BOARD;
DROP TABLE BOARD PURGE; /*완전삭제*/

-- 테이블 생성

CREATE SEQUENCE BOARD_NUMBER INCREMENT BY 300 START WITH 10000;

CREATE TABLE BOARD(
		 BOARD_NUMBER    NUMBER(10)    PRIMARY KEY,
		 C_NUMBER VARCHAR(20) NOT NULL,
		 TITLE   VARCHAR(100)   NOT NULL,
		 CONTENT   VARCHAR(100)   NOT NULL,
		 PRICE  varchar(50)   NOT NULL,
		 POSSIBLE_DOG_KIND  VARCHAR(10)   NOT NULL,
		 constraint FK_BOARD_C_NUMBER foreign key(C_NUMBER) references PETMANAGER(C_NUMBER)
);






/*
##돌봄상태 스크립트 파일 
-- 게시판테이블명 : CARING
--스크립트 파일 명 : caring.ddl.sql

## 돌봄맡기미 엔티티 분석 테이블 명 : CARING
1. 돌봄번호 :CARE_NUMBER    NUMBER(10)    PRIMARY KEY
2. 주인아이디:  USER_ID VARCHAR(20)   NOT NULL
3. 애견관리사 자격번호 : C_NUMBER VARCHAR(20)
4.애견등록번호  : DOG_NUMBER  VARCHAR(20)   NOT NULL
4.강아지이름  : DOG_NAME  VARCHAR(10)   NOT NULL
5. 나  이 : DOG_AGE  NUMBER(5)   NOT NULL
6. 성  별 :  GENDER VARCHAR(5) NOT NULL


##속성 데이터 
-- 돌봄번호 : 시퀀스 넘버로 자동생성 EX) 현재 ~살고있는 누구입니다. 내 애견이라 생각하면 맡겠습니다~~


*/
--테이블 삭제
DROP TABLE CARING;
DROP TABLE CARING PURGE; /*완전삭제*/

CREATE SEQUENCE CARE_NUMBER INCREMENT BY 100 START WITH 500;

CREATE TABLE CARING(
		CARE_NUMBER    NUMBER(10)    PRIMARY KEY,
		USER_ID VARCHAR(20)   NOT NULL,
		C_NUMBER VARCHAR(20)  NOT NULL,
		DOG_NUMBER  VARCHAR(15)   NOT NULL,
		DOG_NAME  VARCHAR(20)   NOT NULL,
		DOG_KIND  VARCHAR(20)   NOT NULL,
		DOG_AGE  NUMBER(5)   NOT NULL,
		GENDER VARCHAR(10) NOT NULL,
 		constraint FK_CARING_USERID foreign key(user_Id) references OWNER(user_Id),
  		constraint FK_CARING_C_NUMBER foreign key(C_NUMBER) references PETMANAGER(C_NUMBER)
);



