package com.thinkgem.jeesite.modules.bookkeeping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bookkeeping.dao.BkCategoryDao;
import com.thinkgem.jeesite.modules.bookkeeping.entity.BkCategory;

@Service
@Transactional(readOnly = true)
public class BkCategoryService extends CrudService<BkCategoryDao,BkCategory>{
	
	@Autowired
	private BkCategoryDao bkCategoryDao;

}
