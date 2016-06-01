package com.cci.dao;

import java.util.List;

import com.cci.pojo.Operator;

public interface OperatorDao {

	/** ******分页查询********* */

	public int getTotalPage();

	public int getCurrentPage();

	public int getTotalElements();

	public List selectOperator(int pageSize, int currentPage, String sqlWhere);

	public void insertOperator(Operator operator);

	public int queryOperatorByOperatorCode(String operator_code);

	public void delOperator(int operator_id);

	public Operator queryOperatorById(int operator_id);

	public void updateOperator(Operator operator);


}
