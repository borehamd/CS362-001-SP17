package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
    @Test
    public void test01()  throws Throwable  {
        int startHour=13;
        int startMinute=30;
        int startDay=10;
        int startMonth=4;
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
        // assertions
        assertTrue(appt.getValid());
        assertEquals(13, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(10, appt.getStartDay());
        assertEquals(04, appt.getStartMonth());
        assertEquals(2017, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());


        String day= startMonth+"/"+startDay+"/"+startYear + " at ";
        String output="\t"+ day +   "1" +":"+ startMinute + "pm" + " ," +  title+ ", "+  description+"\n";


        assertEquals(output, appt.toString());
    }

    @Test
    public void test02()  throws Throwable  {
        int startHour=30;
        int startMinute=30;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(1,
                2,
                3,
                4 ,
                5,
                "none",
                "N/A");
        // assertions
        assertTrue(appt.getValid());

        assertEquals(1, appt.getStartHour());
        assertEquals(2, appt.getStartMinute());
        assertEquals(3, appt.getStartDay());
        assertEquals(4, appt.getStartMonth());
        assertEquals(5, appt.getStartYear());
        assertEquals("none", appt.getTitle());
        assertEquals("N/A", appt.getDescription());


        //setStart functions
        appt.setStartHour(startHour);
        appt.setStartMinute(startMinute);
        appt.setStartDay(startDay);
        appt.setStartMonth(startMonth);
        appt.setStartYear(startYear);
        appt.setTitle(title);
        appt.setDescription(description);

        assertEquals(30, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(10, appt.getStartDay());
        assertEquals(04, appt.getStartMonth());
        assertEquals(2017, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());



    }




    @Test

    public void test03()  throws Throwable  {
        int startHour=30;
        int startMinute=30;
        int startDay=10;
        int startMonth=4;
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
        // assertions
        assertFalse(appt.getValid());
        assertEquals(30, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(10, appt.getStartDay());
        assertEquals(4, appt.getStartMonth());
        assertEquals(2017, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());
        assertNull(appt.toString());
    }

    @Test

    public void test04()  throws Throwable {
        int startHour = 20;
        int startMinute = 30;
        int startDay = 31;
        int startMonth = 4;
        int startYear = 2017;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        // assertions
        assertFalse(appt.getValid());
    }

}

