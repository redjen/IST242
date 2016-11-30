package people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The Athlete class represents an athlete.
 *
 * Interfaces for specific types of athletes should extend this interface.
 *
 */
public abstract class Athlete extends Person {

   private String athleticTitle;
   private SortedMap<Integer, List<String>> athleticAwards;

   public Athlete() {
      this("", "", 0, "");
   }
   
   public Athlete(String firstName, String lastName, int age, String athleticTitle) {
      super(firstName, lastName, age);
          
      setAthleticTitle(athleticTitle);
      
      athleticAwards = new TreeMap<>();
     
   }

   /**
    * Prints the player's information.
    */
   public void printInfo() {
      System.out.printf("Name: %s %s%n", getFirstName(), getLastName());
      System.out.println(getAthleticTitle());
      System.out.printf("Age: %d%n", getAge());
   }
   
   /**
    * Prints the player's awards.
    */
   public void printAwards() {
      String format = "%d  %s%n";
      
      if (athleticAwards.size() > 0) {
         System.out.println("YEAR  AWARD");
         
         for (Map.Entry<Integer, List<String>> entry : athleticAwards.entrySet()) {
            Integer year = entry.getKey();
            List<String> awards = entry.getValue();
            
            for (String award : awards) {
               System.out.printf(format, year, award);
            }
            
         }
      } else {
         System.out.println("No awards.");
      }
      
   }

   /**
    * Sets the athlete's title
    *
    * @param athleticTitle the new title
    */
   public void setAthleticTitle(String athleticTitle) {
      this.athleticTitle = athleticTitle;
   }

   /**
    * Returns the athlete's title
    *
    * @return the title
    */
   public String getAthleticTitle() {
      return athleticTitle;
   }

   /**
    * Adds an award.
    *
    * @param year the year the award was earned
    * @param award the award name
    */
   public void addAthleticAward(int year, String award) {

      List<String> awards;

      if (athleticAwards.containsKey(year)) {
         athleticAwards.get(year).add(award);
         Collections.sort(athleticAwards.get(year));
      } else {
         awards = new ArrayList<>();
         awards.add(award);
         athleticAwards.put(year, awards);
      }
   }

   /**
    * Returns the complete list of athletic awards.
    *
    * The awards are sorted by year then title
    *
    * @return the awards
    */
   public TreeMap<Integer, List<String>> getAwards() {

      TreeMap<Integer, List<String>> awards = new TreeMap<>(athleticAwards);
      return awards;
   }

   /**
    * Returns the athletic awards earned in the specified year.
    *
    * The awards are sorted by year then title
    *
    * @param year the year
    * @return the awards
    */
   public TreeMap<Integer, List<String>> getAwards(int year) {

      TreeMap<Integer, List<String>> awards = new TreeMap<>();

      if (athleticAwards.containsKey(year)) {
         awards.put(year, athleticAwards.get(year));
      }

      return awards;
   }

   /**
    * Returns the athletic awards earned in the specified time period.
    *
    * The awards are sorted by year then title
    *
    * @param startYear first year
    * @param endYear final year
    * @return the awards
    */
   public TreeMap<Integer, List<String>> getAwards(int startYear, int endYear) {

      TreeMap<Integer, List<String>> awards = new TreeMap<>();

      for (int i = startYear; i <= endYear; ++i) {
         if (athleticAwards.containsKey(i)) {
            awards.put(i, athleticAwards.get(i));
         }
      }

      return awards;
   }
}
