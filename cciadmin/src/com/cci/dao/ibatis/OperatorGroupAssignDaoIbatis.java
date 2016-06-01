package com.cci.dao.ibatis;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.cci.dao.OperatorGroupAssignDao;
import com.cci.pojo.OperatorGroupAssign;

public class OperatorGroupAssignDaoIbatis implements OperatorGroupAssignDao {

	private SqlMapClientTemplate sqlMapClientTemplate;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public void delOperatorGroupAssign(int group_id) {
		sqlMapClientTemplate.delete("delOperatorGroupAssign", group_id);
	}

	public void delOGAByOperatorID(int operator_id) {

		sqlMapClientTemplate.delete("delOGAByOperatorID", operator_id);

	}

	public void insertOperatorGroupAssign(
			OperatorGroupAssign operatorGroupAssign) {

		sqlMapClientTemplate.insert("insertOperatorGroupAssign",
				operatorGroupAssign);

	}

	public OperatorGroupAssign queryOperatorGroupAssign(
			OperatorGroupAssign operatorGroupAssign) {
		return (OperatorGroupAssign) sqlMapClientTemplate.queryForObject(
				"queryOperatorGroupAssign", operatorGroupAssign);
	}

}
