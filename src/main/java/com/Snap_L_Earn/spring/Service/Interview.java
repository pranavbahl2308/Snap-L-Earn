package com.Snap_L_Earn.spring.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Interview {

	static float workingHours(Calendar inTime,Calendar outTime){
		//float af=inTime.get(Calendar.HOUR_OF_DAY)-outTime.get(Calendar.HOUR_OF_DAY);
		float af=(inTime.get(Calendar.HOUR_OF_DAY)-outTime.get(Calendar.HOUR_OF_DAY));	
		float bf = (inTime.get(Calendar.MINUTE)-outTime.get(Calendar.MINUTE));
		if(bf < 0){
		//	bf = 
		}
		System.out.println("Hello"+bf);
		return af;
	}
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
//		// TODO Auto-generated method stub
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2015, 10, 4, 8, 43, 17);
//		Calendar calendar1 = Calendar.getInstance();
//		calendar1.set(2015, 10, 4, 16, 26, 17);
//		System.out.println("In main");
//		System.out.println(workingHours(calendar1, calendar));
//	}
    String time1 = "11:00 AM";
    String time2 = "2:06 PM";

    String format = "hh:mm a";

    SimpleDateFormat sdf = new SimpleDateFormat(format);

    Date inTime = sdf.parse(time1);
    Date outTime = sdf.parse(time2);
    System.out.println("In Time : "+ time1);
    System.out.println("Out Time : "+time2); 

    long diffInMillis = outTime.getTime() - inTime.getTime();

    float usedTime = (float) (diffInMillis / (60.0f * 60.0f * 1000.0f));
    System.out.println("Used Time : "+ usedTime);
    float leftTime = 12.0f-usedTime;
    System.out.println("Left Time : "+leftTime);
    if(leftTime < 12){
    	System.out.println("You Still have "+leftTime+"hours left");
    } else {
    	System.out.println("Please Logout");
    }
	}
}
