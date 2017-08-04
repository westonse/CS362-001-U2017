package calendar;
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
	 }

	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
         int a[]=new int[5];
         a[0]=0;
         a[1]=1;
         a[2]=2;
         a[3]=3;
         a[4]=4;
          
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
          //test setter functions
          appt.setStartHour(14);
          appt.setStartMinute(45);
          appt.setStartDay(11);
          appt.setStartMonth(5);
          appt.setStartYear(2018);
          appt.setTitle("This is my new birthday");
          appt.setDescription("This is my new birthday party.");
          appt.setRecurrence(a,0,0,0);
          String day= appt.getStartMonth()+"/"+appt.getStartDay()+"/"+appt.getStartYear() + " at ";
          String thatDay = appt.toString();
	// assertions
		assertEquals(14, appt.getStartHour());
		assertEquals(45, appt.getStartMinute());
        assertEquals(11, appt.getStartDay());
        assertEquals(05, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("This is my new birthday", appt.getTitle());
        assertEquals("This is my new birthday party.", appt.getDescription());
        assertEquals(0, appt.getRecurNumber());
        assertEquals(0, appt.getRecurBy());
        assertEquals(a, appt.getRecurDays());
        assertEquals(false, appt.isRecurring());
        assertEquals(0, appt.getRecurIncrement());
        assertFalse("Day != day",day == thatDay);

	 }
    @Test
    public void test03()  throws Throwable  {
        //test out of bounds and null cases
        
        //test out of bounds for hour
        int startHour=25;
        int startMinute=22;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title=null;
        String description = null;
        int a[]= null;

        //Construct a new Appointment object with the initial data
        Appt appt1 = new Appt(startHour,
                             startMinute ,
                             startDay ,
                             startMonth ,
                             startYear ,
                             title,
                             description);
        //test null reccurrence
        appt1.setRecurrence(a,0,0,0);

        //test out of bounds for minute
        startHour=0;
        startMinute=61;
        startDay=10;
        startMonth=4;
        startYear=2017;
        Appt appt2 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        //test out of bounds for day
        startHour=22;
        startMinute=22;
        startDay=32;
        startMonth=4;
        startYear=2017;
        Appt appt3 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        //test out of bounds for month
        startHour=22;
        startMinute=22;
        startDay=10;
        startMonth=0;
        startYear=2017;
        Appt appt4 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        //test out of bounds for hour
        startHour=-1;
        startMinute=4;
        startDay=10;
        startMonth=4;
        startYear=2017;
        
        //test out of bounds for hour with negative number 
        Appt appt5 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);

        
        //test out of bounds for minute
        startHour=22;
        startMinute=-1;
        startDay=10;
        startMonth=4;
        startYear=2017;
        
        //test out of bounds for minute with negative number
        Appt appt6 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        //test out of bounds for day
        startHour=22;
        startMinute=33;
        startDay=-1;
        startMonth=4;
        startYear=2017;
        
        //test out of bounds for day
        Appt appt7 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        
        
        //test out of bounds for month
        startHour=22;
        startMinute=12;
        startDay=10;
        startMonth=15;
        startYear=2017;
        try{
            //test out of bounds for month
            Appt appt8 = new Appt(startHour,
                                  startMinute ,
                                  startDay ,
                                  startMonth ,
                                  startYear ,
                                  title,
                              description);
            assertFalse(appt8.getValid());
        }catch( ArrayIndexOutOfBoundsException e){}
        
        //assertions
        assertFalse(appt1.getValid());
        assertFalse(appt2.getValid());
        assertFalse(appt3.getValid());
        assertFalse(appt4.getValid());
        assertFalse(appt5.getValid());
        assertFalse(appt6.getValid());
        assertFalse(appt7.getValid());
        assertNull(appt1.toString());
        

        
        
        
    }
    @Test
    public void test04()  throws Throwable  {
        //test mutation of setters
        
        int startHour=20;
        int startMinute=22;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title=null;
        String description = null;
        //int a[]= {1,2,3};
        
        //Construct a new Appointment object with the initial data
        Appt appt1 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        Appt appt2 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        Appt appt3 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        Appt appt4 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        //test set reccurrence
        //appt1.setRecurrence(a,0,0,0);
        
        //test start hour setter
        appt1.setStartHour(-1);
        //test start minute setter
        appt2.setStartMinute(-1);
        //test start day setter
        appt3.setStartDay(-1);
        //test start month setter
        appt4.setStartMonth(0);

        //assertions
        assertFalse(appt1.getValid());
        assertFalse(appt2.getValid());
        assertFalse(appt3.getValid());
        assertFalse(appt4.getValid());

        
        
        
    }
    @Test
    public void test05()  throws Throwable  {
        //test mutation of toString()
        int startHour=13;
        int startMinute=22;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title=null;
        String description = null;
        //int a[]= {1,2,3};
        
        // >12 case
        Appt appt = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        String day= appt.getStartMonth()+"/"+appt.getStartDay()+"/"+appt.getStartYear() + " at ";
        String compareDay = "\t"+ day +  "1:22pm"  + " ," +  appt.getTitle()+ ", "+  appt.getDescription()+"\n";
        String thatDay = appt.toString();
        // <12 case
        Appt appt1 = new Appt(11,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        String day1= appt1.getStartMonth()+"/"+appt1.getStartDay()+"/"+appt1.getStartYear() + " at ";
        String compareDay1 = "\t"+ day1 +  "11:22am"  + " ," +  appt1.getTitle()+ ", "+  appt1.getDescription()+"\n";
        String thatDay1 = appt1.toString();
        //==12 case
        Appt appt2 = new Appt(12,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        String day2= appt2.getStartMonth()+"/"+appt2.getStartDay()+"/"+appt2.getStartYear() + " at ";
        String compareDay2 = "\t"+ day2 +  "12:22pm"  + " ," +  appt2.getTitle()+ ", "+  appt2.getDescription()+"\n";
        String thatDay2 = appt2.toString();
        
        //assertions
        assertEquals(compareDay,thatDay);
        assertEquals(compareDay1,thatDay1);
        assertEquals(compareDay2,thatDay2);
        
    }

    @Test
    public void test06()  throws Throwable  {
        //test reccurrence setter
        int startHour=25;
        int startMinute=22;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title=null;
        String description = null;
        int a[]= {1,2,3};
        
        //Construct a new Appointment object with the initial data
        Appt appt1 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        //test reccurrence
        appt1.setRecurrence(a,1,1,1);
        
        //assertions
        assertEquals(1,appt1.getRecurBy());
        assertEquals(1,appt1.getRecurIncrement());
        assertEquals(1,appt1.getRecurNumber());

    }
    @Test
    public void test07()  throws Throwable  {
        //test default reccurrence setter
        int startHour=25;
        int startMinute=22;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title=null;
        String description = null;
        
        //Construct a new Appointment object with the initial data
        Appt appt1 = new Appt(startHour,
                              startMinute ,
                              startDay ,
                              startMonth ,
                              startYear ,
                              title,
                              description);
        
        //assertions
        assertEquals(2,appt1.getRecurBy());
        
    }

//add more unit tests as you needed
	
}
