package com.spring.mvc.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException{}
