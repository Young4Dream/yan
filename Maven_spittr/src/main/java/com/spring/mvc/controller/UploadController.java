package com.spring.mvc.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String register(MultipartFile file){
		/**
		 * 处理文件请求
		 */
		//判断是否为空
		if(file.isEmpty()){
			Spitter s=(Spitter) session.getAttribute("user");
			System.out.println("未上传头像！");
			return "redirect:/spitter/"+s.getUsername();
		}else{
			Spitter spitter=new Spitter();
			//定义上传位置
			String filePath=request.getSession().getServletContext().getRealPath("/")+"WEB-INF/userfile/" +
					file.getOriginalFilename();
			try {
				//转存文件
				file.transferTo(new File(filePath));
				String name=file.getName();
				System.out.println("file.getName():"+name);
				String contentType=file.getContentType();
				System.out.println("file.getContentType():"+contentType);
				System.out.println("filePath"+filePath);
				spitter = (Spitter) session.getAttribute("user");
				String username=spitter.getUsername();
				if(!username.equals("") || username!=null){
					System.out.println("通过session属性获取用户名："+username);
					spitter=spitterDaoImpl.findByUsername(username);
					System.out.println("通过findByUsername获取的id："+spitter.getId());
					spitter.setLoc_img(filePath);
					spitterDaoImpl.update(spitter);
					session.setAttribute("user", spitter);
				}
				return "redirect:/spitter/"+username;
			} catch (Exception e) {
				return null;
			}
			
		}
	}
}
