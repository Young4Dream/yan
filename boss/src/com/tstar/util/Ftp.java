/**
 * 
 */
package com.tstar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


/**
 * @author zhumengfeng
 *
 */
public class Ftp {
	
	private FTPClient ftp;

	public void connect(String host, String username, String pwd, int port, String root) throws Exception {
		if (ftp == null) {
			ftp = new FTPClient();
		}
		ftp.connect(host, port);
		ftp.login(username, pwd);
		if (root != null && !root.equals("")) {
			ftp.changeWorkingDirectory(root);
		}
	}
	
	public void disconnect() {
		try {
			ftp.logout();
			ftp.disconnect();
		} catch (Exception e) {}
	}
	
	public boolean isConnected() {
		return ftp.isConnected();
	}
	
	public boolean isExist(String dir) {
		return true;
	}
	
	public List<FileInfo> list(String dir) throws Exception {
		if (dir != null && !"".equals(dir)) {
			ftp.changeWorkingDirectory(dir);
		}
		FTPFile[] fs = ftp.listFiles();
		List<FileInfo> files = new ArrayList<FileInfo>();
		for (FTPFile f : fs) {
			if (f.isFile()) {
				FileInfo fileInfo = new FileInfo();
				fileInfo.setName(f.getName());
				fileInfo.setSize(f.getSize());
				fileInfo.setCheckSum(0);
				files.add(fileInfo);
			}
		}
		return files;
	}
	
	public List<FileInfo> list(String dir, String regexp) throws Exception {
		if (dir != null && !"".equals(dir)) {
			ftp.changeWorkingDirectory(dir);
		}
		FTPFile[] fs = ftp.listFiles();
		List<FileInfo> files = new ArrayList<FileInfo>();
		for (FTPFile f : fs) {
			if (f.isFile()) {
				String fileName = f.getName();
				if (RegExp.matches(regexp, fileName)) {
					FileInfo fileInfo = new FileInfo();
					fileInfo.setName(f.getName());
					fileInfo.setSize(f.getSize());
					fileInfo.setCheckSum(0);
					files.add(fileInfo);
				}
			}
		}
		return files;
	}
	
	public boolean cd(String dir) throws Exception {
		return ftp.changeWorkingDirectory(dir);
	}
	
	public void rm(String filename) throws Exception {
		ftp.deleteFile(filename);
	}
	
	public void download(String downloadFile, String saveFile) throws Exception{
		File file = new File(saveFile);
		OutputStream os = new FileOutputStream(file);
		try {
			ftp.retrieveFile(downloadFile, os);
		} finally {
			os.close();
		}
	}
	
	public void upload(String uploadFile) throws Exception {
		File file = new File(uploadFile);
		if (file.isDirectory()) {
			throw new Exception("Don't support make directory");
		}
		File file2 = new File(file.getPath());
		FileInputStream is = new FileInputStream(file2);
		try {
			ftp.storeFile(file2.getName(), is);
		} finally {
			is.close();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Ftp fs = new Ftp();
			fs.connect("192.168.44.182", "cjuser", "cjuser", 21, "/home/cjuser/ftp/");
			String filename = "e:\\b00000498.dat";
			fs.download("b00000498.dat", filename);
			List<FileInfo> files = fs.list("/home/cjuser/ftp/");
			for (FileInfo info : files) {
				System.out.print(info.getName() + "\n");
			}
			fs.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
