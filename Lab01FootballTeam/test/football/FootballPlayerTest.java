/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package football;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class FootballPlayerTest {
   
   private static FootballPlayer player1;
   private static String player1String;
   private static FootballPlayer player2;
   
   public FootballPlayerTest() {
   }
   
   @BeforeClass
   public static void setUpClass() {
      
      player1 = new FootballPlayer(2, "Trevone", "Boykin", "QB" , 23);
      player2 = new FootballPlayer(30, "Zac", "Brooks", "RB", 23);
      
      player1String = "2   QB    23  Trevone Boykin"; // "%-4d%-6s%-4d%s"
      
   }

   @Test
   public void testToString() {
      assertEquals(player1String, player1.toString());
   }

   @Test
   public void testGetNumber() {
      assertEquals(2, player1.getNumber());
   }

   @Test
   public void testSetNumber() {
      player2.setNumber(31);
      assertEquals(31, player2.getNumber());
   }

   @Test
   public void testGetFirstName() {
      assertEquals("Trevone", player1.getFirstName());
   }

   @Test
   public void testSetFirstName() {
      player2.setFirstName("TestFirstName");
      assertEquals("TestFirstName", player2.getFirstName());
   }

   @Test
   public void testGetLastName() {
      assertEquals("Boykin", player1.getLastName());
   }

   @Test
   public void testSetLastName() {
      player2.setLastName("TestLastName");
      assertEquals("TestLastName", player2.getLastName());
   }

   @Test
   public void testGetPosition() {
      assertEquals("QB", player1.getPosition());
   }

   @Test
   public void testSetPosition() {
      player2.setPosition("TST");
      assertEquals("TST", player2.getPosition());
   }

   @Test
   public void testGetAge() {
      assertEquals(23, player1.getAge());
   }

   @Test
   public void testSetAge() {
      player2.setAge(99);
      assertEquals(99, player2.getAge());
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void testSetNegativeAge() {
      player2.setAge(-3);
   }
   
}
