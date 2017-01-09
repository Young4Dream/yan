package com.tstar.callcenter.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tstar.callcenter.dao.admin.SystemConfMapper;
import com.tstar.callcenter.dao.autogenerate.MenuInfoMapper;
import com.tstar.callcenter.model.TreeInfo;
import com.tstar.callcenter.model.autogenerate.MenuInfo;
import com.tstar.callcenter.model.autogenerate.MenuInfoExample;
import com.tstar.callcenter.pub.tools.JsonUtil;
import com.tstar.callcenter.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);
	
	@Resource
	private MenuInfoMapper menuInfoMapper;
	@Resource
	private SystemConfMapper systemConfMapper;

	public List<MenuInfo> selectMenu(long roleId) {
		// TODO Auto-generated method stub
		List<MenuInfo> menuList;
		/*
		if(roleId!=0){
			menuList = systemConfMapper.selectMenuByRoleId(roleId);
		}else{
			MenuInfoExample example = new MenuInfoExample();
			example.setOrderByClause("parent_id,menu_sort asc");
			menuList = menuInfoMapper.selectByExample(example);
		}
		*/
		if(roleId == -1){
		    MenuInfoExample example = new MenuInfoExample();
            example.setOrderByClause("parent_id,menu_sort asc");
            menuList = menuInfoMapper.selectByExample(example);
        }else{
            menuList = systemConfMapper.selectMenuByRoleId(roleId);
        }
		//menuList = systemConfMapper.selectMenuByRoleId(roleId);
		return menuList;
	}
	
	public  String[] updateTree(String dataChange,String data) {
		
		List<TreeInfo> treeList =  JsonUtil.difTree(dataChange, data);
		String[] res = {"",""};
		int result = 0;
		for(TreeInfo treeInfo:treeList){
			MenuInfo record = new MenuInfo();
			record.setUpdateTime(new Date());
			record.setMenuId(treeInfo.getId());
			record.setMenuSort(treeInfo.getSort());
			record.setParentId(treeInfo.getParentId());
			result = updateTreeByMenuId(record);
		}
		if(result>0){
			res[1]="菜单更新成功!";
			res[0]="1";
		}else{
			res[1]="菜单更新失败!";
			res[0]="0";			
		}
		
		return res;
	}
	
	
	public String[] insertMenuInfo(MenuInfo record){
		String[] res = {"",""};
		record.setCreateTime(new Date());
		int result = menuInfoMapper.insert(record);
		if(result>0){
			res[1]="菜单添加成功!";
			res[0]="1";
		}else{
			res[1]="菜单添加失败!";
			res[0]="0";			
		}
		return res;
	}
	
	public String[] updateMenuInfoById(MenuInfo record){
		String[] res = {"",""};
		record.setUpdateTime(new Date());
		int result = menuInfoMapper.updateByPrimaryKey(record);
		if(result>0){
			res[1]="菜单更新成功!";
			res[0]="1";
		}else{
			res[1]="菜单更新失败!";
			res[0]="0";			
		}
		return res;
	}
	
	public String[] deleteMenuInfoById(long menuId){
		String[] res = {"",""};
		int hasMenu = systemConfMapper.selectHasMenuByCount(menuId);
		if(hasMenu>0){
			res[1]="菜单下存在子菜单，不能删除!";
			res[0]="0";
		}else{
			int result = menuInfoMapper.deleteByPrimaryKey(menuId);
			if(result>0){
				res[1]="菜单删除成功!";
				res[0]="1";
			}else{
				res[1]="菜单删除失败!";
				res[0]="0";			
			}
		}
		return res;
	}
	
	public MenuInfo selectMenuInfoById(long menuId){
		//MenuInfo menuInfo= menuInfoMapper.selectByPrimaryKey(menuId);
		return menuInfoMapper.selectByPrimaryKey(menuId);
	}
	
	
	
	
	
	private int updateTreeByMenuId(MenuInfo record) {
		int res = systemConfMapper.updateTreeByMenuId(record);
		return res;
	}
	 
	
	
	


}
