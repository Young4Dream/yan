package com.tstar.callcenter.pub.data;
 
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



/** 
 * key值忽略大小写的HashMap 
 * @author
 * @version 
 */
@SuppressWarnings("all")
public class ResultMap extends Data implements Map,Serializable
{
	private Map map;

	public ResultMap()
	{
		map = new HashMap();
	}
	
	public ResultMap(Map map)
	{
		this.map = map;
	}
	
	public int size()
	{
		return map.size();
	}

	public boolean isEmpty()
	{
		return map.isEmpty();
	}

	public boolean containsKey(Object key)
	{
		return map.containsKey(toLowerCase(key));
	}

	/** 
	 * 如果key是String 则返回小写的key
	 * @param key
	 * @return 如果key是String 则返回小写的key
	 */
	private Object toLowerCase(Object key)
	{
		if (key != null && key instanceof String)
		{
			key = ((String)key).toLowerCase();
		}
		return key;
	}

	public boolean containsValue(Object value)
	{
		return map.containsValue(value);
	}

	public Object get(Object key)
	{
		return map.get(toLowerCase(key));
	}

	public Object put(Object key, Object value)
	{
		return map.put(toLowerCase(key), value);
	}

	public Object putnoCase(Object key, Object value)
	{
		return map.put(key, value);
	}
	
	public Object remove(Object key)
	{
		return map.remove(toLowerCase(key));
	}

	/** 
	 * 放置一个map中的所有参数，（注：直接将map中的参数逐个放入，效率略差于HashMap）
	 * 覆盖方法
	 * @param m
	 */
	public void putAll(Map m)
	{
        for (Iterator i = m.entrySet().iterator(); i.hasNext(); ) 
        {
            Map.Entry e = (Map.Entry) i.next();
            put(e.getKey(), e.getValue());
        }
	}

	public void clear()
	{
		map.clear();
	}

	public Set keySet()
	{
		return map.keySet();
	}

	public Collection values()
	{
		return map.values();
	}

	public Set entrySet()
	{
		return map.entrySet();
	}

	public String toString()
	{
		return map.toString();
	}
	
	
	/** 
	 * 覆盖方法
	 * 支持Element接口
	 * @param name
	 * @return
	 */
	public String getAttribute(String name)
	{
		return getString(name);
	}

	/** 
	 * 覆盖方法
	 * 支持Element接口
	 * @param name
	 * @param value
	 */
	public void setAttribute(String name, String value) 
	{
		put(name, value);
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}