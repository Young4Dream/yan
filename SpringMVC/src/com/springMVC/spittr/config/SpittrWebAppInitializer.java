package com.springMVC.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{WebConfig.class};
	}
/**
 * 将一个或多个路径映射到DispatcherServlet上，此处使用“/”，表示使用默认servlet，它会处理进入应用的所有请求
 * @author Yan 16.10.29 18:29
 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
