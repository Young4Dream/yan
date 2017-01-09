/**
 * 
 */
package com.tstar.activiti.servicetask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhumengfeng
 *
 */
@Component
public class ChangeCompletedServiceTask implements JavaDelegate {

	@Transactional
	public void execute(DelegateExecution execution) throws Exception {
		String businessKey = execution.getProcessBusinessKey();
		System.out.println("ChangeCompletedServiceTask, businessKey=" + businessKey);
	}

}
