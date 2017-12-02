SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS T_ADDRESS;
DROP TABLE IF EXISTS T_APPUSER;
DROP TABLE IF EXISTS T_BOOKCATEGORY;
DROP TABLE IF EXISTS T_BOOKCHAPTER;
DROP TABLE IF EXISTS T_BOOKFILTER;
DROP TABLE IF EXISTS T_BOOKLIST;
DROP TABLE IF EXISTS T_BOOKORDER;




/* Create Tables */

-- 收货地址表
CREATE TABLE T_ADDRESS
(
	id varchar(64) NOT NULL,
	arss_name varchar(30),
	arss_tell varchar(20),
	arss_address varchar(200),
	user_id varchar(64),
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '收货地址表';


-- app用户
CREATE TABLE T_APPUSER
(
	id varchar(64) NOT NULL,
	user_openId varchar(255),
	user_type varchar(255),
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = 'app用户';


-- 书本类别
CREATE TABLE T_BOOKCATEGORY
(
	id varchar(64) NOT NULL,
	cate_title varchar(255),
	cate_image varchar(255),
	cate_digest varchar(255),
	filter_id varchar(64),
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '书本类别';


-- 书本章节
CREATE TABLE T_BOOKCHAPTER
(
	id varchar(64) NOT NULL,
	chapter_image varchar(500),
	chapter_voice varchar(500),
	chapter_type int(50),
	booklist_id varchar(500),
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '书本章节';


-- 书本分类表
CREATE TABLE T_BOOKFILTER
(
	id varchar(64) NOT NULL,
	cate_name varchar(50),
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '书本分类表';


-- 书本列表
CREATE TABLE T_BOOKLIST
(
	id varchar(64) NOT NULL,
	lis_title varbinary(255),
	lis_image varchar(255),
	lis_digest varchar(255),
	lis_publish varchar(255),
	category_id varchar(64),
	lis_detail varchar(500),
	lis_money decimal,
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '书本列表';


-- 订单表
CREATE TABLE T_BOOKORDER
(
	id varchar(64) NOT NULL,
	order_title varchar(255),
	order_amount int,
	order_money decimal,
	order_message varchar(500),
	order_payState int,
	book_id varchar(64),
	address_id varchar(64),
	user_id varchar(64),
	-- 创建者
	create_by varchar(64) NOT NULL COMMENT '创建者',
	-- 创建时间
	create_date datetime NOT NULL COMMENT '创建时间',
	-- 更新者
	update_by varchar(64) NOT NULL COMMENT '更新者',
	-- 更新时间
	update_date datetime NOT NULL COMMENT '更新时间',
	-- 备注信息
	remarks varchar(255) COMMENT '备注信息',
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '订单表';



