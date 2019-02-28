import java.util.ArrayList;
public class Deck {
  // Instance Variable
  private ArrayList<Card> deck;

  //Constructors
  public Deck(){
    deck = new ArrayList<Card>();
  }

  
  public void addCard(Card card, int amount)
  {
    for(int i = 0; i < amount; i++)
    {
        deck.add(card);
    }
  }
  
  public Card getCard(String cardToGet)
  {
    for(int i = 0; i < deck.size(); i++)
    {
        if (cardToGet.equals(deck.get(i).getCardName()))
        {
            return deck.get(i);
            
        }
    }
    return null;
  }
  public Card getCard(int cardToGet)
  {
    return this.deck.get(cardToGet);
  }
  
  public ArrayList getDeckList()
  {
      return this.deck;
  }
}
