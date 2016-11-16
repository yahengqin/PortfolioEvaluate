package com.hundsun.hot.portfolio.mapper;

import com.hundsun.hot.portfolio.model.UserInfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
	
    int deleteByPrimaryKey(Integer userId);
    
    int insert(UserInfo record);
    
    UserInfo selectByPrimaryKey(Integer userId);
    
    List<UserInfo> selectAll();
    
    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByUserAcco(String userAcco);
    
    UserInfo login(@Param("account")String account,@Param("password")String password);
}