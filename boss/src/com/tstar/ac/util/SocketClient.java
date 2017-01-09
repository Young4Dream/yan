/**
 * 
 */
package com.tstar.ac.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author zhumengfeng
 *
 */
public class SocketClient {

	private static final String CODING = "GBK";
	private static final String STREAM_END = "END";
	
	private Socket socket;
    private String host;									
    private int port; 								    
    private boolean connected;
    
    private OutputStream out;
    private InputStream in;
    
    public SocketClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public boolean getConnected() { return this.connected; }
    
    public void connect() throws IOException, UnknownHostException {
    	//socket = new Socket();
    	//socket.bind(new InetSocketAddress("188.2.64.225", 7654));
    	//socket.connect(new InetSocketAddress(host, port));
    	socket = new Socket(host, port);
    	out = socket.getOutputStream();
    	in = socket.getInputStream();
    	connected = true;
    }
    
    public void disconnect() throws IOException {
    	socket.close();
    	connected = false;
    }
    
    public String readUntil(String pattern) throws IOException {
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
                //Log.getLogger().info("" + ch);
                //匹配到结束标识时返回结果  
                if (flag) {  
                    if (ch == lastChar && sb.toString().endsWith(pattern)) {  
                        return sb.toString();  
                    }  
                }
            }  
        return sb.toString();  
    }
    
    public String execute(String cmd) throws IOException {
    	out.write(cmd.getBytes(CODING));
    	out.flush();
    	String res = readUntil(STREAM_END);
    	if (res != null) {
    		return new String(res.getBytes("iso8859-1"), "GBK");
    	} else {
    		return null;
    	}
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		//while (true) {
			System.out.println("************************ CC08测试 ************************" );
			System.out.println("0 退出");
			System.out.println("1单向停机");
			System.out.println("2单向复机");
			System.out.println("3双向停机");
			System.out.println("4双向复机");
			System.out.println("5来电显示");
			System.out.println("6取消来显");
			System.out.println("J0本局");
			System.out.println("J1市话");
			System.out.println("J2IP");
			System.out.println("J3国内");
			System.out.println("J4国际");
			//Scanner sc = new Scanner(System.in);
			System.out.print("请选择功能：");
			//String cmd = sc.nextLine();
			String cmd = "J2";
			//if ("0".equals(cmd)) break;
			System.out.print("请输入号码:");
			//String phone = sc.nextLine();
			String phone = "25233";
			//if ("".equals(phone)) continue;
			String command = "";
			if ("1".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",UT=OF;";
			} else if ("2".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",UT=NRM;";
			} else if ("3".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",PS=STOP;";
			} else if ("4".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",PS=RES;";
			} else if ("5".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",NS=RIS-1;";
			} else if ("6".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",NS=RIS-0;";
			} else if ("J0".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",LMTGRP=9;";
			} else if ("J1".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",LMTGRP=0;";
			} else if ("J2".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",LMTGRP=5;";
			} else if ("J3".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",LMTGRP=2;";
			} else if ("J4".equals(cmd)) {
				command = "MOD ST:D=K'" + phone + ",LMTGRP=3;";
			} else {
				System.out.println("未知的命令，请重选");
				return;
				//continue;
			}
			System.out.println("connecting 129.9.200.10:6000 ...");
			SocketClient socket = new SocketClient("129.9.200.10", 6000);
			socket.connect();
			System.out.println("login:");
			String res = socket.execute("LGI:OP=yxsh,PWD=22007;");
			System.out.println(res.trim());
			res = socket.execute(command);
			System.out.println(res.trim());
			socket.disconnect();
		//}
	}

}
