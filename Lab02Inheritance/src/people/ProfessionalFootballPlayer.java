package people;

/**
 * The ProfessionalFootballPlayer class represents a football player and its
 * attributes.
 */
public class ProfessionalFootballPlayer extends Person implements FootballPlayer {

   private int number;
   private String position;

   /**
    * Constructs and instantiates a new FootballPlayer object
    *
    * @param firstName first name
    * @param lastName last name
    * @param age age (non-negative integer)
    * @param number player number
    * @param position player position
    */
   public ProfessionalFootballPlayer(String firstName, String lastName, int age, int number, String position) {
      super(firstName, lastName, age);

      setNumber(number);
      setPosition(position);
   }

   /**
    * Constructs and initializes a CollegeFootballPlayer with default
    * characteristics.
    *
    * All name fields are set to empty strings, the age is set to 0, the player
    * number is set to 0, and the player position is set to unknown ("UNK").
    */
   public ProfessionalFootballPlayer() {
      // per discussion, the default can be creating a player with no info
      // and the player number 0.
      super("", "", 0);
      setNumber(0);
      setPosition("UNK");
   }

   /**
    * Provides all CollegeFootballPlayer information as a single string.
    *
    * @return
    */
   @Override
   public String getAllInfo() {

      // follows the same format as Person
      return super.getInfo() + " Player number: " + number
              + " Player position: " + position + " Instant rushing yards: "
              + getRushingYards();
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

}
