package com.thinkgem.jeesite.modules.test1.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test1.entity.Client;
/**
 * 
 * 客户Dao接口
 * @author yangjiwang
 *
 */
@MyBatisDao
public interface ClientDao extends CrudDao<Client>{
	
}
