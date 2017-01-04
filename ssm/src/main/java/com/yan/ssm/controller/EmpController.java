package com.yan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yan.ssm.pojo.Emp;
import com.yan.ssm.service.impl.EmpServiceImpl;
@Controller
public class EmpController {
	@Autowired
EmpServiceImpl empServiceImpl;
	@RequestMapping(name="/emps",method=RequestMethod.GET)
	@ResponseBody
	public Emp getEmp(){
		Emp emp=new Emp();
		emp=empServiceImpl.selectByPrimaryKey((short) 7369);
		return emp;
	}
}
