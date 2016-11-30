package football;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The App class runs the application specified in Lab 01.
 *
 * This class should create a football team with 11 players then print the
 * complete information for the team to stdout.
 */
public class App {

   public static void main(String[] args) {

      Scanner scnr = new Scanner(System.in);
      List<FootballPlayer> players = new ArrayList<>();
      FootballTeam team;

      // create roster
      players.add(new FootballPlayer(56, "Cliff", "Avril", "DE", 30));
      players.add(new FootballPlayer(89, "Doug", "Baldwin", "WR", 27));
      players.add(new FootballPlayer(72, "Michael", "Bennett", "DE", 30));
      players.add(new FootballPlayer(2, "Trevone", "Boykin", "QB", 23));
      players.add(new FootballPlayer(68, "Justin", "Britt", "C/G", 25));
      players.add(new FootballPlayer(30, "Zac", "Brooks", "RB", 23));
      players.add(new FootballPlayer(39, "Brandon", "Browner", "CB", 32));
      players.add(new FootballPlayer(92, "Brandin", "Bryant", "FB/DT", 22));
      players.add(new FootballPlayer(28, "Marcus", "Burley", "CB", 26));
      players.add(new FootballPlayer(31, "Kam", "Chancellor", "SS", 28));
      players.add(new FootballPlayer(55, "Frank", "Clark", "DE", 23));

      team = new FootballTeam("Seattle Seahawks", "Blitz", players);

      // print the information for one player using the player object directly
      System.out.println("Please enter a player number to display their information:");
      if (scnr.hasNextInt()) {
         int playerNumber = scnr.nextInt();
         FootballPlayer player = team.getPlayerByPlayerNumber(playerNumber);
         if (player.getNumber() == 0) {
            System.out.printf("Player %d not found.", playerNumber);
         } else {
            System.out.println(player.toString());
         }
         System.out.println();
         System.out.println();
      }

      // print the team's rushing yards
      System.out.printf("Rushing yards: %d", team.getRushingYards());
      System.out.println();
      System.out.println();

      // print the complete team information and roster
      team.printTeam();

   }

}
