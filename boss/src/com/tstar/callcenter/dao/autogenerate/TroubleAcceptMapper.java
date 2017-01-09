package com.tstar.callcenter.dao.autogenerate;



import com.tstar.callcenter.pub.data.ResultMap;


public interface TroubleAcceptMapper {
	
	//查询用户信息
	//public List<ResultMap> selectTrouUser(ResultMap map);
	public void selectTrouUser(ResultMap map);
	
	//查询故障类型
	public void selectTrouType(ResultMap map);
	
	//查询故障历史
	public void selectTrouHist(ResultMap map);
	
	//查询故障工单流转
	public void selectWorkFlow(ResultMap map);
	
	//新增历史故障
	public void insertTrouble(ResultMap map);

	//获取操作员信息
	public void selectLoginUser(ResultMap map);
	
	//对输入的电话号码进行校验
    public ResultMap checkDh(String dh);
    
    //对输入的宽带号码进行校验
    public ResultMap checkBroad(String account);

}
