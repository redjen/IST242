/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;


/**
 *
 * @author redjen
 */
public class CollegeFootballPlayer extends CollegeAthlete implements FootballPlayer {

   private int footballNumber;
   private String footballPosition;
   
   public CollegeFootballPlayer() {
      this(0, "", "", "", 0);
   }

   public CollegeFootballPlayer(int footballNumber, String footballPosition, String firstName, String lastName, int age) {
      super(firstName, lastName, age);
      setNumber(age);
      setPosition(footballPosition);
   }

   
      
   /**
    * Returns the player's instant rushing yards.
    * 
    * @return player's instant yards.
    */
   @Override
   public int getRushingYards() {
      // the rushing yards is a random number between 0 and 100 (inclusive)
       // and generated each time the method is called.
       return (int) (Math.random() * 101);
   }

   /**
    * Returns the player number.
    * 
    * @return the player's number
    */
   @Override
   public int getNumber() {
      return footballNumber;
   }

   /**
    * Set's the player's number.
    * 
    * @param number the new number
    */
   @Override
   public void setNumber(int number) {
      this.footballNumber = number;
   }

   /**
    * Returns the player's position.
    * 
    * @return the player's position
    */
   @Override
   public String getPosition() {
      return this.footballPosition;
   }

   /**
    * Sets the player's position.
    * 
    * @param position the new position
    */
   @Override
   public void setPosition(String position) {
      this.footballPosition = position;
   }

   @Override
   public String toString() {
      String athleteString = super.toString();
      String stringFormat = "%s / #%d / %s";
      
      return String.format(stringFormat, athleteString, getNumber(), getPosition());
   }
   
   public String getSummaryInfo() {
      String format = "  #%5d%15s     %s";
      return String.format(format, getNumber(), getPosition(), getFirstName() + " " + getLastName());
   }
   
}
