package com.tstar.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.ChannelSftp.LsEntry;

public final class Sftp {
	static String _root = "/";
	private com.jcraft.jsch.Session _sshSession;
	private ChannelSftp sftp;
	
	public void connect(String host, String username, String pwd, int port, String root) throws Exception {
		sftp = null;
		try {
			JSch jsch = new JSch();
			_sshSession = jsch.getSession(username, host, port);
			_sshSession.setPassword(pwd);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			_sshSession.setConfig(sshConfig);
			_sshSession.connect();
			// Log: Session connected.
			// Log: Opening channel.
			Channel channel = _sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp)channel;
			// Log: Successfully Connected to host.
			if (root != null && !"".equals(root)) {
				sftp.cd(root);
				_root = root;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void disconnect() {
		if (sftp != null) {
			if (sftp.isConnected()) {
				sftp.disconnect();
				// Log: Connection closed.
			} else if (sftp.isClosed()) {
				
			}
		}
		if (_sshSession != null && _sshSession.isConnected()) {
			_sshSession.disconnect();
		}
		// Log: sftp closed.
	}
	
	public boolean isConnected() {
		return (sftp != null) && sftp.isConnected() && !sftp.isClosed()
				&& (_sshSession != null) && _sshSession.isConnected();
	}
	
	private Vector _list(String dir) {
		try {
			return sftp.ls(dir);
		} catch (Exception e) {
			return null;
		}
	}
	
	private Vector _list() {
		try {
			return sftp.ls(sftp.pwd());
		} catch (Exception e) {
			return null;
		}
	}
	
	public List list(String dir) {
		try {
			Vector ls = _list(dir);
			return _buildFiles(ls);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<FileInfo> list(String dir, String regexp) throws Exception {
		Vector ls = _list(dir);
		return _buildFiles(ls, regexp);
	}
	
	private List _buildFiles(Vector ls) throws Exception {
		if  (ls != null && ls.size() >= 0) {
			List list = new ArrayList();
			for (int i = 0; i < ls.size(); i++) {
				LsEntry f = (LsEntry)ls.get(i);
				String nm = f.getFilename();
				if (nm.equals(".") || nm.equals(".."))
					continue;
				SftpATTRS attr = f.getAttrs();
				Map m = new HashMap();
				if (attr.isDir()) {
					m.put("dir", new Boolean(true));
				} else {
					m.put("dir", new Boolean(false));
				}
				m.put("name", nm);
				list.add(m);
			}
			return list;
		}
		return null;
	}

	private List<FileInfo> _buildFiles(Vector ls, String regexp) throws Exception {
		if  (ls != null && ls.size() >= 0) {
			List<FileInfo> list = new ArrayList<FileInfo>();
			for (int i = 0; i < ls.size(); i++) {
				LsEntry f = (LsEntry)ls.get(i);
				String nm = f.getFilename();
				if (nm.equals(".") || nm.equals(".."))
					continue;
				SftpATTRS attr = f.getAttrs();
				if (!attr.isDir()) {
					if (RegExp.matches(regexp, nm)) {
						FileInfo fileInfo = new FileInfo();
						fileInfo.setName(nm);
						fileInfo.setSize(attr.getSize());
						fileInfo.setCheckSum(0);
						list.add(fileInfo);
					}
				}
			}
			return list;
		}
		return null;
	}
	
	public List list() {
		try {
			Vector ls = _list();
			return _buildFiles(ls);
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean cd(String dirs) throws Exception {
		try {
			String path = dirs;
			if (path.indexOf("\\") != -1) {
				path = dirs.replaceAll("\\", "/");
			}
			String pwd = sftp.pwd();
			if (pwd.equals(path))
				return true;
			
			sftp.cd(_root);
			
			if (_root.equals(dirs)) return true;
			
			String[] paths = path.split("/");
			for (int i = 0; i < paths.length; i++) {
				String dir = paths[i];
				if (isEmpty(dir)) continue;
				sftp.cd(dir);
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static boolean isEmpty(String s) {
		return s == null || "".equals(s.trim());
	}
	
	public boolean isExist(String root, String fileOrDir) throws Exception {
		try {
			boolean exist = false;
			boolean cdflg = false;
			String pwd = sftp.pwd();
			if (pwd.indexOf(root) == -1) {
				cdflg = true;
				sftp.cd(root);
			}
			Vector ls = _list(root);
			if (ls != null && ls.size() > 0) {
				for (int i = 0; i < ls.size(); i++) {
					LsEntry f = (LsEntry)ls.get(i);
					String nm = f.getFilename();
					if (nm.equals(fileOrDir)) {
						exist = true;
						break;
					}
				}
			}
			if (cdflg) {
				sftp.cd("..");
			}
			return exist;
		} catch (Exception e) {
			throw e;
		}
	}
		
	public boolean upload(String uploadFile) throws Exception {
		java.io.InputStream is = null;
		try {
			File file = new File(uploadFile);
			is = new FileInputStream(file);
			sftp.put(is, file.getName());
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (is != null) {
					is.close();
					is = null;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void download(String dir, String downloadFile, String saveFile) throws Exception{
		try {
			boolean isCd = false;
			if (!isEmpty(dir)) {
				sftp.cd(dir);
				isCd = true;
			}
			sftp.get(downloadFile, saveFile);
			if (isCd)
				sftp.cd("..");
			//Log: sucessful to download file
		} catch (Exception e) {
			throw e;
			//Log: Fail to download file
		}
	}
	
	public boolean rm(String deleteFile) throws Exception {
		try {
			Vector ls = _list();
			if (ls != null && ls.size() > 0) {
				for (int i = 0; i < ls.size(); i++) {
					LsEntry f = (LsEntry)ls.get(i);
					String nm = f.getFilename();
					if (!nm.equals(deleteFile)) {
						continue;
					}
					SftpATTRS attr = f.getAttrs();
					if (!attr.isDir()) {
						sftp.rm(nm);
					}
				}
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
}
