/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.base.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.zhjg.base.dao.IBaseWorkplanDao;
import com.safetys.zhjg.base.model.BaseWorkplanModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("baseWorkplanDao")
public class BaseWorkplanDaoImpl extends BaseDaoImpl<BaseWorkplanModel, Long> implements IBaseWorkplanDao {

	public BaseWorkplanDaoImpl() {
		super(BaseWorkplanModel.class, "baseWorkplanModel");
	}
}

