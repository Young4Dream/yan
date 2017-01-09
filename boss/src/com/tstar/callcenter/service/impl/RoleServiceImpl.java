package com.tstar.callcenter.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.tstar.callcenter.dao.admin.SystemConfMapper;
import com.tstar.callcenter.dao.autogenerate.MenuInfoMapper;
import com.tstar.callcenter.dao.autogenerate.MenuRoleMapper;
import com.tstar.callcenter.dao.autogenerate.RoleInfoMapper;
import com.tstar.callcenter.model.autogenerate.MenuInfo;
import com.tstar.callcenter.model.autogenerate.MenuInfoExample;
import com.tstar.callcenter.model.autogenerate.MenuRole;
import com.tstar.callcenter.model.autogenerate.MenuRoleExample;
import com.tstar.callcenter.model.autogenerate.RoleInfo;
import com.tstar.callcenter.model.autogenerate.RoleInfoExample;
import com.tstar.callcenter.pub.data.ResultMap;
import com.tstar.callcenter.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleInfoMapper roleInfoMapper;
	@Resource
	private MenuRoleMapper menuRoleMapper;
	@Resource
	private MenuInfoMapper menuInfoMapper;
	@Resource
	private SystemConfMapper systemConfMapper;
	

	public JSONArray menuJson(List<Long> checkedId){
		MenuInfoExample example = new MenuInfoExample();
		example.setOrderByClause("parent_id,menu_sort asc");
		List<MenuInfo> menuList = menuInfoMapper.selectByExample(example);
		JSONArray array = new JSONArray();
		for(int j=0;j<menuList.size();j++){
			MenuInfo menu = menuList.get(j);
			String str = "{'id':'"+menu.getMenuId()+"','pId':'"+menu.getParentId()+"','name':'"+menu.getMenuName()+"','open':'true'";
		
			for(int i=0;i<checkedId.size();i++){
				if(menu.getMenuId()==checkedId.get(i)){
					str=str + ",'checked':'true'";
					checkedId.remove(i);
					break;
				}
			}
				str=str + "}";

			JSONObject object = JSON.parseObject(str); 
			array.add(object);
		}
		return array;
	}
	

	public List<Long> checkedId(long roleId){
		List<Long> ids = systemConfMapper.selectMenuIdByRoleId(roleId);
		return ids;
		
	}
	

	public List<RoleInfo> selectByExample(RoleInfo roleInfo){
		RoleInfoExample example = new RoleInfoExample();
		RoleInfoExample.Criteria criteria = example.createCriteria();
		if(roleInfo!=null){
			if(roleInfo.getRoleName()!=null){
				if(!roleInfo.getRoleName().equals(""))
				criteria.andRoleNameEqualTo(roleInfo.getRoleName());
			}
			if(roleInfo.getIsAdmin()!=0){
				criteria.andIsAdminEqualTo(roleInfo.getIsAdmin());
			}	
		}
		List<RoleInfo> roleList= roleInfoMapper.selectByExample(example);
		return roleList;
	}


	public String[] insert(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		String[] res = {"",""};
		roleInfo.setCreateTime(new Date());
		//int result = roleInfoMapper.insert(roleInfo);
		int result = roleInfoMapper.insertSelective(roleInfo);
		if(result>0){
			res[1]="添加成功!";
			res[0]="1";
		}else{
			res[1]="添加失败!";
			res[0]="0";			
		}
		return res;
	}


	public String[] updateByPrimaryKey(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		String[] res = {"",""};
		//roleInfo.setCreateTime(roleInfo.getCreateTime());
		roleInfo.setUpdateTime(new Date());
		int result = roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
		if(result>0){
			res[1]="修改成功!";
			res[0]="1";
		}else{
			res[1]="修改失败!";
			res[0]="0";			
		}
		return res;
	}


	public String[] deleteByPrimaryKey(long roleId) {
		// TODO Auto-generated method stub
		String[] res = {"",""};
		ResultMap param = new ResultMap();
		param.put("role_id", roleId);
		int userCount = systemConfMapper.selectUserCountByRole(param);
		if(userCount>0){
			res[1]="删除失败!此角色下存在用户，暂不能删除！";
			res[0]="0";	
		}else{
			int result = roleInfoMapper.deleteByPrimaryKey(roleId);
			if(result>0){
				res[1]="删除成功!";
				res[0]="1";
			}else{
				res[1]="删除失败!";
				res[0]="0";			
			}
		}
		return res;
	}


	public String[] menuUpdateByMenuId(long roleId,String menuChange) {
		// TODO Auto-generated method stub
		String[] res = {"",""};
		int result = 0;
		String[] menuElement = menuChange.split(",");
		
		//在角色没有关联任何菜单时保存，传递进来的menuChange = ""的后，不进入for循环
		if (menuChange.equals("")){
		    result = 1;
		}
		else{
		    for(int i=0;i<menuElement.length;i++){
	            String[] menus = menuElement[i].split("-");
	            String menuId = menus[0];
	            String change = menus[1];
	            if("true".equals(change)){
	                MenuRole menuRole = new MenuRole();
	                menuRole.setRoleId(roleId);
	                menuRole.setMenuId(Long.parseLong(menuId));
	                result += menuRoleMapper.insert(menuRole);
	            }else if("false".equals(change)){
	                MenuRoleExample example = new MenuRoleExample();
	                example.createCriteria().andRoleIdEqualTo(roleId).andMenuIdEqualTo(Long.parseLong(menuId));
	                result += menuRoleMapper.deleteByExample(example);
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


	public int findRoleByCount(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		ResultMap map = new ResultMap();
		if(roleInfo!=null){
			if(roleInfo.getRoleName()!=null){
				if(!roleInfo.getRoleName().equals(""))
					map.put("role_name", roleInfo.getRoleName());
			}
			if(roleInfo.getIsAdmin()!=0){
				map.put("is_admin", roleInfo.getIsAdmin());
			}	
		}
		return systemConfMapper.selectRoleByCount(map);
	}


	public List<ResultMap> findRoleByPage(RoleInfo roleInfo,int start,int length) {
		// TODO Auto-generated method stub
		ResultMap map = new ResultMap();
		if(roleInfo!=null){
			if(roleInfo.getRoleName()!=null){
				if(!roleInfo.getRoleName().equals(""))
					map.put("role_name", roleInfo.getRoleName());
			}
			if(roleInfo.getIsAdmin()!=0){
				map.put("is_admin", roleInfo.getIsAdmin());
			}	
		}
//		map.put("pageSize", length);
//		map.put("offset", start);
		PageHelper.startPage(start/length+1, length);
		List<ResultMap> roleList= systemConfMapper.selectRoleByPage(map);
		for(ResultMap role:roleList){
			if("1".equals(role.getAttribute("isAdmin"))){
				role.setAttribute("isAdminZH", "是");
			}else if("-1".equals(role.getAttribute("isAdmin"))){
				role.setAttribute("isAdminZH", "否");
			}
		}
		return roleList;
	}
	

}
