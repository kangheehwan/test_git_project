*
	## �ñ�����̺� ���� DML
	--  �ñ�����̺�� : owner
	--  ��ũ��Ʈ���ϸ� : owner_init.sql
	--  �ñ�̰��� �ý��� ������ ���� �ʱ�ȭ ������

## ȸ�� �ñ�� ��ƼƼ �м� ���̺� �� : OWNER
1. ���̵� : USER_ID VARCHAR(20)    PRIMARY KEY
2. �̸� :  NAME VARCHAR(20)   NOT NULL
3.��й�ȣ : USER_PW VARCHAR(20)   NOT NULL
4.��� : GRADE VARCHAR(10)   NOT NULL
5.����ó : MOBILE VARCHAR(20)   NOT NULL
6.������ : ADDRESS VARCHAR(20)      NOT NULL 
*/

insert into OWNER
values('user01', '�ñ��1', 'pass01', 'owner','010-1111-1111', '����� ���۱�');

insert into OWNER
values('user02', '�ñ��2', 'pass02', 'owner','010-1111-1112', '����� ������');

insert into OWNER
values('user03', '�ñ��3', 'pass03','owner', '010-1111-1113', '����� ���빮��');

insert into OWNER
values('user04', '�ñ��4', 'pass04', 'owner','010-1111-1114', '����� ������');

insert into OWNER
values('user05', '�ñ��5', 'pass05', 'owner','010-1111-1115', '����� �����');


*
	## ���������̺� ���� DML
	--  �ñ�����̺�� : petmanager
	--  ��ũ��Ʈ���ϸ� :petmanager_init.sql
	-- �����̰��� �ý��� ������ ���� �ʱ�ȭ ������

## ȸ�� ������ ��ƼƼ �м� ���̺� �� : PETMANAGER
1. �ְ߰����� �ڰݹ�ȣ : C_NUMBER VARCHAR(20)    PRIMARY KEY
2. �̸� :  NAME VARCHAR(20)   NOT NULL
3. ��й�ȣ : USER_PW VARCHAR(20)   NOT NULL
4. ��� : GRADE VARCHAR(10)   NOT NULL
5. ����ó : MOBILE VARCHAR(20)   NOT NULL
6. ������������ : POSSIBLE_AREA   VARCHAR(15)   NOT NULL
7. ������ȯ�� : ENVIROMENT VARCHAR(20)      NOT NULL 
8. �ְߵ������: CARRIER   VARCHAR(20)    NOT NULL 
9. ���絹�� ���� DOG_CARE VARCHAR(10)
*/

insert into PETMANAGER
values('15-10001', '������1', 'pass01', 'manager', '010-2222-1111','����� �����','����Ʈ','��Ƽ��3��', '�������');

insert into PETMANAGER
values('15-10002', '������2', 'pass02', 'manager', '010-2222-1112','����� ������','����','ġ�Ϳ�1��', '�������');

insert into PETMANAGER
values('15-10003', '������3', 'pass03', 'manager', '010-2222-1113','����� ���۱�','����','���6����', '�������');

insert into PETMANAGER
values('15-10004', '������3', 'pass04', 'manager', '010-2222-1114','����� ������','����','���1����', '�������');

insert into PETMANAGER
values('15-10005', '������5', 'pass05', 'manager', '010-2222-1115','����� ���α�','����Ʈ','����2��', '�������');




*/
	## �Խ������̺�(�����̱� ���)�� ���� DML
	--  �Խ������̺�� :board
	--  ��ũ��Ʈ���ϸ� :board_init.sql
	-- �Խ��� �ý��� ������ ���� �ʱ�ȭ ������

## �Խ��� ��ƼƼ �м� ���̺� �� : BOARD
1. �۹�ȣ : BOARD_NUMBER    NUMBER(10)    PRIMARY KEY
2  �ڰ��� ��ȣ : C_NUMBER   VARCHAR(20) NOT NULL
3. ���� :  TITLE   VARCHAR(100)   NOT NULL
4. �Ұ��� : CONTENT   VARCHAR(100)   NOT NULL
5. ����  : PRICE String(10)   NOT NULL
6. ������ ��  : POSSIBLE_DOG_KIND  VARCHAR(10)   NOT NULL


*/


insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10001', '07.24~07.25 ���������', '�ް��� ���ܼ� ���帱�� �ֽ��ϴ�. ������ �����̶� �����ϰ� ���ϰڽ��ϴ�.'
,'������30000��','������');

insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10002','08.24 ���������', '�������� ����ϴ� �ֳ�. �پ��� ������ �������ֽ��ϴ�.'
, '������10000�� ������30000��','������');

insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10003', '08�� �Ѵ� ���������', '�����ϰ� ���� �ް� �ٳ������'
, '������20000�� ������ 30000�� ������ 50000��','������');

insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10004', '08�� 25�� 26�� ', '�ȳ��ϼ��� ���� ���빮���� ����ִ� �������Դϴ�. ������� �� 10ȸ���� �����ҽ��ϴ�. �����ּ���'
, '������10000�� ������ 30000�� ������ 50000��','������');


insert into BOARD
values(BOARD_NUMBER.NEXTVAL, '15-10005', '8�� 2°�� ���������.', '������,���ʱ� �����մϴ�. �ް��ٳ������'
, '������20000��','������');


*/
	## �������̺�(������Ī)�� ���� DML
	--  �Խ������̺�� :caring
	--  ��ũ��Ʈ���ϸ� :caring_init.sql
	-- ������Ī���̺� ������ ���� �ʱ�ȭ ������

	## �����ñ�� ��ƼƼ �м� ���̺� �� : CARING
1. ������ȣ :CARE_NUMBER    NUMBER(10)    PRIMARY KEY
2. ���ξ��̵�:  USER_ID VARCHAR(20)   NOT NULL
3. �ְ߰����� �ڰݹ�ȣ : C_NUMBER VARCHAR(20)
4.�ְߵ�Ϲ�ȣ  : DOG_NUMBER  VARCHAR(20)   NOT NULL
5.�������̸�  : DOG_NAME  VARCHAR(10)   NOT NULL
6.������ ���� :DOG_KIND VARCHAR(10) not null
7. ��  �� : DOG_AGE  NUMBER(5)   NOT NULL
8. ��  �� :  GENDER VARCHAR(5) NOT NULL
  
*/


insert into caring  
values(CARE_NUMBER.NEXTVAL,'user01','15-10001','40001','�ֳʴ�','����',3,'����');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user02','15-10002','40002','����ȣ','���޸���',2,'����');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user03','15-10003','40003','��ȭ��','�ú�����',5,'����');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user04','15-10004','40004','�����','���',6,'����');

insert into caring
values(CARE_NUMBER.NEXTVAL,'user05','15-10005','40005','���ϴ�','��Ƽ��',7,'����');