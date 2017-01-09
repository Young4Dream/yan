package com.tstar.callcenter.service;

import java.util.List;

import com.tstar.callcenter.model.autogenerate.MenuInfo;

public interface MenuService {
	
    List<MenuInfo> selectMenu(long roleId);
    
    String[] updateTree(String dataChange,String data);
    
    public String[] insertMenuInfo(MenuInfo record);
    
    public String[] updateMenuInfoById(MenuInfo record);
    
    public String[] deleteMenuInfoById(long menuId);
    
    MenuInfo selectMenuInfoById(long menuId);

}
