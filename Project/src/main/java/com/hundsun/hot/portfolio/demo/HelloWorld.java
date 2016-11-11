package com.hundsun.hot.portfolio.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	
	private static Logger logger=LoggerFactory.getLogger(HelloWorld.class);
	//test conneciton
	@ResponseBody
	@RequestMapping("index")
	public String helloWorld(){
		logger.info("this is a info message");
		logger.debug("this is a debug message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		return "index";
	}

}
