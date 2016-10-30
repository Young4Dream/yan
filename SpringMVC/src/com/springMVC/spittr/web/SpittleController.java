package com.springMVC.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.springMVC.spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	@Autowired
	public SpittleController (SpittleRepository spittleRepository){
		this.spittleRepository=spittleRepository;
	}
	@RequestMapping(method=GET)
	public String spittles(Model model){
		model.addAttribute("spittleList",spittleRepository.findSpittle(Long.MAX_VALUE, 20));
		return "spittles";//java.lang.AssertionError: Model attribute 'spittleList' does not exist

//		model.addAttribute(spittleRepository.findSpittle(Long.MAX_VALUE, 20));
//		return "spittles";
	}
}
