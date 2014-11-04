package com.ClientCardManagement.test;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class DataTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDate() {
		String createTime = "2013-06-22";
		Date start = Date.valueOf(createTime);
//		Date startEnd = new Date(start.getDate() + 1);
//		System.out.println(start.toString());
//		Calendar c = Calendar.getInstance();
//		c.setTime(start);
//		c.add(Calendar.DATE, 1);
//		System.out.println(((java.util.Date) c.getTime()).getDate());
		//Date a = Date.valueOf();
		//System.out.println(a.toString());
		Date next = getNextDate(start);
		System.out.println(next.toString());
	}
	
	public java.sql.Date getNextDate(java.sql.Date start){
		
		Calendar c = Calendar.getInstance();
		c.setTime(start);
		c.add(Calendar.DATE, 1);
		
		java.util.Date d = c.getTime();
		String s = DateFormat.getDateInstance().format(d);
//		System.out.println(d);
		
		java.sql.Date next = java.sql.Date.valueOf(s);
		
		return next;
	}
}
