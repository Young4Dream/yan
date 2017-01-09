/**
 * 执行指令线程
 */
package com.tstar.ac.business;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tstar.ac.model.AcAction;
import com.tstar.ac.model.AcCommand;
import com.tstar.portal.model.SysWarnLog;
import com.tstar.res.model.ResDevice;
import com.tstar.util.DateUtil;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.Log;
import com.tstar.util.StringUtil;
import com.tstar.util.UUID;

/**
 * @author zhumengfeng
 *
 */
public class CmdThread extends Thread {

	private final static long SLEEP_DURATION = 2000L; // millisecond
	
	private void suspend(long duration) {
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage());
		}
	}
	
	private INorth getExecutor(ResDevice device, String ctrlSetName) throws Exception {
		String className = "com.tstar.ac.business." + ctrlSetName; 
		return (INorth)Class.forName(className).newInstance();
	}
	
	public void run() {
		AcBus bus = new AcBus();
		// 无法连接服务器告警，每天发一天
		Map<String, String> warns = new HashMap<String, String>(); 
		while (true) {
			suspend(SLEEP_DURATION);
			AcAction action = bus.getTopRunnableAction();
			if (action != null) {
				Log.getLogger().info("Top executing action got, id=" + action.getId() + ", businessKey=" + action.getBusinessKey()  + ", ossKey=" + action.getOssKey());
				List<AcCommand> cmds = bus.getCmdsByAct(action.getId());
				if (cmds == null || cmds.size() == 0) {
					action.setStatus(AcAction.STATUS_NO_COMMANDS);
					bus.updateAction(action);
					continue;
				}
				int size = cmds.size();
				Log.getLogger().info("Commands.count=" + size);
				ResDevice device = bus.getDeviceByCode(cmds.get(0).getDeviceCode());
				// 获取连接
				INorth executor = null;
				try { 
					executor = getExecutor(device, cmds.get(0).getCtrlSetName()); 
				}
				catch (Exception e) {
					Log.getLogger().error("Unknown error: " + ExceptionUtil.getStackTrace(e));
					continue;
				}
				// 打开连接
				try {
					Log.getLogger().info("Connecting " + device.getCtrlIp());
					executor.open(device.getCtrlIp());
				} catch (Exception e) {
					action.setStatus(AcAction.STATUS_RETRY);
					action.setRetry(1 + action.getRetry());
					bus.saveCmds(action, null);
					String warnKey = DateUtil.formatDate(new Date()) + device.getCtrlIp();
					String warnMsg = warns.get(warnKey);
					if (StringUtil.isEmpty(warnMsg)) {
						// 发送告警
						SysWarnLog warnLog = new SysWarnLog();
						warnLog.setId(UUID.get());
						warnLog.setWarnModule("自动控制");
						warnLog.setWarnLevel("ERROR");
						warnLog.setWarnMsg("无法连接服务器：" + device.getCtrlIp());
						warnLog.setWarnTime(new Date());
						warnLog.setStatus(0);
						bus.saveWarnLog(warnLog);
						warns.put(warnKey, warnLog.getWarnMsg());
					}
					Log.getLogger().error("Fail to connect to " + device.getCtrlIp());
					continue;
				}
				// 执行命令
				try {
					boolean success = true;
					for (int i = 0; i < size; i++) {
						AcCommand cmd = cmds.get(i);
						Log.getLogger().info("Command: " + cmd.getCmd());
						RetMsg res = executor.execute(cmd.getCmd(), cmd.getCmdPrompt());
						Log.getLogger().info(res.getRetDesc());
						cmd.setRetCode(Integer.parseInt(res.getRetCode()));
						cmd.setRetDesc(res.getRetDesc());
						cmd.setExeTime(new Date());
						if (0 != cmd.getRetCode() && 1 == cmd.getKeyFlag()) {
							// 关键指令执行失败，中断执行
							success = false;
							break;
						}
					}
					if (success) {
						action.setStatus(AcAction.STATUS_SUCCESS);
					} else {
						action.setStatus(AcAction.STATUS_FAIL);
					}
					bus.saveCmds(action, cmds);
				} catch (Exception e) {
					action.setStatus(AcAction.STATUS_RETRY);
					action.setRetry(1 + action.getRetry());
					bus.saveCmds(action, null);
					Log.getLogger().error(ExceptionUtil.getStackTrace(e));
				} finally {
					try { executor.close(); } catch (Exception e) {}; 
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
