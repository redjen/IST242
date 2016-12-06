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
   
   private static GameHistoryRecord ghr;
   
   public GameHistoryRecordTest() {
   }
   
   @BeforeClass
   public static void setUpClass() {
      Calendar cal = Calendar.getInstance();
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
      assertEquals(2016, ghr.getDate().get(Calendar.YEAR));
      assertEquals(1, ghr.getDate().get(Calendar.MONTH));
      assertEquals(2, ghr.getDate().get(Calendar.DATE));
      assertEquals(3, ghr.getDate().get(Calendar.HOUR));
      assertEquals(4, ghr.getDate().get(Calendar.MINUTE));
      assertEquals(5, ghr.getDate().get(Calendar.SECOND));
   }

   @Test
   public void testToString() {
   }

   @Test
   public void testCompareTo() {
   }
   
}
