/*
 * This file was automatically generated by EvoSuite
 * Thu Aug 03 05:14:16 GMT 2017
 */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import calendar.CalendarUtil;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class CalendarUtil_ESTest extends CalendarUtil_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      int[] intArray0 = new int[4];
      CalendarUtil.DaysInMonth = intArray0;
      int int0 = CalendarUtil.NumDaysInMonth(858, 0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      CalendarUtil calendarUtil0 = new CalendarUtil();
      calendarUtil0.DaysInMonth = calendarUtil0.DaysInMonth;
      int[] intArray0 = new int[3];
      intArray0[0] = (-757);
      calendarUtil0.DaysInMonth = intArray0;
      int int0 = CalendarUtil.NumDaysInMonth(0, 0);
      assertEquals((-757), int0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      // Undeclared exception!
      try { 
        CalendarUtil.NumDaysInMonth(2, (-2441));
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // -2441
         //
         assertThrownBy("calendar.CalendarUtil", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear((-280));
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear(100);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear(0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      boolean boolean0 = CalendarUtil.IsLeapYear((-2441));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      int int0 = CalendarUtil.NumDaysInMonth(4324, 1);
      assertEquals(29, int0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      int int0 = CalendarUtil.NumDaysInMonth((-1700), 0);
      assertEquals(31, int0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      CalendarUtil calendarUtil0 = new CalendarUtil();
      calendarUtil0.DaysInMonth = null;
      // Undeclared exception!
      try { 
        CalendarUtil.NumDaysInMonth(1653, (-2072));
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("calendar.CalendarUtil", e);
      }
  }
}
