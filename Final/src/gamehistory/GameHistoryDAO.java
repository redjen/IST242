package gamehistory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
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

      try {
         historyFile = new File(filePath);
                 
         if (historyFile.exists()) {
            in = new Scanner(historyFile);
            in = in.useDelimiter(DELIMITER);

            while (in.hasNextLine()) {
               GameHistoryRecord rec = readRecord(in);
               history.add(rec);
               in.nextLine();
            }
         }
         
         // if the hisotry file doesn't exist, skip and return the empty
         // arraylist

      } catch (GameHistoryException ex) {
         logger.warning(ex.getMessage());
         logger.warning(ex.getCause().getMessage());
         return null;
      } catch (FileNotFoundException ex) {
         Logger.getLogger(GameHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
      } finally {
         if (in != null) {
            in.close();
         }
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

      PrintStream out = null;
      File historyFile = null;

      try {
         historyFile = new File(filePath);
         if (historyFile.exists()) {
            historyFile.delete();
         }
         out = new PrintStream(historyFile);

         for (GameHistoryRecord rec : history) {
            writeRecord(rec, out);
         }

      } catch (IOException ex) {
         logger.warning(ex.getMessage());
      } finally {
         if (out != null) {

            out.close();
         }

      }
   }

   /**
    * Writes a single history record to the history file using an
    * established
    * PrintWriter.
    *
    * This method should be called when writing all records.
    *
    * @param rec The GameHistoryRecord
    * @param out The PrintWriter
    * @throws java.io.IOException
    */
   public void writeRecord(GameHistoryRecord rec, PrintStream out) throws IOException {
      out.print(rec.getName());
      out.print(DELIMITER);
      out.print(rec.getScore());
      out.print(DELIMITER);
      out.printf(SDF.format(rec.getDate().getTime()));
      out.print(DELIMITER);
      out.println();

//      out.printf("%s;;%d;;%s;;%n", rec.getName(), rec.getScore(),
//              SDF.format(rec.getDate().getTime()));
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
            throw new GameHistoryException("Name field missing from record.");
         }

         // score
         if (in.hasNextInt()) {
            score = in.nextInt();
         } else {
            throw new GameHistoryException("Score field missing from record.");
         }

         // date
         if (in.hasNext()) {
            rawDate = in.next();
            date.setTime(SDF.parse(rawDate));
         } else {
            throw new GameHistoryException("Date field missing from record.");
         }

         rec = new GameHistoryRecord(name, score, date);
      } catch (ParseException ex) {
         throw new GameHistoryException("An error occurred while reading from the history file.", ex);
      }

      // 
      return rec;
   }

}
