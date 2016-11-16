package com.hundsun.hot.portfolio.service.interfaces;

import java.util.List;

import com.hundsun.hot.portfolio.model.UserInfo;

public interface UserInfoSrv {
	
    int deleteById(Integer userId);
    
    int Add(UserInfo record);
    
    UserInfo getById(Integer userId);
    
    List<UserInfo> getAll();
    
    int updateById(UserInfo record);

    UserInfo getByUserAcco(String userAcco);
    
    UserInfo login(String account ,String password);
}
