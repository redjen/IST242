package gamehistory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The GameHistoryModel class represents
 *
 */
public class GameHistoryModel {

   private ArrayList<GameHistoryRecord> history;

   // this constant/field needs to be static because it's used in the empty
   // constructor as a parameter to another constructor.
   private final static String DEFAULT_HISTORY_FILE_PATH  = "resources/history.txt";
   
   private final String historyFilePath;
   private final int MAX_RECORDS = 20;

   public GameHistoryModel() {
      
      this(DEFAULT_HISTORY_FILE_PATH);

   }

   public GameHistoryModel(String historyFilePath) {
      this.historyFilePath = historyFilePath;
      history = new ArrayList<>();
   }
   
   

   public void loadHistory() {
      GameHistoryDAO dao = new GameHistoryDAO(historyFilePath);      
      history.addAll(dao.getHistory());
      
   }
   
   /**
    * Adds a new record to the history.
    *
    * If there are more than the maximum number of records in the list, the
    * lowest score will be removed.
    *
    * @param rec GameHistoryRecord to add
    */
   public void addRecord(GameHistoryRecord rec) {

      history.add(rec);
      Collections.sort(history);
      if (history.size() > MAX_RECORDS) {
         history.remove(history.size() - 1);
      }

   }

   /**
    * Returns the complete history
    *
    * @return complete history as an ArrayList sorted by high score descending
    */
   public ArrayList<GameHistoryRecord> getHistory() {
      ArrayList<GameHistoryRecord> copy = new ArrayList<>(history);
      return copy;
   }
   
   public void save() {
      GameHistoryDAO dao = new GameHistoryDAO(historyFilePath);
      dao.writeHistory(history);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();

      for (GameHistoryRecord rec : history) {
         sb.append(String.format("%s%n", rec.toString()));
      }

      return sb.toString();
   }

}
