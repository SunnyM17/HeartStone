import static org.junit.Assert.*;

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

      public void test_playerTurnEnergy()
      {
        p = new Player(player1);
        e = new Enemy(enemy1);
        initializeOngDeckE(enemy1);
        initializeEHand(enemy1);
        initalizeOngDeckP(player1);
        intializePHand(player1);
        p.setRemainingEnergy(0);
        assertEquals("Expected",false,playerTurn())
      }
}

