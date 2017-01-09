package com.tstar.callcenter.action;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport implements  ServletContextAware{
	
	private static final long serialVersionUID = 1L;  
	  
    private ServletContext context;  
  
    private String filePath;
    
    private String fileName;
  
    private String mimeType;  
  
    private InputStream inStream;

	
     
    public String downLoad() throws Exception {  
        mimeType = context.getMimeType(filePath); 
        setFileName();
        return "downLoad";
    }  
  
    public InputStream getInStream() {  


    	try {
    		inStream = new FileInputStream(filePath);
    		if (inStream == null) {  
    			inStream = new ByteArrayInputStream("Sorry,File not found !"  
                  .getBytes());  
    		} 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        return inStream;  
    }
  
    public String getMimeType() {  
        return mimeType;  
    }  
  
    public void setFileName() {  
        try {
        	String filename = (this.filePath.split("/"))[5]; 
            this.fileName = new String(filename.getBytes("ISO8859-1"),"utf-8");  
        } catch (UnsupportedEncodingException e) {  
        }  
    }  
  
    public String getFileName() {  
        return  this.fileName;
    }  

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context = context; 
	}  

}
