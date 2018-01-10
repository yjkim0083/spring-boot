package com.mvmlabs.springboot.service.admin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvmlabs.springboot.dao.admin.UserManageDAO;
import com.mvmlabs.springboot.model.admin.UserManage;
import com.mvmlabs.springboot.service.admin.UserManageService;

@Service
public class UserManageServiceImpl implements UserManageService {

	@Autowired
	private UserManageDAO userManageDAO;
	
	@Override
	public List<UserManage> selectUserList() throws Exception {
		return userManageDAO.selectUserList();
	}

	@Override
	public void insertUser(UserManage userManage) throws Exception {
		userManageDAO.insertUser(userManage);
	}

	@Override
	public UserManage selectUser(String userId) throws Exception {
		return userManageDAO.selectUser(userId);
	}

	@Override
	public void updateUser(UserManage userManage) throws Exception {
		userManageDAO.updateUser(userManage);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		userManageDAO.deleteUser(userId);
	}
}
