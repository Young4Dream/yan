package com.yan.ssm.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.ssm.pojo.Emp;
import com.yan.ssm.pojo.EmpExample;
import com.yan.ssm.service.impl.EmpServiceImpl;

@Controller
public class EmpController {
	@Autowired
	EmpServiceImpl empServiceImpl;

	@RequestMapping(name = "/emps", method = GET)
	@ResponseBody
	public List<Emp> getEmp() {
		EmpExample example = new EmpExample();
		return empServiceImpl.selectByExample(example);
	}
}
