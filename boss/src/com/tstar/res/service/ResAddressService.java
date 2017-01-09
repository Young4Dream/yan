/**
 * 
 */
package com.tstar.res.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.tstar.res.model.ResAddress;

/**
 * @author zhumengfeng
 *
 */
public interface ResAddressService {

	List<ResAddress> findAll();
	JSONArray findAll2Tree();
	String[] insert(ResAddress obj);
	String[] update(ResAddress obj);
	String[] delete(String id);
}
