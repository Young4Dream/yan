package com.tstar.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    
    public static void write(String fileName, String content) throws IOException {
    	File file = new File(fileName);
    	// Check folder, if it does not exist, make it
		String parent = file.getParent();
		File dir = new File(parent);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// Check file, if it does not exist, create it
    	if (!file.exists()) {
    		file.createNewFile();
    	}
    	FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	BufferedWriter bw = new BufferedWriter(fw);
    	try {
	    	bw.write(content);
	    	//bw.newLine();
    	} finally {
    		bw.close();
    	}
    }

    public static void write(String fileName, String[] lines) throws IOException {
    	File file = new File(fileName);
    	// Check folder, if it does not exist, make it
		String parent = file.getParent();
		File dir = new File(parent);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// Check file, if it does not exist, create it
    	if (!file.exists()) {
    		file.createNewFile();
    	}
    	FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	BufferedWriter bw = new BufferedWriter(fw);
    	try {
	    	for (int i = 0; i < lines.length; i++) {
	    		bw.write(lines[i]);
	    		bw.newLine();
	    	}
    	} finally {
    		bw.close();
    	}
    }
    
    public static String readTxtFile(String filePath) {
		StringBuilder sb = new StringBuilder();
    	File file = new File(filePath);
    	if (file.isFile() && file.exists()) {
    		try {
	    		InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
	    		try {
		    		BufferedReader br = new BufferedReader(isr);
		    		String line = null;
		    		while ((line = br.readLine()) != null) {
		    			sb.append(line);
		    		}
	    		} finally {
	    			isr.close();
	    		}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return sb.toString();
    }

    /**
	 * @author Administrator
	 * 删除指定的文件
	 * @param filePath：文件的绝对路径
	 * 
	 * */
    public static void deleteFile(String filePath){
    	File file = new File(filePath);
    	
    	if(file.exists() && file.isFile()){
    		try {
    			if(file.delete()){
    				//Log.getLogger().info(International.getProperty("FileOper.RemoveSuccess")+filePath+"\n");
    			}else{
    				//Log.getLogger().info(International.getProperty("FileOper.RemoveFailure")+filePath+"\n");
    			}
			} catch (RuntimeException e) {
				//删除话单文件时出现异常
				//Log.getLogger().error(International.getProperty("SortMain.ThrownException"),e);
			}
    	}
    }
    
    /**
     * @author Administrator
     * 根据话单目录和过滤的文件名称，获取话单文件列表。
     * 
     * @param folder：话单所在目录
     * @param filterName：过滤的文件名称
     * @return File[]：话单文件名称数组
     * */
    public static File[] getFileNames(String folder, String filterName){
    	List<File> fileList = new ArrayList<File>();
    	boolean filterRes = false;
    	//对过滤文件名称进行处理
    	String prefixName = "";//过滤文件名的前缀
		String suffixName = "";//过滤文件名的后缀
		
    	if(-1!=filterName.indexOf(".")){
    		String nameArray [] = filterName.split("\\.");
			if(nameArray.length>1){
				prefixName = nameArray[0];//过滤文件名的前缀
				suffixName = nameArray[1];//过滤文件名的后缀
			}
			if(prefixName.endsWith("*")){
				prefixName = prefixName.replaceAll("\\*", "");
			}
			if(suffixName.endsWith("*")){
				suffixName = suffixName.replaceAll("\\*", "");
			}
			filterRes = true;
    	}
    	
    	//Log.getLogger().info(International.getProperty("FileOper.PrefixName")+prefixName);
    	//Log.getLogger().info(International.getProperty("FileOper.SuffixName")+suffixName);
    	
    	File file = new File(folder);
    	File[] files = file.listFiles();
    	String fileName = "";
    	
    	if(filterRes){
    		if(files.length>0){
				for(int i=0;i<files.length;i++){
					//判断是否是文件，如果是返回true，否则返回false
					if(files[i].isFile()){
						fileName = files[i].getName();
						//如果是以过滤的后缀结束，且包含前缀，则是要获取的文件
						if(fileName.endsWith(suffixName) && -1!=fileName.indexOf(prefixName)){
							fileList.add(files[i]);
						}
					}else{
						continue;
					}
				}
			}
    	}else{
    		if(files.length>0){
    			for (int i = 0; i < files.length; i++) {
    				if (files[i].isFile()) {
    					fileList.add(files[i]);
    				}
    			}
    		}
    	}
    	
    	//打印获取到的文件列表名称
    	for(int j=0;j<fileList.size();j++){
    		//Log.getLogger().info(International.getProperty("FileOper.FileName")+fileList.get(j));
    	}
    	File fileRes[] = new File[fileList.size()];// 声明文件数组，长度为集合的长度
    	fileList.toArray(fileRes);// 集合数组化
    	return fileRes;
    }
    
    public static List<File> getFiles(String folder) {
    	List<File> fileList = new ArrayList<File>();
    	File file = new File(folder);
    	File[] files = file.listFiles();
    	//String fileName = "";
    	
    	if(files.length>0){
    		for (int i = 0; i < files.length; i++) {
    			if (files[i].isFile()) {
    				fileList.add(files[i]);
    			}
    		}
    	}
    	return fileList;
    }
    
    public static List<String> list(String dir, String regexp) {
    	List<String> files = new ArrayList<String>();
    	File folder = new File(dir);
    	if (!folder.exists()) {
    		folder.mkdirs();
    	}
    	File[] infos = folder.listFiles();
    	//System.out.println(infos.length);
    	for (File info : infos) {
    		//System.out.println(info.getName());
    		if (info.isFile()) {
    			String fileName = info.getName();
    			if (RegExp.matches(regexp, fileName)) {
    				files.add(fileName);
    			}
    		}
    	}
    	return files;
    }
    
    public static List<FileInfo> listFiles(String dir, String regexp) {
    	List<FileInfo> files = new ArrayList<FileInfo>();
    	File folder = new File(dir);
    	if (!folder.exists()) {
    		folder.mkdirs();
    	}
    	File[] infos = folder.listFiles();
    	//System.out.println(infos.length);
    	for (File info : infos) {
    		//System.out.println(info.getName());
    		if (info.isFile()) {
    			String fileName = info.getName();
    			if (RegExp.matches(regexp, fileName)) {
    				//files.add(fileName);
    				FileInfo fileInfo = new FileInfo();
    				fileInfo.setName(fileName);
    				fileInfo.setSize(info.length());
    				fileInfo.setCheckSum(0);
    				files.add(fileInfo);
    			}
    		}
    	}
    	return files;
    }
    
	public static void copy(String fileFrom, String fileTo) throws IOException {
        FileInputStream in = new java.io.FileInputStream(fileFrom);
        FileOutputStream out = new FileOutputStream(fileTo);
        byte[] bt = new byte[1024];
        int count;
        while ((count = in.read(bt)) > 0) {
            out.write(bt, 0, count);
        }
        in.close();   
        out.close();
	}
	
	public static void move(String fileFrom, String fileTo) throws IOException {
		copy(fileFrom, fileTo);
		(new File(fileFrom)).delete();
	}
	  
	/**
	 * 以二进制读取文件
	 * @param filepath
	 * @return
	 */
	public static byte[] copyFile(String filepath) {
		File srcFile = new File(filepath);
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;
		byte[] content = null;
		try {
			in = new BufferedInputStream(new FileInputStream(srcFile));
			out = new ByteArrayOutputStream(1024);

			int len = -1;
			byte[] b = new byte[1024];
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			content = out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭输入流和输出流
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	/**
	 * 读取文本文件
	 * @param filepath
	 * @param head 增加文件头
	 * @param tail 增加文件尾
	 * @return
	 */
	public static byte[] copyFile(String filepath, String head, String tail) {
		File srcFile = new File(filepath);
		BufferedInputStream in = null;
		ByteArrayOutputStream out = null;
		byte[] content = null;
		try {
			in = new BufferedInputStream(new FileInputStream(srcFile));
			out = new ByteArrayOutputStream(1024);

			if (head != null && !head.equals("")) {
				byte[] h = head.getBytes();
				out.write(h, 0, h.length);
			}
			int len = -1;
			byte[] b = new byte[1024];
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			if (tail != null && !tail.equals("")) {
				byte[] t = tail.getBytes();
				out.write(t, 0, t.length);
			}
			content = out.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭输入流和输出流
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	
    public static void main(String[] args) {
    	String folder = "e:/cdr/source/ims";
    	List<String> fs = list(folder, null);
    	for (String s : fs) {
    		System.out.println(s);
    	}
	}
    
}
