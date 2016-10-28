package com.hundsun.hot.portfolio.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hundsun.hot.portfolio.mapper.BaseEarningsMapper;
import com.hundsun.hot.portfolio.model.BaseEarnings;

@Controller
public class TestDao {

	@Autowired
	private BaseEarningsMapper baseEarningsMapper;

	@RequestMapping("daoTest")
	public void testDao() {
		BaseEarnings baseEarnings = new BaseEarnings();
		baseEarnings.setStockCode("600570");
		baseEarnings.setStockEarnings(10.111);
		baseEarnings.setTradeDay(20161018);
		baseEarningsMapper.insert(baseEarnings);
		List<BaseEarnings> list = baseEarningsMapper.selectAll();
		for (BaseEarnings base : list) {
			System.out.println(base.toString());
		}
	}

}
