package com.spring.mvc.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.spring.mvc.dao.impl.SpitterDaoImpl;
import com.spring.mvc.pojo.Spitter;

@Controller
@RequestMapping("/file")
public class UploadController {
@Autowired
private SpitterDaoImpl spitterDaoImpl;
@Autowired
private HttpServletRequest request;
@Autowired
private HttpSession session;
@Autowired
Spitter spitter;
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String register(@RequestParam("file") MultipartFile file){
		/**
		 * 处理文件请求
		 */
		//判断是否为空
		if(file.isEmpty()){
			System.out.println("未上传头像！");
		}else{
			//定义上传位置
			String filePath=request.getSession().getServletContext().getRealPath("/")+"WEB-INF/userfile/" +
					file.getOriginalFilename();
			try {
				//转存文件
				file.transferTo(new File(filePath));
				String name=file.getName();
				System.out.println(name);
				String contentType=file.getContentType();
				System.out.println(contentType);
				spitter = spitterDaoImpl.findByUsername((String)session.getAttribute("username"));
				spitter.setLoc_img(filePath);
				spitterDaoImpl.update(spitter);
				session.setAttribute("user", spitter);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/spitter/"+spitter.getUsername();
	}
}
