package com.hundsun.hot.portfolio.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {
	public static int getToday(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String today = simpleDateFormat.format(new Date());
		int res = Integer.valueOf(today);	
		return res;
	}
}
