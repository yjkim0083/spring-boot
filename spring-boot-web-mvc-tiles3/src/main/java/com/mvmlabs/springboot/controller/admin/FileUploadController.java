package com.mvmlabs.springboot.controller.admin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/admin")
public class FileUploadController {

	@Value("${upload.path}")
	private String uploadPath;
	
	@RequestMapping("/fileExample")
	public String filePage() {
		return "admin.fileExample";
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	@ResponseBody
	//public String fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("userName") String userName) throws Exception {
	public String fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("userName") String userName) throws Exception {
		
		System.out.println("userName:" + userName);
		
		// 파일이 비어있을 경우
		if(file.isEmpty()) {
			return "file is empty!";
		}
		
		byte[] bytes = file.getBytes();
		Path path = Paths.get(uploadPath + "/" + file.getOriginalFilename());
		
		Files.write(path, bytes);
		
		return "success";
	}
}
