package com.tstar.portal.service;

import java.util.List;

import com.tstar.portal.model.Menu;

public interface MenuService {
	
    List<Menu> selectMenu(String roleId);
    
    //String[] updateTree(String dataChange,String data);
    
    public String[] insertMenu(Menu record);
    
    public String[] updateMenuById(Menu record);
    
    public String[] deleteMenuById(String menuId);
    
    Menu selectMenuById(String menuId);

}
