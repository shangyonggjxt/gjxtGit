package com.cci.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cci.dao.OperatorDao;
import com.cci.dao.OperatorGroupAssignDao;
import com.cci.dao.StationGroupDao;
import com.cci.pojo.Operator;
import com.cci.pojo.OperatorGroupAssign;
import com.cci.pojo.PageSize;
import com.cci.pojo.StationGroup;

public class OperatorAction extends BaseAction {

	private Operator operator;
	private StationGroup stationGroup;
	private OperatorDao operatorDao;
	private StationGroupDao stationGroupDao;
	private OperatorGroupAssignDao operatorGroupAssignDao;
	private String functionName;

	private int pageSize = PageSize.pageSize;
	private int currentPage = 1;
	private int totalPage;
	private int totalElements;

	private List list;

	private List firstList = new ArrayList();
	private List secondList = new ArrayList();
	private List thirdList = new ArrayList();
	private List fourthList = new ArrayList();

	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object userObject = session.getAttribute("sysmUser");

		if (userObject == null) {
			return this.ERROR;
		}

		session.setAttribute("location_href",
				"operator.action?functionName=query");

		if (functionName != null && functionName.equals("view")) {

			operator = operatorDao.queryOperatorById(operator.getOperator_id());

			return "view";

		}

		if (functionName != null && functionName.equals("update_view")) {
			operator = operatorDao.queryOperatorById(operator.getOperator_id());
			return "update_view";
		}

		if (functionName != null && functionName.equals("update")) {

			operator.setDel_flag(0);
			operatorDao.updateOperator(operator);

			return "operationSuc";
		}

		if (functionName != null && functionName.equals("delOperator")) {
			operatorDao.delOperator(operator.getOperator_id());
			return "operationSuc";
		}

		if (functionName != null && functionName.equals("preSave")) {
			return "preSave";
		}

		if (functionName != null && functionName.equals("save")) {

			int num = operatorDao.queryOperatorByOperatorCode(operator
					.getOperator_code());

			if (num != 0) {
				this.addFieldError("operator", operator.getOperator_code()
						+ ":账号已经存在了!!!");
				return this.INPUT;
			}

			operator.setDel_flag(0);
			operatorDao.insertOperator(operator);

			return "operationSuc";

		}

		if (functionName != null && functionName.equals("query")) {

			if (this.operator == null) {
				this.operator = new Operator();
			}

			String queryStr = "1=1";
			StringBuilder stb = new StringBuilder(queryStr);

			if (!(operator.getOperator_code() == null || operator
					.getOperator_code().trim().equals(""))) {
				stb.append(" and operator_code  like  '%"
						+ operator.getOperator_code().trim() + "%'");
			}

			list = operatorDao.selectOperator(pageSize, currentPage, stb
					.toString());
			this.currentPage = operatorDao.getCurrentPage();
			this.totalElements = operatorDao.getTotalElements();
			this.totalPage = operatorDao.getTotalPage();

			return "query";

		}

		if (functionName != null && functionName.equals("preAuth")) {

			if (stationGroup == null) {
				stationGroup = new StationGroup();
			}

			query(stationGroup);

			operator = operatorDao.queryOperatorById(operator.getOperator_id());

			return "preAuth";

		}

		if (functionName != null && functionName.equals("cancelAuth")) {

			operatorGroupAssignDao
					.delOGAByOperatorID(operator.getOperator_id());

			if (stationGroup == null) {
				stationGroup = new StationGroup();
			}

			query(stationGroup);

			operator = operatorDao.queryOperatorById(operator.getOperator_id());

			this.addFieldError("cancelAuth", "已经清空赋权!!!");

			return "preAuth";

		}

		if (functionName != null && functionName.equals("saveAuth")) {

			OperatorGroupAssign operatorGroupAssign = new OperatorGroupAssign();

			operatorGroupAssign.setOperator_id(operator.getOperator_id());

			String sql = "1=1";
			StringBuilder stbFirst = new StringBuilder(sql);
			StringBuilder stbSecond = new StringBuilder(sql);
			StringBuilder stbThird = new StringBuilder(sql);
			StringBuilder stbFourth = new StringBuilder(sql);

			int first_id = stationGroup.getFirst_id();
			int second_id = stationGroup.getSecond_id();
			int third_id = stationGroup.getThird_id();
			int fourth_id = stationGroup.getFourth_id();

			if (first_id > 0) {
				stbFirst.append(" and group_id=" + first_id);
				stbSecond.append(" and first_id=" + first_id);
				stbThird.append(" and first_id=" + first_id);
				stbFourth.append(" and first_id=" + first_id);
			}

			if (second_id > 0) {
				stbSecond.append(" and group_id=" + second_id);
				stbThird.append(" and second_id=" + second_id);
				stbFourth.append(" and second_id=" + second_id);
			}

			if (third_id > 0) {
				stbThird.append(" and group_id=" + third_id);
				stbFourth.append(" and third_id=" + third_id);
			}

			if (fourth_id > 0) {
				stbFourth.append(" and group_id=" + fourth_id);
			}

			List queryFirst = stationGroupDao.selectFirst(stbFirst.toString());
			List querySecond = stationGroupDao.selectSecond(stbSecond
					.toString());
			List queryThird = stationGroupDao.selectThird(stbThird.toString());
			List queryFourth = stationGroupDao.selectFourth(stbFourth
					.toString());

			for (int i = 0; i < queryFirst.size(); i++) {
				StationGroup stationGroup = (StationGroup) queryFirst.get(i);
				operatorGroupAssign.setGroup_id(stationGroup.getGroup_id());

				if (operatorGroupAssignDao
						.queryOperatorGroupAssign(operatorGroupAssign) == null) {

					operatorGroupAssignDao
							.insertOperatorGroupAssign(operatorGroupAssign);
				}
			}

			for (int i = 0; i < querySecond.size(); i++) {
				StationGroup stationGroup = (StationGroup) querySecond.get(i);
				operatorGroupAssign.setGroup_id(stationGroup.getGroup_id());

				if (operatorGroupAssignDao
						.queryOperatorGroupAssign(operatorGroupAssign) == null) {

					operatorGroupAssignDao
							.insertOperatorGroupAssign(operatorGroupAssign);
				}
			}

			for (int i = 0; i < queryThird.size(); i++) {
				StationGroup stationGroup = (StationGroup) queryThird.get(i);
				operatorGroupAssign.setGroup_id(stationGroup.getGroup_id());

				if (operatorGroupAssignDao
						.queryOperatorGroupAssign(operatorGroupAssign) == null) {

					operatorGroupAssignDao
							.insertOperatorGroupAssign(operatorGroupAssign);
				}
			}

			for (int i = 0; i < queryFourth.size(); i++) {
				StationGroup stationGroup = (StationGroup) queryFourth.get(i);
				operatorGroupAssign.setGroup_id(stationGroup.getGroup_id());

				if (operatorGroupAssignDao
						.queryOperatorGroupAssign(operatorGroupAssign) == null) {

					operatorGroupAssignDao
							.insertOperatorGroupAssign(operatorGroupAssign);
				}
			}

			return "operationSuc";
		}

		return super.execute();
	}

	private void query(StationGroup stationGroup) {

		firstList = stationGroupDao.queryGroupFirst();
		secondList = stationGroupDao.queryGroupSecond(stationGroup);
		thirdList = stationGroupDao.queryGroupThird(stationGroup);
		fourthList = stationGroupDao.queryGroupFourth(stationGroup);

	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public OperatorDao getOperatorDao() {
		return operatorDao;
	}

	public void setOperatorDao(OperatorDao operatorDao) {
		this.operatorDao = operatorDao;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List getFirstList() {
		return firstList;
	}

	public void setFirstList(List firstList) {
		this.firstList = firstList;
	}

	public List getSecondList() {
		return secondList;
	}

	public void setSecondList(List secondList) {
		this.secondList = secondList;
	}

	public List getThirdList() {
		return thirdList;
	}

	public void setThirdList(List thirdList) {
		this.thirdList = thirdList;
	}

	public List getFourthList() {
		return fourthList;
	}

	public void setFourthList(List fourthList) {
		this.fourthList = fourthList;
	}

	public StationGroupDao getStationGroupDao() {
		return stationGroupDao;
	}

	public void setStationGroupDao(StationGroupDao stationGroupDao) {
		this.stationGroupDao = stationGroupDao;
	}

	public StationGroup getStationGroup() {
		return stationGroup;
	}

	public void setStationGroup(StationGroup stationGroup) {
		this.stationGroup = stationGroup;
	}

	public OperatorGroupAssignDao getOperatorGroupAssignDao() {
		return operatorGroupAssignDao;
	}

	public void setOperatorGroupAssignDao(
			OperatorGroupAssignDao operatorGroupAssignDao) {
		this.operatorGroupAssignDao = operatorGroupAssignDao;
	}

}
