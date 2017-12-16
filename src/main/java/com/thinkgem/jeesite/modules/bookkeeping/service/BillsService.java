package com.thinkgem.jeesite.modules.bookkeeping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bookkeeping.dao.BillsDao;
import com.thinkgem.jeesite.modules.bookkeeping.entity.Bills;

@Service
@Transactional(readOnly = true)
public class BillsService extends CrudService<BillsDao,Bills>{
	
	@Autowired
	private BillsDao billsDao;

}
