/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test1.entity.TestStudent;
import com.thinkgem.jeesite.modules.test1.dao.TestStudentDao;

/**
 * 学生Service
 * @author yangqinghua
 * @version 2016-01-03
 */
@Service
@Transactional(readOnly = true)
public class TestStudentService extends CrudService<TestStudentDao, TestStudent> {

	public TestStudent get(String id) {
		return super.get(id);
	}
	
	public List<TestStudent> findList(TestStudent testStudent) {
		return super.findList(testStudent);
	}
	
	public Page<TestStudent> findPage(Page<TestStudent> page, TestStudent testStudent) {
		return super.findPage(page, testStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(TestStudent testStudent) {
		super.save(testStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestStudent testStudent) {
		super.delete(testStudent);
	}
	
}