package com.mvmlabs.springboot.dao.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvmlabs.springboot.model.admin.UserManage;

@Repository
public class UserManageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<UserManage> selectUserList() throws Exception {
		return sqlSession.selectList("userManageMapper.selectUserList");
	}
}
