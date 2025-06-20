package com.b2b.stuman.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber(int num)
	{
		Random random = new Random();
		return random.nextInt(num);
	}
	
	public String getSystemDate(String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = sdf.format(new Date());
		return date;
	}
	
	public String getRequiredDate(String format,int days)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
}
