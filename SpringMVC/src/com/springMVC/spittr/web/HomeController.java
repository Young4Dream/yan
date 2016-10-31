package com.springMVC.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 声明为一个控制器
 */
@Controller
@RequestMapping("/")
public class HomeController {

	/**
	 * 处理对“/”的GET请求，并且定义视图名
	 */
	@RequestMapping(method=GET)
	public String home(){
		return "home";
	}
}
