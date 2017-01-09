package com.tstar.callcenter.dao.admin;

import java.util.List;

import com.tstar.callcenter.model.autogenerate.MenuInfo;
import com.tstar.callcenter.pub.data.ResultMap;

public interface SystemConfMapper {

	List<ResultMap>selectRoleByPage(ResultMap map);
	
	int selectRoleByCount(ResultMap map);
	
	List<MenuInfo> selectMenuByRoleId(long roleId);
	
	List<Long> selectMenuIdByRoleId(long roleId);
	
	int updateTreeByMenuId(MenuInfo record);
	
	int selectHasMenuByCount(long menuId);
	
	List<ResultMap>selectUserByPage(ResultMap map);
	
	int selectUserByCount(ResultMap map);
	
	List<ResultMap>roleSelectList();
	
	int selectUserCountByRole(ResultMap map);
	
}
