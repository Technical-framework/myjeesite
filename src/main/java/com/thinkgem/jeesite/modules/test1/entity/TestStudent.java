/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test1.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生Entity
 * @author yangqinghua
 * @version 2016-01-03
 */
public class TestStudent extends DataEntity<TestStudent> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private Long age;		// 年龄
	private Long sex;		// 性别
	private String introduce;		// 自我介绍
	private Long classId;		// 班级
	private Long dutiesId;		// 职务
	private String remark;		// 备注
	
	public TestStudent() {
		super();
	}

	public TestStudent(String id){
		super(id);
	}

	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	
	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=255, message="自我介绍长度必须介于 0 和 255 之间")
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}
	
	public Long getDutiesId() {
		return dutiesId;
	}

	public void setDutiesId(Long dutiesId) {
		this.dutiesId = dutiesId;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}