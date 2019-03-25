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
    /**
    @Test
    public void test_getCard_CheckCardGotten()
    {
        Deck d = new Deck();
        Card c1 = new Card();
        Card c2 = new Card();
        d.addCard(c1,1);
        d.addCard(c2,1);
        ArrayList<Card> deck = d.getDeckList();
        assertEquals("The Card expected was", c1, deck.get(0),0.000001); //error: can't convert card to double
 }    
 */
}
