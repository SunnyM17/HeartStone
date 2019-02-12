import java.util.ArrayList;

public class Deck {


  // Instance Variable
  private ArrayList<Card> masterDeck = new ArrayList<Card>();

  //Constructors
  public Deck() {
    
  }
  public Deck(ArrayList<Card> deck)
  {
    this.masterDeck = deck;
  }

}