
package football;

import java.util.Random;

/**
 * The FootballPlayer class represents a football player and its attributes.
 */
public class FootballPlayer {
   
   private int number;
   private String firstName;
   private String lastName;
   private String position;
   private int age;

   public FootballPlayer(int number, String firstName, String lastName, String position, int age) {
      setNumber(number);
      setFirstName(firstName);
      setLastName(lastName);
      setPosition(position);
      setAge(age);
   }
   
   /**
    * Returns the player's information as a formatted string.
    * 
    * The attributes are displayed in this order: number, position, age, name.
    * 
    * @return the player's information as a formatted string.
    */
   @Override
   public String toString() {
      String stringFormat = "%-4d%-6s%-4d%s";
      
      return String.format(stringFormat, 
              getNumber(), getPosition(), getAge(),
              getFirstName() + " " + getLastName());
   }
   
    /**
    * Returns the player's rushing yards statistic.
    * 
    * @return the rushing yards
    */
   public int getRushingYards() {
      Random rand = new Random();
      return rand.nextInt(101);
   }

   /**
    * Returns the player number.
    * 
    * @return the player's number
    */
   public int getNumber() {
      return number;
   }

   /**
    * Set's the player's number.
    * 
    * @param number the new number
    */
   public void setNumber(int number) {
      this.number = number;
   }

   /**
    * Returns the player's first name.
    * 
    * @return the player's first name
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * Sets the player's first name.
    * 
    * @param firstName the new first name
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * Returns the player's last name.
    * 
    * @return the player's last name
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * Sets the player's last name.
    * 
    * @param lastName the new last name
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * Returns the player's position.
    * 
    * @return the player's position
    */
   public String getPosition() {
      return position;
   }

   /**
    * Sets the player's position.
    * 
    * @param position the new position
    */
   public void setPosition(String position) {
      this.position = position;
   }

   /**
    * Returns the player's age in years.
    * 
    * @return the player's age
    */
   public int getAge() {
      return age;
   }

   /**
    * Sets the player's age.
    * 
    * Note that ages can't be negative.
    * 
    * @param age the new age in years
    */
   public void setAge(int age) {
      
      if (age < 1) {
         throw new IllegalArgumentException("Age cannot be less than 1.");
      }
      
      this.age = age;
   }
   
   
}
