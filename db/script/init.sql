
CREATE EXTENSION pgcrypto; 



insert into tbl_user_info(user_id, pwd, user_role, user_nm, user_email, user_cntct_no, created_tm, created_by, updated_tm, updated_by)
values ('admin', crypt('1234', gen_salt('MD5')), 'ROLE_ADMIN', '관리자','totaleyes@kdcs.co.kr', '010-0000-0000', current_timestamp, 'init', current_timestamp, 'init');

insert into tbl_user_info(user_id, pwd, user_role, user_nm, user_email, user_cntct_no, created_tm, created_by, updated_tm, updated_by)
values ('user', crypt('1234', gen_salt('MD5')), 'ROLE_USER', '사용자','totaleyes-user@kdcs.co.kr', '010-0000-0001', current_timestamp, 'init', current_timestamp, 'init');


insert into tbl_user_info(user_id, pwd, user_role, user_nm, user_email, user_cntct_no, created_tm, created_by, updated_tm, updated_by)
values ('checker', crypt('1234', gen_salt('MD5')), 'ROLE_INSPECTOR', '점검자','totaleyes-inspector@kdcs.co.kr', '010-0000-0002', current_timestamp, 'init', current_timestamp, 'init');














/***
create table user_info(
	user_id		varchar(20),
	user_pw		varchar(200) not null,
	user_nm		varchar(20),
	user_role	varchar(20),
	create_dt	date,
	create_id	varchar(20),
	modify_dt	date,
	modify_id	varchar(20),
	constraint pk_user_info primary key (
		user_id
	)
);
--drop table user_info;

select * from user_info;
insert into user_info(user_id, user_pw, user_nm, user_role, create_dt, create_id) values('user','1234','user','ROLE_USER', now(), 'test');
insert into user_info(user_id, user_pw, user_nm, user_role, create_dt, create_id) values('admin','1234','admin','ROLE_ADMIN', now(), 'test');
insert into user_info(user_id, user_pw, user_nm, user_role, create_dt, create_id) values('check','1234','check','ROLE_CHECK', now(), 'test');


CREATE SEQUENCE seq_board_info START 1;
create table board_info(
	seq			integer DEFAULT nextval('seq_board_info'),
	subject		varchar(200) not null,
	contents	text,	
	create_dt	date,
	create_id	varchar(20),
	modify_dt	date,
	modify_id	varchar(20),
	constraint pk_board_info primary key (
		seq
	)
);

INSERT INTO board_info (seq,subject,contents,create_dt,create_id) VALUES (nextval('seq_board_info'),'TEST','TESTTEST',now(),'TEST');


**/