
package com.tstar.callcenter.pub.data;

import java.util.Collection;
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


@SuppressWarnings("all")
public class DataElement extends Data implements Map
{
	private Element element;
	
	public DataElement(Element element)
	{
		this.element = element;
	}

	public String getTagName()
	{
		return element.getTagName();
	}

	public String getAttribute(String name)
	{
		return element.getAttribute(name);
	}

	public void setAttribute(String name, String value) throws DOMException
	{
		element.setAttribute(name, value);
	}

	public void removeAttribute(String name) throws DOMException
	{
		element.removeAttribute(name);
	}

	public Attr getAttributeNode(String name)
	{
		return element.getAttributeNode(name);
	}

	public Attr setAttributeNode(Attr newAttr) throws DOMException
	{
		return element.setAttributeNode(newAttr);
	}

	public Attr removeAttributeNode(Attr oldAttr) throws DOMException
	{
		return element.removeAttributeNode(oldAttr);
	}

	public NodeList getElementsByTagName(String name)
	{
		return element.getElementsByTagName(name);
	}

	public String getAttributeNS(String namespaceURI, String localName) throws DOMException
	{
		return element.getAttributeNS(namespaceURI, localName);
	}

	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException
	{
		element.setAttributeNS(namespaceURI, qualifiedName, value);
	}

	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException
	{
		element.removeAttributeNS(namespaceURI, localName);
	}

	public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException
	{
		return element.getAttributeNodeNS(namespaceURI, localName);
	}

	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException
	{
		return setAttributeNodeNS(newAttr);
	}

	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException
	{
		return element.getElementsByTagNameNS(namespaceURI, localName);
	}

	public boolean hasAttribute(String name)
	{
		return element.hasAttribute(name);
	}

	public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException
	{
		return element.hasAttributeNS(namespaceURI, localName);
	}

	public String getNodeName()
	{
		return element.getNodeName();
	}

	public String getNodeValue() throws DOMException
	{
		return element.getNodeValue();
	}

	public void setNodeValue(String nodeValue) throws DOMException
	{
		element.setNodeValue(nodeValue);
	}

	public short getNodeType()
	{
		return element.getNodeType();
	}

	public Node getParentNode()
	{
		return element.getParentNode();
	}

	public NodeList getChildNodes()
	{
		return null;
	}

	public Node getFirstChild()
	{
		return element.getFirstChild();
	}

	public Node getLastChild()
	{
		return element.getLastChild();
	}

	public Node getPreviousSibling()
	{
		return element.getPreviousSibling();
	}

	public Node getNextSibling()
	{
		return element.getNextSibling();
	}

	public NamedNodeMap getAttributes()
	{
		return element.getAttributes();
	}

	public Document getOwnerDocument()
	{
		return element.getOwnerDocument();
	}

	public Node insertBefore(Node newChild, Node refChild) throws DOMException
	{
		return element.insertBefore(newChild, refChild);
	}

	public Node replaceChild(Node newChild, Node oldChild) throws DOMException
	{
		return element.replaceChild(newChild, oldChild);
	}

	public Node removeChild(Node oldChild) throws DOMException
	{
		return element.removeChild(oldChild);
	}

	public Node appendChild(Node newChild) throws DOMException
	{
		return element.appendChild(newChild);
	}

	public boolean hasChildNodes()
	{
		return element.hasChildNodes();
	}

	public Node cloneNode(boolean deep)
	{
		return element.cloneNode(deep);
	}

	public void normalize()
	{
		element.normalize();
	}

	public boolean isSupported(String feature, String version)
	{
		return element.isSupported(feature, version);
	}

	public String getNamespaceURI()
	{
		return element.getNamespaceURI();
	}

	public String getPrefix()
	{
		return element.getPrefix();
	}

	public void setPrefix(String prefix) throws DOMException
	{
		element.setPrefix(prefix);
	}

	public String getLocalName()
	{
		return element.getLocalName();
	}

	public boolean hasAttributes()
	{
		return element.hasAttributes();
	}
	
	public Object get(Object key)
	{
		return element.getAttribute((String) key);
	}

	public Object put(Object key, Object value)
	{
		String reslut = element.getAttribute((String)key);
		element.setAttribute((String)key, (String)value);
		return reslut;
	}

	public Object remove(Object key)
	{
		String reslut = element.getAttribute((String)key);
		element.removeAttribute((String)key);
		return reslut;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	public TypeInfo getSchemaTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdAttribute(String name, boolean isId) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNS(String namespaceURI, String localName,
			boolean isId) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNode(Attr idAttr, boolean isId)
			throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public short compareDocumentPosition(Node other) throws DOMException {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getBaseURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getFeature(String feature, String version) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextContent() throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUserData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDefaultNamespace(String namespaceURI) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEqualNode(Node arg) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSameNode(Node other) {
		// TODO Auto-generated method stub
		return false;
	}

	public String lookupNamespaceURI(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	public String lookupPrefix(String namespaceURI) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTextContent(String textContent) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public Object setUserData(String key, Object data, UserDataHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

}