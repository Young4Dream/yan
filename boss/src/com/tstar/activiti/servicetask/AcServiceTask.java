/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.tstar.ac.dao.AcActionMapper;
import com.tstar.ac.model.AcAction;

/**
 * @author zhumengfeng
 *
 */
@Component
public class AcServiceTask implements JavaDelegate {
	
	@Resource
	private AcActionMapper daoAcAction;
	
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		daoAcAction.updateStatusByJobId(instanceId, AcAction.STATUS_NORMAL);
		execution.setVariable("acDuration", new Integer(0));
		execution.setVariable("acFinished", "0");
		execution.setVariable("acResult", "");
		execution.setVariable("acResultDesc", "");
	}

}
