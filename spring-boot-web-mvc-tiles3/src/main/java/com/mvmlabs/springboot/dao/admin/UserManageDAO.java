package com.mvmlabs.springboot.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvmlabs.springboot.model.admin.UserManage;

@Repository
public class UserManageDAO {

	@Autowired
	private SqlSession sqlSession;

	public int selectUserTotalCnt(Map<String, Object> param) throws Exception {
		return sqlSession.selectOne("userManageMapper.selectUserTotalCnt", param);
	}
	
	public List<UserManage> selectUserList(Map<String,Object> param) throws Exception {
		return sqlSession.selectList("userManageMapper.selectUserList", param);
	}

	public void insertUser(UserManage userManage) throws Exception {
		sqlSession.insert("userManageMapper.insertUser", userManage);
	}

	public UserManage selectUser(String userId) throws Exception {
		return sqlSession.selectOne("userManageMapper.selectUser", userId);
	}

	public void updateUser(UserManage userManage) throws Exception {
		sqlSession.insert("userManageMapper.updateUser", userManage);
	}
	
	public void deleteUser(String userId) throws Exception {
		sqlSession.delete("userManageMapper.deleteUser", userId);
	}

}
