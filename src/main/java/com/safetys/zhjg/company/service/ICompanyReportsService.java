/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service;

import java.util.List;

import com.safetys.zhjg.company.model.CompanyReportsModel;
import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.system.model.FkUserModel;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface ICompanyReportsService extends IBaseService<CompanyReportsModel, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
	
	/**
	 * 根据起始年份和月份查询出统计结果
	 * Y:年
	 * M:月
	 * @return
	 * 
	 */
	public List<CompanyReportsModel> getByYM(String Y,String M,FkUserModel fkUserModel);
}
