package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
          //test addAppt() & toString() with a valid appt
          GregorianCalendar rightnow = new GregorianCalendar(2017,7,18);
          CalDay today = new CalDay(rightnow);
          int startHour=15;
          int startMinute=30;
          int startDay=11;  	//11
          int startMonth=4; 	//4
          int startYear=2017; 	//2017/2017
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
          today.addAppt(appt);
          //create string to compare to toString() function 
          String testString = today.toString();
          StringBuilder sb = new StringBuilder();
          String todayDate = (today.getMonth()) + "/" + today.getDay() + "/" + today.getYear();
          sb.append("\t --- " + todayDate + " --- \n");
          sb.append(" --- -------- Appointments ------------ --- \n");
          Iterator<Appt> itr = today.appts.iterator();
          while(itr.hasNext()) {
              Object element = itr.next();
              sb.append(element + " ");
          }
          sb.append("\n");
          
          // assertions
          assertEquals(1,today.getSizeAppts());
          assertEquals("Testing toString", sb.toString(), testString);
          assertEquals(appt,itr.next());

	 }
	 @Test
	  public void test02()  throws Throwable  {
          //test addAppt with multiple unordered appointments
          GregorianCalendar rightnow = new GregorianCalendar(2017,7,18);
          CalDay today = new CalDay(rightnow);
          int startHour=15;
          int startMinute=30;
          int startDay=18;  	//11
          int startMonth=7; 	//4
          int startYear=2017; 	//2017/2017
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
          today.addAppt(appt);
        
          startHour=12;
          startMinute=30;
          startDay=18;  	//11
          startMonth=7; 	//4
          startYear=2017; 	//2017/2017
          title="Birthday Party";
          description="This is my friends birthday party.";
          //Construct a new Appointment object with the initial data
          Appt appt1 = new Appt(startHour,
                               startMinute ,
                               startDay ,
                               startMonth ,
                               startYear ,
                               title,
                               description);
          today.addAppt(appt1);
          startHour=22;
          startMinute=30;
          startDay=18;  	//11
          startMonth=7; 	//4
          startYear=2017; 	//2017/2017
          title="Birthday Party";
          description="This is my other friends birthday party.";
          //Construct a new Appointment object with the initial data
          Appt appt2 = new Appt(startHour,
                                startMinute ,
                                startDay ,
                                startMonth ,
                                startYear ,
                                title,
                                description);
          today.addAppt(appt2);
          
          //assertions
          assertTrue("Testing unordered appointments",today.isValid());
          
		 
	 }
    
    @Test
    public void test03()  throws Throwable  {
        //test an invalid CalDay
        //GregorianCalendar rightnow = new GregorianCalendar(2017,7,18);
        CalDay today = new CalDay();
        try {
            Iterator<Appt> itr = today.appts.iterator();
            fail("Expecting exception:NullPointerException");
        } catch(NullPointerException e) { }
        
        String testString = today.toString();
        //assertions
        assertEquals("",testString);
        assertFalse("Testing invalid",today.isValid());
        assertNull(today.iterator());

    }
    @Test
    public void test04()  throws Throwable  {
        //test invalid appts
        GregorianCalendar rightnow = new GregorianCalendar(2017,7,18);
        CalDay today = new CalDay(rightnow);
        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        //Construct a new Appointment object with the initial data
        int startHour=-1;
        int startMinute=30;
        int startDay=18;  	//11
        int startMonth=7; 	//4
        int startYear=2017; 	//2017/2017
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
        today.addAppt(appt);
        Iterator<Appt> itr = today.appts.iterator();
        
        
        //assertions
        assertEquals(listAppts,today.getAppts());
        assertFalse(itr==today.iterator());

        
    }
    
    
    
//add more unit tests as you needed
}
