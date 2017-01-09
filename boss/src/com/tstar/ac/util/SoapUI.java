/**
 * 
 */
package com.tstar.ac.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import com.tstar.util.ExceptionUtil;
import com.tstar.util.FileHelper;

/**
 * @author zhumengfeng
 *
 */
public class SoapUI {
	
	private static final String CODING = "UTF-8";
	private String url;
	private URL wsURL;
	private boolean connected;
	
    public SoapUI(String url) {
    	this.url = url;
    }
    
    public boolean getConnected() { return connected; }
    
    public void connect() throws MalformedURLException, IOException {
    	wsURL = new URL(url);
    	connected = true;
    }
    
    public void disconnect() throws IOException {
    	connected = false;
    }
    
    public String execute(String cmd) throws IOException {
    	HttpURLConnection conn = (HttpURLConnection)wsURL.openConnection();
    	conn.setDoInput(true);
    	conn.setDoOutput(true);
    	conn.setRequestMethod("POST");
    	conn.setRequestProperty("Content-Length", String.valueOf(cmd.getBytes().length));
    	conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
    	
    	OutputStream out = conn.getOutputStream();
    	out.write(cmd.getBytes());
    	out.flush();
    	
    	InputStream in = conn.getInputStream();
    	String res = readUntil(in, null);
    	
    	in.close();
    	out.close();
    	conn.disconnect();
    	
    	if (res != null) {
    		return new String(res.getBytes("iso8859-1"), "UTF-8");
    	} else {
    		return null;
    	}
    }
    
    private String readUntil(InputStream in, String pattern) throws IOException {
        StringBuffer sb = new StringBuffer(); 
        char lastChar = (char)-1;  
        boolean flag = pattern != null && pattern.length() > 0;  
        if(flag)  
            lastChar = pattern.charAt(pattern.length() - 1);  
        char ch;  
        int code = -1;  
        while ((code = in.read()) != -1) {  
            ch = (char)code;  
            sb.append(ch);  
            //匹配到结束标识时返回结果  
            if (flag) {  
                if (ch == lastChar && sb.toString().endsWith(pattern)) {  
                    return sb.toString();  
                }  
            }
        }  
        return sb.toString();  
    }
    
    public static void main(String[] args) {
    	//String currCharset = Charset.defaultCharset().toString();
    	/*
    	String cmd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:spg=\"http://www.huawei.com/SPG\">" +
    	   "<soapenv:Header>" +
    		"<spg:ResendFlag>0</spg:ResendFlag>" +
    	     "<spg:Authentication>" +
    	         "<spg:Username>BSS_kongguanju</spg:Username>" +
    	         "<spg:Password>56DDBF1E5D96B730C032D82B829FA9C9</spg:Password>" +
    	      "</spg:Authentication>" +
    	      "<spg:MessageID>100</spg:MessageID>" +
    	   "</soapenv:Header>" +
    	   "<soapenv:Body>" +
    	      "<spg:LST_SBR>" +
    	         "<spg:IMPU>sip:+862022016@ims.kongguanju.com</spg:IMPU>" +
    	         "<spg:DSPMODE>0</spg:DSPMODE>" +
    	         "<spg:DSPOPTIMIZE>0</spg:DSPOPTIMIZE>" +
    	      "</spg:LST_SBR>" +
    	   "</soapenv:Body>" +
    	"</soapenv:Envelope>";
    	*/
    	System.out.println("Default Charset: " + Charset.defaultCharset());
    	SoapUI soap = new SoapUI("http://129.30.30.4:8080/spg");
    	System.out.println("Connecting http://129.30.30.4:8080/spg ...");
    	try {
    		soap.connect();
    		System.out.println("Connected successfully and execute command:");
        	String cmd = FileHelper.readTxtFile("config/ims/LST_SBR.xml");
        	System.out.println("Command: " + cmd);
    		String result = soap.execute(cmd);
    		System.out.println("result:");
    		System.out.println(result);
    		soap.disconnect();
    	} catch (Exception e) {
    		System.out.println(ExceptionUtil.getStackTrace(e));
    	}
    }
    
}
