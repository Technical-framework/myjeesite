SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS demo_user;




/* Create Tables */

CREATE TABLE demo_user
(
	-- 用户编号
	id int NOT NULL AUTO_INCREMENT COMMENT '用户编号',
	-- 用户姓名
	name varchar(255) NOT NULL COMMENT '用户姓名',
	-- 用户年龄
	age int NOT NULL COMMENT '用户年龄',
	-- 用户性别
	sex tinyint NOT NULL COMMENT '用户性别',
	-- 用户手机
	phone varchar(255) NOT NULL COMMENT '用户手机',
	-- 用户住址
	address varchar(255) NOT NULL COMMENT '用户住址',
	PRIMARY KEY (id)
);



