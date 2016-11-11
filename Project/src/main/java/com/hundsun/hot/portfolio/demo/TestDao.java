package com.hundsun.hot.portfolio.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;

@Controller
public class TestDao {

	@Autowired
	private BaseEarningsMapper baseEarningsMapper;

	@RequestMapping("daoTest")
	public void testDao() {
		List<String> list = baseEarningsMapper.getStockCodeList();
		for (String base : list) {
			System.out.println(base.toString());
		}
	}

}
