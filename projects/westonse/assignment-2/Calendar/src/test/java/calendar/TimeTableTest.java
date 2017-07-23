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
          
          LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(1));
          
          //test null list as well
          LinkedList<Appt> nullListAppts = null;
          //assertions
          assertFalse("ERROR: Permutated list matches original.",listAppts == listUpdatedAppts);
          assertFalse("ERROR: Deleted list matches original list.",listAppts == listDeletedAppts);
          assertNull("ERROR: deleteAppt didnt return null.", timeTable.deleteAppt(nullListAppts, appt));
          //test null case
          assertNull("ERROR: getApptRange didnt return null", timeTable.getApptRange(nullListAppts,aDate,anotherDate));

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
   //add more unit tests as you needed
}
