*
	## 맡기미테이블에 대한 DML
	--  맡기미테이블명 : owner
	--  스크립트파일명 : owner_init.sql
	--  맡기미관리 시스템 개발을 위한 초기화 데이터

## 회원 맡기미 엔티티 분석 테이블 명 : OWNER
1. 아이디 : USER_ID VARCHAR(20)    PRIMARY KEY
2. 이름 :  NAME VARCHAR(20)   NOT NULL
3.비밀번호 : USER_PW VARCHAR(20)   NOT NULL
4.등급 : GRADE VARCHAR(10)   NOT NULL
5.연락처 : MOBILE VARCHAR(20)   NOT NULL
6.거주지 : ADDRESS VARCHAR(20)      NOT NULL 
*/

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


*
	## 돌보미테이블에 대한 DML
	--  맡기미테이블명 : petmanager
	--  스크립트파일명 :petmanager_init.sql
	-- 돌보미관리 시스템 개발을 위한 초기화 데이터

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




*/
	## 게시판테이블(돌보미글 등록)에 대한 DML
	--  게시판테이블명 :board
	--  스크립트파일명 :board_init.sql
	-- 게시판 시스템 개발을 위한 초기화 데이터

## 게시판 엔티티 분석 테이블 명 : BOARD
1. 글번호 : BOARD_NUMBER    NUMBER(10)    PRIMARY KEY
2  자격증 번호 : C_NUMBER   VARCHAR(20) NOT NULL
3. 제목 :  TITLE   VARCHAR(100)   NOT NULL
4. 소개글 : CONTENT   VARCHAR(100)   NOT NULL
5. 가격  : PRICE String(10)   NOT NULL
6. 가능한 종  : POSSIBLE_DOG_KIND  VARCHAR(10)   NOT NULL


*/


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


*/
	## 돌봄테이블(돌봄매칭)에 대한 DML
	--  게시판테이블명 :caring
	--  스크립트파일명 :caring_init.sql
	-- 돌봄매칭테이블 개발을 위한 초기화 데이터

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