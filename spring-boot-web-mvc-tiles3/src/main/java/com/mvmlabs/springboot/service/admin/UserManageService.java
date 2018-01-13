package com.mvmlabs.springboot.service.admin;

import java.util.List;
import java.util.Map;

import com.mvmlabs.springboot.model.admin.UserManage;

public interface UserManageService {
	
	public int selectUserTotalCnt(Map<String, Object> param) throws Exception;

	public List<UserManage> selectUserList(Map<String,Object> parma) throws Exception;

	public void insertUser(UserManage userManage) throws Exception;

	public UserManage selectUser(String userId) throws Exception;

	public void updateUser(UserManage userManage) throws Exception;

	public void deleteUser(String userId) throws Exception;

	
}
