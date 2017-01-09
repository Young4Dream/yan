package com.tstar.portal.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.tstar.portal.model.Menu;
import com.tstar.portal.service.MenuService;

public class MenuAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<Menu> menuList = new ArrayList<Menu>();
	private String dataChange = "";
	private String data = "";

	/**
	 *-1代表是管理员角色，拥有菜单的所有操作权限，如果不赋值为-1，其默认为0，
	 *0已经在数据库定义为了“新增用户”这个角色的默认ID，是不能删除的，其也等
	 *同于其它角色来处理。原来在MenuServiceImpl.java文件中的selectMenu
	 *函数要判断传进来的角色ID是0认为其管理员，这样就会与“新增用户”这个角色
	 *ID冲突，所以也相应修改MenuServiceImpl.java文件中的selectMenu函数
	 *的判断，-1为管理员。
	 *另外一个需给此处赋值为-1的原因，是前台menuConf.jsp页面中菜单管理增删
	 *改操作时，会调用本文件中相应的insertMenu等函数，这些函数末尾都会调用
	 *menuTree()，这时候，由于没有办法传入roleId参数，所以就会使用默认值0，
	 *进而传递到后面MenuServiceImpl.java文件中的selectMenu函数中，又会
	 *造成错误判断，导致前台界面在增删改完菜单后，界面无法显示数据
	 */
	private String roleId = "";  
	private String menuId;
	private String res;
	private String resNum;
	private Menu menu = new Menu();
	
	@Resource
	private MenuService  menuService;
	
	public String goToMenuPage(){
		return "menuPage";
	}
	
	public String menuTree(){
		menuList = menuService.selectMenu(roleId);
		return "menuTree";
	}
	
	/*
	public String updateTree(){
		String[] r = menuService.updateTree(dataChange,data);
		resNum = r[0];
		res = r[1];
		return menuTree();
	}
	*/
	
	public String insertMenu(){
		String[] r = menuService.insertMenu(menu);
		resNum = r[0];
		res = r[1];
		return menuTree();
	}
	
	public String updateMenu(){
		String[] r = menuService.updateMenuById(menu);
		resNum = r[0];
		res = r[1];
		return menuTree();
	}
	
	public String deleteMenu(){
		String[] r = menuService.deleteMenuById(menuId);
		resNum = r[0];
		res = r[1];
		return menuTree();
	}
	
	public String selectMenuById(){
		menu = null;
		menu = menuService.selectMenuById(menuId);
		return "menuInfo";
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getDataChange() {
		return dataChange;
	}

	public void setDataChange(String dataChange) {
		this.dataChange = dataChange;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRes() {
		return res;
	}

	public String getResNum() {
		return resNum;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	


	
	
	

}
