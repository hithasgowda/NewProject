package practice.contactTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calender {
	public static void main(String[] args)
	{
		Date date =new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String actualdate=format.format(date);
		System.out.println(actualdate);
		
		Calendar cal =format.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, -30);
		String  dataRequries=format.format(cal.getTime());
		System.out.println(dataRequries);
	}
}
