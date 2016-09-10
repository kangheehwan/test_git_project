
/*
##ȸ��(�ñ��) ��Ű�� ��ũ��Ʈ ���� 
-- ȸ�����̺� �� : owner
--��ũ��Ʈ ���� �� : owner.ddl.sql

## ȸ�� �ñ�� ��ƼƼ �м� ���̺� �� : OWNER
1. ���̵� : USER_ID VARCHAR(20)    PRIMARY KEY
2. �̸� :  NAME VARCHAR(20)   NOT NULL
3.��й�ȣ : USER_PW VARCHAR(20)   NOT NULL
4.��� : GRADE VARCHAR(10)   NOT NULL
5.����ó : MOBILE VARCHAR(20)   NOT NULL
6.������ : ADDRESS VARCHAR(20)      NOT NULL 


##�Ӽ� ������ 
-- �������� ��� �ÿ� �������� EX) ����� ���۱�
-- ����� ���   OWNER �� MANAGER�� �������� ����

*/
--���̺� ����
DROP TABLE OWNER;
DROP TABLE OWNER PURGE; /*��������*/


--���̺� ���� 
CREATE TABLE  OWNER(
		USER_ID   VARCHAR(20)    PRIMARY KEY,
	        NAME VARCHAR(20)   NOT NULL,
		USER_PW VARCHAR(20)   NOT NULL,
	       GRADE VARCHAR(10)   NOT NULL,
	       MOBILE   VARCHAR(15)   NOT NULL,
	      ADDRESS VARCHAR(20)      NOT NULL
);


/*
##ȸ��(������) ��Ű�� ��ũ��Ʈ ���� 
-- ȸ�����̺� �� : PETMANAGER
--��ũ��Ʈ ���� �� : PETMANAGER.ddl.sql

## ȸ�� ������ ��ƼƼ �м� ���̺� �� : PETMANAGER
1. �ְ߰����� �ڰݹ�ȣ : C_NUMBER VARCHAR(20)    PRIMARY KEY
2. �̸� :  NAME VARCHAR(20)   NOT NULL
3. ��й�ȣ : USER_PW VARCHAR(20)   NOT NULL
4. ����ó : MOBILE VARCHAR(20)   NOT NULL
5. ��� : GRADE VARCHAR(10)   NOT NULL
6. ������������ : POSSIBLE_AREA   VARCHAR(15)   NOT NULL
7. ������ȯ�� : ENVIROMENT VARCHAR(20)      NOT NULL 
8. �ְߵ������: CARRER   VARCHAR(20)    NOT NULL 
9. ���絹�� ���� DOG_CARE VARCHAR(5)



##�Ӽ� ������ 
-- �������������� ��� �ÿ� �������� EX) ����� ���۱�
-- ������ȯ��  ����Ʈ,����,����
-- ���� ������ ���� ��Ī�̵Ǹ� ������ Ȥ�� ������������� �ҿ���


*/
--���̺� ����
DROP TABLE PETMANAGER;
DROP TABLE PETMANAGER PURGE; /*��������*/

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
##�Խ��� (������ �۵��)��Ű�� ��ũ��Ʈ ���� 
-- �Խ������̺�� : BOARD
--��ũ��Ʈ ���� �� : board.ddl.sql

## �Խ��ǿ�ƼƼ �м� ���̺� �� : BOARD
1. �۹�ȣ : BOARD_NUMBER    NUMBER(10)    PRIMARY KEY
2  �ڰ��� ��ȣ : C_NUMBER   VARCHAR(20) NOT NULL
3. ���� :  TITLE   VARCHAR(100)   NOT NULL
4. �Ұ��� : CONTENT   VARCHAR(20)   NOT NULL
5. ����  : PRICE  NUMBER(10)   NOT NULL
6. ������ ��  : POSSIBLE_DOG_KIND  VARCHAR(10)   NOT NULL


##�Ӽ� ������ 
-- ���� : EX) ���� ~����ִ� �����Դϴ�. �� �ְ��̶� �����ϸ� �ðڽ��ϴ�~~
-- ���� : EX) ���� ���� ���ϱ��� �ð��� �� �����Ұ� �����ϴ� �ڼ��� ������ �������� Ȯ�����ּ���~
-- ����(24�ð� ����): ������ 2���� ������ 3���� ������ 4����
-- ������ ��(������ ������ ��������) : ������(include in ������) ���� ������(include in ������,������) ���� 


*/
--���̺� ����
DROP TABLE BOARD;
DROP TABLE BOARD PURGE; /*��������*/

-- ���̺� ����

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
##�������� ��ũ��Ʈ ���� 
-- �Խ������̺�� : CARING
--��ũ��Ʈ ���� �� : caring.ddl.sql

## �����ñ�� ��ƼƼ �м� ���̺� �� : CARING
1. ������ȣ :CARE_NUMBER    NUMBER(10)    PRIMARY KEY
2. ���ξ��̵�:  USER_ID VARCHAR(20)   NOT NULL
3. �ְ߰����� �ڰݹ�ȣ : C_NUMBER VARCHAR(20)
4.�ְߵ�Ϲ�ȣ  : DOG_NUMBER  VARCHAR(20)   NOT NULL
4.�������̸�  : DOG_NAME  VARCHAR(10)   NOT NULL
5. ��  �� : DOG_AGE  NUMBER(5)   NOT NULL
6. ��  �� :  GENDER VARCHAR(5) NOT NULL


##�Ӽ� ������ 
-- ������ȣ : ������ �ѹ��� �ڵ����� EX) ���� ~����ִ� �����Դϴ�. �� �ְ��̶� �����ϸ� �ðڽ��ϴ�~~


*/
--���̺� ����
DROP TABLE CARING;
DROP TABLE CARING PURGE; /*��������*/

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



