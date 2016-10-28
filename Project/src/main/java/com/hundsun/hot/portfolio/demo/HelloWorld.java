package com.hundsun.hot.portfolio.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hundsun.hot.portfolio.service.implement.BaseEarningsSrvImpl;
import com.hundsun.hot.portfolio.service.interfaces.BaseEarningsService;

@Controller
public class HelloWorld {
	
	private BaseEarningsService baseearnings = new BaseEarningsSrvImpl();
	
	//test conneciton
	@ResponseBody
	@RequestMapping("index")
	public String helloWorld(){
		
		baseearnings.getAll();
		
		return "index";
	}

}
