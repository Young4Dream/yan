package com.tstar.portal.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tstar.portal.dao.MenuMapper;
import com.tstar.portal.model.Menu;
import com.tstar.portal.service.MenuService;
import com.tstar.util.UUID;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Resource
	private MenuMapper daoMenu;
	
	public List<Menu> selectMenu(String roleId) {
		if (roleId == null || "".equals(roleId)) {
			return daoMenu.selectAll();
		} else {
			return daoMenu.selectByRoleId(roleId);
		}
	}
	
	/*
	public  String[] updateTree(String dataChange,String data) {
		List<TreeInfo> treeList =  JsonUtil.difTree(dataChange, data);
		String[] res = {"",""};
		int result = 0;
		for(TreeInfo treeInfo : treeList){
			Menu record = new Menu();
			record.setUpdateTime(new Date());
			record.setId(treeInfo.getId());
			record.setDisOrder(treeInfo.getSort());
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
	*/
	
	public String[] insertMenu(Menu record){
		record.setId(UUID.get());
		record.setStatus(0);
		record.setCreateTime(new Date());
		int result = daoMenu.insert(record);
		if(result > 0){
			return new String[]{"1", "菜单添加成功!"};
		}else{
			return new String[]{"0", "菜单添加失败!"};
		}
	}
	
	public String[] updateMenuById(Menu record){
		record.setUpdateTime(new Date());
		int result = daoMenu.updateByPrimaryKeySelective(record);
		if(result > 0){
			return new String[]{"1", "菜单修改成功!"};
		}else{
			return new String[]{"0", "菜单修改失败!"};
		}
	}
	
	public String[] deleteMenuById(String menuId){
		int count = daoMenu.countChild(menuId);
		if (count > 0){
			return new String[]{"0", "菜单下存在子菜单，不能删除!"};
		} else {
			int result = daoMenu.deleteByPrimaryKey(menuId);
			if (result > 0) {
				return new String[]{"1", "菜单删除成功!"};
			}else{
				return new String[]{"0", "菜单删除失败!"};
			}
		}
	}
	
	public Menu selectMenuById(String menuId){
		return daoMenu.selectByPrimaryKey(menuId);
	}
	
	/*
	private int updateTreeByMenuId(Menu record) {
		int res = systemConfMapper.updateTreeByMenuId(record);
		return res;
	}
	*/
	
}
