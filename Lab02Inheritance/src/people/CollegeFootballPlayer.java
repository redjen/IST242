
package people;

/**
 * The CollegeFootballPlayer class represents a student that is also a football
 * player.
 * 
 */
public class CollegeFootballPlayer extends Student implements FootballPlayer {
   
   private int number;
   private String position;
   
   /**
    * Constructs and initializes a CollegeFootballPlayer with the specified 
    * characteristics.
    * 
    * @param informedFirstName first name
    * @param informedLastName last name
    * @param informedAge age
    * @param informedMajor college major
    * @param number football player number
    * @param position football player position
    */
   public CollegeFootballPlayer(String informedFirstName, String informedLastName, 
           int informedAge, String informedMajor, int number, String position) {
      super(informedFirstName, informedLastName, informedAge, informedMajor);
      setNumber(number);
      setPosition(position);
   }
   
   /**
    * Constructs and initializes a CollegeFootballPlayer with default
    * characteristics. 
    * 
    * All student-related fields are set to empty strings, the age is set to 0, 
    * the player number is set to 0, and the player position is set to unknown
    * ("UNK").
    */
   public CollegeFootballPlayer() {
      super("", "", 0, "");
      setNumber(0);
      setPosition("UNK");
   }
   
   
   /**
    * Provides all CollegeFootballPlayer information as a single string.
    * @return 
    */
   @Override
   public String getAllInfo() {
     
      return super.getAllInfo() + " " + number + " " + position + " " +
              getRushingYards();
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
      return number;
   }

   /**
    * Set's the player's number.
    * 
    * @param number the new number
    */
   @Override
   public void setNumber(int number) {
      this.number = number;
   }

   /**
    * Returns the player's position.
    * 
    * @return the player's position
    */
   @Override
   public String getPosition() {
      return this.position;
   }

   /**
    * Sets the player's position.
    * 
    * @param position the new position
    */
   @Override
   public void setPosition(String position) {
      this.position = position;
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
      String stringFormat = "%-4d%-6s%-5d%-4d%s";
      
      return String.format(stringFormat, 
              getNumber(), getPosition(), getAge(), getRushingYards(),
              getFirstName() + " " + getLastName());
   }
   
}
