package com.tstar.callcenter.model;

/**
 * 树 实体 ，无库表
 * 
 * @author lixm
 *
 */
public class TreeInfo {
	private long id;
	
	private long parentId;
	
	private long sort;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getSort() {
		return sort;
	}

	public void setSort(long sort) {
		this.sort = sort;
	}
	
	

}
