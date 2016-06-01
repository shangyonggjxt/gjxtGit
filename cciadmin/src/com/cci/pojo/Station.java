package com.cci.pojo;

public class Station {

	private String station_name;
	private String station_code;
	private int station_type;
	private int del_flag;
	private String demo;
	private int basestation_id;
	private String basestation_name;
	private String IP;
	private String server_ip;
	private int server_port;

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getStation_code() {
		return station_code.trim();
	}

	public void setStation_code(String station_code) {
		this.station_code = station_code.trim();
	}

	public int getStation_type() {
		return station_type;
	}

	public void setStation_type(int station_type) {
		this.station_type = station_type;
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

	public int getBasestation_id() {
		return basestation_id;
	}

	public void setBasestation_id(int basestation_id) {
		this.basestation_id = basestation_id;
	}

	public String getBasestation_name() {
		return basestation_name;
	}

	public void setBasestation_name(String basestation_name) {
		this.basestation_name = basestation_name;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String ip) {
		IP = ip;
	}

	public String getServer_ip() {
		return server_ip;
	}

	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}

	public int getServer_port() {
		return server_port;
	}

	public void setServer_port(int server_port) {
		this.server_port = server_port;
	}

}
