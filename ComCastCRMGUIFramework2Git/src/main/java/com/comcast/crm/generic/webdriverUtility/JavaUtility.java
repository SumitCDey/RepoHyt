package com.comcast.crm.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;



public class JavaUtility {

	public int getRandomNum(int size) {
		Random r=new Random();
		int r_no=r.nextInt(size);
		return r_no;
	}
	
	SimpleDateFormat sim=null;

	public String getSystemDate(String format) {
		Date d=new Date();
		sim=new SimpleDateFormat(format);
		String date = sim.format(d);
		return date;
	}

	public String getRequiredDate(String format,int days) {
		Date d=new Date();
		sim=new SimpleDateFormat(format);
		String date = sim.format(d);
		Calendar c=sim.getCalendar();
		c.add(Calendar.DAY_OF_MONTH, days);
		return sim.format(c.getTime());
	}

	public StringBuilder getAlphaNumericString(int size) {
		int n=size;
		String AlphanumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			int index = (int) ((AlphanumericString.length())*Math.random());
			sb.append(AlphanumericString.charAt(index));
		}
		return sb;
	}
	
	public StringBuilder getAlphabeticString(int size) {
		int n=size;
		String AlphanumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			int index = (int) ((AlphanumericString.length())*Math.random());
			sb.append(AlphanumericString.charAt(index));
		}
		return sb;
	}
	
	public StringBuilder getStringWithSpecific(int size, String data) {
		int n=size;
		String AlphanumericString=data;
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<n;i++)
		{
			int index = (int) ((AlphanumericString.length())*Math.random());
			sb.append(AlphanumericString.charAt(index));
		}
		return sb;
	}
}
