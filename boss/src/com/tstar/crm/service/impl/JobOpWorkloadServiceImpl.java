/**
 * 
 */
package com.tstar.crm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.JobOpWorkloadMapper;
import com.tstar.crm.model.JobOpWorkload;
import com.tstar.crm.service.JobOpWorkloadService;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class JobOpWorkloadServiceImpl implements JobOpWorkloadService {

	@Resource
	private JobOpWorkloadMapper dao;
	
	public List<JobOpWorkload> findByFormId(String formId) {
		return dao.selectByFormId(formId);
	}

	public String[] insert(JobOpWorkload obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		int count = dao.insert(obj);
		if (count > 0) {
			return new String[]{"0", "添加成功！"};
		} else {
			return new String[]{"1", "添加失败！"};
		}
	}

	public String[] delete(String id) {
		int count = dao.deleteByPrimaryKey(id);
		if (count > 0) {
			return new String[]{"0", "删除成功！"};
		} else {
			return new String[]{"1", "删除失败！"};
		}
	}

}
