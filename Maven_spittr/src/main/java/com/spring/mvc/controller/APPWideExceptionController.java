package com.spring.mvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.mvc.web.APPWideException;

@ControllerAdvice
public class APPWideExceptionController {
	@ExceptionHandler(value=APPWideException.class)
	public String appWideExceptionHandler(){
	return "error/appError";
	}
}
