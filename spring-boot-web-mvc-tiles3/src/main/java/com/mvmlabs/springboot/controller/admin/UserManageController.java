package com.mvmlabs.springboot.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvmlabs.springboot.service.admin.UserManageService;

@Controller
@RequestMapping("/admin")
public class UserManageController {

	private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);
	
	@Autowired
	private UserManageService userManageService;
	
	@RequestMapping(value = "/user", method=RequestMethod.GET)
	public ModelAndView user() throws Exception {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("admin.user");
	    mav.addObject("userList", userManageService.selectUserList());
	    return mav;
	}
	
	
}
