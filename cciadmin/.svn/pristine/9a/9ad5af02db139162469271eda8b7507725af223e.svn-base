package com.cci.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cci.dao.BaseStationDao;
import com.cci.dao.StationDao;
import com.cci.dao.StationGroupDao;
import com.cci.pojo.BaseStation;
import com.cci.pojo.PageSize;
import com.cci.pojo.StationGroup;

public class BaseStationAction extends BaseAction {

	private BaseStationDao baseStationDao;
	private BaseStation baseStation;
	private StationGroupDao stationGroupDao;
	private StationDao stationDao;

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

	private StationGroup stationGroup;

	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object userObject = session.getAttribute("sysmUser");

		if (userObject == null) {
			return this.ERROR;
		}

		session.setAttribute("location_href",
				"baseStation.action?functionName=query");

		if (functionName != null && functionName.equals("query")) {

			if (this.baseStation == null) {
				this.baseStation = new BaseStation();
			}

			String queryStr = "1=1";
			StringBuilder stb = new StringBuilder(queryStr);

			if (!(baseStation.getBasestation_name() == null || baseStation
					.getBasestation_name().trim().equals(""))) {
				stb.append(" and basestation_name  like  '%"
						+ baseStation.getBasestation_name().trim() + "%'");
			}

			list = baseStationDao.selectBaseStation(pageSize, currentPage, stb
					.toString());

			this.currentPage = baseStationDao.getCurrentPage();
			this.totalElements = baseStationDao.getTotalElements();
			this.totalPage = baseStationDao.getTotalPage();

			return "query";

		}

		if (functionName != null && functionName.equals("update_view")) {

			baseStation = baseStationDao.queryBaseStationByID(baseStation
					.getBasestation_id());

			return "update_view";
		}

		if (functionName != null && functionName.equals("delStation")) {

			if (stationDao.queryNumByBasestationID(baseStation
					.getBasestation_id()) > 0) {
				return "operationFail";

			}

			baseStationDao.delBaseStation(baseStation.getBasestation_id());
			return "operationSuc";

		}

		if (functionName != null && functionName.equals("view")) {

			baseStation = baseStationDao.queryBaseStationByID(baseStation
					.getBasestation_id());
			return "view";

		}

		if (functionName != null && functionName.equals("update")) {

			baseStationDao.updateBaseStation(baseStation);
			return "operationSuc";

		}

		if (functionName != null && functionName.equals("preSave")) {

			if (stationGroup == null) {
				stationGroup = new StationGroup();
			}

			query(stationGroup);

			return "preSave";

		}

		if (functionName != null && functionName.equals("insert")) {

			if (stationGroup.getFirst_id() > 0) {
				baseStation.setGroup_id(stationGroup.getFirst_id());
			}

			if (stationGroup.getSecond_id() > 0) {
				baseStation.setGroup_id(stationGroup.getSecond_id());
			}

			if (stationGroup.getThird_id() > 0) {
				baseStation.setGroup_id(stationGroup.getThird_id());
			}

			if (stationGroup.getFourth_id() > 0) {
				baseStation.setGroup_id(stationGroup.getFourth_id());
			}

			baseStationDao.insertBaseStation(baseStation);

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

	public BaseStationDao getBaseStationDao() {
		return baseStationDao;
	}

	public void setBaseStationDao(BaseStationDao baseStationDao) {
		this.baseStationDao = baseStationDao;
	}

	public StationGroupDao getStationGroupDao() {
		return stationGroupDao;
	}

	public void setStationGroupDao(StationGroupDao stationGroupDao) {
		this.stationGroupDao = stationGroupDao;
	}

	public BaseStation getBaseStation() {
		return baseStation;
	}

	public void setBaseStation(BaseStation baseStation) {
		this.baseStation = baseStation;
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

	public StationGroup getStationGroup() {
		return stationGroup;
	}

	public void setStationGroup(StationGroup stationGroup) {
		this.stationGroup = stationGroup;
	}

	public StationDao getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}

}
