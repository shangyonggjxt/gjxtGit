package com.cttic.service.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cttic.service.domain.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "users")
public class UserController {

	static Map<Integer, User> Users = Collections.synchronizedMap(new HashMap<Integer, User>());

	@ApiOperation(value = "获取用户列表")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> user = new ArrayList<User>(Users.values());
		return user;
	}

	@ApiOperation(value = "创建用户")
	@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addUsers(@ModelAttribute User user) {
		Users.put(user.getId(), user);
		return Users.size() + "";
	}

	@ApiOperation(value = "根据id获取用户信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Integer id) {
		return Users.get(id);
	}

	@ApiOperation(value = "根据id更新用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path"),
			@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable Integer id, @ModelAttribute User s) {
		User user = Users.get(id);
		user.setName(s.getName());
		user.setAge(s.getAge());
		Users.put(id, user);
		return "success";
	}

	@ApiOperation(value = "根据id删除用户信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer id) {
		Users.remove(id);
		return "success";
	}

}