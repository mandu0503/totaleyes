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
