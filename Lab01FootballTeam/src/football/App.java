
package football;

import java.util.ArrayList;
import java.util.List;

/**
 * The App class runs the application specified in Lab 01.
 * 
 * This class should create a football team with 11 players then print
 * the complete information for the team to stdout.
 */
public class App {

    public static void main(String[] args) {
        
       List<FootballPlayer> players = new ArrayList<>();
       FootballTeam team;
       
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
       team.printTeam();    
   
    }
    

}
