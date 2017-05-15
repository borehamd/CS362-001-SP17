package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.LinkedList;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

    @Test
    public void test01()  throws Throwable  {
        int thisYear=2017;
        int thisMonth=12;
        int thisDay=1;

        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

        CalDay day=new CalDay(today);
	
        assertTrue(day.isValid());
	assertEquals(0,day.getSizeAppts());
    }
    
    @Test
    public void test03()  throws Throwable  {
       CalDay day=new CalDay();
       assertFalse(day.isValid());
    }
    
    @Test
    public void test04() throws Throwable{
       int thisYear=2017;
       int thisMonth=5;
       int thisDay=1;

       GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

       CalDay day=new CalDay(today);
       int startHour=13;
       int startMinute=30;
       int startDay=1;
       int startMonth=5;
       int startYear=2017;
       String title="Birthday Party";
       String description="This is my birthday party.";
       Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
       Appt appt2 = new Appt(startHour-1,startMinute-1,startDay,startMonth,startYear,title,description);
       
       
       
       
       LinkedList Appts=new LinkedList<Appt>();
       
       Appts.add(appt);
       day.addAppt(appt2);
       LinkedList Appts2=new LinkedList<Appt>();
       Appts2.add(appt2);
       Appts2.add(appt);

       assertEquals(1,day.getSizeAppts());
       //assertEquals(Appts2,day.getAppts());
    }
       

    @Test
    public void test02()  throws Throwable  {
        int thisYear=2017;
        int thisMonth=5;
        int thisDay=1;

        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

        CalDay day=new CalDay(today);
        assertTrue(day.isValid());
        assertEquals(1,day.getDay());
        assertEquals(5,day.getMonth());
        assertEquals(2017,day.getYear());

        int startHour=13;
        int startMinute=30;
        int startDay=1;
        int startMonth=5;
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        day.addAppt(appt);

        StringBuilder sb = new StringBuilder();
        String todayDate = "5" + "/" + "1" + "/" + "2017";
        sb.append("\t --- " + todayDate + " --- \n");
        sb.append(" --- -------- Appointments ------------ --- \n");
        sb.append(appt.toString());

//			sb.append(this.appts);
        sb.append(" \n");
        assertEquals(sb.toString(),day.toString());
        LinkedList<Appt> listappt=new LinkedList<Appt>();
        listappt.add(appt);
        assertEquals(listappt,day.getAppts());




    }




}
