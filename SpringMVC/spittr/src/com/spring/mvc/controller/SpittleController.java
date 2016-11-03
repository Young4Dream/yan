package com.spring.mvc.controller;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.mvc.dao.SpittleDao;
import com.spring.mvc.jdbc.DBHelper;

@Controller
@RequestMapping("/spittle")
public class SpittleController {
	@Autowired
	private SpittleDao spittleDao;
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView spittles(){
//		Connection conn=DBHelper.getConnection();
		System.out.println(DBHelper.ctx);
		ModelAndView mv=new ModelAndView();
		Object o=spittleDao.findAll();
		System.out.println(o);
		mv.addObject("spittleList", o);
		mv.setViewName("spittles");
		return mv;
	}
	@RequestMapping(value="/one",method=RequestMethod.POST)
	public String spittle(@RequestParam("id")int id,Model model){
		model.addAttribute("spittle", spittleDao.findById(id));
		return "spittle";
	}
}
