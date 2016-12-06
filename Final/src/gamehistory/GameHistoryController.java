package gamehistory;

import java.util.Calendar;

/**
 * The GameHistoryController class represents
 * 
 */
public class GameHistoryController {
   
   private GameHistoryModel history;

   public GameHistoryController() {
      history = new GameHistoryModel();
      history.loadHistory();
   }
   
   public void addHighScore(String name, int score, Calendar cal) {
      
      GameHistoryRecord rec = new GameHistoryRecord(name, score, cal);
      history.addRecord(rec);
      history.save();
      System.out.print(history.toString());
      
   }
   
   public int getHighScore() {
      return history.getHighScore();
   }
   
   public String getHistoryAsString() {
      String historyList = "";
      historyList = history.toString();
      return historyList;
   }
   
}
