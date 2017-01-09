package com.tstar.callcenter.service.impl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import oracle.sql.CLOB;

import org.springframework.stereotype.Service;

import com.tstar.callcenter.dao.autogenerate.TroubleAcceptMapper;
import com.tstar.callcenter.model.InsertTrouble;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.TroubleAcceptService;

@Service
public class TroubleAcceptServiceImpl implements TroubleAcceptService{
	
	@Resource
	TroubleAcceptMapper troubleAcceptMapper;
	
	private int trouUserCount;
	private int workFlowCount;

	public int findTrouHistByCount(String jobtype, String thiskey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<ResultMap> findTrouHist(String jobtype, String thiskey) throws  IOException {
		// TODO Auto-generated method stub
		List<ResultMap> trouHistList = new ArrayList<ResultMap>();
		if(jobtype!=null&&thiskey!=null){
			ResultMap params = new ResultMap();
			params.put("v_faulttype", jobtype);
			params.put("v_account", thiskey);
			params.put("cv_1", new ArrayList<ResultMap>());//传入一个jdbc游标，用于接收返回参数
			troubleAcceptMapper.selectTrouHist(params);
			trouHistList = (List<ResultMap>) params.get("cv_1");
			for(int i=0;i<trouHistList.size();i++){
				try {
					trouHistList.get(i).setAttribute("address", ClobToString((CLOB)trouHistList.get(i).get("address")));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return trouHistList;
	}

	@SuppressWarnings("unchecked")
	public List<ResultMap> findTrouType(String jobtype) {
		// TODO Auto-generated method stub
		ResultMap params = new ResultMap();

		int type = 0;
		if(jobtype.equals("112fault")){
			type=1;
		}else if(jobtype.equals("radfault")){
			type=2;
		}else if(jobtype.equals("radfault")){
			type=3;
		}
		
		params.put("v_businesstype", type);
		params.put("v_f", new ArrayList<ResultMap>());//传入一个jdbc游标，用于接收返回参数
		troubleAcceptMapper.selectTrouType(params);
		List<ResultMap> typesList = (List<ResultMap>)params.get("v_f");
		return typesList;
	}

	@SuppressWarnings("unchecked")
	public List<ResultMap> findTrouUser(String jobtype, String thiskey, String queryType, String moreField,
            String exact, int start, int length) {
		// TODO Auto-generated method stub
		ResultMap params = new ResultMap();
		params.put("v_faulttype", jobtype);
		params.put("v_value", thiskey);
		params.put("v_querytype", queryType);//查询哪个字段，1用户号码，2用户名称，3用户地址
		params.put("v_morefield", moreField);//是否多字段查询，1多字段，0单字段
		params.put("v_exact", exact);//是否精确查询，1精确查询，0模糊查询
		params.put("v_start", start + "");//分页，本页开始
		params.put("v_end", start + length + "");//分页，本页结束
		params.put("cv_1", new ArrayList<ResultMap>());//传入一个jdbc游标，用于接收返回参数
		troubleAcceptMapper.selectTrouUser(params);
		setTrouUserCount(Integer.parseInt(String.valueOf(params.get("v_count"))));
		List<ResultMap> usersList = (List<ResultMap>)params.get("cv_1");
		return usersList;
	}

	@SuppressWarnings("unchecked")
	public List<ResultMap> findworkFlow(String queryStr){
		// TODO Auto-generated method stub
		ResultMap params = new ResultMap();
		List<ResultMap> workFlow = new ArrayList<ResultMap>();
		if(queryStr != null){
			params.put("v_QueryStr", queryStr);
			params.put("cv_1", new ArrayList<ResultMap>());//传入一个jdbc游标，用于接收返回参数
			troubleAcceptMapper.selectWorkFlow(params);
			setWorkFlowCount(Integer.parseInt(String.valueOf(params.get("v_count"))));
			workFlow = (List<ResultMap>)params.get("cv_1");
			
			/*
			for(int i=0;i<workFlow.size();i++){
				try {
					try {
						workFlow.get(i).setAttribute("bz", ClobToString((CLOB)workFlow.get(i).get("bz")));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		}
		return workFlow;
	}

	@SuppressWarnings("unchecked")
	public String[] insertTrouble(InsertTrouble insertTrouble) {
		// TODO Auto-generated method stub
		ResultMap params = new ResultMap();
		String result = "";
		String paramStr = "";
		String[] res = {"",""};
		
		paramStr+="jobtype="+insertTrouble.getJobtype()+";";
		paramStr+="thiskey="+insertTrouble.getThiskey()+";";
		paramStr+="gzxx="+insertTrouble.getGzxx()+";";
		paramStr+="linkphone="+insertTrouble.getLinkphone()+";";
		paramStr+="linkman="+insertTrouble.getLinkman()+";";
		paramStr+="sSlbm="+insertTrouble.getSslbm()+";";
		paramStr+="jlry="+insertTrouble.getJlry()+";";
		paramStr+="ywarea="+insertTrouble.getYwarea()+";";
		paramStr+="username="+insertTrouble.getUsername()+";";
		paramStr+="address="+insertTrouble.getAddress()+";";
		paramStr+="usertype="+insertTrouble.getUsertype()+";";
		paramStr+="callerid="+insertTrouble.getCallerid()+";";
		paramStr+="bz="+insertTrouble.getBz()+";";
		paramStr+="userid="+insertTrouble.getUserid()+";";
		paramStr+="datatype="+insertTrouble.getDatatype();
		

		
		
		System.out.println("paramStr-----------------------:  "+paramStr);
		
		
		List<ResultMap> cvmap = new ArrayList<ResultMap>();
		ResultMap m = new ResultMap();
		m.put("res", "a");
		cvmap.add(m);
		
		params.put("v_querystr", paramStr);
		params.put("cv_1", cvmap);//传入一个jdbc游标，用于接收返回参数
		//params.put("cv_1", new ArrayList<ResultMap>());//传入一个jdbc游标，用于接收返回参数
		troubleAcceptMapper.insertTrouble(params);
		List<ResultMap> resMap = (List<ResultMap>)params.get("cv_1");
		result = resMap.get(0).getAttribute("res");
		if(result.equals("OK")){
			res[1]="添加成功!";
			res[0]="1";
		}else{
			res[1]="添加失败!";
			res[0]="0";			
		}
		return res;
	}
	
 
	
	public static String ClobToString(CLOB clob) throws SQLException, IOException { 

		String reString = ""; 
		Reader is = clob.getCharacterStream();// 得到流 
		BufferedReader br = new BufferedReader(is); 
		String s = br.readLine(); 
		StringBuffer sb = new StringBuffer(); 
		while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING 
		sb.append(s); 
		s = br.readLine(); 
		} 
		reString = sb.toString(); 
		return reString; 
		}

    public int getTrouUserCount() {
        return trouUserCount;
    }

    public void setTrouUserCount(int trouUserCount) {
        this.trouUserCount = trouUserCount;
    }

    public ResultMap checkDh(String dh){
        return troubleAcceptMapper.checkDh(dh);
    }
    
    public ResultMap checkBroad(String account){
        return troubleAcceptMapper.checkBroad(account);
    }

    public int getWorkFlowCount() {
        return workFlowCount;
    }

    public void setWorkFlowCount(int workFlowCount) {
        this.workFlowCount = workFlowCount;
    }
}
