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
public class ProfessionalFootballPlayer extends Athlete implements FootballPlayer {

   private int footballNumber;
   private String footballPosition;

   public ProfessionalFootballPlayer(String firstName, String lastName, int age, String athleticTitle,
           int footballNumber, String footballPosition) {
      
      super(firstName, lastName, age, athleticTitle);
      setNumber(footballNumber);
      setPosition(footballPosition);
   }
   
   /**
    * Prints the player's information.
    */
   @Override
   public void printInfo() {
      super.printInfo();
      System.out.printf("%d %s%n", getNumber(), getPosition());
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
   
}
