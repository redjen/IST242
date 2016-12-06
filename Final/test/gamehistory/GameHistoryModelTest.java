package gamehistory;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class GameHistoryModelTest {
   
   private static GameHistoryModel ghm;
   private static GameHistoryRecord rec1;
   private static GameHistoryRecord rec2;
   
   public GameHistoryModelTest() {
      
      
   }
   
   @BeforeClass
   public static void setUp() {
      ghm = new GameHistoryModel();
      
      Calendar cal = Calendar.getInstance();
      cal.set(2016, 1, 2, 3, 4, 5);
      rec1 = new GameHistoryRecord("Test 1", 25, cal);
      
      cal.set(2015, 2, 3, 4, 5, 6);
      rec2 = new GameHistoryRecord("Test 2", 37, cal);
   }


   @Test
   public void testGetHistory() {
      ghm.addRecord(rec1);
      ghm.addRecord(rec2);
      
      ArrayList<GameHistoryRecord> list = ghm.getHistory();
      assertTrue(list.size() == 2);
      assertEquals(37, list.get(0).getScore());
      assertEquals(25, list.get(1).getScore());
   }

   
}
