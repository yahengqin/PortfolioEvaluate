package com.hundsun.hot.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.hot.portfolio.timer.IndexComputeTask;

@Controller
@RequestMapping("compute")
public class ComputeController {
	
	@Autowired
	private IndexComputeTask indexComputeTask;

	@ResponseBody
	@RequestMapping("index")
	public String compute(){
		indexComputeTask.baseIndexCompute();
		return "Compute Index Success";
	}
}
