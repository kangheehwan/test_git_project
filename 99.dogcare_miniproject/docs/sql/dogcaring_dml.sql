/*
   ##회원(맡기미)테이블 스키마 스크립트 파일
   -- 회원테이블명 : owner
   -- 스크립트파일명 : owner_dml.sql
   


   

## 회원(맡기미) 엔티티 분석 : OWNER
1. 아이디 : USER_ID VARCHAR(20)    PRIMARY KEY
2. 이름 :  NAME VARCHAR(20)   NOT NULL
3.비밀번호 : USER_PW VARCHAR(20)   NOT NULL
4.연락처 : MOBILE VARCHAR(20)   NOT NULL
5.등급 : GRADE VARCHAR(10)   NOT NULL
6.연락처 : MOBILE   VARCHAR(15)   NOT NULL
7.거주지 : ADDRESS VARCHAR(20)      NOT NULL 

  
*/
--데이터 삭제 
delete from owner;
--1.회원가입 
insert into OWNER
values('user01', '맡기미1', 'pass01', 'owner','010-1111-1111', '서울시 동작구');

insert into OWNER
values('user02', '맡기미2', 'pass02', 'owner','010-1111-1112', '서울시 강남구');

insert into OWNER
values('user03', '맡기미3', 'pass03','owner', '010-1111-1113', '서울시 동대문구');

insert into OWNER
values('user04', '맡기미4', 'pass04', 'owner','010-1111-1114', '서울시 강동구');

insert into OWNER
values('user05', '맡기미5', 'pass05', 'owner','010-1111-1115', '서울시 노원구');

-- 2.내정보조회 기능
select * from owner where user_id='user01';

-- 3.아이디 찾기(이름과 핸드폰)
select user_id  from owner
 where name = '맡기미1' and mobile = '010-1111-1111';

-- 4.비밀번호 찾기(아이디와 전화번호)
select user_pw from owner
 where user_id = 'user01' and mobile = '010-1111-1111';

--5.회원정보 수정 
-- 변경 가능 항목 : 비밀번호, 이름, 연락처, 이메일
update owner set
 name='사용자변경',user_pw='pass11',  mobile='010-1234-1234', address='서울시 노원구'
where user_id='user01';

-- 5.탈퇴 기능
delete * from owner
where user_id='user01';

-- 8.로그인 : 
select * from owner where user_id='user02' and user_pw='pass02';




/*
   ##회원(돌보미)테이블 스키마 스크립트 파일
   -- 회원테이블명 : PETMANAGER
   -- 스크립트파일명 : PETMANAGER_dml.sql
   


## 회원 돌보미 엔티티 분석 테이블 명 : PETMANAGER
1. 애견관리사 자격번호 : C_NUMBER VARCHAR(20)    PRIMARY KEY
2. 이름 :  NAME VARCHAR(20)   NOT NULL
3. 비밀번호 : USER_PW VARCHAR(20)   NOT NULL
4. 등급 : GRADE VARCHAR(10)   NOT NULL
5. 연락처 : MOBILE VARCHAR(20)   NOT NULL
6. 돌봄가능지역 : POSSIBLE_AREA   VARCHAR(15)   NOT NULL
7. 거주지환경 : ENVIROMENT VARCHAR(20)      NOT NULL 
8. 애견돌봄경력: CARRIER   VARCHAR(20)    NOT NULL 
9. 현재돌봄 여부 DOG_CARE VARCHAR(10)

  
*/
delete  * from petmanager;


--1.회원가입 
insert into PETMANAGER
values('15-10001', '돌보미1', 'pass01', 'manager', '010-2222-1111','서울시 노원구','아파트','마티즈3년', '돌봄대기');

insert into PETMANAGER
values('15-10002', '돌보미2', 'pass02', 'manager', '010-2222-1112','서울시 강동구','주택','치와와1년', '돌봄대기');

insert into PETMANAGER
values('15-10003', '돌보미3', 'pass03', 'manager', '010-2222-1113','서울시 동작구','빌라','비글6개월', '돌봄대기');

insert into PETMANAGER
values('15-10004', '돌보미3', 'pass04', 'manager', '010-2222-1114','서울시 강남구','주택','비글1개월', '돌봄대기');

insert into PETMANAGER
values('15-10005', '돌보미5', 'pass05', 'manager', '010-2222-1115','서울시 종로구','아파트','시츄2년', '돌봄대기');

-- 2.내정보조회 기능
select * from PETMANAGER where C_NUMBER='15-10001';

-- 3.아이디 찾기(이름과 핸드폰)
select PETMANAGER  from PETMANAGER
 where name = '돌보미1' and mobile = '010-2222-1111';

-- 4.비밀번호 찾기(아이디와 전화번호)
select user_pw from PETMANAGER
 where C_NUMBER = '15-10005' and mobile = '010-2222-1115';

--5.회원정보 수정 
-- 변경 가능 항목 : 비밀번호, 이름, 연락처, 이메일
update PETMANAGER set
 name='사용자변경',user_pw='pass11',  mobile='010-1234-1234', POSSIBLE_AREA='서울시 강동구' ENVIROMENT='주택'CARRIER='시추2년'
where C_NUMBER='15-10001';

-- 5.탈퇴 기능
delete from petmanager
where C_NUMBER='15-10002';

-- 8.로그인 : 
select * from members where C_NUMBER='15-10001' and user_pw='pass01';





/*
   ##게시판테이블 스키마 스크립트 파일
   -- 회원테이블명 : BOARD
   -- 스크립트파일명 :  BOARD_dml.sql
   


## 게시판 엔티티 분석 테이블 명 : BOARD
1. 글번호 : BOARD_NUMBER    NUMBER(10)    PRIMARY KEY
2  자격증 번호 : C_NUMBER   VARCHAR(20) NOT NULL
3. 제목 :  TITLE   VARCHAR(100)   NOT NULL
4. 소개글 : CONTENT   VARCHAR(100)   NOT NULL
5. 가격  : PRICE String(10)   NOT NULL
6. 가능한 종  : POSSIBLE_DOG_KIND  VARCHAR(10)   NOT NULL
  
*/

--1.게시판가입
insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10001', '07.24~07.25 돌봐드려요', '휴가가 생겨서 봐드릴수 있습니다. 성실히 내아이라 생각하고 임하겠습니다.'
,'중형견30000원','중형견');

insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10002','08.24 돌봐드려요', '강아지를 사랑하는 팻남. 다양한 경험을 가지고있습니다.'
, '소형견10000원 중형견30000원','중형견');

insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10003', '08월 한달 돌봐드려요', '저만믿고 여름 휴가 다녀오세요'
, '소형견20000원 중형견 30000원 대형견 50000원','대형견');

insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10004', '08월 25일 26일 ', '안녕하세요 현재 동대문구에 살고있는 돌보미입니다. 현재까지 약 10회정도 돌보았습니다. 연락주세요'
, '소형견10000원 중형견 30000원 대형견 50000원','대형견');


insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10005', '8월 2째주 돌봐드려요.', '강남구,서초구 가능합니다. 휴가다녀오세요'
, '소형견20000원','소형견');





-- 2.게시판 정보조회 기능(사용자 자격증 번호를 통해서 )
select * from BOARD where C_NUMBER='15-10001';


-- 3.게시글정보 수정 
-- 변경 가능 항목 : 비밀번호, 이름, 연락처, 이메일
update BOARD set
 TITLE='8월 24일날 돌봐드립니다.',PRICE='소형견 30000원'
where C_NUMBER='15-10001';

--4. 게시글정보 삭제
delete from BOARD
where C_NUMBER='15-10002' AND BOARD_NUMBER ='10001';



/*
 ##돌봄상태 스크립트 파일 
-- 게시판테이블명 : CARING
--스크립트 파일 명 : caring.ddl.sql

## 돌봄맡기미 엔티티 분석 테이블 명 : CARING
1. 돌봄번호 :CARE_NUMBER    NUMBER(10)    PRIMARY KEY
2. 주인아이디:  USER_ID VARCHAR(20)   NOT NULL
3. 애견관리사 자격번호 : C_NUMBER VARCHAR(20)
4.애견등록번호  : DOG_NUMBER  VARCHAR(20)   NOT NULL
5.강아지이름  : DOG_NAME  VARCHAR(10)   NOT NULL
6.강아지 종류 :DOG_KIND VARCHAR(10) not null
7. 나  이 : DOG_AGE  NUMBER(5)   NOT NULL
8. 성  별 :  GENDER VARCHAR(5) NOT NULL
  
*/




--1.맡기기등록 
insert into caring  
values(CARE_NUMBER.NEXTVAL,'user01','15-10001','40001','주너니','시츄',3,'수컷');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user02','15-10002','40002','리길호','포메리안',2,'암컷');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user03','15-10003','40003','면화니','시베리안',5,'수컷');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user04','15-10004','40004','해쿠니','비글',6,'암컷');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user05','15-10005','40005','희하니','말티즈',7,'수컷');




-- 2.맡기기 정보조회 기능(사용자 자격증 번호를 통해서 )
select * from caring where care_number='3200';


-- 3.맡기기 수정 
-- 변경 가능 항목 : 비밀번호, 이름, 연락처, 이메일
update caring set
DOG_NUMBER ='40002' 
 where care_number='3200';

--4. 맡기기 삭제
delete from caring
where care_number='3200';