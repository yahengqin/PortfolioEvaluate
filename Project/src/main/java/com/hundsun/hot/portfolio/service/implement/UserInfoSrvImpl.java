package com.hundsun.hot.portfolio.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.hot.portfolio.mapper.UserInfoMapper;
import com.hundsun.hot.portfolio.model.UserInfo;
import com.hundsun.hot.portfolio.service.interfaces.UserInfoSrv;
@Service
public class UserInfoSrvImpl implements UserInfoSrv {
	
	@Autowired
	private UserInfoMapper userMapper;

	@Override
	public int deleteById(Integer userId) {
		if(userId != null){
			return userMapper.deleteByPrimaryKey(userId);
		}
		return -1;
	}

	@Override
	public int Add(UserInfo record) {
		if(record!= null){
			return userMapper.insert(record);
		}
		return -1;
	}

	@Override
	public UserInfo getById(Integer userId) {
		if(userId != null){
			return userMapper.selectByPrimaryKey(userId);
		}
		return null;
	}

	@Override
	public List<UserInfo> getAll() {
		List<UserInfo> resList = new ArrayList<>();
		resList = userMapper.selectAll();
		return resList;
	}

	@Override
	public int updateById(UserInfo record) {
		if(record != null){
			return userMapper.updateByPrimaryKey(record);
		}
		return -1;
	}

	@Override
	public UserInfo getByUserAcco(String userAcco) {
		if(userAcco != null){
			return userMapper.selectByUserAcco(userAcco);
		}
		return null;
	}

	@Override
	public UserInfo login(String account, String password) {
		// TODO Auto-generated method stub
		if(account != null && password!= null){
			return userMapper.login(account,password);
		}
		return null;
	}

}
