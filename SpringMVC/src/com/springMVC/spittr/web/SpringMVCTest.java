package com.springMVC.spittr.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
public class SpringMVCTest {

	@Test
	public void test() throws Exception {
		HomeController homeController=new HomeController();
		MockMvc mockMvc=standaloneSetup(homeController).build();
		mockMvc.perform(get("/"))//对"/"执行get请求
				.andExpect(view().name("home"));//断言视图名为home
	}

}
