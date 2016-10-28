package com.hundsun.hot.portfolio.tools;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanWare implements ApplicationContextAware {

	private static ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;
	}

	public static Object getBean(String beanName) {
		Object object = null;
		try {
			object = appContext == null ? null : appContext.getBean(beanName);
		} catch (Exception e) {
			object = null;
		}
		return object;
	}

	public static <T> T getBean(Class<T> requiredType) {
		T t = null;
		try {
			t = appContext == null ? null : appContext.getBean(requiredType);
		} catch (Exception e) {
			t = null;
		}
		return t;
	}

}
