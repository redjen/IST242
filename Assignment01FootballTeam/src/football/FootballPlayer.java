
package football;

/**
 * The FootballPlayer class represents a football player and its attributes.
 */
public class FootballPlayer {
   
   private int number;
   private String firstName;
   private String lastName;
   private String position;
   private int age;

   /**
    * Instantiates a new FootballPlayer object.
    * 
    * @param number player's number
    * @param firstName player's first name
    * @param lastName player's last name
    * @param position player's position
    * @param age player's age (must be positive)
    */
   public FootballPlayer(int number, String firstName, String lastName, String position, int age) {
      setNumber(number);
      setFirstName(firstName);
      setLastName(lastName);
      setPosition(position);
      setAge(age);
   }
   
   /**
    * Instantiates a new FootballPlayer with no name, 0 for the player number, 
    * NA for the position, and 0 for the age.
    */
   public FootballPlayer() {
       // per discussion, the default can be creating a player with no info
       // and the player number 0.
      this(0, "Unassigned", "", "NA", 0);
   }
   
   /**
    * Returns the player's instant rushing yards.
    * 
    * @return player's instant yards.
    */
   public int getRushingYards() {
       // the rushing yards is a random number between 0 and 100 (inclusive)
       // and generated each time the method is called.
       return (int) (Math.random() * 101);
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
       // TODO add rushing yards
      String stringFormat = "%-4d%-6s%-5d%-4d%s";
      
      return String.format(stringFormat, 
              getNumber(), getPosition(), getAge(), getRushingYards(),
              getFirstName() + " " + getLastName());
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
      
      if (age < 0) {
         throw new IllegalArgumentException("Age cannot be less than 0.");
      }
      
      this.age = age;
   }
   
   
}
