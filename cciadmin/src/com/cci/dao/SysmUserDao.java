package com.cci.dao;

import java.util.List;

import com.cci.pojo.SysmUser;

public interface SysmUserDao {

	/** ******分页查询********* */

	public int getTotalPage();

	public int getCurrentPage();

	public int getTotalElements();

	public List selectSysmUser(int pageSize, int currentPage, String sqlWhere);

	public List userLogin(SysmUser sysmUser);

}
