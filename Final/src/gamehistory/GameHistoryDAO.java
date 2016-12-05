package gamehistory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The GameHistoryDAO class represents
 * 
 */
public class GameHistoryDAO {
   
   private static final Logger logger = Logger.getLogger("GameHistoryDAO");
   
   private String filePath;
   private final SimpleDateFormat SDF = new SimpleDateFormat(("MM/dd/yyyy HH:mm:ss"));
   private final String DELIMITER = ";;";
   
   public GameHistoryDAO(String filePath) {
      this.filePath = filePath;
   }
   
      
   /**
    * Returns the history from the history file.
    * 
    * @return ArrayList of all history records
    */
   public ArrayList<GameHistoryRecord> getHistory() {
      ArrayList<GameHistoryRecord> history = new ArrayList();
      File historyFile = null;
      Scanner in = null;
      in.useDelimiter(DELIMITER);
      
      
      
      try {
         historyFile = new File(filePath);
         in = new Scanner(historyFile);
         
         while(in.hasNextLine()) {
            in.nextLine();
            GameHistoryRecord rec = readRecord(in);
            history.add(rec);
         }
         
      } catch (FileNotFoundException | GameHistoryException ex) {
         logger.warning(ex.getMessage());
         return null;
      } finally {
         in.close();
      }
      
      
      return history;
   }
   
   /**
    * Writes the history to the history file
    * 
    * @param history containing history records 
    */
   // parameter is final because ArrayList is passed by reference and should
   // not be overwritten; this is less costly than copying it.
   public void writeHistory(final ArrayList<GameHistoryRecord> history) {
      
      PrintWriter out = null;
      File historyFile = null;
      
         
      try {
         historyFile = new File(filePath);
         out = new PrintWriter(historyFile);
         
         for (GameHistoryRecord rec : history) {
            writeRecord(rec, out);
         }
         
      } catch (FileNotFoundException ex) {
         logger.warning(ex.getMessage());
      } finally {
         out.flush();
         out.close();
      }
            
      
      
      
   }
   
   /**
    * Writes a single history record to the history file using an established PrintWriter.
    * 
    * This method should be called when writing all records.
    * 
    * @param rec The GameHistoryRecord
    * @param out The PrintWriter
    */
   private void writeRecord(GameHistoryRecord rec, PrintWriter out) {
         out.printf("%s;;%d;;%s;;%n", rec.getName(), rec.getScore(),
                 SDF.format(rec.getDate().getTime()));      
   }
   
   /**
    * Reads a single GameHistoryRecord from the history file
    * 
    * @param in Scanner 
    * @return the next GameHistoryRecord
    * @throws GameHistoryException when an error occurs when reading 
    */
   private GameHistoryRecord readRecord(Scanner in) throws GameHistoryException {
      GameHistoryRecord rec = null;
      String name;
      int score;
      String rawDate;
      Calendar date = Calendar.getInstance();
      
      try {
// user name
         if (in.hasNext()) {
            name = in.next();
         } else {
            throw new GameHistoryException();
         }

         // score
         if (in.hasNextInt()) {
            score = in.nextInt();
         } else {
            throw new GameHistoryException();
         }

         // date
         if (in.hasNext()) {
            rawDate = in.next();
            date.setTime(SDF.parse(rawDate));
         }
         
         rec = new GameHistoryRecord(name, score, date);
      } catch (ParseException parseException) {
         throw new GameHistoryException("An error occurred while reading from the history file.");
      }
      
      // 
      
      
      return rec;
   }
  

}
