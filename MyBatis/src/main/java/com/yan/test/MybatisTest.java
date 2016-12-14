package com.yan.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yan.dao.RoleMapper;
import com.yan.po.Role;
import com.yan.util.SqlSessionFactoryUtil;

public class MybatisTest {
public static void main(String[] args) {
	SqlSession sqlSession=null;
	try{
		sqlSession = SqlSessionFactoryUtil.openSqlSession();
		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
//		Role role =new Role();
//		role.setId(1);
//		role.setRoleName("超级管理员");
//		role.setNote("admin");
//		roleMapper.insert(role);
//		sqlSession.commit();
		Role r =new Role();
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("id", 1);
//		map.put("roleName", "超级管理员");
//		r=roleMapper.selectByUnionKey(map);
//		System.out.println("通过map:"+r);
		r=roleMapper.selectByPrimaryKey(1);
		System.out.println("通过id:"+r);
		r=roleMapper.selectByUnionKey("超级管理员", 1);
		System.out.println("通过@注解:"+r);
	}catch(Exception e){
		System.err.println("异常："+e.getMessage());
		sqlSession.rollback();
	}finally{
		if(sqlSession!=null){
			sqlSession.close();
		}
		System.exit(0);
	}
}
}
