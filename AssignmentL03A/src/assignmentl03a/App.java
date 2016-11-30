package assignmentl03a;

import gui.MainFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import people.FootballPlayer;
import people.CollegeFootballPlayer;

public class App {

   public static void main(String[] args) {
      JFrame mainFrame;

      List<FootballPlayer> players = addPlayers();

      mainFrame = new MainFrame(players);
      mainFrame.setVisible(true);
   }

   private static List<FootballPlayer> addPlayers() {

      List<FootballPlayer> players = new ArrayList<>();

      players.add(new CollegeFootballPlayer(55, "DE", "Frank", "Clark", 23));
      players.add(new CollegeFootballPlayer(56, "DE", "Cliff", "Avril", 30));
      players.add(new CollegeFootballPlayer(89, "WR", "Doug", "Baldwin", 27));
      players.add(new CollegeFootballPlayer(2, "QB", "Trevone", "Boykin", 23));
      players.add(new CollegeFootballPlayer(68, "C/G", "Justin", "Britt", 25));
      players.add(new CollegeFootballPlayer(30, "RB", "Zac", "Brooks", 23));
      players.add(new CollegeFootballPlayer(39, "CB", "Brandon", "Browner", 32));
      players.add(new CollegeFootballPlayer(92, "FB/DT", "Brandin", "Bryant", 22));
      players.add(new CollegeFootballPlayer(28, "CB", "Marcus", "Burley", 26));
      players.add(new CollegeFootballPlayer(31, "SS", "Kam", "Chancellor", 28));
      players.add(new CollegeFootballPlayer(72, "DE", "Michael", "Bennett", 30));

      return players;
   }

}
