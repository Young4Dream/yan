/**
 * 
 */
package com.tstar.web;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.RepositoryService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tstar.util.ExceptionUtil;

/**
 * @author zhumengfeng
 *
 */
@Controller
public class DeployAction {
	@Autowired
	private RepositoryService repositoryService;
	
	@RequestMapping(value="process.deploy")
	public void upload(@RequestParam("file") MultipartFile file, 
			HttpServletRequest request, ModelMap model) {
		String fileName = file.getOriginalFilename();
		System.out.println("==============================deploy...");
		System.out.println("fileName=" + fileName);
		try {
			InputStream fileInputStream = file.getInputStream();
			String extension = FilenameUtils.getExtension(fileName);
			if (extension.equals("zip") || extension.equals("bar")) {
				ZipInputStream zip = new ZipInputStream(fileInputStream);
				repositoryService.createDeployment().addZipInputStream(zip).deploy();
			} else {
				repositoryService.createDeployment().addInputStream(fileName, fileInputStream).deploy();
			}
		} catch (Exception e) {
			System.out.println("fail to deploy process, because of file input stream");
			System.out.println(ExceptionUtil.getStackTrace(e));
		}
	}
}
