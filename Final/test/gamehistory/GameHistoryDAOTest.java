package gamehistory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class GameHistoryDAOTest {

   private static GameHistoryModel ghm;
   private static GameHistoryRecord rec1;
   private static GameHistoryRecord rec2;

   private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

   private static final String EXPECTED_REC1_STRING = "Test 1;;25;;02/02/2016 03:04:05;;\n";
   private static final String EXPECTED_REC2_STRING = "Test 2;;37;;03/03/2015 04:05:06;;\n";
   private static final String TEST_OUT_FILE = "resources/testsave.txt";
   private static final String TEST_IN_FILE = "resources/testread.txt";

   public GameHistoryDAOTest() {
   }

   @BeforeClass
   public static void setUp() {
      System.setOut(new PrintStream(outContent));

      ghm = new GameHistoryModel();

      Calendar cal = Calendar.getInstance();
      cal.set(2016, 1, 2, 3, 4, 5);

      rec1 = new GameHistoryRecord("Test 1", 25, cal);
      ghm.addRecord(rec1);

      cal = Calendar.getInstance();
      cal.set(2015, 2, 3, 4, 5, 6);
      rec2 = new GameHistoryRecord("Test 2", 37, cal);
      ghm.addRecord(rec2);
   }

   @Test
   public void testGetHistory() {
      GameHistoryDAO dao = new GameHistoryDAO(TEST_IN_FILE);
      ArrayList<GameHistoryRecord> records = dao.getHistory();
      assertNotNull(records);
      assertEquals(2, records.size());
      assertEquals("Test 2", records.get(0).getName());
      assertEquals("Test 1", records.get(1).getName());
      

   }

   @Test
   public void testWriteRecord() throws IOException {
      GameHistoryDAO dao = new GameHistoryDAO(TEST_OUT_FILE);
      dao.writeRecord(rec1, System.out);
      assertEquals(EXPECTED_REC1_STRING, outContent.toString());
   }

   @Test
   public void testWriteHistory() throws FileNotFoundException {
      String line;
      
      GameHistoryDAO dao = new GameHistoryDAO(TEST_OUT_FILE);
      dao.writeHistory(ghm.getHistory());
      
      Scanner s = new Scanner(new File(TEST_OUT_FILE));
      line = s.nextLine() + "\n";
      assertEquals(EXPECTED_REC2_STRING, line);
      line = s.nextLine() + "\n";
      assertEquals(EXPECTED_REC1_STRING, line);
      assertFalse(s.hasNextLine());
      s.close();
   }

}
