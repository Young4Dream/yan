/**
 * Telnet工具
 */
package com.tstar.ac.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;

import org.apache.commons.net.telnet.TelnetClient;

/**
 * @author zhumengfeng
 *
 */
public class Telnet {

	private static final char PROMPT_CHAR_1 = '>';
	
    private TelnetClient telnet = new TelnetClient();
    private PrintStream out;
    private InputStream in;
    
    private String host;									
    private int port; 								    
    private boolean connected;
    
    public Telnet(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public boolean getConnected() { return this.connected; }
    
    public void connect() throws SocketException, IOException {
    	telnet.connect(host, port);
        out = new PrintStream(telnet.getOutputStream());
        in = telnet.getInputStream();
        connected = true;
    }
    
    public void disconnect() throws IOException {
    	telnet.disconnect();
    	connected = false;
    }
    
    public String readUntil(String pattern) throws IOException {
    	String p = null;
    	if (pattern == null) {
    		p = ";";
    	} else {
    		p = pattern;
    	}
        StringBuffer sb = new StringBuffer(); 
            char lastChar = (char)-1;  
            boolean flag = p != null && p.length() > 0;  
            if(flag)  
                lastChar = p.charAt(p.length() - 1);  
            char ch;  
            int code = -1;  
            while ((code = in.read()) != -1) {  
                ch = (char)code;  
                sb.append(ch);  
                //Log.getLogger().info("" + ch);
                //匹配到结束标识时返回结果  
                if (flag) {  
                    if (ch == lastChar && sb.toString().endsWith(p)) {  
                        return sb.toString();  
                    }  
                }else{  
                    //如果没指定结束标识,匹配到默认结束标识字符时返回结果  
                    if(ch == PROMPT_CHAR_1)  
                        return sb.toString();  
                }  
                //登录失败时返回结果  
                if(sb.toString().contains("Login Failed")){  
                    return sb.toString();  
                }  
            }  
        return sb.toString();  
    }
    
    public String execute(String cmd) throws IOException {
    	out.println(cmd);
    	out.flush();
    	return readUntil(null);
    }
    
    public String execute(String cmd, String prompt) throws IOException {
    	out.println(cmd);
    	out.flush();
    	return readUntil(prompt);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Telnet telnet = new Telnet("172.22.61.14", 9819);
		telnet.connect();
		
		String cmd;
		String res;
		
		cmd = "LOGIN:::CTAG::UN=beixiangjiekou,PWD=N2000N2000;";
		System.out.println(cmd);
		res = telnet.execute(cmd, ";");
		System.out.println(new String(res.getBytes("iso8859-1"), "GBK"));
		
		cmd = "DEL-ONT::DEV=172.22.70.182,FN=0,SN=16,PN=7,ONTID=19:6::;";
		System.out.println(cmd);
		res = telnet.execute(cmd, ";");
		System.out.println(new String(res.getBytes("iso8859-1"), "GBK"));
		
		cmd = "ADD-ONT::DEV=172.22.70.182,FN=0,SN=16,PN=7,ONTID=19:6::NAME=松江区5001,LINEPROF=HG8120_line,SRVPROF=HG8120_yewu,SERIALNUM=4857544341124623,AUTH=SN,VENDORID=HWTC,EQUIPMENTID=313230,MAINSOFTVERSION=V1R003C01S108,VAPROFILE=HG8120_VOIP,BUILDTOPO=TRUE;";
		System.out.println(cmd);
		res = telnet.execute(cmd, ";");
		System.out.println(new String(res.getBytes("iso8859-1"), "GBK"));
		
		cmd = "LOGOUT:::CTAG::;";
		System.out.println(cmd);
		res = telnet.execute(cmd, ";");
		System.out.println(new String(res.getBytes("iso8859-1"), "GBK"));
		
		telnet.disconnect();
	}

}
