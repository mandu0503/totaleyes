

-- totaleyes
CREATE SCHEMA "totaleyes";

-- 사용자_정보
DROP TABLE IF EXISTS "totaleyes"."tbl_user_info";

-- 회사_정보
DROP TABLE IF EXISTS "totaleyes"."tbl_biz_info";


-- 사용자_정보
CREATE TABLE "totaleyes"."tbl_user_info"
(
	"user_id"       VARCHAR(128) NOT NULL, -- 사용자_아이디
	"pwd"           VARCHAR(256) NOT NULL, -- 비밀번호
	"user_nm"       VARCHAR(128) NOT NULL, -- 사용자_명
	"user_email"    VARCHAR(128) NOT NULL, -- 사용자_이메일
	"user_cntct_no" VARCHAR(32)  NOT NULL, -- 사용자_연락처_번호
	"user_role"     VARCHAR(32)  NOT NULL, -- 사용자_권한
	"biz_seq"       INT4         NULL,     -- 회사_일련번호
	"mstr_yn"       VARCHAR(1)   NULL     DEFAULT 'N', -- 대표_여부
	"del_yn"        VARCHAR(1)   NULL     DEFAULT 'N', -- 삭제_여부
	"apprvl_yn"     VARCHAR(1)   NULL     DEFAULT 'N', -- 승인_여부
	"apprvl_tm"     TIMESTAMP    NULL,     -- 승인_시간
	"created_tm"    TIMESTAMP    NULL,     -- 생성_시간
	"created_by"    VARCHAR(128) NULL,     -- 생성자
	"updated_tm"    TIMESTAMP    NULL,     -- 수정_시간
	"updated_by"    VARCHAR(128) NULL      -- 수정자
);

-- 사용자_정보 기본키
CREATE UNIQUE INDEX "PK_tbl_user_info"
	ON "totaleyes"."tbl_user_info"
	( -- 사용자_정보
		"user_id" ASC -- 사용자_아이디
	)
;
-- 사용자_정보
ALTER TABLE "totaleyes"."tbl_user_info"
	ADD CONSTRAINT "PK_tbl_user_info"
		 -- 사용자_정보 기본키
	PRIMARY KEY 
	USING INDEX "PK_tbl_user_info";

-- 회사_정보
CREATE TABLE "totaleyes"."tbl_biz_info"
(
	"biz_seq"       SERIAL       NOT NULL, -- 회사_일련번호
	"biz_nm"        VARCHAR(128) NULL,     -- 회사_명
	"biz_no"        VARCHAR(10)  NULL,     -- 사업자_번호
	"ceo_nm"        VARCHAR(128) NULL,     -- 대표자_명
	"biz_cndt"      VARCHAR(128) NULL,     -- 업태
	"biz_type"      VARCHAR(128) NULL,     -- 업종
	"agnt_nm"       VARCHAR(128) NULL,     -- 담당자_명
	"agnt_email"    VARCHAR(128) NULL,     -- 담당자_이메일
	"agnt_cntct_no" VARCHAR(32)  NULL,     -- 담당자_연락처_번호
	"del_yn"        VARCHAR(1)   NULL     DEFAULT 'N', -- 삭제_여부
	"apprvl_yn"     VARCHAR(1)   NULL     DEFAULT 'N', -- 승인_여부
	"apprvl_tm"     TIMESTAMP    NULL,     -- 승인_시간
	"created_tm"    TIMESTAMP    NULL,     -- 생성_시간
	"created_by"    VARCHAR(128) NULL,     -- 생성자
	"updated_tm"    TIMESTAMP    NULL,     -- 수정_시간
	"updated_by"    VARCHAR(128) NULL      -- 수정자
);

-- 회사_정보 유니크 인덱스
CREATE UNIQUE INDEX "UK_tbl_biz_info"
	ON "totaleyes"."tbl_biz_info"
	( -- 회사_정보
		"biz_no" ASC -- 사업자_번호
	);

-- 회사_정보 기본키
CREATE UNIQUE INDEX "PK_tbl_biz_info"
	ON "totaleyes"."tbl_biz_info"
	( -- 회사_정보
		"biz_seq" ASC -- 회사_일련번호
	)
;
-- 회사_정보
ALTER TABLE "totaleyes"."tbl_biz_info"
	ADD CONSTRAINT "PK_tbl_biz_info"
		 -- 회사_정보 기본키
	PRIMARY KEY 
	USING INDEX "PK_tbl_biz_info";

-- 회사_정보
ALTER TABLE "totaleyes"."tbl_biz_info"
	ADD CONSTRAINT "UK_tbl_biz_info" -- 회사_정보 유니크 제약
	UNIQUE 
	USING INDEX "UK_tbl_biz_info";

-- 사용자_정보
ALTER TABLE "totaleyes"."tbl_user_info"
	ADD CONSTRAINT "FK_tbl_biz_info_TO_tbl_user_info"
	 -- 회사_정보 -> 사용자_정보
		FOREIGN KEY (
			"biz_seq" -- 회사_일련번호
		)
		REFERENCES "totaleyes"."tbl_biz_info" ( -- 회사_정보
			"biz_seq" -- 회사_일련번호
		);