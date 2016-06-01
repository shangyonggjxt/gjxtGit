package com.cci.pojo;

public class BaseStation {

	private int basestation_id;
	private int group_id;
	private String basestation_name;
	private String lng;
	private String lat;
	private String address;
	private String department;
	private int del_flag;
	private String demo;

	private String group_name;

	public int getBasestation_id() {
		return basestation_id;
	}

	public void setBasestation_id(int basestation_id) {
		this.basestation_id = basestation_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getBasestation_name() {
		return basestation_name;
	}

	public void setBasestation_name(String basestation_name) {
		this.basestation_name = basestation_name;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

}
