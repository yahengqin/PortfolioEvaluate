package com.hundsun.hot.portfolio.tools.shiro;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hundsun.hot.portfolio.model.UserInfo;
import com.hundsun.hot.portfolio.service.interfaces.UserInfoSrv;
import com.hundsun.hot.portfolio.tools.CommonData;
import com.hundsun.hot.portfolio.tools.Identity;

@Component
public class ShiroSecurityRealm extends AuthorizingRealm {
	
	@Autowired
	private UserInfoSrv userSrv;

	@Autowired
	private SessionDAO sessionDAO;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//暂时不引入角色的概念，只是做一个通用的角色名称填充
		SimpleAuthorizationInfo simpleAuthorInfo  = new SimpleAuthorizationInfo();
		if(Identity.getLoadUser() != null){
			String roleName = "portfolio_common_user";
			simpleAuthorInfo = new SimpleAuthorizationInfo();
			simpleAuthorInfo.addRole(roleName);
		}
		return simpleAuthorInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		UserInfo userInfo = userSrv.login(token.getUsername(), String.valueOf(token.getPassword()));
		if (userInfo == null) {
			throw new AccountException("用户名或密码错误");
		} else{
			String userName = token.getUsername();
			System.out.println("do shiro anth");
			onePointLogin(userName);
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(),
					this.getName());
			// 添加用户信息
			ShiroSession.setSessionData(CommonData.PORTFOLIO_LOGIN_USER_INFO, userInfo);
			return authcInfo;
		}
	}
	
	/**
	 * @Description 保证单点登录，一个账户只存在一个session
	 * @param userAcco
	 * @return void
	 */
	private void onePointLogin(String userAcco) {
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		for (Session session : sessions) {
			String loginHostriy = String
					.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			if (userAcco.equals(loginHostriy)) {
				// 同一浏览器下不剔除session
				String nowSession = SecurityUtils.getSubject().getSession().getId().toString();
				String oldSession = session.getId().toString();
				if (!nowSession.equals(oldSession)) {
					// 设置session立即失效，即将其踢出系统
					session.setTimeout(0);
				}
				break;
			}
		}
	}

}
