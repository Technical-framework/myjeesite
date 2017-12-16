SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS bk_bills;
DROP TABLE IF EXISTS bk_category;

/* Create Tables */
-- 记账表
CREATE TABLE bk_bills
(
	-- 主键
	id int NOT NULL AUTO_INCREMENT COMMENT '主键',
	-- 金额
	money decimal(10,4) NOT NULL COMMENT '金额',
	-- 金额来源（0-支出1-收入）
	direction int DEFAULT 0 NOT NULL COMMENT '金额来源（0-支出1-收入）',
	-- 类型ID
	category_id_1 int NOT NULL COMMENT '类型ID',
	-- 子类型ID
	category_id_2 int NOT NULL COMMENT '子类型ID',
	-- 备注
	remark varchar(255) COMMENT '备注',
	-- 创建时间
	gmt_create datetime DEFAULT NOW(), SYSDATE() COMMENT '创建时间',
	-- 创建人
	create_user int NOT NULL COMMENT '创建人',
	-- 修改时间
	gmt_modify decimal COMMENT '修改时间',
	-- 修改人
	modify_user int COMMENT '修改人',
	PRIMARY KEY (id)
) COMMENT = '记账表';


-- 类型表
CREATE TABLE bk_category
(
	-- 主键
	id int NOT NULL AUTO_INCREMENT COMMENT '主键',
	-- 类型名称
	name varchar(255) COMMENT '类型名称',
	-- 父ID
	parent_id int DEFAULT 0 NOT NULL COMMENT '父ID',
	-- 支出类型（0-支出1-收入）
	type int DEFAULT 0 NOT NULL COMMENT '支出类型（0-支出1-收入）',
	-- 创建时间
	gmt_create datetime DEFAULT NOW(), SYSDATE() NOT NULL COMMENT '创建时间',
	-- 创建人
	create_user int DEFAULT 0 NOT NULL COMMENT '创建人',
	-- 修改时间
	gmt_modify datetime COMMENT '修改时间',
	-- 修改人
	modify_user int COMMENT '修改人',
	PRIMARY KEY (id)
) COMMENT = '类型表';



