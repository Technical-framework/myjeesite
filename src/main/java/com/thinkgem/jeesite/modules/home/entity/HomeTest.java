package com.thinkgem.jeesite.modules.home.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class HomeTest  extends DataEntity<HomeTest> {
	
	private static final long serialVersionUID = 2562180743106546735L;
	
	private String name;
	private Integer age;
	private int sex;
	private String remark;
	
	@Length(min=1, max=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
