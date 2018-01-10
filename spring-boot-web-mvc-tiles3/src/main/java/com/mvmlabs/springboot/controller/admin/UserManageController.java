package com.mvmlabs.springboot.controller.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvmlabs.springboot.model.admin.UserManage;
import com.mvmlabs.springboot.service.admin.UserManageService;

@Controller
@RequestMapping("/admin")
public class UserManageController {

	private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);
	
	@Autowired
	private UserManageService userManageService;
	
	/**
	 * /admin/user 페이지 이동
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user", method=RequestMethod.GET)
	public String user() throws Exception {
	    return "admin.user";
	}
	
	/**
	 *  /admin/user 화면에서 list 조회
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/list", method=RequestMethod.GET)
	@ResponseBody
	public List<UserManage> getUserList() throws Exception {
		return userManageService.selectUserList();
	}
	
	/**
	 *  /admin/user/add 페이지 이동
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/add", method=RequestMethod.GET)
	public String addUser() throws Exception {
		return "admin.user.add";
	}
	
	/**
	 *  /admin/user/add 화면에서 추가기능
	 * @param userManage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user", method=RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody UserManage userManage) throws Exception {
		userManageService.insertUser(userManage);
		return "success";
	}
	
	/**
	 *  /admin/user/{userId} : 수정화면 페이지 이동
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/{userId}", method=RequestMethod.GET)
	public ModelAndView user(@PathVariable(value="userId") String userId) throws Exception {
	    return new ModelAndView("admin.user.edit", "userId", userId);
	}
	
	/**
	 *  유저 수정화면의 유저 정보 조회
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/info/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public UserManage getUserInfo(@PathVariable(value="userId") String userId) throws Exception {
	    return userManageService.selectUser(userId);
	}
	
	
	/**
	 * 유저 수정
	 * @param userManage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user", method=RequestMethod.PUT)
	@ResponseBody
	public String editUserInfo(@RequestBody UserManage userManage) throws Exception {
		userManageService.updateUser(userManage);
		return "success";
	}
	
	/**
	 *  유저 삭제
	 * @param userManage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@RequestBody UserManage userManage) throws Exception {
		userManageService.deleteUser(userManage.getUserId());
		return "success";
	}
	
	
}
