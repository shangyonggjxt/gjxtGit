package com.cci.dao;

import java.util.List;

import com.cci.pojo.Station;

public interface StationDao {

	/** ******分页查询********* */

	public int getTotalPage();

	public int getCurrentPage();

	public int getTotalElements();

	public List selectStation(int pageSize, int currentPage, String sqlWhere);

	public void insertStation(Station station);

	public int queryNumByStationCode(Station station);

	public int queryNumByBasestationID(int basestation_id);

	public void delStation(Station station);

	public Station queryStationByCode(Station station);

	public void updateStation(Station station);

}
