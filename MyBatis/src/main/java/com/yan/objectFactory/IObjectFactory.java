package com.yan.objectFactory;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import com.yan.typeHandler.IStringTypeHandler;

public class IObjectFactory extends DefaultObjectFactory{
	
	private static final long serialVersionUID = -3553557167241007943L;
	private static final Logger log=Logger.getLogger(IStringTypeHandler.class.getName());
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,
			List<Object> constructorArgs) {
		log.info("使用定制工厂的create方法构建列表对象");
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public <T> T create(Class<T> type) {
		// TODO Auto-generated method stub
		log.info("使用定制工厂的create方法构建单个对象");
		return super.create(type);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		// TODO Auto-generated method stub
		return super.isCollection(type);
	}

	@Override
	protected Class<?> resolveInterface(Class<?> arg0) {
		
		return super.resolveInterface(arg0);
	}

	@Override
	public void setProperties(Properties properties) {
		log.info("定制属性："+properties);
		super.setProperties(properties);
	}

}
