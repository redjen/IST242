package people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ProfessionalGolfer class represents
 *
 */
public class ProfessionalGolfer extends Athlete implements Golfer {

   private List<Double> handicapDifferentials;
   private double handicapIndex;

   public ProfessionalGolfer(String firstName, String lastName, int age, String athleticTitle) {
      super(firstName, lastName, age, athleticTitle);

      handicapDifferentials = new ArrayList<>();
      handicapIndex = 0;
   }

   /**
    * Adds a handicap differential.
    *
    * @param handicapDifferential the new handicap differential
    */
   @Override
   public void addHandicapDifferential(double handicapDifferential) {

      // round to tenths per rule
      handicapDifferential = Math.round(handicapDifferential * 10.0) / 10.0;

      if (handicapDifferentials.size() < 20) {
         handicapDifferentials.add(handicapDifferential);
      } else {
         Collections.sort(handicapDifferentials);
         if (handicapDifferentials.get(0) < handicapDifferential) {
            handicapDifferentials.remove(0);
            handicapDifferentials.add(handicapDifferential);
         }
      }

      // calculate new handicap index
      int hd = handicapDifferentials.size();
      int hdCount = -1;
      double newIndex = 0.0;

      if (hd > 0 && hd < 7) {
         hdCount = 1;
      } else if (hd < 9) {
         hdCount = 2;
      } else if (hd < 11) {
         hdCount = 3;
      } else if (hd < 13) {
         hdCount = 4;
      } else if (hd < 15) {
         hdCount = 5;
      } else if (hd < 17) {
         hdCount = 6;
      } else if (hd == 17) {
         hdCount = 7;
      } else if (hd == 18) {
         hdCount = 8;
      } else if (hd == 19) {
         hdCount = 9;
      } else {
         hdCount = 10;
      }

      Collections.sort(handicapDifferentials);
      for (int i = 0; i < hdCount; ++i) {
         newIndex += handicapDifferentials.get(i);
      }
      newIndex = (newIndex / hdCount) * 0.96;
      newIndex = Math.round(newIndex * 10.0) / 10.0;

      handicapIndex = newIndex;
   }

   /**
    * Returns the player's current handicap index.
    *
    * @return the handicap index
    */
   @Override
   public double getHandicapIndex() {
      return handicapIndex;
   }

   /**
    * Calculates the player's course handicap.
    * 
    * The slope differential must be an integer between 55 and 155.
    * Values outside that range will be rounded.
    *
    * @param slopeRating the slope rating for the course to be played
    * @return the course handicap
    */
   @Override
   public int getCourseDifferential(int slopeRating) {
      
      if (slopeRating < 55) {
         slopeRating = 55;
      } else if (slopeRating > 155) {
         slopeRating = 155;
      }
      
      return (int) Math.round((handicapIndex * slopeRating) / 113);
   }
   
   /**
    * Prints the player's information.
    */
   @Override
   public void printInfo() {
      super.printInfo();
      System.out.printf("Handicap index: %.1f%n", handicapIndex);
   }

}
