package com.Snap_L_Earn.spring.Service;

import java.text.ParseException;
import java.util.Calendar;

public class NewTest {

	static void workingHours(Calendar inTime,Calendar outTime){
		//float af=inTime.get(Calendar.HOUR_OF_DAY)-outTime.get(Calendar.HOUR_OF_DAY);
//		float af=(inTime.get(Calendar.HOUR_OF_DAY)-outTime.get(Calendar.HOUR_OF_DAY));	
//		float bf = (inTime.get(Calendar.MINUTE)-outTime.get(Calendar.MINUTE));
		float workingHours = ((float)(outTime.getTimeInMillis()-inTime.getTimeInMillis())/(60.0f*60.0f*1000.0f));
		System.out.println("used time :"+workingHours);
		float leftTime = 12.0f-workingHours;
		System.out.println("left time :"+leftTime);
		if(leftTime<12.0f){
			System.out.println("You Still have "+leftTime+" hours left");
		} else {
			System.out.println("Please logout");
		}
		
	}
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 10, 4, 8, 00, 17);
		System.out.println("In Time"+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE));
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2015, 10, 4, 16, 30, 17);
		System.out.println("Out Time"+calendar1.get(Calendar.HOUR_OF_DAY)+":"+calendar1.get(Calendar.MINUTE));
		NewTest.workingHours(calendar, calendar1);
	}
}
