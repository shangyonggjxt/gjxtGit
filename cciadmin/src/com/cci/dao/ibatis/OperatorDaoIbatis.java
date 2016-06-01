package com.cci.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.cci.dao.OperatorDao;
import com.cci.pojo.Operator;
import com.cci.pojo.PageUtil;

public class OperatorDaoIbatis implements OperatorDao {

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

	public List selectOperator(int pageSize, int currentPage, String sqlWhere) {

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
				"getOperatorCounts", pageUtil));

		setTotalPages();

		return sqlMapClientTemplate.queryForList("selectOperator", pageUtil);
	}

	public void setTotalPages() {

		if (this.totalElements != 0 && (this.totalElements % pageSize == 0))

			this.totalPage = (int) (this.totalElements / this.pageSize);
		else
			this.totalPage = (int) (this.totalElements / this.pageSize + 1);
	}

	public void insertOperator(Operator operator) {
		sqlMapClientTemplate.insert("insertOperator", operator);
	}

	public int queryOperatorByOperatorCode(String operator_code) {
		return (Integer) sqlMapClientTemplate.queryForObject(
				"queryOperatorByOperatorCode", operator_code);
	}

	public void delOperator(int operator_id) {
		sqlMapClientTemplate.update("delOperator", operator_id);
	}

	public Operator queryOperatorById(int operator_id) {
		return (Operator) sqlMapClientTemplate.queryForObject(
				"queryOperatorById", operator_id);
	}

	public void updateOperator(Operator operator) {
		sqlMapClientTemplate.update("updateOperator", operator);

	}

	
	
}
