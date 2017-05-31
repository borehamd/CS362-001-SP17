package edu.osu.cs362;

import java.util.*;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
        private static final int NUM_TESTS=100;
   	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
	     long startTime = Calendar.getInstance().getTimeInMillis();
	     long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
	     System.out.println("Start testing...");

	     for (int iteration = 0; elapsed < TestTimeout; iteration++) {
		long randomseed=System.currentTimeMillis();
		Random random=new Random(randomseed);
		TimeTable time=new TimeTable();

		LinkedList<Appt> listappt=new LinkedList<Appt>();
		for(int i=0;i<50;i++){
		   int startDay=random.nextInt(30)+1;
		   int startMonth=random.nextInt(11)+1;
		   int startYear=random.nextInt();
		   int startHour=random.nextInt(23);
		   int startMinute=random.nextInt(59);
		   String title=(String) ValuesGenerator.getString(random);
		   String description=(String) ValuesGenerator.getString(random);

		   Appt appt=new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);		    listappt.add(appt);
		}

		for(int i=0;i<40;i++){
		   int rand=random.nextInt(listappt.size()+3);
		   if (rand==listappt.size()){
		      int startDay=random.nextInt(37)+1;
		      int startMonth=random.nextInt(16)+1;
		      int startYear=random.nextInt();

		      int startHour=random.nextInt(27);
		      int startMinute=random.nextInt(70);
		      String title=(String) ValuesGenerator.getString(random);
		      String description=(String) ValuesGenerator.getString(random);
		      Appt appt=new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);
		      time.deleteAppt(listappt,appt);
		   }
		   else if(rand==listappt.size()+2){
		      time.deleteAppt(null,listappt.get(random.nextInt(listappt.size())));
		   }
		   else if(rand==listappt.size()+1){
		      time.deleteAppt(listappt,null);

		   }
		   else listappt=time.deleteAppt(listappt,listappt.get(rand));
		}

		 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

		 if((iteration%10000)==0 && iteration!=0 )
		    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
		 
		 
	 }


	  }
}
