package com.cttic.service.inter;

public interface UserServiceRepo {

	void createUser(String username, String password);

	void deleteByName(String username);

}