package com.thinkgem.jeesite.modules.bookkeeping.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bookkeeping.entity.BkCategory;

@MyBatisDao
public interface BkCategoryDao extends CrudDao<BkCategory>{

}
