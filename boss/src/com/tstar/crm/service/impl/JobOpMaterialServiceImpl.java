/**
 * 
 */
package com.tstar.crm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.crm.dao.JobOpMaterialMapper;
import com.tstar.crm.model.JobOpMaterial;
import com.tstar.crm.service.JobOpMaterialService;
import com.tstar.ocs.dao.SidMaterialMapper;
import com.tstar.ocs.model.SidMaterial;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
@Service
public class JobOpMaterialServiceImpl implements JobOpMaterialService {

	@Resource
	private JobOpMaterialMapper dao;
	@Resource
	private SidMaterialMapper daoSidMaterial;
	
	public List<JobOpMaterial> findByFormId(String formId) {
		return dao.selectByFormId(formId);
	}

	public String[] insert(JobOpMaterial obj) {
		obj.setId(UUID.get());
		obj.setCreateTime(new Date());
		SidMaterial sidMaterial = daoSidMaterial.selectByPrimaryKey(obj.getMaterialId());
		obj.setMaterialName(sidMaterial.getName());
		obj.setUnitName(sidMaterial.getUnitName());
		obj.setPrice(sidMaterial.getPrice());
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
