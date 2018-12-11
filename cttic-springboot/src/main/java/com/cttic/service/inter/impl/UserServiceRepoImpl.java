package com.cttic.service.inter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cttic.service.inter.UserServiceRepo;

@Service
public class UserServiceRepoImpl implements UserServiceRepo {

	// @Autowired
	// private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate2;

	@Override
	public void createUser(String username, String password) {
		// TODO Auto-generated method stub
		jdbcTemplate1.update("insert  into user (username,password) values(?,?)", username, password);

	}

	@Override
	public void deleteByName(String username) {
		// TODO Auto-generated method stub

		jdbcTemplate2.update("delete  from  user where  username=?", username);

	}

}
