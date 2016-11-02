package com.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 根配置，只需要标明Configuration和ComponentScan注解即可
 * @author yan
 *
 */
@Configuration
@ComponentScan("com.spring")//扫描com.spring中所有带有Component或repository等标记的实现类，用以生成bean
@EnableAspectJAutoProxy//使AOP生效
@Import({WebAppInitializer.class,WebConfig.class})
//@ImportResource(locations={"classpath:applicationContext.xml"})
public class RootConfig {}
