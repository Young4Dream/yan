package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.spring.mvc.dao.impl.SpitterDaoImpl;
import com.spring.mvc.pojo.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	@Autowired CookieLocaleResolver resolver; 
	@Autowired
	CommonsMultipartResolver multipartResolver;
	@Autowired
    HttpServletRequest request;
	@Autowired
	HttpSession session;
    //@Autowired SessionLocaleResolver resolver; 
      
    /** 
     * 语言切换 
     */
    @RequestMapping("language") 
    public ModelAndView language(HttpServletRequest request,HttpServletResponse response,String language){ 
          
        language=language.toLowerCase(); 
        if(language==null||language.equals("")){ 
            return new ModelAndView("redirect:/"); 
        }else{ 
            if(language.equals("zh_cn")){ 
                resolver.setLocale(request, response, Locale.CHINA ); 
            }else if(language.equals("en")){ 
                resolver.setLocale(request, response, Locale.ENGLISH ); 
            }else{ 
                resolver.setLocale(request, response, Locale.CHINA ); 
            } 
        } 
          
        return new ModelAndView("redirect:/"); 
    } 

	@Autowired
	private SpitterDaoImpl spitterDaoImpl;
	/**
	 * 前往注册页面
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		return "registerForm";
	}
	/**
	 * 实现添加功能，完成后跳转至个人信息
	 * @param s
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(MultipartFile file,@Valid Spitter spitter,Errors errors){
		if(errors.hasErrors()){
			//取得所有验证未通过的error，遍历打印
			List<ObjectError> list=new ArrayList<ObjectError>();
				list=errors.getAllErrors();
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i).getDefaultMessage());
				}
			System.out.println(spitter);
			System.out.println("属性验证未通过");
			return "registerForm";
		}
		spitter.setLoc_img("null");
		try {
			spitterDaoImpl.add(spitter);
			session.setAttribute("user", spitter);
			if(session.getAttribute("user") !=null){
				System.out.println("session属性添加成功："+(Spitter)session.getAttribute("user"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/spitter/"+spitter.getUsername();
	}
//	@RequestMapping(value="/register",method=RequestMethod.POST)
//	public String register(@RequestParam("firstName") @Valid String firstName,Errors error,
//			@RequestParam  @Valid String lastName, Errors e,
//			@Valid @RequestParam String email,Errors err,
//			@RequestParam @Valid String username,Errors errs,
//			@RequestParam @Valid String password,Errors error1){
//		if(e.hasErrors()){
//			return "registerForm";
//		}
//		Spitter s=new Spitter(firstName,lastName,email,username,password);
//		System.out.println(s);
//		spitterDaoImpl.add(s);
//		return "redirect:/spitter/"+s.getUsername();
//	}
	/**
	 * 获取个人信息
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable("name") String username,Model model){
		Spitter s=spitterDaoImpl.findByUsername(username);
		System.out.println("传入的参数为："+username);
		System.out.println(s);
		model.addAttribute("spitter",s);
		return "profile";
	}
	public SpitterDaoImpl getSpitterDaoImpl() {
		return spitterDaoImpl;
	}
	public void setSpitterDaoImpl(SpitterDaoImpl spitterDaoImpl) {
		this.spitterDaoImpl = spitterDaoImpl;
	}
}
