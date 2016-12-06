package gamehistory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * The GameHistoryRecord class represents a single record in the game's
 scoring history. It records the user's name, score, and the time the game
 * ended. The record is comparable and ordered by score.
 * 
 */
public class GameHistoryRecord implements Comparable<GameHistoryRecord> {
   
   private String name;
   private int score;
   private Calendar date;
   private final String STRING_FORMAT = "%-10s%-5d%s";
   private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(("MM/dd/yyyy HH:mm:ss"));

   public GameHistoryRecord(String name, int score, Calendar date) {
      this.name = name;
      this.score = score;
      this.date = date;
   }

   /**
    * Return the name of the user.
    * @return the user's name
    */
   public String getName() {
      return name;
   }

   /**
    * Return the high score.
    * 
    * @return the high score
    */
   public int getScore() {
      return score;
   }

   /**
    * Returns the game's date. 
    * @return the game's date
    */
   public Calendar getDate() {
      return date;
   }

   @Override
   public String toString() {
      return String.format(STRING_FORMAT, getName(), getScore(), 
              DATE_FORMAT.format(date.getTime()));
   }
   
   /**
    * Sorts records by score descending.
    * 
    * @param o
    * @return 
    */
   @Override
   public int compareTo(GameHistoryRecord o) {
      return Integer.compare(o.score, this.score);
   }
   
   

}
