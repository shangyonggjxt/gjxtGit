package com.cci.dao;

import java.util.List;

import com.cci.pojo.GroupFirst;
import com.cci.pojo.GroupFourth;
import com.cci.pojo.GroupSecond;
import com.cci.pojo.GroupThird;
import com.cci.pojo.StationGroup;

public interface StationGroupDao {

	/** ******分页查询********* */

	public int getTotalPage();

	public int getCurrentPage();

	public int getTotalElements();

	public List selectGroupFirst(int pageSize, int currentPage, String sqlWhere);

	public List selectGroupSecond(int pageSize, int currentPage, String sqlWhere);

	public List selectGroupThird(int pageSize, int currentPage, String sqlWhere);

	public List selectGroupFourth(int pageSize, int currentPage, String sqlWhere);

	public void insertGroupFirst(GroupFirst groupFirst);

	public void insertGroupSecond(GroupSecond groupSecond);

	public void insertGroupThird(GroupThird groupThird);

	public void insertGroupFourth(GroupFourth groupFourth);

	public List queryGroupFirst();

	public List queryGroupSecond(StationGroup stationGroup);

	public List queryGroupThird(StationGroup stationGroup);

	public List queryGroupFourth(StationGroup stationGroup);

	public GroupFirst queryGroupFirstByID(int group_id);

	public GroupSecond queryGroupSecondByID(int group_id);

	public GroupThird queryGroupThirdByID(int group_id);

	public GroupFourth queryGroupFourthByID(int group_id);

	public void updateGroupFirst(GroupFirst groupFirst);

	public void updateGroupSecond(GroupSecond groupSecond);

	public void updateGroupThird(GroupThird groupThird);

	public void updateGroupFourth(GroupFourth groupFourth);

	public int queryStationGroupParentId(int group_id);

	public void delGroupFirst(int group_id);

	public void delGroupSecond(int group_id);

	public void delGroupThird(int group_id);

	public void delGroupFourth(int group_id);

	public List selectFirst(String sql);

	public List selectSecond(String sql);

	public List selectThird(String sql);

	public List selectFourth(String sql);

}
