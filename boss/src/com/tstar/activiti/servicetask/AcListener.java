/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import com.tstar.ac.dao.AcActionMapper;
import com.tstar.ac.model.AcAction;

/**
 * @author zhumengfeng
 *
 */
@Component
public class AcListener implements ExecutionListener {

	@Resource
	private AcActionMapper daoAcAction;
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		System.out.println("=========================================listener");
		/*
		Integer duration = (Integer)execution.getVariable("acDuration");
		if (duration == null) {
			duration = new Integer(0);
		}
		if (1 <= duration) {
			execution.setVariable("acFinished", "1");
			execution.setVariable("acResult", "超时，未进行自控");
			execution.setVariable("acResultDesc", "");
			return;
		}
		duration = 1 + duration;
		execution.setVariable("acDuration", duration);
		String instanceId = execution.getProcessBusinessKey();
		List<AcAction> lst = daoAcAction.selectByInstanceId(instanceId);
		if (lst == null || lst.size() == 0) {
			execution.setVariable("acFinished", "1");
			execution.setVariable("acResult", "没有可执行的指令");
			execution.setVariable("acResultDesc", "");
			return;
		}
		int finished = 0;
		int success = 0;
		int undefined = 0;
		int failed = 0;
		for (AcAction action : lst) {
			int status = action.getStatus();
			if (status == 9) {
				success++;
				finished++;
			} else if (status == 91) {
				undefined++;
				finished++;
			} else if (status == 99) {
				failed++;
				finished++;
			}
		}
		if (finished == lst.size()) { 
			execution.setVariable("acFinished", "1");
			execution.setVariable("acResult", "自控已完成");
			execution.setVariable("acResultDesc", "共" + finished + "个指令，" 
					+ success + "个成功，" + failed + "个失败，" + undefined + "个未定义");
			return;
		}
		*/
	}

}
