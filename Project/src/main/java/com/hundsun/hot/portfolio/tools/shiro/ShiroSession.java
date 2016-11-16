package com.hundsun.hot.portfolio.tools.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroSession {

	// save KV to the session
	public static void setSessionData(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	// remove the V through K
	public static void removeSessionData(Object key) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.removeAttribute(key);
			}
		}
	}

	// get V the session through K
	public static Object getSessionData(Object key) {
		Object object = null;
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				object = session.getAttribute(key);
			}
		}
		return object;
	}
}
