package com.mvmlabs.springboot.service.admin;

import java.util.List;

import com.mvmlabs.springboot.model.admin.UserManage;

public interface UserManageService {

	public List<UserManage> selectUserList() throws Exception;
}
