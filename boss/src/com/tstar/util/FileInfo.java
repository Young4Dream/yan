/**
 * 
 */
package com.tstar.util;

/**
 * @author zhumengfeng
 *
 */
public class FileInfo {
	public String name;
	public Long size;
	public Integer checkSum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Integer getCheckSum() {
		return checkSum;
	}
	public void setCheckSum(Integer checkSum) {
		this.checkSum = checkSum;
	}
}
