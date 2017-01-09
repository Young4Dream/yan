package com.tstar.callcenter.pub.tools;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tstar.callcenter.model.JsonInfo;
import com.tstar.callcenter.model.TreeInfo;

/**
 * json类
 * @author lixm
 *	2015 4-30
 */
public class JsonUtil {

	private static final Logger logger = Logger.getLogger(JsonUtil.class);
	
	/**
	 * 两个长度相同的，id相同的TreeInfo,找出不同的e
	 * @param class1 
	 * @param String jsStr
	 * @return List<MenuInfo> menuList
	 */
	
	public static List<TreeInfo> difTree(String dataChange,String data){
		List<TreeInfo> dataChangeList = paresJsonToTreeInfo(dataChange);
		List<TreeInfo> dataList = paresJsonToTreeInfo(data);
		List<TreeInfo> difTree = new ArrayList<TreeInfo>();
		difTree = ListUtil.compareTo(dataChangeList, dataList);
		return difTree;
		
	}
	
	/**
	 * 解析String类型的json=>List<TreeInfo>
	 * json 格式 例子     String str="[{'id':1,'children':[{'id':2},{'id':3}]},{'id':4,'children':[]}]";
	 * @param String jsStr
	 * @return List<MenuInfo> menuList
	 */
	
	public static List<TreeInfo> paresJsonToTreeInfo(String jsStr){
		List<TreeInfo> treeList = new ArrayList<TreeInfo>();
		if(jsStr==null||"".equals(jsStr)){
			logger.error("JsonUtil.class-------error:"+"参数为空");
			return treeList;
		}
		JSONArray list= JSON.parseArray(jsStr);
		String[] strArray = {""};
		
		jsonToObject(list,0,strArray,treeList);
		
		return treeList;
	}
	
	/**
	 * 私有方法
	 * 递归解析
	 * @param  JSONArray list, 要解析的JSONArray
	 * 		   long parentId,  父节点的id
	 * 		   String[] strArray, children 数组
	 * 		   List<MenuInfo> menuList 得到的list
	 */
	private static void jsonToObject( JSONArray list, long parentId, String[] strArray, List<TreeInfo> treeList){
		for(int i=0;i<list.size();i++){
			TreeInfo treeInfo = new TreeInfo();
			JsonInfo jsonInfo = JSON.parseObject(list.get(i).toString(),JsonInfo.class);

			treeInfo.setId(jsonInfo.getId());
			treeInfo.setSort(i+1);
			treeInfo.setParentId(parentId);
			treeList.add(treeInfo);
			
			if(jsonInfo.getChildren()!=null){
				strArray=jsonInfo.getChildren();
				String str= StringUtil.connect(strArray);
				JSONArray JsonArray= JSON.parseArray("["+str+"]");
				jsonToObject(JsonArray,treeInfo.getId(),strArray,treeList);
			}
		}
	}
	


}
