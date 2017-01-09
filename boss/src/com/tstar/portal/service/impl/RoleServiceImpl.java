package com.tstar.portal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tstar.portal.dao.MenuMapper;
import com.tstar.portal.dao.RoleAclMapper;
import com.tstar.portal.dao.RoleMapper;
import com.tstar.portal.dao.UserMapper;
import com.tstar.portal.model.ResultMap;
import com.tstar.portal.model.Role;
import com.tstar.portal.model.RoleAcl;
import com.tstar.portal.service.RoleService;
import com.tstar.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper daoRole;
	@Resource
	private RoleAclMapper daoRoleAcl;
	@Resource
	private MenuMapper daoMenu;
	@Resource
	private UserMapper daoUser;
	

	public JSONArray menuJson(String roleId){
		List<Map<String, Object>> menuList = daoMenu.selectAllHasRole(roleId);
		JSONArray array = new JSONArray();
		for(int j = 0; j < menuList.size(); j++){
			Map<String, Object> menu = menuList.get(j);
			String str = "{'id':'" + menu.get("ID") + "','pId':'" + menu.get("PARENT_ID") + "','name':'" + menu.get("MENU_NAME") + "','open':'true'";
			if ("1".equals("" + menu.get("ROLE_CHECKED"))) {
				str = str + ",'checked':'true'";
			}
			str = str + "}";

			JSONObject object = JSON.parseObject(str); 
			array.add(object);
		}
		return array;
	}
	

	public List<String> checkedId(String roleId){
		List<String> ids = daoRoleAcl.selectMenuIdByRoleId(roleId);
		return ids;
		
	}

	public String[] insert(Role role) {
		role.setId(UUID.get());
		role.setAdminFlag(0);
		role.setCreateTime(new Date());
		int result = daoRole.insert(role);
		if (result > 0){
			return new String[]{"1", "添加成功!"};
		} else {
			return new String[]{"0", "添加失败!"};
		}
	}

	public String[] updateByPrimaryKey(Role role) {
		role.setUpdateTime(new Date());
		int result = daoRole.updateByPrimaryKeySelective(role);
		if( result > 0){
			return new String[]{"1", "修改成功!"};
		}else{
			return new String[]{"0", "修改失败!"};
		}
	}


	public String[] deleteByPrimaryKey(String roleId) {
		int count = daoUser.countByRoleId(roleId);
		if(count > 0){
			return new String[]{"0", "删除失败!此角色下存在用户，暂不能删除！"};
		}else{
			int result = daoRole.deleteByPrimaryKey(roleId);
			if (result > 0){
				return new String[]{"1", "删除成功!"};
			}else{
				return new String[]{"0", "删除失败!"};
			}
		}
	}

	public String[] menuUpdateByMenuId(String roleId,String menuChange) {
		String[] res = {"",""};
		int result = 0;
		String[] menuElement = menuChange.split(",");
		
		//在角色没有关联任何菜单时保存，传递进来的menuChange = ""的后，不进入for循环
		if (menuChange.equals("")){
		    result = 1;
		}
		else{
		    for(int i=0; i<menuElement.length; i++){
	            String[] menus = menuElement[i].split("-");
	            String menuId = menus[0];
	            String change = menus[1];
	            if("true".equals(change)){
	                RoleAcl menuRole = new RoleAcl();
	                menuRole.setRoleId(roleId);
	                menuRole.setMenuId(menuId);
	                menuRole.setId(UUID.get());
	                result += daoRoleAcl.insert(menuRole);
	            }else if("false".equals(change)){
	                result += daoRoleAcl.deleteByExample(roleId, menuId);
	            }
	        }
		}

		if(result>0){
			res[1]="更新成功!";
			res[0]="1";
		}else{
			res[1]="更新失败!";
			res[0]="0";			
		}
		return res;
	}

	public int countByName(Map<String, Object> map) {
		//return daoRole.countAll();
		return daoRole.countByCriteria(map);
	}
	
	public List<ResultMap> findRoleByPage(Map<String, Object> map) {
		//List<ResultMap> roleList= daoRole.selectAllRole();
		List<ResultMap> roleList= daoRole.selectByPage(map);
		return roleList;
	}
	
}
