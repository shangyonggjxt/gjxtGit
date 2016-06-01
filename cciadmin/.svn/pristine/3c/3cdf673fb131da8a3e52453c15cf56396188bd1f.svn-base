package com.cci.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.cci.dao.SysmUserDao;
import com.cci.pojo.PageUtil;
import com.cci.pojo.SysmUser;

public class SysmUserDaoIbatis implements SysmUserDao {

	private SqlMapClientTemplate sqlMapClientTemplate;

	private int currentPage;
	private int totalPage;
	private int totalElements;
	private int pageSize;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List selectSysmUser(int pageSize, int currentPage, String sqlWhere) {

		this.currentPage = currentPage;
		this.pageSize = pageSize;
		int beginElement = (currentPage - 1) * pageSize;
		int endElement = currentPage * pageSize;

		PageUtil pageUtil = new PageUtil();

		pageUtil.setBeginElement(beginElement);
		pageUtil.setEndElement(endElement);
		pageUtil.setPageSize(pageSize);
		pageUtil.setSqlWhere(sqlWhere);

		totalElements = (Integer) (sqlMapClientTemplate.queryForObject(
				"getSysmUserCounts", pageUtil));

		setTotalPages();

		return sqlMapClientTemplate.queryForList("selectSysmUser", pageUtil);
	}

	public void setTotalPages() {

		if (this.totalElements != 0 && (this.totalElements % pageSize == 0))

			this.totalPage = (int) (this.totalElements / this.pageSize);
		else
			this.totalPage = (int) (this.totalElements / this.pageSize + 1);
	}

	public List userLogin(SysmUser sysmUser) {
		return sqlMapClientTemplate.queryForList("querySysmUser", sysmUser);
	}

}
