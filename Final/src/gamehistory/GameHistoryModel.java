package gamehistory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The GameHistoryModel class represents
 *
 */
public class GameHistoryModel {

   private ArrayList<GameHistoryRecord> history;

   private final String HISTORY_FILE_PATH = "resources/history";
   private final int MAX_RECORDS = 20;

   public GameHistoryModel() {
      
      GameHistoryDAO dao = new GameHistoryDAO(HISTORY_FILE_PATH);
      history = dao.getHistory();   

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
    * @return complete history as an ArrayList
    */
   public ArrayList<GameHistoryRecord> getHistory() {
      return history;
   }
   
   public void save() {
      GameHistoryDAO dao = new GameHistoryDAO(HISTORY_FILE_PATH);
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
