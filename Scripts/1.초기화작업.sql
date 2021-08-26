-- 내 스키마
DROP SCHEMA IF EXISTS erp;

-- 내 스키마
CREATE SCHEMA erp;

-- 직책
CREATE TABLE erp.Title (
	code INT(4)      NOT NULL COMMENT '직책코드', -- 직책코드
	name VARCHAR(50) NOT NULL COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE erp.Title
	ADD CONSTRAINT PK_Title -- 직책 기본키
		PRIMARY KEY (
			code -- 직책코드
		);

-- 부서
CREATE TABLE erp.department (
	code  INT(4)      NOT NULL COMMENT '부서코드', -- 부서코드
	name  VARCHAR(50) NOT NULL COMMENT '부서명', -- 부서명
	floor INTEGER     NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE erp.department
	ADD CONSTRAINT PK_department -- 부서 기본키
		PRIMARY KEY (
			code -- 부서코드
		);

-- 사원
CREATE TABLE erp.employee (
	empno   INT(4)      NOT NULL COMMENT '사원코드', -- 사원코드
	empname VARCHAR(50) NOT NULL COMMENT '사원명', -- 사원명
	title   INT(4)      NULL     COMMENT '직책', -- 직책
	manager INT(4)      NULL     COMMENT '직속상사', -- 직속상사
	salary  INTEGER     NULL     COMMENT '급여', -- 급여
	dno     INT(4)      NULL     COMMENT '부서' -- 부서
)
COMMENT '사원';

-- 사원
ALTER TABLE erp.employee
	ADD CONSTRAINT PK_employee -- 사원 기본키
		PRIMARY KEY (
			empno -- 사원코드
		);

-- 사원
ALTER TABLE erp.employee
	ADD CONSTRAINT FK_Title_TO_employee -- 직책 -> 사원
		FOREIGN KEY (
			title -- 직책
		)
		REFERENCES erp.Title ( -- 직책
			code -- 직책코드
		);

-- 사원
ALTER TABLE erp.employee
	ADD CONSTRAINT FK_employee_TO_employee -- 사원 -> 사원
		FOREIGN KEY (
			manager -- 직속상사
		)
		REFERENCES erp.employee ( -- 사원
			empno -- 사원코드
		);

-- 사원
ALTER TABLE erp.employee
	ADD CONSTRAINT FK_department_TO_employee -- 부서 -> 사원
		FOREIGN KEY (
			dno -- 부서
		)
		REFERENCES erp.department ( -- 부서
			code -- 부서코드
		);