/**
 * 
 */
package com.tstar.activiti.servicetask;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.tstar.ac.dao.AcActionMapper;
import com.tstar.ac.model.AcAction;
import com.tstar.util.ExceptionUtil;

/**
 * @author zhumengfeng
 *
 */
@Component
public class AcCheckServiceTask implements JavaDelegate {

	@Resource
	private AcActionMapper daoAcAction;
	
	public void execute(DelegateExecution execution) throws Exception {
		String instanceId = execution.getProcessBusinessKey();
		try {
			System.out.println("开始检查自控结果...");
			System.out.println("instanceId=" + instanceId);
			List<AcAction> lst = daoAcAction.selectByInstanceId(instanceId);
			if (lst == null || lst.size() == 0) {
				execution.setVariable("acResult", "1");
				execution.setVariable("acResultDesc", "不需进行业务发放");
				System.out.println("没有指令。");
				return;
			}
			AcAction action = null;
			// 查找第一个有指令的业务
			for (int i = 0; i < lst.size(); i++) {
				if (91 == lst.get(i).getStatus()) {
					continue;
				}
				action = lst.get(i);
				break;
			}
			// 没有业务
			if (action == null) {
				execution.setVariable("acResult", "1");
				execution.setVariable("acResultDesc", "没有任何需要执行的指令");
				System.out.println("未配置业务");
				return;
			}
			int status = action.getStatus();
			if (status == 9) {
				execution.setVariable("acResult", "1");
				execution.setVariable("acResultDesc", "业务成功发放");
				System.out.println("业务已执行成功");
				return;
			} else if (status == 99) {
				execution.setVariable("acResult", "2");
				execution.setVariable("acResultDesc", "业务发放失败");
				System.out.println("指令失败");
				return;
			} else if (status == 98 && 3 <= action.getRetry()) {
				execution.setVariable("acResult", "2");
				execution.setVariable("acResultDesc", "业务发放异常，并且重试次数超过3次");
				System.out.println("异常，重试");
				return;
			}
			// 检查超时，1小时之后超时
			long duration = (new Date()).getTime() - action.getCreateTime().getTime();
			if (duration > 3600000) {
				execution.setVariable("acResult", "2");
				execution.setVariable("acResultDesc", "超过1小时");
				return;
			}
			// 以上条件都未满足，设置为未控制，继续等待
			execution.setVariable("acResult", "0");
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
			throw e;
		}
	}

}
