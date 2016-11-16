package com.hundsun.hot.portfolio.tools;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import com.hundsun.hot.portfolio.model.UserInfo;
import com.hundsun.hot.portfolio.tools.shiro.ShiroSession;

public class Identity {
	
	/**
	 * @Description 封装登录接口，日后会根据具体的登录逻辑进行调整
	 * @param userInfo
	 * @return UserInfo
	 */
	public static void login(UserInfo userInfo){
		if(userInfo != null){
			Subject subject = SecurityUtils.getSubject();
			if (null != subject) {
				UsernamePasswordToken token = new UsernamePasswordToken();
				token.setUsername(userInfo.getUserAcco());
				token.setPassword(userInfo.getPassword().toCharArray());
				subject.login(token);
			}
		}
	}
	
	public static UserInfo getLoadUser() {
		UserInfo result = null;
		Object userInfo = ShiroSession.getSessionData(CommonData.PORTFOLIO_LOGIN_USER_INFO);
		if(userInfo != null){
			result = (UserInfo)userInfo;
		}
		return result;
	}

}
