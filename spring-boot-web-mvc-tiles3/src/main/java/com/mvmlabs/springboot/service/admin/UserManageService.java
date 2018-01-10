package com.mvmlabs.springboot.service.admin;

import java.util.List;

import com.mvmlabs.springboot.model.admin.UserManage;

public interface UserManageService {

	public List<UserManage> selectUserList() throws Exception;

	public void insertUser(UserManage userManage) throws Exception;

	public UserManage selectUser(String userId) throws Exception;

	public void updateUser(UserManage userManage) throws Exception;

	public void deleteUser(String userId) throws Exception;
}
