package com.cttic.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cttic.service.domain.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = MyException.class)
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) {

		ErrorInfo<String> errorInfo = new ErrorInfo<>();
		errorInfo.setMessage(e.getMessage());
		errorInfo.setCode(ErrorInfo.ERROR);
		errorInfo.setData("show error information");
		errorInfo.setUrl(req.getRequestURL().toString());
		return errorInfo;
	}

}
