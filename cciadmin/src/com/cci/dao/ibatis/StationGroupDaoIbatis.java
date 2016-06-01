package com.cci.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.cci.dao.StationGroupDao;
import com.cci.pojo.GroupFirst;
import com.cci.pojo.GroupFourth;
import com.cci.pojo.GroupSecond;
import com.cci.pojo.GroupThird;
import com.cci.pojo.PageUtil;
import com.cci.pojo.StationGroup;
import com.ibatis.sqlmap.client.SqlMapClient;

public class StationGroupDaoIbatis implements StationGroupDao {

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

	public List selectGroupFirst(int pageSize, int currentPage, String sqlWhere) {

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
				"getGroupFirstCounts", pageUtil));

		setTotalPages();

		return sqlMapClientTemplate.queryForList("selectGroupFirst", pageUtil);
	}

	public List selectGroupSecond(int pageSize, int currentPage, String sqlWhere) {

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
				"getGroupSecondCounts", pageUtil));

		setTotalPages();

		return sqlMapClientTemplate.queryForList("selectGroupSecond", pageUtil);
	}

	public List selectGroupThird(int pageSize, int currentPage, String sqlWhere) {

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
				"getGroupThirdCounts", pageUtil));

		setTotalPages();

		return sqlMapClientTemplate.queryForList("selectGroupThird", pageUtil);
	}

	public List selectGroupFourth(int pageSize, int currentPage, String sqlWhere) {

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
				"getGroupFourthCounts", pageUtil));

		setTotalPages();

		return sqlMapClientTemplate.queryForList("selectGroupFourth", pageUtil);
	}

	public void setTotalPages() {

		if (this.totalElements != 0 && (this.totalElements % pageSize == 0))

			this.totalPage = (int) (this.totalElements / this.pageSize);
		else
			this.totalPage = (int) (this.totalElements / this.pageSize + 1);
	}

	public void insertGroupFirst(GroupFirst groupFirst) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupFirst.getGroup_name());
			stationGroup.setDemo(groupFirst.getDemo());

			int group_id = (Integer) sqlMapClient.insert("insertStationGroup",
					stationGroup);

			groupFirst.setGroup_id(group_id);

			sqlMapClient.insert("insertGroupFirst", groupFirst);

			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void insertGroupFourth(GroupFourth groupFourth) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupFourth.getGroup_name());
			stationGroup.setDemo(groupFourth.getDemo());
			stationGroup.setParent_id(groupFourth.getThird_id());

			int group_id = (Integer) sqlMapClient.insert("insertStationGroup",
					stationGroup);

			groupFourth.setGroup_id(group_id);

			sqlMapClient.insert("insertGroupFourth", groupFourth);

			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void insertGroupSecond(GroupSecond groupSecond) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupSecond.getGroup_name());
			stationGroup.setDemo(groupSecond.getDemo());
			stationGroup.setParent_id(groupSecond.getFirst_id());

			int group_id = (Integer) sqlMapClient.insert("insertStationGroup",
					stationGroup);
			groupSecond.setGroup_id(group_id);

			sqlMapClient.insert("insertGroupSecond", groupSecond);

			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void insertGroupThird(GroupThird groupThird) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupThird.getGroup_name());
			stationGroup.setDemo(groupThird.getDemo());
			stationGroup.setParent_id(groupThird.getSecond_id());

			int group_id = (Integer) sqlMapClient.insert("insertStationGroup",
					stationGroup);
			groupThird.setGroup_id(group_id);

			sqlMapClient.insert("insertGroupThird", groupThird);

			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public List queryGroupFirst() {
		return sqlMapClientTemplate.queryForList("queryGroupFirst");
	}

	public List queryGroupFourth(StationGroup stationGroup) {
		return sqlMapClientTemplate.queryForList("queryGroupFourth",
				stationGroup);
	}

	public List queryGroupSecond(StationGroup stationGroup) {
		return sqlMapClientTemplate.queryForList("queryGroupSecond",
				stationGroup);
	}

	public List queryGroupThird(StationGroup stationGroup) {
		return sqlMapClientTemplate.queryForList("queryGroupThird",
				stationGroup);
	}

	public GroupFirst queryGroupFirstByID(int group_id) {
		return (GroupFirst) sqlMapClientTemplate.queryForObject(
				"queryGroupFirstByID", group_id);
	}

	public GroupFourth queryGroupFourthByID(int group_id) {
		return (GroupFourth) sqlMapClientTemplate.queryForObject(
				"queryGroupFourthByID", group_id);
	}

	public GroupSecond queryGroupSecondByID(int group_id) {

		return (GroupSecond) sqlMapClientTemplate.queryForObject(
				"queryGroupSecondByID", group_id);
	}

	public GroupThird queryGroupThirdByID(int group_id) {
		return (GroupThird) sqlMapClientTemplate.queryForObject(
				"queryGroupThirdByID", group_id);
	}

	public void updateGroupFirst(GroupFirst groupFirst) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupFirst.getGroup_name());
			stationGroup.setDemo(groupFirst.getDemo());
			stationGroup.setGroup_id(groupFirst.getGroup_id());

			sqlMapClient.update("updateStationGroup", stationGroup);
			sqlMapClient.update("updateGroupFirst", groupFirst);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void updateGroupFourth(GroupFourth groupFourth) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupFourth.getGroup_name());
			stationGroup.setDemo(groupFourth.getDemo());
			stationGroup.setGroup_id(groupFourth.getGroup_id());

			sqlMapClient.update("updateStationGroup", stationGroup);
			sqlMapClient.update("updateGroupFourth", groupFourth);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void updateGroupSecond(GroupSecond groupSecond) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupSecond.getGroup_name());
			stationGroup.setDemo(groupSecond.getDemo());
			stationGroup.setGroup_id(groupSecond.getGroup_id());

			sqlMapClient.update("updateStationGroup", stationGroup);
			sqlMapClient.update("updateGroupSecond", groupSecond);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void updateGroupThird(GroupThird groupThird) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			StationGroup stationGroup = new StationGroup();
			stationGroup.setGroup_name(groupThird.getGroup_name());
			stationGroup.setDemo(groupThird.getDemo());
			stationGroup.setGroup_id(groupThird.getGroup_id());

			sqlMapClient.update("updateStationGroup", stationGroup);
			sqlMapClient.update("updateGroupThird", groupThird);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public int queryStationGroupParentId(int group_id) {
		return (Integer) sqlMapClientTemplate.queryForObject(
				"queryStationGroupParentId", group_id);
	}

	public void delGroupFirst(int group_id) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			sqlMapClient.delete("delGroupFirst", group_id);
			sqlMapClient.delete("delOperatorGroupAssign", group_id);
			sqlMapClient.update("delStationGroup", group_id);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void delGroupFourth(int group_id) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			sqlMapClient.delete("delGroupFourth", group_id);
			sqlMapClient.delete("delOperatorGroupAssign", group_id);
			sqlMapClient.update("delStationGroup", group_id);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void delGroupSecond(int group_id) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			sqlMapClient.delete("delGroupSecond", group_id);
			sqlMapClient.delete("delOperatorGroupAssign", group_id);
			sqlMapClient.update("delStationGroup", group_id);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void delGroupThird(int group_id) {

		SqlMapClient sqlMapClient = sqlMapClientTemplate.getSqlMapClient();

		try {
			sqlMapClient.startTransaction();

			sqlMapClient.delete("delGroupThird", group_id);
			sqlMapClient.delete("delOperatorGroupAssign", group_id);
			sqlMapClient.update("delStationGroup", group_id);

			sqlMapClient.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List selectFirst(String sql) {
		return sqlMapClientTemplate.queryForList("selectFirst", sql);
	}

	public List selectFourth(String sql) {
		return sqlMapClientTemplate.queryForList("selectFourth", sql);
	}

	public List selectSecond(String sql) {
		return sqlMapClientTemplate.queryForList("selectSecond", sql);
	}

	public List selectThird(String sql) {
		return sqlMapClientTemplate.queryForList("selectThird", sql);
	}

}
