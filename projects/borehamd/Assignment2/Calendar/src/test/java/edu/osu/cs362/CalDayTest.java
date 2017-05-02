package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

    @Test
    public void test01()  throws Throwable  {
        int thisYear=2017;
        int thisMonth=13;
        int thisDay=1;

        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

        CalDay day=new CalDay(today);
        assertFalse(day.isValid());

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
