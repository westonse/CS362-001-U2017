package calendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests CalDay Class with valid appointments.
     */
	 @Test
	  public void radnomtest1()  throws Throwable  {
		 
          long startTime = Calendar.getInstance().getTimeInMillis();
          long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
          //test addAppt with multiple unordered appointments
          GregorianCalendar rightnow = new GregorianCalendar(2017,7,18);
          CalDay today = new CalDay(rightnow);
          
          System.out.println("Start testing...");
          
          try{
              for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                  long randomseed =System.currentTimeMillis(); //10
                  //			System.out.println(" Seed:"+randomseed );
                  Random random = new Random(randomseed);
                  
                  int startHour=ValuesGenerator.RandInt(random);
                  int startMinute=ValuesGenerator.RandInt(random);
                  int startDay=18;//ValuesGenerator.RandInt(random);;
                  int startMonth=7;//ValuesGenerator.RandInt(random);;
                  int startYear=2017;//ValuesGenerator.RandInt(random);
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
                  //add random unordered appointments that are all on the same day
                  today.addAppt(appt);
                  elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                  if((iteration%10000)==0 && iteration!=0 )
                      System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                  
              }
          }catch(NullPointerException e){
              
          }
          
          System.out.println("Done testing...");

		 
	 }
    /**
     * Generate Random Tests that tests CalDay Class with invalid appointments.
     */
    @Test
    public void radnomtest2()  throws Throwable  {
        
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
        //test addAppt with multiple unordered appointments
        GregorianCalendar rightnow = new GregorianCalendar(2017,7,18);
        CalDay today = new CalDay(rightnow);
        
        System.out.println("Start testing...");
        
        try{
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed =System.currentTimeMillis(); //10
                //			System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);
                
                int startHour=-1*ValuesGenerator.RandInt(random);
                int startMinute=ValuesGenerator.RandInt(random);
                int startDay=18;//ValuesGenerator.RandInt(random);;
                int startMonth=7;//ValuesGenerator.RandInt(random);;
                int startYear=2017;//ValuesGenerator.RandInt(random);
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
                //add random unordered appointments that are all on the same day
                today.addAppt(appt);
                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if((iteration%10000)==0 && iteration!=0 )
                    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                
            }
        }catch(NullPointerException e){
            
        }
        
        System.out.println("Done testing...");
        
        
    }
    


	
}
