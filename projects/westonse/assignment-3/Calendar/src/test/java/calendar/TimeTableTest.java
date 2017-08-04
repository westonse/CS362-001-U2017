package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
          //test permute and delete functions with a list of valid apointments 
          LinkedList<Appt> listAppts = new LinkedList<Appt>();
          int startHour=14;
          int startMinute=30;
          int startDay=12;  	//12
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
          int[] anArray={2,3,4};
          appt.setRecurrence( anArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
          //add appoinntment
          listAppts.add(appt);
          // create another appointment
          startHour=14;
          startMinute=30;
          startDay=11;  	//11
          startMonth=4; 	//4
          startYear=2017; 	//2017
          title="Class";
          description="class 2.";
          //Construct a new Appointment object with the initial data
          appt = new Appt(startHour,
                          startMinute ,
                          startDay ,
                          startMonth ,
                          startYear ,
                          title,
                          description);
          //test branch at 148
          appt.setRecurrence( anArray, Appt.RECUR_BY_WEEKLY, 0, 0);
          //add appoinntment
          listAppts.add(appt);
          
          // create another appointment
          startHour=14;
          startMinute=30;
          startDay=13;  	//13
          startMonth=4; 	//4
          startYear=2017; 	//2017
          title="Class";
          description="class 3.";
          //Construct a new Appointment object with the initial data
          appt = new Appt(startHour,
                          startMinute ,
                          startDay ,
                          startMonth ,
                          startYear ,
                          title,
                          description);
          //add appoinntment
          listAppts.add(appt);
          
          //test getApptRange
          GregorianCalendar aDate = new GregorianCalendar(2017,4,1);
          GregorianCalendar anotherDate = new GregorianCalendar(2017,4,31);

          TimeTable timeTable=new TimeTable();
          //assertNull("Testing appointment range", timeTable.getApptRange(listAppts,aDate,anotherDate));
          
          //Create a linked list of calendar days to return
          LinkedList<CalDay> calDays = new LinkedList<CalDay>();
          int[] pv={1,0,2};
          //create a permutated list to compare to original
          LinkedList<Appt> listUpdatedAppts=timeTable.permute(listAppts, pv);
          
          //LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(1));
          
          //test null list as well
          LinkedList<Appt> nullListAppts = null;
          //assertions
          //assertFalse("ERROR: Permutated list matches original.",listAppts == listUpdatedAppts);
          //assertFalse("ERROR: Deleted list matches original list.",listAppts == listDeletedAppts);
          //assertNull("ERROR: deleteAppt didnt return null.", timeTable.deleteAppt(nullListAppts, appt));
          //test null case
          //assertNull("ERROR: getApptRange didnt return null", timeTable.getApptRange(nullListAppts,aDate,anotherDate));

	 }
    
    @Test
    public void test02()  throws Throwable  {
        //test valid appts
        LinkedList<Appt> appts = new LinkedList<Appt>();
        int startHour=3;
        int startMinute=30;
        int startDay=2;  	//12
        int startMonth=4; 	//4
        int startYear=2017; 	//2017/2017
        String title="Birthday Party";
        String description="This is my birthday party.";
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        LinkedList<CalDay> empty = new LinkedList<CalDay>();

        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                             startMinute ,
                             startDay ,
                             startMonth ,
                             startYear ,
                             title,
                             description);
        appts.add(appt);
        
        int[] recurringDays =  new int[0];
        appt.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
        startHour=3;
        startMinute=30;
        startDay=3;  	//12
        startMonth=4; 	//4
        startYear=2017; 	//2017/2017
        title="Birthday Party";
        description="This is my birthday party.";
        Appt appt1 = new Appt(startHour,
                             startMinute ,
                             startDay ,
                             startMonth ,
                             startYear ,
                             title,
                             description);
        
        appt1.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 0, 0);
        appts.add(appt1);
        
        //dates of appts not in range of given dates
        GregorianCalendar firstDay = new GregorianCalendar(startYear,startMonth,startDay+1);
        //Create an identical object for the firstDay
        GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
        //GregorianCalendar lastDay = new GregorianCalendar(startYear,startMonth,5);

        TimeTable t=new TimeTable();
        
        //Increase today day to 1
        lastDay.add(Calendar.DAY_OF_MONTH,1);
        try {
            // Retrieves a range of appointments between two dates (i.e., today and tomorrow).
            calDays = t.getApptRange(appts, firstDay, lastDay);
        }
        catch( NullPointerException e)
        {
            
        }
        //assertions
        //test that linked list is empty
        assertEquals("ERROR: list not NULL",empty, calDays);

        
        
    }
    @Test
    public void test03()  throws Throwable  {
            //test null appt and null list of appts
            LinkedList<Appt> listAppts = null;
            LinkedList<Appt> appts = new LinkedList<Appt>();
            int startHour=-1;
            int startMinute=30;
            int startDay=12;  	//12
            int startMonth=4; 	//4
            int startYear=2017; 	//2017/2017
            String title="Birthday Party";
            String description="This is my birthday party.";
            LinkedList<CalDay> calDays = new LinkedList<CalDay>();
            //Construct a new Appointment object with the initial data
            Appt appt = new Appt(startHour,
                                 startMinute ,
                                 startDay ,
                                 startMonth ,
                                 startYear ,
                                 title,
                                 description);
        Appt appt1 = null;
        TimeTable t=new TimeTable();
        //assertions
        //test null list
        assertNull("ERROR: deleteAppts did not return null on a null list.",t.deleteAppt(listAppts,appt));
        //test null appt
        assertNull("ERROR: deleteAppts did not return null on a null list.",t.deleteAppt(appts,appt1));
    }
    @Test
    public void test04()  throws Throwable  {
        //testing delete funtion
        TimeTable t=new TimeTable();
        //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
        //get todays date
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        
        int startHour=13;
        int startMinute=30;
        int startDay=thisDay;  	//11
        int startMonth=thisMonth; 	//4
        int startYear=thisYear; 	//2017
        String title="Birthday Party";
        String description="This is my birthday party.";
        // Create a valid appointment!
        Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        Appt appt1 = new Appt(startHour, startMinute , startDay+1 , startMonth , startYear , title, description);
        Appt appt2 = new Appt(startHour, startMinute , startDay+2 , startMonth , startYear , title, description);
        Appt appt3 = new Appt(startHour, startMinute , startDay+3 , startMonth , startYear , title, description);
        Appt appt4 = new Appt(-1, startMinute , startDay+3 , startMonth , startYear , title, description);

        /** Collection of all of the appointments for the calendar day */
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);
        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);

        //test delete
        LinkedList<Appt> apptsDelete = t.deleteAppt(appts,appt1);
        //assertions
        assertEquals(appt,apptsDelete.getFirst());
        assertEquals(1,apptsDelete.indexOf(appt2));
        //test delete again
        //LinkedList<Appt> apptsDelete1 = t.deleteAppt(appts,appt);
        //assertions
        //assertEquals(appt2,apptsDelete1.getFirst());
        //invalid appt assertion
        assertNull(t.deleteAppt(appts,appt4));
        
        
    }
    @Test
    public void test05()  throws Throwable  {
        //testing delete funtion
        TimeTable t=new TimeTable();
        //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
        //get todays date
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        
        int startHour=13;
        int startMinute=30;
        int startDay=thisDay;  	//11
        int startMonth=thisMonth; 	//4
        int startYear=thisYear; 	//2017
        String title="Birthday Party";
        String description="This is my birthday party.";
        // Create a valid appointment!
        Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        Appt appt1 = new Appt(startHour, startMinute , startDay+1 , startMonth , startYear , title, description);
        Appt appt2 = new Appt(startHour, startMinute , startDay+2 , startMonth , startYear , title, description);
        Appt appt3 = new Appt(startHour, startMinute , startDay+3 , startMonth , startYear , title, description);
        
        /** Collection of all of the appointments for the calendar day */
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);
        appts.add(appt1);
        appts.add(appt2);
        //appts.add(appt3);
        
        //test permute
        int[] pv = {1,0,2};
        LinkedList<Appt> apptsPermute = t.permute(appts,pv);
        //assertions
        assertEquals(appt1,apptsPermute.getFirst());
        assertEquals(1,apptsPermute.indexOf(appt));
        
    }
    @Test
    public void test06()  throws Throwable  {
        //testing getApptApperances
        TimeTable t=new TimeTable();
        //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
        //get todays date
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        
        int startHour=-1;
        int startMinute=30;
        int startDay=thisDay;  	//11
        int startMonth=thisMonth; 	//4
        int startYear=thisYear; 	//2017
        String title="Birthday Party";
        String description="This is my birthday party.";
        // Create appointments
        Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        Appt appt1 = new Appt(startHour, startMinute , startDay+1 , startMonth , startYear , title, description);
        Appt appt2 = new Appt(startHour, startMinute , startDay+2 , startMonth , startYear , title, description);
        Appt appt3 = new Appt(startHour, startMinute , startDay+3 , startMonth , startYear , title, description);
        int[] anArray={};
        appt.setRecurrence( anArray, 0, 0, 0);
        appt1.setRecurrence( anArray, 0, 0, 0);
        appt2.setRecurrence( anArray, 0, 0, 0);

        /** Collection of all of the appointments for the calendar day */
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);
        appts.add(appt1);
        appts.add(appt2);
        
        //test getApptApperances
        GregorianCalendar firstDay = new GregorianCalendar(startYear,startMonth,1);
        GregorianCalendar lastDay = new GregorianCalendar(startYear,startMonth,30);
        GregorianCalendar apptDay = new GregorianCalendar(startYear,startMonth,startDay);
        CalDay calDay = new CalDay(apptDay);
        GregorianCalendar apptDay1 = new GregorianCalendar(startYear,startMonth,startDay+1);
        CalDay calDay1 = new CalDay(apptDay1);
        GregorianCalendar apptDay2 = new GregorianCalendar(startYear,startMonth,startDay+2);
        CalDay calDay2 = new CalDay(apptDay2);
        LinkedList<CalDay> apperances = t.getApptRange(appts,firstDay,lastDay);

        //assertions
        assertEquals(calDay.toString(),apperances.getFirst().toString());
        
    }
    
    @Test
    // Covered goals for unit test test01():
    // The goal of the test01 is to call the public method getApptRange with the exact objects too cover the following targets:
    // Switch Statement in the private method getNextApptOccurrence
    // in particular case Appt.RECUR_BY_MONTHLY
    public void test07()  throws Throwable  {
        //covers some reccurence mutation possibilities
        TimeTable t=new TimeTable();
        
        
        //create linked list of Appt type
        //create Appt objects
        //add the object to the linked list
        //create first day and last day of type GregorianCalendar today = new GregorianCalendar(2, 3, 4);
        //get todays date
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        
        int startHour=15;
        int startMinute=30;
        int startDay=thisDay;  	//11
        int startMonth=thisMonth; 	//4
        int startYear=thisYear; 	//2017
        String title="Birthday Party";
        String description="This is my birthday party.";
        // Create a valid appointment!
        Appt appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        Appt appt1 = new Appt(startHour+1, startMinute , startDay , startMonth , startYear , title, description);
        Appt appt2 = new Appt(startHour+2, startMinute , startDay , startMonth , startYear , title, description);

        /** Collection of all of the appointments for the calendar day */
        LinkedList<Appt> appts = new LinkedList<Appt>();


        //Change the  default recurring information in the object appt using setRecurrence method in the Appt class
        int[] recurringDays =  {1,2,3};
        appt.setRecurrence(recurringDays, Appt.RECUR_BY_MONTHLY, 0, 1);
        appt1.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 0, 1);
        appt2.setRecurrence(recurringDays, Appt.RECUR_BY_YEARLY, 0, 1);
        appts.add(appt);
        appts.add(appt1);
        appts.add(appt2);

        //get a list of appointments for one day that are occurred between today and tomorrow!
        GregorianCalendar firstDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
        //Create an identical object for the firstDay
        GregorianCalendar lastDay = (GregorianCalendar)firstDay.clone();
        //Increase today day to 1
        lastDay.add(Calendar.DAY_OF_MONTH,1);
        try {
            // Retrieves a range of appointments between two dates (i.e., today and tomorrow).
            t.getApptRange(appts, firstDay, lastDay);
        }
        catch( NullPointerException e)
        {
            
        }
        
    }

    
   //add more unit tests as you needed
}
