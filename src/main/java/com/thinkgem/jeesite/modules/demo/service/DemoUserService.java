package com.thinkgem.jeesite.modules.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.demo.dao.DemoUserDao;
import com.thinkgem.jeesite.modules.demo.entity.DemoUser;

@Service
@Transactional(readOnly = true)
public class DemoUserService extends CrudService<DemoUserDao,DemoUser> {
	
	@Autowired
	private DemoUserDao demoUserDao;
}
