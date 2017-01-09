package com.tstar.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAction {

	@RequestMapping(value="report.upload")
	public void upload(@RequestParam("reportFile") MultipartFile file, 
			HttpServletRequest request, ModelMap model) {
		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("WEB-INF/reportlets");
		System.out.println(path);
		String fileName = file.getOriginalFilename(); 
		System.out.println(fileName);
		File targetFile = new File(path, fileName);
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
