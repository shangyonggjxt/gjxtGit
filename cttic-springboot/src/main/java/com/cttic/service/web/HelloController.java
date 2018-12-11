package com.cttic.service.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cttic.service.exception.MyException;

@RestController
public class HelloController {

	@RequestMapping("/boot")
	public String index() {
		return "spring boot";
	}

	@RequestMapping("/errorjson")
	public String errorjson() throws MyException {
		throw new MyException("获取json出现异常");
	}

}
