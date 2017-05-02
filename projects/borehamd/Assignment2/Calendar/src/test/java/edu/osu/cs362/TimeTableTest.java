package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.*;


import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

    @Test
    public void test01()  throws Throwable  {
        LinkedList<Appt> listappt=new LinkedList<Appt>();
        TimeTable time=new TimeTable();



        int startHour=13;
        int startMinute=30;
        int startDay=1;
        int startMonth=5;
        int startYear=2017;
        String title="class";
        String description="Me383.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        listappt.add(appt);

        startHour=13;
        startMinute=30;
        startDay=5;
        startMonth=5;
        startYear=2017;
        title="class";
        description="Me383.";
        //Construct a new Appointment object with the initial data
        Appt appt2 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        listappt.add(appt2);
        GregorianCalendar firstday=new GregorianCalendar(2017,5,1);
        GregorianCalendar lastday=new GregorianCalendar(2017,5,6);

        time.getApptRange(listappt,firstday,lastday);
        LinkedList<GregorianCalendar> days=new LinkedList<GregorianCalendar>();
        days.add(firstday);
        days.add(lastday);

        CalDay cal1=new CalDay(new GregorianCalendar(2017,5,1));
        cal1.addAppt(appt);
        CalDay cal2=new CalDay(new GregorianCalendar(2017,5,2));
        CalDay cal3=new CalDay(new GregorianCalendar(2017,5,3));
        CalDay cal4=new CalDay(new GregorianCalendar(2017,5,4));
        CalDay cal5=new CalDay(new GregorianCalendar(2017,5,5));
        cal5.addAppt(appt2);

        LinkedList<CalDay> listday=new LinkedList<CalDay>();
        listday.add(cal1);
        listday.add(cal2);
        listday.add(cal3);
        listday.add(cal4);
        listday.add(cal5);


        assertEquals(listday, time.getApptRange(listappt,firstday,lastday));

    }
    @Test
    public void test02()  throws Throwable  {
        LinkedList<Appt> listappt=new LinkedList<Appt>();
        TimeTable time=new TimeTable();



        int startHour=13;
        int startMinute=30;
        int startDay=1;
        int startMonth=5;
        int startYear=2017;
        String title="class";
        String description="Me383.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        listappt.add(appt);

        startHour=13;
        startMinute=30;
        startDay=1;
        startMonth=5;
        startYear=2017;
        title="something";
        description="LEEDLE LEEDLE LEEDLE";
        //Construct a new Appointment object with the initial data
        Appt appt2 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        listappt.add(appt2);

        LinkedList<Appt> listappt1=new LinkedList<Appt>();
        listappt1.add(appt);
        assertEquals(listappt1,time.deleteAppt(listappt,appt2));






    }
    @Test
    public void test03()  throws Throwable  {
        LinkedList<Appt> listappt=new LinkedList<Appt>();
        TimeTable time=new TimeTable();



        int startHour=13;
        int startMinute=30;
        int startDay=1;
        int startMonth=5;
        int startYear=2017;
        String title="class";
        String description="Me383.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        listappt.add(appt);

        startHour=13;
        startMinute=30;
        startDay=1;
        startMonth=5;
        startYear=2017;
        title="something";
        description="LEEDLE LEEDLE LEEDLE";
        //Construct a new Appointment object with the initial data
        Appt appt2 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        Appt appt3 = new Appt(startHour,
                startMinute ,
                2 ,
                startMonth ,
                startYear ,
                title,
                description);
        listappt.add(appt2);

        LinkedList<Appt> listappt1=new LinkedList<Appt>();
        listappt1.add(appt);
        assertEquals(null,time.deleteAppt(listappt,appt3));






    }

    @Test
    public void test04()  throws Throwable  {
        LinkedList<Appt> listappt=new LinkedList<Appt>();
        TimeTable time=new TimeTable();



        int startHour=13;
        int startMinute=30;
        int startDay=31;
        int startMonth=4;
        int startYear=2017;
        String title="class";
        String description="Me383.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        listappt.add(appt);

        GregorianCalendar firstday=new GregorianCalendar(2017,4,30);
        GregorianCalendar lastday=new GregorianCalendar(2017,5,1);

        time.getApptRange(listappt,firstday,lastday);
        LinkedList<GregorianCalendar> days=new LinkedList<GregorianCalendar>();
        days.add(firstday);
        days.add(lastday);

        CalDay cal1=new CalDay(new GregorianCalendar(2017,4,30));
        CalDay cal2=new CalDay(new GregorianCalendar(2017,5,1));

        LinkedList<CalDay> listday=new LinkedList<CalDay>();
        listday.add(cal1);
        listday.add(cal2);


        assertEquals(listday, time.getApptRange(listappt,firstday,lastday));

    }
}