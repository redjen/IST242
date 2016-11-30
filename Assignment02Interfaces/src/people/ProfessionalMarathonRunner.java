package people;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ProfessionalMarathonRunner class represents a person that runs marathons.
 *
 */
public class ProfessionalMarathonRunner extends Athlete implements Marathoner {

   private List<Integer> paces;
   private int averagePace;
   private int fastestPace; // in seconds/mile

   public ProfessionalMarathonRunner(String firstName, String lastName, int age, String athleticTitle) {
      super(firstName, lastName, age, athleticTitle);

      paces = new ArrayList<>();
   }
   
   @Override
   public void printInfo() {
      super.printInfo();
      if (fastestPace > 0) {
         System.out.printf("Fastest pace: %d:%2d%n", (int) fastestPace / 60, fastestPace % 60);
      }
      
   }

   /**
    * Gets the average of all recorded pace times in seconds.
    *
    * @return average of all pace times
    */
   @Override
   public int getAverageOverallPace() {
      return averagePace;
   }

   /**
    * Returns the best (fastest) recorded pace in seconds.
    *
    * @return highest recorded pace
    */
   @Override
   public int getBestPace() {
      return fastestPace;
   }

   /**
    * Adds a new pace to the recorded times.
    *
    * @param time the new pace in seconds.
    */
   @Override
   public void addPace(int pace) {
      int totalTime = 0;

      paces.add(pace);
      Collections.sort(paces);

      if (pace > fastestPace) {
         fastestPace = pace;
      }

      for (Integer p : paces) {
         totalTime += p;
      }

      this.averagePace = totalTime / paces.size();
   }

}
