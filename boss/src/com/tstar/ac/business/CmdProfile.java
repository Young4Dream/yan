/**
 * 从Commands.xml文件中载入控制指令集
 */
package com.tstar.ac.business;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tstar.ac.model.AcCommand;
import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileHelper;
import com.tstar.util.RegExp;

/**
 * @author zhumengfeng
 *
 */
public class CmdProfile {
	private static final String CONFIG_PATH = "config/commands.xml";
	
	private static final String FILE_FLAG = "file:";
	
	private static final String NODE_CTRL_SET = "ctrl-set";
	private static final String NODE_COMMANDS = "commands";
	private static final String NODE_COMMAND = "command";

	private static final String ATTR_ID = "id";
	private static final String ATTR_PROMPT = "prompt";
	private static final String ATTR_INDEX = "index";
	private static final String ATTR_KEY = "key";

	private static final String CMD_LOGIN = "login";
	private static final String CMD_LOGOUT = "logout";
	
	private static Map<String, Map<String, List<AcCommand>>> ctrlSets = null;
	
	private static void load() throws Exception {
		File file = new File(CONFIG_PATH);
		if (!file.exists()) {
			throw new Exception(CONFIG_PATH + " does not exists.");
		}
		
		ctrlSets = new HashMap<String, Map<String, List<AcCommand>>>();
		
		FileInputStream fis = new FileInputStream(file);
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(fis);
		Element root = document.getRootElement();
		
		// 获取设备相关指令
		List<Element> ctrlSetNodes = root.elements(NODE_CTRL_SET);
		for (Element ctrlSetNode : ctrlSetNodes) {
			String setId = ctrlSetNode.attributeValue(ATTR_ID);
			Map<String, List<AcCommand>> ctrlSet = new HashMap<String, List<AcCommand>>();
			ctrlSets.put(setId, ctrlSet);
			List<Element> cmdsNodes = ctrlSetNode.elements(NODE_COMMANDS);
			for (Element cmdsNode : cmdsNodes) {
				String cmdsId = cmdsNode.attributeValue(ATTR_ID);
				List<AcCommand> cmds = new ArrayList<AcCommand>();
				ctrlSet.put(cmdsId, cmds);
				List<Element> cmdNodes = cmdsNode.elements(NODE_COMMAND);
				for (Element cmdNode : cmdNodes) {
					AcCommand cmd = new AcCommand();
					try { cmd.setCmdOrder(Integer.parseInt(cmdNode.attributeValue(ATTR_INDEX))); } catch (Exception e) { cmd.setCmdOrder(1); }
					try { cmd.setKeyFlag(Integer.parseInt(cmdNode.attributeValue(ATTR_KEY))); } catch (Exception e) { cmd.setKeyFlag(1); }
					try { cmd.setCmdPrompt(cmdNode.attributeValue(ATTR_PROMPT)); } catch (Exception e) { cmd.setCmdPrompt(""); }
					String text = cmdNode.getText().trim();
					if (text.startsWith(FILE_FLAG)) {
						// 命令保存在文件之中，读取文件内容
						String fileName = "config/" + text.substring(FILE_FLAG.length());
						String content = FileHelper.readTxtFile(fileName);
						cmd.setCmd(content);
					} else {
						cmd.setCmd(text);
					}
					cmds.add(cmd);
				}
				// 按INDEX属性排序指令集
				Collections.sort(cmds, new SortCmd());
			}
		}
	}

	public static List<AcCommand> getCmds(String ctrlSetId, String cmdsId, Map<String, Object> variables) {
		if (ctrlSets == null) {
			try {
				load();
				if (ctrlSets == null) return null;
			} catch (Exception e) {
				System.out.println(ExceptionUtil.getStackTrace(e));
			}
		}
		Map<String, List<AcCommand>> ctrlSet = ctrlSets.get(ctrlSetId);
		if (ctrlSet == null) return null;
		List<AcCommand> cmds = ctrlSet.get(cmdsId);
		if (cmds == null || cmds.size() == 0) return null;
		List<AcCommand> loginCmds = ctrlSet.get(CMD_LOGIN);
		List<AcCommand> logoutCmds = ctrlSet.get(CMD_LOGOUT);
		List<AcCommand> allCmds = new ArrayList<AcCommand>();
		if (loginCmds != null && loginCmds.size() > 0) allCmds.addAll(loginCmds);
		allCmds.addAll(cmds);
		if (logoutCmds != null && logoutCmds.size() > 0) allCmds.addAll(logoutCmds);
		List<AcCommand> resCmds = new ArrayList<AcCommand>();
		for (AcCommand cmd : allCmds) {
			AcCommand resCmd = new AcCommand();
			resCmd.setCmdOrder(cmd.getCmdOrder());
			resCmd.setKeyFlag(cmd.getKeyFlag());
			resCmd.setCmdPrompt(cmd.getCmdPrompt());
			String text = cmd.getCmd();
			if (variables != null) {
				String[] variableNames = RegExp.findVariables(text);
				if (variableNames != null && variableNames.length > 0) {
					for (String var : variableNames) {
						// #{seq}替换成随机整数
						String value = "seq".equals(var) 
							? "" + (int)(1 + Math.random() * 100000) 
							: (variables.get(var) == null ? "" : variables.get(var).toString());
						if (value != null) {
							text = text.replace("#{" + var + "}", value);
						}
					}
				}
			}
			resCmd.setCmd(text);
			resCmds.add(resCmd);
		}
		return resCmds;
	}
	
	public static void main(String[] args) throws Exception {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("businessKey", "24190");
		variables.put("name", "bss");
		variables.put("password", "123456");
		List<AcCommand> lst = getCmds("IMS_V9", "nsdan", variables);
		for (AcCommand cmd : lst) {
			System.out.println(cmd.getCmd());
		}
	}
}
