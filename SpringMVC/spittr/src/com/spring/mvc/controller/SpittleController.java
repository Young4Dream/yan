package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import static org.springframework.web.bind.annotation.RequestMethod.GET;
import com.spring.mvc.dao.SpittleDao;

@Controller
@RequestMapping("/s")
public class SpittleController {
	@Autowired
	private SpittleDao spittleDao;
	@RequestMapping//(value="spittles",method=GET)
	public ModelAndView spittles(){
		ModelAndView mv=new ModelAndView();
		Object o=spittleDao.findAll();
		mv.addObject("spittlesList", o);
		mv.setViewName("spittles");
		return mv;
	}
}
