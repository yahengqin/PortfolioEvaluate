package com.hundsun.hot.portfolio.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	@ResponseBody
	@RequestMapping("index")
	public String helloWorld(){
		return "index";
	}

}
