package football;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test class for FootballTeam.
 */
public class FootballTeamTest {

   private static List<FootballPlayer> players;
   private static FootballTeam team1;
   private static FootballTeam team2;
   private static String player30String;
   private static String player2String;
   private static String header = "Num Pos   Age Name\n"
              + "--------------------------------------------------\n";

   private static ByteArrayOutputStream out;

   public FootballTeamTest() {
   }

   @BeforeClass
   public static void setUpClass() {
      player2String = "2   QB    23  Trevone Boykin"; // "%-4d%-6s%-4d%s"
      player30String = "30  RB    23  Zac Brooks";

      List<FootballPlayer> players = new ArrayList<>();

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

      team1 = new FootballTeam("Seattle Seahawks", "Blitz", players);
      team2 = new FootballTeam("Seattle Seahawks", "Blitz", players);

   }

   @Before
   public void setUp() {
      out = new ByteArrayOutputStream();
      System.setOut(new PrintStream(out));
   }

   @After
   public void tearDown() {
      System.setOut(null);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testNotElevenPlayers() {
      // not yet implemented
      List<FootballPlayer> players1 = new ArrayList<>();
      players1.add(new FootballPlayer(56, "Cliff", "Avril", "DE", 30));
      FootballTeam team = new FootballTeam("test", "test", players1);
   }

   @Test
   public void testPrintPlayer() {
      String expectedOutput = header
              + player2String + "\n";
      team1.printPlayer(2);
      assertEquals(expectedOutput, out.toString());
   }

   @Test
   public void testPrintPlayerNonexisting() {
      String expectedOutput = header + 
              "Player 99 does not exist.";
      team1.printPlayer(99);
   }

   @Test
   public void testPrintTeam() {
      String expectedOutput = "Name:   Seattle Seahawks\n"
+ "Mascot: Blitz\n"
+ "\n"
+ "Num Pos   Age Name\n"
+ "--------------------------------------------------\n"
+ "2   QB    23  Trevone Boykin\n"
+ "28  CB    26  Marcus Burley\n"
+ "30  RB    23  Zac Brooks\n"
+ "31  SS    28  Kam Chancellor\n"
+ "39  CB    32  Brandon Browner\n"
+ "55  DE    23  Frank Clark\n"
+ "56  DE    30  Cliff Avril\n"
+ "68  C/G   25  Justin Britt\n"
+ "72  DE    30  Michael Bennett\n"
+ "89  WR    27  Doug Baldwin\n"
+ "92  FB/DT 22  Brandin Bryant\n\n";

      team1.printTeam();
      assertEquals(expectedOutput, out.toString());
   }

   @Test
   public void testGetName() {
      assertEquals("Seattle Seahawks", team1.getName());
   }

   @Test
   public void testSetName() {
      team2.setName("Philadelphia Eagles");
      assertEquals("Philadelphia Eagles", team2.getName());
   }

   @Test
   public void testGetMascot() {
      assertEquals("Blitz", team1.getMascot());
   }

   @Test
   public void testSetMascot() {
      team2.setMascot("Swoop");
      assertEquals("Swoop", team2.getMascot());
   }

}
