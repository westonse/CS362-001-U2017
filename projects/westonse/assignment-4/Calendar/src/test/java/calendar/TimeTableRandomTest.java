package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests deleteAppt and getApptRange funciton with valid and invalid appointments.
     */
	 @Test
	  public void radnomtest1()  throws Throwable  {
		  
          long startTime = Calendar.getInstance().getTimeInMillis();
          long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
          //test delete and getApptRange functions with a randon list of valid apointments
          LinkedList<Appt> listAppts = new LinkedList<Appt>();
          LinkedList<Appt> deleteAppts = new LinkedList<Appt>();
          //used to test null values on delete funciton
          LinkedList<Appt> nullAppts = null;
          Appt nullAppt = null;
          //used to test invalid appt on delete function
          Appt invalidAppt = new Appt(-1,-1,-1,-1,-1,"","");
          //used to test list of empty appts on delete function
          LinkedList<Appt> emptyAppts = new LinkedList<Appt>();

          System.out.println("Start testing...");
          
          try{
              for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                  long randomseed =System.currentTimeMillis(); //10
                  //			System.out.println(" Seed:"+randomseed );
                  Random random = new Random(randomseed);
                  
                  int startHour=ValuesGenerator.RandInt(random);
                  int startMinute=ValuesGenerator.RandInt(random);
                  int startDay=ValuesGenerator.RandInt(random);
                  int startMonth=4;//ValuesGenerator.RandInt(random);;
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
                  if(!appt.getValid())continue;
                  for (int i = 0; i < NUM_TESTS; i++) {
                      String methodName = ApptRandomTest.RandomSelectMethod(random);
                      if (methodName.equals("setTitle")){
                          String newTitle=(String) ValuesGenerator.getString(random);
                          appt.setTitle(newTitle);
                      }
                      else if (methodName.equals("setRecurrence")){
                          int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
                          int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                          int recur=ApptRandomTest.RandomSelectRecur(random);
                          int recurIncrement = ValuesGenerator.RandInt(random);
                          int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
                          appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                      }				
                  }
                  listAppts.add(appt);
                  elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                  if((iteration%10000)==0 && iteration!=0 )
                      System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                  
              }
              GregorianCalendar aDate = new GregorianCalendar(2017,4,1);
              GregorianCalendar anotherDate = new GregorianCalendar(2017,4,2);
              
              TimeTable timeTable=new TimeTable();
              long randomseed =System.currentTimeMillis(); //10
              Random random = new Random(randomseed);
              //attempt to delete null Appt out of list
              deleteAppts = timeTable.deleteAppt(listAppts,nullAppt);
              //attempt to delete invalid Appt out of list
              deleteAppts = timeTable.deleteAppt(listAppts,invalidAppt);
              //attempt to delete random Appt out of a null list
              deleteAppts = timeTable.deleteAppt(nullAppts,listAppts.get(ValuesGenerator.RandInt(random)%listAppts.size()));
              //attempt to delete random Appt out of an empty list
              deleteAppts = timeTable.deleteAppt(emptyAppts,listAppts.get(ValuesGenerator.RandInt(random)%listAppts.size()));
            
              //attempt to remove random appointment index from the list of appointments
              deleteAppts = timeTable.deleteAppt(listAppts,listAppts.get(ValuesGenerator.RandInt(random)%listAppts.size()));

              //calDays = timeTable.getApptRange(listAppts,aDate,anotherDate);
              /*for (int iteration = 0; iteration < 5; iteration++) {
               calDays = timeTable.deleteAppt(listAppts,listAppts.get(ValuesGenerator.RandInt(random)%listAppts.size()));

              }*/

          }catch(NullPointerException e){
              
          }
          
          System.out.println("Done testing...");
		 
	 }

    /**
     * Generate Random Tests that tests getApptRange funciton with invalid appointments.
     */
    @Test
    public void radnomtest2()  throws Throwable  {
        
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
        //test getApptRange with invalid appointments
        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        //used to test list of empty appts on getApptRange function
        LinkedList<Appt> emptyAppts = new LinkedList<Appt>();
        
        System.out.println("Start testing...");
        
        try{
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed =System.currentTimeMillis(); //10
                //			System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);
                
                int startHour=-1*ValuesGenerator.RandInt(random);
                int startMinute=ValuesGenerator.RandInt(random);
                int startDay=ValuesGenerator.RandInt(random);
                int startMonth=3;//ValuesGenerator.RandInt(random);;
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
                for (int i = 0; i < NUM_TESTS; i++) {
                    String methodName = ApptRandomTest.RandomSelectMethod(random);
                    if (methodName.equals("setTitle")){
                        String newTitle=(String) ValuesGenerator.getString(random);
                        appt.setTitle(newTitle);
                    }
                    else if (methodName.equals("setRecurrence")){
                        int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
                        int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                        int recur=ApptRandomTest.RandomSelectRecur(random);
                        int recurIncrement = ValuesGenerator.RandInt(random);
                        int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
                        appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                    }
                }
                listAppts.add(appt);
                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if((iteration%10000)==0 && iteration!=0 )
                    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                
            }
            GregorianCalendar aDate = new GregorianCalendar(2017,4,1);
            GregorianCalendar anotherDate = new GregorianCalendar(2017,4,2);
            
            TimeTable timeTable=new TimeTable();
            //try with dates out of order first
            try{
                calDays = timeTable.getApptRange(listAppts,anotherDate,aDate);
            }catch(DateOutOfRangeException e){
                
            }
            //try to retrieve date range with invalid appointments
            //calDays = timeTable.getApptRange(listAppts,aDate,anotherDate);
            //try to retrieve date range with empty appointment list
            calDays = timeTable.getApptRange(emptyAppts,aDate,anotherDate);
        }catch(NullPointerException e){
            
        }
        
        System.out.println("Done testing...");
        
    }

	
}
