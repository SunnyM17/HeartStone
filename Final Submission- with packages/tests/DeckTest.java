package tests;

import utilities.Deck;
import static org.junit.Assert.*;
import org.junit.Assert;
import java.util.ArrayList;
import org.junit.Test;

// ---------- TEAM 08 --------
// --Guransh Mangat, Bassel Hassan, George Abouseta, Yihan Wei, Liam Miller -----

public class DeckTest
{
      @Test
      public void test_addCard_CheckDeckSize()
      {
          Deck d = new Deck();
          Card c1 = new Card();
          Card c2 = new Card();
          d.addCard(c1,2);
          d.addCard(c2,1);
          ArrayList<Card> deck = d.getDeckList();
          assertEquals("The Deck size expected was", 3 , deck.size(),0.000001);
    }
}
