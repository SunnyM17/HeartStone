import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;

// ------- TEAM 08 -------
// --Guransh Mangat, Bassel Hassan, George Abouseta, Yihan Wei, Liam Miller --
public class Battle1Test
{

      @Test
      public void test_initPHand()
      {
        p = new Player(player1);
        initializePHand(player1);
        assertEquals("The expected size of the hand was",5,playerHand.getDeckList().size(),0.00001)
      }

      @Test
      public void test_initEHand()
      {
        e = new Enemy(enemy1);
        initializePHand(player1);
        assertEquals("The expected size of the hand was",5,enemyHand.getDeckList().size(), 0.00001);
      }

      @Test
      public void test_playerTurnNoEnergy()
      {
        p = new Player(player1);
        e = new Enemy(enemy1);
        initializeOngDeckE(enemy1);
        initializeEHand(enemy1);
        initalizeOngDeckP(player1);
        intializePHand(player1);
        p.setRemainingEnergy(0);
        int n = rand.nextInt(5);
        assertEquals("Expected",false,playerTurn(n,p,e),0.00001);
      }

      @Test
      public void test_playerTurnNoHP()
      {
        p = new Player(player1);
        e = new Enemy(enemy1);
        initializeOngDeckE(enemy1);
        initializeEHand(enemy1);
        initalizeOngDeckP(player1);
        intializePHand(player1);
        p.setHealth(0);
        assertEquals("Expected",false,playerTurn(0,p,e),0.00001);
      }
      
      @Test
      public void test_playerTurnDeadE()
      {
        p = new Player(player1);
        e = new Enemy(enemy1);
        initializeOngDeckE(enemy1);
        initializeEHand(enemy1);
        initalizeOngDeckP(player1);
        intializePHand(player1);
        e.setHealth(0);
        assertEquals("Expected",true,playerTurn(0,p,e),0.00001)
      }
      
      @Test
      public void test_turnEmptyDeck()
      {
        p = new Player(player1);
        e = new Enemy(enemy1);
        initializeOngDeckE(enemy1);
        initializeEHand(enemy1);
        initalizeOngDeckP(player1);
        assertEquals("Expected",false,playerTurn(0,p,e),0.00001)
      }

      @Test 
      
}


