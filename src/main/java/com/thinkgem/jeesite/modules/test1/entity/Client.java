package com.thinkgem.jeesite.modules.test1.entity;

import java.io.Serializable;

public class Client implements Serializable{
	private Integer id;				//客户编号
	private String name;			//客户姓名	
	private Integer age;			//客户年龄
	private String sex;				//客户性别
	private String address;			//客户地址
	private String phone;			//客户手机
	
	public Client() {
		super();
	}
	
	public Client(Integer id, String name, Integer age, String sex, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
}
