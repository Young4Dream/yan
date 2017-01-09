package com.tstar.util;

/**
 * Author: zhumengfeng
 * Description:
 * 	Bean装载工具类
 */
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tstar.ocs.model.Cdr;

public class BeanHelper {
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * List<T> getList<Class<T> clazz, ResultSet rs)
	 * @param <T>
	 * @param clazz 要封装的JavaBean
	 * @param rs 记录集
	 * @throws Exception
	 * @return 
	 * description: 将记录集逐行封装成JavaBean，添加进列表并返回
	 * restrict: T符合POJO，属性名称与记录集字段名称严格匹配
	 */
	public static <T> List<T> getList(Class<T> clazz, ResultSet rs) throws Exception {
		Field field = null;
		List<T> lst = new ArrayList<T>();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		String[] colNames = new String[colCount];
		for (int i = 0; i < colCount; i++) {
			colNames[i] = rsmd.getColumnName(i + 1);
		}
		while (rs.next()) {
			T t = clazz.newInstance();
			for (int i = 0; i < colCount; i++) {
				// 获取字段值
				Object value = rs.getObject(colNames[i]);
				// 获取字段类型
				Class<?> dbType = value.getClass();
				// 获取Bean属性
				field = clazz.getDeclaredField(colNames[i]);
				// 获取Bean属性类型
				Class<?> beanType = field.getClass();
				// 字段类型和Bean属性类型不匹配，抛出异常
				if (dbType != beanType) {
					throw new RuntimeException(dbType.getName() + " cannot be resolved to " + beanType.getName());
				}
				// 调用Bean类的setter方法
				PropertyDescriptor pd = new PropertyDescriptor(colNames[i], clazz);
				Method m = pd.getWriteMethod();
				m.setAccessible(true);
				m.invoke(t, value);
			}
			lst.add(t);
		}
		return lst;
	}
	
	public static <T> void bean2map(T obj, Map<String, Object> map) throws Exception {
		Class<?> clazz = obj.getClass();
		BeanInfo bi = Introspector.getBeanInfo(clazz);
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			if (!pd.getPropertyType().isArray()) {
				String name = pd.getName();
				if (map.get(name) == null) {
					Object value = pd.getReadMethod().invoke(obj, null);
					map.put(name, value);
				}
			}
		}
	}
	
	public static <T> void setProperties(T obj, Map<String, String> map) throws Exception {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			Class<?> propType = field.getType();
			String fieldName = field.getName();
			String value = map.get(fieldName);
			if (value == null) continue;
			Object parm = str2object(propType, value);
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
			Method m = pd.getWriteMethod();
			m.setAccessible(true);
			m.invoke(obj, parm);
		}
	}
	
	/**
	 * 设置POJO对象的属性值
	 * @param <T> POJO对象类
	 * @param obj POJO对象
	 * @param name 属性名称
	 * @param value 属性值，字符串型，自动转换为属性类型
	 */
	public static <T> void setProperty(T obj, String name, Object value) throws Exception {
		PropertyDescriptor pd = new PropertyDescriptor(name, obj.getClass());
		Method m = pd.getWriteMethod();
		m.setAccessible(true);
		m.invoke(obj, value);
	}
	
	/**
	 * 设置POJO对象的属性值
	 * @param <T> POJO对象类
	 * @param obj POJO对象
	 * @param name 属性名称
	 * @param value 属性值，字符串型，自动转换为属性类型
	 */
	public static <T> void setPropertyFromStr(T obj, String name, String value) throws Exception {
		Class<?> clazz = obj.getClass();
		PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
		Method m = pd.getWriteMethod();
		// 获取数据类型
		Class<?> propType = clazz.getDeclaredField(name).getType();
		// 类型转换
		Object parm = str2object(propType, value);
		m.setAccessible(true);
		m.invoke(obj, parm);
	}
	
	/**
	 * 将字符串转换成指定类型
	 * @param <T>
	 * @param type
	 * @param s
	 * @return
	 */
	public static final <T> T str2object(Class<T> type, String s) {
		Object res = null;
		if (type == String.class)
			res = s;
		else if (type == int.class || type == Integer.class) 
			res = Integer.parseInt(s);
		else if (type == short.class || type == Short.class)
			res = Short.parseShort(s);
		else if (type == long.class || type == Long.class)
			res = Long.parseLong(s);
		else if (type == byte.class || type == Byte.class)
			res = Byte.parseByte(s);
		else if (type == float.class || type == Float.class)
			res = Float.parseFloat(s);
		else if (type == double.class || type == Double.class)
			res = Double.parseDouble(s);
		else if (type == BigDecimal.class)
			res = new BigDecimal(s);
		else if (type == boolean.class || type == Boolean.class)
			res = Boolean.parseBoolean(s);
		else if (Date.class.isAssignableFrom(type)) {
			// str2date
			try { res = sdf2.parse(s); } 
			catch (Exception e) {
				try { res = sdf1.parse(s); } catch (Exception e1) {}
			}
		} else 
			throw new IllegalArgumentException(String.format("invalid data type: '%s'", type));
		return (T)res;
	}
	
	public static void main(String[] args) throws Exception {
		Cdr cdr = new Cdr();
		Date now = new Date();
		setProperty(cdr, "createTime", now);
		String id = "1";
		setProperty(cdr, "id", id);
		Integer duration = 100;
		setProperty(cdr, "duration", duration);
		setProperty(cdr, "duration", duration);
		System.out.println("cdr.id=" + cdr.getId() + ", cdr.duration=" + cdr.getDuration() + ", cdr.createTime=" + cdr.getCreateTime());
		setPropertyFromStr(cdr, "caller", "990");
		setPropertyFromStr(cdr, "endTime", "2016-07-01 15:01:02");
		setPropertyFromStr(cdr, "price", "0.5");
		System.out.println("cdr.caller=" + cdr.getCaller() + ", cdr.endTime=" + cdr.getEndTime() + ", cdr.price=" + cdr.getPrice());
		Map<String, Object> map = new HashMap<String, Object>();
		bean2map(cdr, map);
		System.out.println("map.caller=" + map.get("caller"));
	}
	
}
