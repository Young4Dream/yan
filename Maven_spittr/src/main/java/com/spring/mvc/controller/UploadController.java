package com.spring.mvc.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class UploadController {
//        http://blog.csdn.net/a1314517love/article/details/24183273
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
@RequestMapping(value={"upload"},method=RequestMethod.POST)
public ModelAndView upload(@RequestParam(value="file",required=false) CommonsMultipartFile file,HttpServletRequest request){
		String path=request.getSession().getServletContext().getRealPath("upload");
		String fileName=file.getOriginalFilename();
        System.out.println(path); 
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
            file.transferTo(targetFile); 
            System.out.println("图片上传完成！");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
	return null;
}
}
