import java.util.ArrayList;
public class Deck {
  // Instance Variable
  private ArrayList<Card> deck = new ArrayList<Card>();;

  //Constructors
  public Deck(){
      
  }
  
  public Deck(Deck deck)
  {
      this.deck = deck.deck;
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
  
  public ArrayList getDeckList()
  {
      return this.deck;
  }
}
