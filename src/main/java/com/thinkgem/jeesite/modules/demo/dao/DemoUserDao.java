package com.thinkgem.jeesite.modules.demo.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.demo.entity.DemoUser;

@MyBatisDao
public interface DemoUserDao extends CrudDao<DemoUser>{
	
}
