
package football;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * The FootballTeam class represents a football team with its attributes and a 
 * roster of football players. 
 * 
 * Football teams must have 11 players.
 * 
 */
public class FootballTeam {
   
   private Map<Integer, FootballPlayer> roster;
   private String name;
   private String mascot;
   
   // I asked in the Lesson 01 presentation if using final static for constants
   // would be OK, and I believe the answer was "yes." If not, I'll avoid this
   // in the future and not make them final static.
   private final static String PRINT_HEADER = 
           "Num Pos   Age Name\n" +
           "--------------------------------------------------";

   public FootballTeam(String name, String mascot, List<FootballPlayer> players) {
      
      if (players.size() != 11) {
         throw new IllegalArgumentException("Football teams require a roster of exactly 11 players.");
      }
      
      setName(name);
      setMascot(mascot);
      roster = new TreeMap<>();

      for (FootballPlayer player : players) {
         roster.put(player.getNumber(), player);
      }
   }
   

   /**
    * Prints the information for the player by number.
    * 
    * If the player does not exist this will be indicated in the output.
    * 
    * @param number the player's number 
    */
   public void printPlayer(int number) {
      System.out.println(PRINT_HEADER);
      
      if (roster.containsKey(number)) {
         System.out.println(roster.get(number).toString());
      } else {
         System.out.println("Player " + number + " does not exist.");
      }
   }
   
   /**
    * Prints the team roster.
    */
   public void printTeam() {
      System.out.println("Name:   " + name);
      System.out.println("Mascot: " + mascot);
      System.out.println();
      System.out.println(PRINT_HEADER);
      
      if (roster.size() > 0) {
         for (Integer number : roster.keySet()) {
            System.out.println(roster.get(number).toString());
         }
      } else {
         System.out.println("No players.");
      }
      System.out.println();    
   }
   

   /**
    * Returns the team's name.
    * 
    * @return the team's name
    */
   public String getName() {
      return name;
   }

   /**
    * Sets the team's name.
    * 
    * @param name the new team name
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * Returns the team's mascot.
    * 
    * @return the team's mascot
    */
   public String getMascot() {
      return mascot;
   }

   /**
    * Sets the team's mascot
    * 
    * @param mascot the new mascot
    */
   public void setMascot(String mascot) {
      this.mascot = mascot;
   }
   
   
}
