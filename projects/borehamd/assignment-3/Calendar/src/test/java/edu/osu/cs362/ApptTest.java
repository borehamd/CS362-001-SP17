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
        int startHour=11;
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
        assertEquals(11, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(10, appt.getStartDay());
        assertEquals(04, appt.getStartMonth());
        assertEquals(2017, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());


        String day= startMonth+"/"+startDay+"/"+startYear + " at ";
        String output="\t"+ day +   "11" +":"+ startMinute + "am" + " ," +  title+ ", "+  description+"\n";


        assertEquals(output, appt.toString());
    }

    @Test
    public void test02()  throws Throwable  {
        int startHour=10;
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

	assertTrue(appt.getValid());
	
        assertEquals(10, appt.getStartHour());
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
       
    }

    @Test

    public void test04()  throws Throwable {
        int startHour = 1;
        int startMinute = 2;
        int startDay = 3;
        int startMonth = 4;
        int startYear = 5;
        String title = "thday Party";
        String description = "s is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
	appt.setStartHour(24);
	assertFalse(appt.getValid());
	appt.setStartMinute(90);
	assertFalse(appt.getValid());
	appt.setStartDay(32);
	assertFalse(appt.getValid());
	appt.setStartMonth(-5);

	// assertions
        assertFalse(appt.getValid());

    }
    @Test

    public void test05() throws Throwable{
       Appt appt=new Appt(1,2,3,4,5,"son of a","waffle");
       appt.setStartMinute(60);
       assertFalse(appt.getValid());
    }
    @Test
    public void test6() throws Throwable{
	Appt appt=new Appt(1,2,3,4,5,"son of a","waffle");
	appt.setStartDay(0);
	assertFalse(appt.getValid());
    }
    @Test
    public void test07() throws Throwable{
       Appt appt=new Appt(1,2,3,4,5,"son of a","waffle");
       appt.setStartMonth(0);
       assertFalse(appt.getValid());
    }
    @Test
    public void test08() throws Throwable{
       Appt appt=new Appt(0,0,0,0,0,"fddsfsf","sdfsfdf");
       assertNull(appt.toString());
    }





}
