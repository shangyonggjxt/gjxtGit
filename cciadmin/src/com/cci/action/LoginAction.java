package com.cci.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.cci.dao.SysmUserDao;
import com.cci.pojo.SysmUser;

public class LoginAction extends BaseAction {

	private SysmUser sysmUser;
	private SysmUserDao sysmUserDao;
	private String location_href;
	private BASE64Decoder decoder = new BASE64Decoder();

	public String execute() throws Exception {

		if (sysmUser == null) {
			return this.ERROR;
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 30);

		if (session != null) {

			if (session.getAttribute("location_href") != null) {
				location_href = (String) session.getAttribute("location_href");
			} else {
				location_href = "";
			}
		}

		sysmUser.setUsername(new String(decoder.decodeBuffer(sysmUser
				.getUsername().trim())));
		sysmUser.setPassword(new String(decoder.decodeBuffer(sysmUser
				.getPassword().trim())));

		List userList = sysmUserDao.userLogin(sysmUser);

		if (userList.size() > 0) {

			SysmUser sysmUser = (SysmUser) userList.get(0);

			session.setAttribute("sysmUser", (SysmUser) userList.get(0));

			return this.SUCCESS;
		} else {
			return this.ERROR;
		}

	}

	public SysmUser getSysmUser() {
		return sysmUser;
	}

	public void setSysmUser(SysmUser sysmUser) {
		this.sysmUser = sysmUser;
	}

	public SysmUserDao getSysmUserDao() {
		return sysmUserDao;
	}

	public void setSysmUserDao(SysmUserDao sysmUserDao) {
		this.sysmUserDao = sysmUserDao;
	}

	public String getLocation_href() {
		return location_href;
	}

	public void setLocation_href(String location_href) {
		this.location_href = location_href;
	}

}
