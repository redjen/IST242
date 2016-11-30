
package people;

/**
 * The FootballPlayer interface represents a generic football player. 
 * 
 * The FootballPlayer is basic and requires that objects support the essential
 * characteristics of a member of a football team. 
 * 
 */
public interface FootballPlayer extends Athlete {
   
   /**
    * Returns the player's instant rushing yards.
    * 
    * @return player's instant yards.
    */
   public int getRushingYards();
   
   /**
    * Returns the player number.
    * 
    * @return the player's number
    */
   public int getNumber();
   
   /**
    * Set's the player's number.
    * 
    * @param number the new number
    */
   public void setNumber(int number);
   
   /**
    * Returns the player's position.
    * 
    * @return the player's position
    */
   public String getPosition();
   
   /**
    * Sets the player's position.
    * 
    * @param position the new position
    */
   public void setPosition(String position);  
   
   /**
    * Returns the player's number, position, and name as a formatted string.
    * @return string of player's basic information
    */
   public String getSummaryInfo();
}
