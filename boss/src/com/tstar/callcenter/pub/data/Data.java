 
package com.tstar.callcenter.pub.data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

import com.tstar.callcenter.pub.tools.DateUtil;

/** 
 * 所有数据存储类的抽象类（暂时只支持Map和Element） 
 * @author
 * @version 0.1 2015-3-6 16:30:10
 */
@SuppressWarnings("all")
public abstract class Data implements Map, Element
{
	/**
	 * 由对象创建Data型数据
	 * @param object 对象
	 * @return Data型数据
	 */
	public static Data creatData(Object object)
	{
		if (object instanceof Map)
		{
			return new ResultMap((Map)object);
		}
		else if (object instanceof Element)
		{
			return new DataElement((Element)object);
		}
		
		throw new IllegalArgumentException("不能使用该类型构建，现在暂时只支持Map和Element");
	}

	/** 
	 * 如果得到值为空，则返回defaultValue
	 * @param key
	 * @param defaultValue 值为空时的代替返回值 
	 * @return
	 */
	public Object get(Object key, Object defaultValue)
	{
		Object result = get(key); 
		if (result == null || result.equals(""))
		{
			result = defaultValue;
		}
		return result;
	}
	
	/** 
	 * 得到String类型的返回值
	 * @param key
	 * @return
	 */
	public String getString(Object key)
	{
		Object result = get(key); 
		if (result == null)
		{
			return null; 
		}
		return result.toString().trim();
	}
	
	/** 
	 * 得到String类型的返回值， 如果为空则返回defaultValue
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getString(Object key, String defaultValue)
	{
		Object result = get(key, defaultValue); 
		if (result == null)
		{
			return null; 
		}
		return result.toString().trim();
	}
	
	/** 
	 * 将日期类型返回成一个表示日期的字符串 YYYY-MM-DD格式
	 * 
	 * @param key
	 * @return
	 */
	public String getDateString(Object key) 
	{
		Date date = (Date) get(key);
		return DateUtil.format(date, "yyyy-MM-dd");
	}
	
	/** 
	 * 将日期类型返回成一个表示日期的字符串 YYYY-MM-DD格式
	 * 如果为空 则返回defaultValue
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getDateString(Object key, String defaultValue)
	{
		String result = defaultValue;
		Date date = (Date) get(key);
		if (date != null)
		{
			result = DateUtil.format(date, "yyyy-MM-dd");
		}
		return result;
	}
	
	/** 
	 * 得到int型的返回值
	 * @param key
	 * @return
	 */
	public int getInt(Object key)
	{
		return (int)Double.parseDouble(getString(key));
	}
	
	/** 
	 * 得到int型的返回值， 如果为空则返回defaultValue
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public int getInt(Object key, int defaultValue)
	{
		String result = getString(key, String.valueOf(defaultValue));
		if (result.length() < 1)
		{
			result = "0";
		}
		return (int)Double.parseDouble(result);
	}

	/** 
	 * 得到long型的返回值
	 * 将返回值强转为long型
	 * @param key
	 * @return
	 */
	public long getLong(Object key)
	{
		return (long)Double.parseDouble(getString(key));
	}
	
	/** 
	 * 得到long型的返回值， 如果为空则返回defaultValue
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public long getLong(Object key, long defaultValue)
	{
		String result = getString(key, String.valueOf(defaultValue));
		if (result.length() < 1)
		{
			result = "0";
		}
		
		return (long)Double.parseDouble(result);
	}
	
	/** 
	 * 得到double型的返回值
	 * @param key
	 * @return
	 */
	public double getDouble(Object key)
	{
		return Double.parseDouble(getString(key));
	}

	/** 
	 * 得到double型的返回值, 如果为空则返回defaultValue
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public double getDouble(Object key, double defaultValue)
	{
		return Double.parseDouble(getString(key, String.valueOf(defaultValue)));
	}
	
	public int size()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public boolean isEmpty()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public boolean containsKey(Object key)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public boolean containsValue(Object value)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public Object get(Object key)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public Object put(Object key, Object value)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public Object remove(Object key)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public void putAll(Map t)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public void clear()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public Set keySet()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public Collection values()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public Set entrySet()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}


	public String getTagName()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public void removeAttribute(String name) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public boolean hasAttribute(String name)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public String getAttribute(String name)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public void setAttribute(String name, String value) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public boolean hasAttributeNS(String namespaceURI, String localName)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Attr getAttributeNode(String name)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Attr removeAttributeNode(Attr oldAttr) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Attr setAttributeNode(Attr newAttr) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public NodeList getElementsByTagName(String name)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public String getAttributeNS(String namespaceURI, String localName)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Attr getAttributeNodeNS(String namespaceURI, String localName)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public NodeList getElementsByTagNameNS(String namespaceURI, String localName)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public short getNodeType()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public void normalize()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public boolean hasAttributes()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public boolean hasChildNodes()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public String getLocalName()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public String getNamespaceURI()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public String getNodeName()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public String getNodeValue() throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public String getPrefix()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public void setNodeValue(String nodeValue) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public void setPrefix(String prefix) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Document getOwnerDocument()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public NamedNodeMap getAttributes()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node getFirstChild()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node getLastChild()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node getNextSibling()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node getParentNode()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node getPreviousSibling()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node cloneNode(boolean deep)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public NodeList getChildNodes()
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public boolean isSupported(String feature, String version)
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node appendChild(Node newChild) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node removeChild(Node oldChild) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node insertBefore(Node newChild, Node refChild) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	public Node replaceChild(Node newChild, Node oldChild) throws DOMException
	{
		throw new IllegalStateException("该方法未实现，不能使用！");
	}

	/**
	 * 将数据的指定属性相加，结果放入o1
	 * @param o1
	 * @param o2
	 * @param keys 指定的属性数组
	 */
	public static void dataAdd(Object o1, Object o2, String[] keys)
	{
		Data data1 = creatData(o1);
		Data data2 = creatData(o2);
	
		for (int i = 0; i < keys.length; i++)
		{
			String str1 = data1.getString(keys[i]);
			if (str1 == null || str1.length() == 0)
			{
				str1 = "0";
			}
			String str2 = data2.getString(keys[i]);
			if (str1 == null || str2.length() == 0)
			{
				str2 = "0";
			}
			BigDecimal d1 = new BigDecimal(str1);
			BigDecimal d2 = new BigDecimal(str2);
	
			d1 = d1.add(d2);
			data1.put(keys[i], d1.toString());
		}
	}

	public TypeInfo getSchemaTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdAttribute(String name, boolean isId) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public String getBaseURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public short compareDocumentPosition(Node other) throws DOMException {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTextContent() throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTextContent(String textContent) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public boolean isSameNode(Node other) {
		// TODO Auto-generated method stub
		return false;
	}

	public String lookupPrefix(String namespaceURI) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDefaultNamespace(String namespaceURI) {
		// TODO Auto-generated method stub
		return false;
	}

	public String lookupNamespaceURI(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEqualNode(Node arg) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getFeature(String feature, String version) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object setUserData(String key, Object data, UserDataHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUserData(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}