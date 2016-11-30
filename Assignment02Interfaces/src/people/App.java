package people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The App class runs the application specified in the assignment.
 *
 * This app demonstrates the use of the abstract class Athlete and three interfaces
 * used to implement classes representing a football player, a golfer, and a
 * marathon runner.
 */
public class App {

   public static void main(String[] args) {

      Scanner scnr = new Scanner(System.in);
      List<Athlete> players = new ArrayList<>();
      Random r = new Random();

      // create test athletes
      ProfessionalGolfer alice = new ProfessionalGolfer("Alice", "Golfer", 29, "World Champion");
      ProfessionalFootballPlayer bob = new ProfessionalFootballPlayer("Bob", "FootballPlayer", 47, "Rookie Football Player", 56, "QBK");
      ProfessionalMarathonRunner claudia = new ProfessionalMarathonRunner("Claudia", "Runner", 67, "Ultra Marathoner");
      alice.addAthleticAward(1999, "Best Golfer Ever!");
      alice.addAthleticAward(1998, "Women's Champion");
      alice.addAthleticAward(2016, "World Campion");
      alice.addAthleticAward(2016, "US Champion");
      alice.addHandicapDifferential(r.nextDouble() * 50);
      alice.addHandicapDifferential(r.nextDouble() * 50);
      alice.addHandicapDifferential(r.nextDouble() * 50);
      bob.addAthleticAward(2016, "Best New Player");
      claudia.addAthleticAward(2015, "Washington State Champion");
      claudia.addPace(r.nextInt(10 * 60) + 300);
      claudia.addPace(r.nextInt(10 * 60) + 300);
      claudia.addPace(r.nextInt(10 * 60) + 300);
      players.add(alice);
      players.add(bob);
      players.add(claudia);

      
      // print the names and titles of all atheletes
      System.out.println("Welcome to the professional athletic club!");
      System.out.println();
      System.out.println("MEMBERS:");
      printMembers(players);

      
      // print the complete information for one random athlete. Note that the info
      // printed is slightly different depending on player type
      int playerIndex = r.nextInt(players.size());
      Athlete player = players.get(playerIndex);
      System.out.println("INFORMATION AND AWARDS FOR A RANDOM MEMBER:");
      printPlayerAndAwards(player);
      
      // calculate a course handicap for Alice the golfer
      System.out.println();
      System.out.print("Enter a course slope to calculate Alice's course handicap [55-155]: ");
      if (scnr.hasNextInt()) {
         System.out.print("Course handicap: ");
         System.out.print(alice.getCourseDifferential(scnr.nextInt()));
      }
      System.out.println();
      
   }

   /**
    * Prints the player information and award list for the specified member.
    * 
    * Please note that the information displayed is customized for the 
    * member's sport.
    * 
    * @param player 
    */
   private static void printPlayerAndAwards(Athlete player) {

      System.out.println();
      player.printInfo();
      System.out.println();
      player.printAwards();
      System.out.println();
      System.out.println("==================================================");
      System.out.println();
   }

   /**
    * Prints a simple membership list containing names and titles.
    * 
    * @param players The list of members to print.
    */
   private static void printMembers(List<Athlete> players) {
      List<String> members = new ArrayList<>();
      for (Athlete player : players) {
         members.add(String.format("%s %s, %s",
                 player.getFirstName(), player.getLastName(), player.getAthleticTitle()));
      }
      Collections.sort(members);
      for (String member : members) {
         System.out.println(member);
      }
      System.out.println();
      System.out.println();
      System.out.println();
   }
}
