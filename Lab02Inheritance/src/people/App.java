package people;

import java.util.ArrayList;
import java.util.List;

/**
 * The App class runs the application specified in Lab 01.
 *
 * This class should create a football team with 11 players then print the
 * complete information for the team to stdout.
 */
public class App {

   public static void main(String[] args) {

      List<FootballPlayer> players = new ArrayList<>();
      FootballTeam team;
      

      // demonstrate the use of ProfessionalFootballPlayer
      players.add(new ProfessionalFootballPlayer("Cliff", "Avril", 30, 56, "DE"));
      players.add(new ProfessionalFootballPlayer("Doug", "Baldwin", 27, 89, "WR"));
      players.add(new ProfessionalFootballPlayer("Michael", "Bennett", 30, 72, "DE"));
      players.add(new ProfessionalFootballPlayer("Trevone", "Boykin", 23, 2, "QB"));
      players.add(new ProfessionalFootballPlayer("Justin", "Britt", 25, 68, "C/G"));
      players.add(new ProfessionalFootballPlayer("Zac", "Brooks", 23, 30, "RB"));
      players.add(new ProfessionalFootballPlayer("Brandon", "Browner", 32, 39, "CB"));
      players.add(new ProfessionalFootballPlayer("Brandin", "Bryant", 22, 92, "FB/DT"));
      players.add(new ProfessionalFootballPlayer("Marcus", "Burley", 26, 28, "CB"));
      players.add(new ProfessionalFootballPlayer("Kam", "Chancellor", 28, 31, "SS"));
      players.add(new ProfessionalFootballPlayer("Frank", "Clark", 23, 55, "DE"));

      team = new FootballTeam("Seattle Seahawks", "Blitz", players);
      
      printDemoInfo(team, "professional football player");
      
      
      
      // demonstrate the use of CollegeFootballPlayer
      players.clear();
      players.add(new CollegeFootballPlayer("Cliff", "Avril", 30, "IST", 56, "DE"));
      players.add(new CollegeFootballPlayer("Doug", "Baldwin", 27, "EMS", 89, "WR"));
      players.add(new CollegeFootballPlayer("Michael", "Bennett", 30, "ENGL", 72, "DE"));
      players.add(new CollegeFootballPlayer("Trevone", "Boykin", 23, "SPAN", 2, "QB"));
      players.add(new CollegeFootballPlayer("Justin", "Britt", 25, "HIST", 68, "C/G"));
      players.add(new CollegeFootballPlayer("Zac", "Brooks", 23, "IST", 30, "RB"));
      players.add(new CollegeFootballPlayer("Brandon", "Browner", 32, "HDFS", 39, "CB"));
      players.add(new CollegeFootballPlayer("Brandin", "Bryant", 22, "ENGL", 92, "FB/DT"));
      players.add(new CollegeFootballPlayer("Marcus", "Burley", 26, "IST", 28, "CB"));
      players.add(new CollegeFootballPlayer("Kam", "Chancellor", 28, "HRIM", 31, "SS"));
      players.add(new CollegeFootballPlayer("Frank", "Clark", 23, "UND", 55, "DE"));
      
      team = new FootballTeam("Penn State", "Nittany Lion", players);
      printDemoInfo(team, "college football player");


   }
   
   /**
    * This is a helper method used to demonstrate how code can be reused for
    * different types when using interfaces.
    * 
    * This method needs to be static because it is called by the static method
    * main().
    * 
    * @param demoTeam a football team
    * @param displayType the label to be displayed for the player type
    */
   private static void printDemoInfo(FootballTeam demoTeam, String displayType) {
      FootballPlayer singlePlayer;
      
      System.out.println("Single " + displayType + " information:");
      System.out.println();
      demoTeam.printPlayer(56);
      System.out.println();
      System.out.println();
      
      System.out.println("Single " + displayType + " getAllInfo information:");
      singlePlayer = demoTeam.getPlayerByPlayerNumber(56);
      System.out.println(singlePlayer.getAllInfo());
      System.out.println();
      System.out.println();
      
      System.out.println("Team consisting of " + displayType + "s:");
      demoTeam.printTeam();
      System.out.println();
      System.out.println();
   }

}
