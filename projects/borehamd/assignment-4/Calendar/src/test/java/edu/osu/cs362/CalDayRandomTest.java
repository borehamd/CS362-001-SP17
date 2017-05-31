package edu.osu.cs362;


import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
	private static final int NUM_TESTS=100;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	
	 @Test
	  public void radnomtest()  throws Throwable  {
	     long startTime = Calendar.getInstance().getTimeInMillis();
	     long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

	     System.out.println("Start testing...");

	     for (int iteration = 0; elapsed < TestTimeout; iteration++) {
		long randomseed=System.currentTimeMillis();
		Random random=new Random(randomseed);
		//int startHour=random.nextInt(23);
		//int startMinute=random.nextInt(59);
		int startDay=random.nextInt(31)+1;
		int startMonth=random.nextInt(12)+1;
		int startYear=random.nextInt();
		
		GregorianCalendar day=new GregorianCalendar(startYear,startMonth,startDay);
		CalDay today=new CalDay(day);


		for (int i = 0; i < NUM_TESTS; i++) {
		   int startHour=random.nextInt(30);
		   int startMinute=random.nextInt(70);
		
		   String title=(String) ValuesGenerator.getString(random);
		   String description=(String) ValuesGenerator.getString(random);
		
		   Appt appt=new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);

		   today.addAppt(appt);
		}
		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		if((iteration%10000)==0 && iteration!=0 )
		   System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
	     }
		 
		 
	 }


	
}
