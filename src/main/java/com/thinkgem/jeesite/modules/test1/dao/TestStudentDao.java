/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test1.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test1.entity.TestStudent;

/**
 * 学生DAO接口
 * @author yangqinghua
 * @version 2016-01-03
 */
@MyBatisDao
public interface TestStudentDao extends CrudDao<TestStudent> {
	
}