import static org.junit.Assert.*;

import org.junit.Test;

// ---------- TEAM 08 --------
// --Guransh Mangat, Bassel Hassan, George Abouseta, Yihan Wei, Liam Miller -----

public class CardTest
{
      @Test
      public void test_setCardName_newName()
      {
            Card c = new Card();
            c.setCardName("Brawl");
            assertEquals("The card name expected was", "Brawl", c.getCardName());
      }
      
      @Test
      public void test_setEnergyCost_newCost()
      {
            Card c = new Card();
            c.setEnergyCost(4);
            assertEquals("The card energy cost expected was", 4, c.getEnergyCost(), 0.000001);
      }
      
      @Test
      public void test_setDamageValue_newDamage()
      {
            Card c = new Card();
            c.setDamageValue(15);
            assertEquals("The card damage value expected was", 15, c.getDamageValue(),0.000001);
      }
      
      @Test
      public void test_setBlockValue_newBlock()
      {
            Card c = new Card();
            c.setBlockValue(15);
            assertEquals("The card block value expected was", 15, c.getBlockValue(), 0.000001);
      }
      
      @Test
      public void test_showCardDescription()
      {
            Card c = new Card();
            c.setCardName("Gear");
            c.setEnergyCost(2);
            c.setDamageValue(0);
            c.setBlockValue(15);
            assertEquals("The card description expected was", "Gear: Energy Cost: 2, Blocks 15 damage.", c.showCardDescription());
      }
}
