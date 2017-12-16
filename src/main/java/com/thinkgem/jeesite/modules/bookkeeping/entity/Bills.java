package com.thinkgem.jeesite.modules.bookkeeping.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class Bills extends DataEntity<Bills>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double money;
	private Integer direction;
	private Integer category_id_1;
	private Integer category_id_2;
	private String remark;
	private Date gmt_create;
	private Integer create_user;
	private Date gmt_modify;
	private Integer modify_user;
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public Integer getCategory_id_1() {
		return category_id_1;
	}
	public void setCategory_id_1(Integer category_id_1) {
		this.category_id_1 = category_id_1;
	}
	public Integer getCategory_id_2() {
		return category_id_2;
	}
	public void setCategory_id_2(Integer category_id_2) {
		this.category_id_2 = category_id_2;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Integer getCreate_user() {
		return create_user;
	}
	public void setCreate_user(Integer create_user) {
		this.create_user = create_user;
	}
	public Date getGmt_modify() {
		return gmt_modify;
	}
	public void setGmt_modify(Date gmt_modify) {
		this.gmt_modify = gmt_modify;
	}
	public Integer getModify_user() {
		return modify_user;
	}
	public void setModify_user(Integer modify_user) {
		this.modify_user = modify_user;
	}
	
}
