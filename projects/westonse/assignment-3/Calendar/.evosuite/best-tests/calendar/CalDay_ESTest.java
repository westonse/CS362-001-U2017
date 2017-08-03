/*
 * This file was automatically generated by EvoSuite
 * Thu Aug 03 05:14:01 GMT 2017
 */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class CalDay_ESTest extends CalDay_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      calDay0.appts = linkedList0;
      Appt appt0 = new Appt((-470), 0, 0, 0, (-470), "e?In", (String) null);
      linkedList0.add(appt0);
      Appt appt1 = new Appt(0, 0, 1, 1, 1, "", (String) null);
      calDay0.addAppt(appt1);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Locale locale0 = Locale.FRENCH;
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(locale0);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      calDay0.isValid();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(1, 1, 1, 1, 1);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      calDay0.getYear();
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.year = (-298);
      calDay0.getYear();
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      calDay0.appts = linkedList0;
      Appt appt0 = new Appt(0, 0, 1, 1, 1, "", (String) null);
      calDay0.addAppt(appt0);
      calDay0.getSizeAppts();
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(2513, 2513, 1377);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      calDay0.appts.add((Appt) null);
      calDay0.appts.add((Appt) null);
      calDay0.getSizeAppts();
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, (-1380), 0);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      calDay0.getSizeAppts();
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.month = 828;
      calDay0.getMonth();
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.month = (-2442);
      calDay0.getMonth();
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.month = 3512;
      calDay0.getDay();
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.month = (-1275);
      calDay0.getDay();
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      calDay0.getAppts();
      assertEquals(2014, calDay0.getYear());
      assertEquals(1, calDay0.getDay());
      assertTrue(calDay0.isValid());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      calDay0.appts = linkedList0;
      Appt appt0 = new Appt(0, 0, 0, 2, 0, "", "\"&z:");
      linkedList0.add(appt0);
      LinkedList<Appt> linkedList1 = calDay0.getAppts();
      assertEquals(1, linkedList1.size());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      // Undeclared exception!
      try { 
        calDay0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      calDay0.appts = null;
      // Undeclared exception!
      try { 
        calDay0.iterator();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      CalDay calDay0 = null;
      try {
        calDay0 = new CalDay((GregorianCalendar) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-743), (-743), (-743), (-743), (-743));
      mockGregorianCalendar0.setLenient(false);
      CalDay calDay0 = null;
      try {
        calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // YEAR
         //
         assertThrownBy("java.util.GregorianCalendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      boolean boolean0 = calDay0.isValid();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      assertNull(linkedList0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getYear();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getDay();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getMonth();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(0, 0, 0, 0, 0, "", "");
      linkedList0.add(appt0);
      calDay0.appts = linkedList0;
      String string0 = calDay0.toString();
      assertEquals("\t --- 0/0/0 --- \n --- -------- Appointments ------------ --- \nnull \n", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      String string0 = calDay0.toString();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, (-1380), 0);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      Iterator<?> iterator0 = calDay0.iterator();
      assertNotNull(iterator0);
      assertEquals(11, calDay0.getDay());
      assertEquals(117, calDay0.getYear());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      Iterator<?> iterator0 = calDay0.iterator();
      assertNull(iterator0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      calDay0.appts = linkedList0;
      Appt appt0 = new Appt(0, 0, 1, 1, 1, "", (String) null);
      calDay0.addAppt(appt0);
      calDay0.addAppt(appt0);
      assertFalse(calDay0.isValid());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      calDay0.appts = linkedList0;
      Appt appt0 = new Appt(8, 739, 8, 0, 3013, "", "_!k= yGxFfS6gAo");
      calDay0.appts.add(appt0);
      Appt appt1 = new Appt(0, 0, 1, 1, 1, "", (String) null);
      calDay0.addAppt(appt1);
      calDay0.addAppt(appt1);
      assertFalse(calDay0.isValid());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      Appt appt0 = new Appt(0, 0, (-1275), 0, 4092, "\t", "\t");
      calDay0.addAppt(appt0);
      assertFalse(calDay0.isValid());
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      Appt appt0 = new Appt(0, 0, 1, 1, 1, "", (String) null);
      // Undeclared exception!
      try { 
        calDay0.addAppt(appt0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("calendar.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      // Undeclared exception!
      try { 
        calDay0.getSizeAppts();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("calendar.CalDay", e);
      }
  }
}
