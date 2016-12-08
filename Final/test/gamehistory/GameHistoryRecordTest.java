package gamehistory;

import java.util.Calendar;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class GameHistoryRecordTest {
   
   // Have to be static to use in static methods.
   private static GameHistoryRecord ghr;
   private static Calendar cal;
   
   public GameHistoryRecordTest() {
   }
   
   @BeforeClass
   public static void setUpClass() {
      cal = Calendar.getInstance();
      cal.set(2016, 1, 2, 3, 4, 5);
      ghr = new GameHistoryRecord("Test", 100, cal);
   }

   @Test
   public void testGetName() {
      assertEquals("Test", ghr.getName());
   }

   @Test
   public void testGetScore() {
      assertEquals(100, ghr.getScore());
   }

   @Test
   public void testGetDate() {
      cal.set(Calendar.YEAR, 2020);
      assertEquals(2016, ghr.getDate().get(Calendar.YEAR));
      assertEquals(1, ghr.getDate().get(Calendar.MONTH));
      assertEquals(2, ghr.getDate().get(Calendar.DATE));
      assertEquals(3, ghr.getDate().get(Calendar.HOUR));
      assertEquals(4, ghr.getDate().get(Calendar.MINUTE));
      assertEquals(5, ghr.getDate().get(Calendar.SECOND));
   }

   @Test
   public void testToString() {
      String expected = "Test      100  02/02/2016 03:04:05";
      assertEquals(expected, ghr.toString());
   }

   @Test
   public void testCompareTo() {
      GameHistoryRecord ghr2 = new GameHistoryRecord("test 2", 500, Calendar.getInstance());
      assertEquals(true, ghr.compareTo(ghr2) >= 1);
      assertEquals(true, ghr2.compareTo(ghr) < 0);
   }
   
}
