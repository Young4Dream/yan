package com.spring.mvc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.mvc.dao.SpittleDao;
import com.spring.mvc.pojo.Spittle;
import com.spring.mvc.web.SpittleNotFoundException;

@Controller
@RequestMapping("/spittle")
public class SpittleController {
	@Autowired
	private SpittleDao spittleDao;
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView spittles(){
		ModelAndView mv=new ModelAndView();
		Object o=spittleDao.findAll();
		mv.addObject("spittleList", o);
		mv.setViewName("spittles");
		return mv;
	}
	/**
	 * 通过路径参数接受请求，直接使用？传参
	 * @param id
	 * @param model
	 * @return
	 */
//	@RequestMapping(value="/one",method=RequestMethod.GET)
//	public String spittle(@RequestParam("id")int id,Model model){
//		model.addAttribute("spittle", spittleDao.findById(id));
//		return "spittle";
//	}
	/**
	 * RESTful风格，使用@PathVariable实现
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String spittle(@PathVariable("id")int id,Model model){
		Spittle spittle=spittleDao.findById(id);
		if(spittle==null){
			throw new SpittleNotFoundException();
		}
		model.addAttribute("spittle", spittle);
		return "spittle";
	}
	/**
	 * 实现增加message的post请求
	 */
	@RequestMapping(value="list",method=RequestMethod.POST)
	public ModelAndView add(ModelAndView mv){
		Spittle s=new Spittle();
		s.setMessage((String) mv.getModelMap().get("message"));
		s.setId(27L);
		s.setTime(new Date());
		s.setLatitude(13.4);
		s.setLongitude(140.21);
		spittleDao.add(s);
		mv.setViewName("redirect:/spittle/list");
		return mv;
	}
}
