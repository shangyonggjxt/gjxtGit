package com.cci.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.cci.dao.BaseStationDao;
import com.cci.pojo.BaseStation;
import com.cci.pojo.PageUtil;

public class BaseStationDaoIbatis implements BaseStationDao {

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

	public List selectBaseStation(int pageSize, int currentPage, String sqlWhere) {

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
				"getBaseStationCounts", pageUtil));

		setTotalPages();

		return sqlMapClientTemplate.queryForList("selectBaseStation", pageUtil);
	}

	public void setTotalPages() {

		if (this.totalElements != 0 && (this.totalElements % pageSize == 0))

			this.totalPage = (int) (this.totalElements / this.pageSize);
		else
			this.totalPage = (int) (this.totalElements / this.pageSize + 1);
	}

	public int insertBaseStation(BaseStation baseStation) {
		return (Integer) sqlMapClientTemplate.insert("insertBaseStation",
				baseStation);
	}

	public List queryBaseStation() {
		return sqlMapClientTemplate.queryForList("queryBaseStation");
	}

	public BaseStation queryBaseStationByID(int basestation_id) {
		return (BaseStation) sqlMapClientTemplate.queryForObject(
				"queryBaseStationByID", basestation_id);
	}

	public void updateBaseStation(BaseStation baseStation) {
		sqlMapClientTemplate.update("updateBaseStation", baseStation);
	}

	public void delBaseStation(int basestation_id) {
		sqlMapClientTemplate.update("delBaseStation", basestation_id);
	}

	public int queryBaseStationByGroupId(int group_id) {

		return (Integer) sqlMapClientTemplate.queryForObject(
				"queryBaseStationByGroupId", group_id);
	}
}
