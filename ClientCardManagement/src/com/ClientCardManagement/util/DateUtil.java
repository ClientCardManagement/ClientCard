package com.ClientCardManagement.util;

import java.text.DateFormat;
import java.util.Calendar;

public class DateUtil {
	public static java.sql.Date getNextDate(java.sql.Date start) {

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
