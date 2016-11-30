package people;

/**
 * The Person class represents a person with a name and age.
 *
 * The toString() method returns the person's information in the form "first
 * name last name / age years".
 *
 */
public class Person {

   private String firstName;
   private String lastName;
   private int age;

   public Person(String firstName, String lastName, int age) {
      setFirstName(firstName);
      setLastName(lastName);
      setAge(age);
   }

   /**
    * Returns the person's first name.
    *
    * @return the first name.
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * Sets the person's first name.
    *
    * @param firstName the new first name
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * Returns the person's last name.
    *
    * @return the last name
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * Sets the person's last name.
    *
    * @param lastName the new last name
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * Returns the person's age.
    *
    * @return the age
    */
   public int getAge() {
      return age;
   }

   /**
    * Sets the person's age.
    *
    * The age must be greater than 0 or an IllegalArgumentException will be
    * thrown.
    *
    * @param age the new age
    */
   public void setAge(int age) {

      if (age < 0) {
         throw new IllegalArgumentException("Age must be greater than 0.");
      }

      this.age = age;

   }

   /**
    * The toString() method returns the person's information in the form "first
    * name last name / age years".
    *
    * @return
    */
   @Override
   public String toString() {
      String stringFormat = "%s %s / %d years";
      
      return String.format(stringFormat, getFirstName(), getLastName(), getAge());
   }

}
