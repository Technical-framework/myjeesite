package com.thinkgem.jeesite.modules.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.home.dao.HomeTestDao;
import com.thinkgem.jeesite.modules.home.entity.HomeTest;

@Service
@Transactional(readOnly = true)
public class HomeTestService extends CrudService<HomeTestDao,HomeTest>{

	@Autowired
	private HomeTestDao homTestDao;
	
	
}
